/*
 * Copyright (C) 2015 The Android Open Source Project
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

package com.fissy.dialer.app.calllog;

import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.provider.CallLog;
import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.fissy.dialer.common.concurrent.AsyncTaskExecutor;
import com.fissy.dialer.common.concurrent.AsyncTaskExecutors;
import com.fissy.dialer.util.PermissionsUtil;

/**
 * TODO(calderwoodra): documentation
 */
public class CallLogAsyncTaskUtil {

    private static final String TAG = "CallLogAsyncTaskUtil";
    private static AsyncTaskExecutor asyncTaskExecutor;

    private static void initTaskExecutor() {
        asyncTaskExecutor = AsyncTaskExecutors.createThreadPoolExecutor();
    }

    public static void markCallAsRead(@NonNull final Context context, @NonNull final long[] callIds) {
        if (!PermissionsUtil.hasPhonePermissions(context)
                || !PermissionsUtil.hasCallLogWritePermissions(context)) {
            return;
        }
        if (asyncTaskExecutor == null) {
            initTaskExecutor();
        }

        asyncTaskExecutor.submit(
                Tasks.MARK_CALL_READ,
                new AsyncTask<Void, Void, Void>() {
                    @Override
                    public Void doInBackground(Void... params) {

                        StringBuilder where = new StringBuilder();
                        where.append(CallLog.Calls.TYPE).append(" = ").append(CallLog.Calls.MISSED_TYPE);
                        where.append(" AND ");

                        Long[] callIdLongs = new Long[callIds.length];
                        for (int i = 0; i < callIds.length; i++) {
                            callIdLongs[i] = callIds[i];
                        }
                        where
                                .append(CallLog.Calls._ID)
                                .append(" IN (" + TextUtils.join(",", callIdLongs) + ")");

                        ContentValues values = new ContentValues(1);
                        values.put(CallLog.Calls.IS_READ, "1");
                        context
                                .getContentResolver()
                                .update(CallLog.Calls.CONTENT_URI, values, where.toString(), null);
                        return null;
                    }
                });
    }

    /**
     * The enumeration of {@link AsyncTask} objects used in this class.
     */
    public enum Tasks {
        DELETE_VOICEMAIL,
        DELETE_CALL,
        MARK_VOICEMAIL_READ,
        MARK_CALL_READ,
        GET_CALL_DETAILS,
        UPDATE_DURATION,
    }

    /**
     * TODO(calderwoodra): documentation
     */
    public interface CallLogAsyncTaskListener {
        void onDeleteVoicemail();
    }
}
