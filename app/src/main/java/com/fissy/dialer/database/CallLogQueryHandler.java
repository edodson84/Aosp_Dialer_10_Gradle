/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fissy.dialer.database;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.CallLog.Calls;

import com.android.contacts.common.database.NoNullCursorAsyncQueryHandler;
import com.fissy.dialer.common.LogUtil;
import com.fissy.dialer.phonenumbercache.CallLogQuery;
import com.fissy.dialer.telecom.TelecomUtil;
import com.fissy.dialer.util.PermissionsUtil;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles asynchronous queries to the call log.
 */
public class CallLogQueryHandler extends NoNullCursorAsyncQueryHandler {

    /**
     * Call type similar to Calls.INCOMING_TYPE used to specify all types instead of one particular
     * type. Exception: excludes Calls.VOICEMAIL_TYPE.
     */
    public static final int CALL_TYPE_ALL = -1;

    private static final int NUM_LOGS_TO_DISPLAY = 1000;
    /**
     * The token for the query to fetch the old entries from the call log.
     */
    private static final int QUERY_CALLLOG_TOKEN = 54;
    /**
     * The token for the query to mark all missed calls as read after seeing the call log.
     */
    private static final int UPDATE_MARK_MISSED_CALL_AS_READ_TOKEN = 56;
    /**
     * The token for the query to fetch the number of missed calls.
     */
    private static final int QUERY_MISSED_CALLS_UNREAD_COUNT_TOKEN = 59;

    private final int logLimit;
    private final WeakReference<Listener> listener;

    private final Context context;

    public CallLogQueryHandler(Context context, ContentResolver contentResolver, Listener listener) {
        this(context, contentResolver, listener, -1);
    }

    public CallLogQueryHandler(
            Context context, ContentResolver contentResolver, Listener listener, int limit) {
        super(contentResolver);
        this.context = context.getApplicationContext();
        this.listener = new WeakReference<>(listener);
        logLimit = limit;
    }

    @Override
    protected Handler createHandler(Looper looper) {
        // Provide our special handler that catches exceptions
        return new CatchingWorkerHandler(looper);
    }

    /**
     * Fetches the list of calls from the call log for a given type. This call ignores the new or old
     * state.
     *
     * <p>It will asynchronously update the content of the list view when the fetch completes.
     */
    public void fetchCalls(int callType, long newerThan) {
        cancelFetch();
        if (PermissionsUtil.hasPhonePermissions(context)) {
            fetchCalls(QUERY_CALLLOG_TOKEN, callType, false /* newOnly */, newerThan);
        } else {
            updateAdapterData(null);
        }
    }

    /**
     * Fetches the list of calls in the call log.
     */
    private void fetchCalls(int token, int callType, boolean newOnly, long newerThan) {
        StringBuilder where = new StringBuilder();
        List<String> selectionArgs = new ArrayList<>();

        // Always hide blocked calls.
        where.append("(").append(Calls.TYPE).append(" != ?)");
        selectionArgs.add(Integer.toString(Calls.BLOCKED_TYPE));

        if (newOnly) {
            where.append(" AND (").append(Calls.NEW).append(" = 1)");
        }

        if (callType > CALL_TYPE_ALL) {
            where.append(" AND (").append(Calls.TYPE).append(" = ?)");
            selectionArgs.add(Integer.toString(callType));
        }

        if (newerThan > 0) {
            where.append(" AND (").append(Calls.DATE).append(" > ?)");
            selectionArgs.add(Long.toString(newerThan));
        } else {
            // Filter out all Duo entries other than video calls
            where
                    .append(" AND (")
                    .append(Calls.PHONE_ACCOUNT_COMPONENT_NAME)
                    .append(" IS NULL OR ")
                    .append(Calls.PHONE_ACCOUNT_COMPONENT_NAME)
                    .append(" NOT LIKE 'com.google.android.apps.tachyon%' OR ")
                    .append(Calls.FEATURES)
                    .append(" & ")
                    .append(Calls.FEATURES_VIDEO)
                    .append(" == ")
                    .append(Calls.FEATURES_VIDEO)
                    .append(")");
        }

        final int limit = (logLimit == -1) ? NUM_LOGS_TO_DISPLAY : logLimit;
        final String selection = where.length() > 0 ? where.toString() : null;
        Uri uri =
                TelecomUtil.getCallLogUri(context)
                        .buildUpon()
                        .appendQueryParameter(Calls.LIMIT_PARAM_KEY, Integer.toString(limit))
                        .build();
        startQuery(
                token,
                null,
                uri,
                CallLogQuery.getProjection(),
                selection,
                selectionArgs.toArray(new String[selectionArgs.size()]),
                Calls.DEFAULT_SORT_ORDER);
    }

    /**
     * Cancel any pending fetch request.
     */
    private void cancelFetch() {
        cancelOperation(QUERY_CALLLOG_TOKEN);
    }

    /**
     * Updates all missed calls to mark them as read.
     */
    public void markMissedCallsAsRead() {
        if (!PermissionsUtil.hasPhonePermissions(context)) {
            return;
        }

        ContentValues values = new ContentValues(1);
        values.put(Calls.IS_READ, "1");

        startUpdate(
                UPDATE_MARK_MISSED_CALL_AS_READ_TOKEN,
                null,
                Calls.CONTENT_URI,
                values,
                getUnreadMissedCallsQuery(),
                null);
    }

    /**
     * Fetch all missed calls received since last time the tab was opened.
     */
    public void fetchMissedCallsUnreadCount() {
        if (!PermissionsUtil.hasPhonePermissions(context)) {
            return;
        }

        startQuery(
                QUERY_MISSED_CALLS_UNREAD_COUNT_TOKEN,
                null,
                Calls.CONTENT_URI,
                new String[]{Calls._ID},
                getUnreadMissedCallsQuery(),
                null,
                null);
    }

    @Override
    protected synchronized void onNotNullableQueryComplete(int token, Object cookie, Cursor cursor) {
        if (cursor == null) {
            return;
        }
        try {
            if (token == QUERY_CALLLOG_TOKEN) {
                if (updateAdapterData(cursor)) {
                    cursor = null;
                }
            } else if (token == QUERY_MISSED_CALLS_UNREAD_COUNT_TOKEN) {
                updateMissedCallsUnreadCount(cursor);
            } else {
                LogUtil.w(
                        "CallLogQueryHandler.onNotNullableQueryComplete",
                        "unknown query completed: ignoring: " + token);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /**
     * Updates the adapter in the call log fragment to show the new cursor data. Returns true if the
     * listener took ownership of the cursor.
     */
    private boolean updateAdapterData(Cursor cursor) {
        final Listener listener = this.listener.get();
        return listener != null && listener.onCallsFetched(cursor);
    }

    /**
     * @return Query string to get all unread missed calls.
     */
    private String getUnreadMissedCallsQuery() {
        return Calls.IS_READ
                + " = 0 OR "
                + Calls.IS_READ
                + " IS NULL"
                + " AND "
                + Calls.TYPE
                + " = "
                + Calls.MISSED_TYPE;
    }

    private void updateMissedCallsUnreadCount(Cursor statusCursor) {
        final Listener listener = this.listener.get();
        if (listener != null) {
            listener.onMissedCallsUnreadCountFetched(statusCursor);
        }
    }

    /**
     * Listener to completion of various queries.
     */
    public interface Listener {

        /**
         * Called when {@link CallLogQueryHandler#fetchMissedCallsUnreadCount()} completes.
         */
        void onMissedCallsUnreadCountFetched(Cursor cursor);

        /**
         * Called when {@link CallLogQueryHandler#fetchCalls(int, long)} complete. Returns true if takes
         * ownership of cursor.
         */
        boolean onCallsFetched(Cursor combinedCursor);
    }

    /**
     * Simple handler that wraps background calls to catch {@link SQLiteException}, such as when the
     * disk is full.
     */
    private class CatchingWorkerHandler extends AsyncQueryHandler.WorkerHandler {

        CatchingWorkerHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            try {
                // Perform same query while catching any exceptions
                super.handleMessage(msg);
            } catch (SQLiteDiskIOException | SQLiteFullException | SQLiteDatabaseCorruptException e) {
                LogUtil.e("CallLogQueryHandler.handleMessage", "exception on background worker thread", e);
            } catch (IllegalArgumentException e) {
                LogUtil.e("CallLogQueryHandler.handleMessage", "contactsProvider not present on device", e);
            } catch (SecurityException e) {
                // Shouldn't happen if we are protecting the entry points correctly,
                // but just in case.
                LogUtil.e(
                        "CallLogQueryHandler.handleMessage", "no permission to access ContactsProvider.", e);
            }
        }
    }
}
