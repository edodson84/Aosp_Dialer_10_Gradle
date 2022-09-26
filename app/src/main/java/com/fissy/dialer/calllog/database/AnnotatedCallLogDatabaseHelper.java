/*
 * Copyright (C) 2017 The Android Open Source Project
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
 * limitations under the License
 */

package com.fissy.dialer.calllog.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.CallLog.Calls;

import androidx.annotation.VisibleForTesting;

import com.fissy.dialer.calllog.database.contract.AnnotatedCallLogContract.AnnotatedCallLog;
import com.fissy.dialer.common.LogUtil;
import com.fissy.dialer.common.concurrent.Annotations.BackgroundExecutor;
import com.fissy.dialer.inject.ApplicationContext;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;

import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * {@link SQLiteOpenHelper} for the AnnotatedCallLog database.
 */
@Singleton
public class AnnotatedCallLogDatabaseHelper extends SQLiteOpenHelper {

    @VisibleForTesting
    static final int VERSION = 4;

    private static final String FILENAME = "annotated_call_log.db";
    /**
     * Important note:
     *
     * <p>Do NOT modify/delete columns (e.g., adding constraints, changing column type, etc).
     *
     * <p>As SQLite's "ALTER TABLE" statement doesn't support such operations, doing so requires
     * complex, expensive, and error-prone operations to upgrade the database (see
     * https://www.sqlite.org/lang_altertable.html "Making Other Kinds Of Table Schema Changes").
     *
     * <p>All column constraints are enforced when data are inserted/updated via
     * AnnotatedCallLogContentProvider. See AnnotatedCallLogConstraints for details.
     */
    private static final String CREATE_TABLE_SQL =
            "create table if not exists "
                    + AnnotatedCallLog.TABLE
                    + " ("
                    + (AnnotatedCallLog._ID + " integer primary key, ")
                    + (AnnotatedCallLog.TIMESTAMP + " integer, ")
                    + (AnnotatedCallLog.NUMBER + " blob, ")
                    + (AnnotatedCallLog.FORMATTED_NUMBER + " text, ")
                    + (AnnotatedCallLog.NUMBER_PRESENTATION + " integer, ")
                    + (AnnotatedCallLog.DURATION + " integer, ")
                    + (AnnotatedCallLog.DATA_USAGE + " integer, ")
                    + (AnnotatedCallLog.IS_READ + " integer, ")
                    + (AnnotatedCallLog.NEW + " integer, ")
                    + (AnnotatedCallLog.GEOCODED_LOCATION + " text, ")
                    + (AnnotatedCallLog.PHONE_ACCOUNT_COMPONENT_NAME + " text, ")
                    + (AnnotatedCallLog.PHONE_ACCOUNT_ID + " text, ")
                    + (AnnotatedCallLog.FEATURES + " integer, ")
                    + (AnnotatedCallLog.CALL_TYPE + " integer, ")
                    + (AnnotatedCallLog.NUMBER_ATTRIBUTES + " blob, ")
                    + (AnnotatedCallLog.CALL_MAPPING_ID + " text")
                    + ");";
    /**
     * Deletes all but the first maxRows rows (by timestamp, excluding voicemails) to keep the table a
     * manageable size.
     */
    private static final String CREATE_TRIGGER_SQL =
            "create trigger delete_old_rows after insert on "
                    + AnnotatedCallLog.TABLE
                    + " when (select count(*) from "
                    + AnnotatedCallLog.TABLE
                    + " where "
                    + AnnotatedCallLog.CALL_TYPE
                    + " != "
                    + Calls.VOICEMAIL_TYPE
                    + ") > %d"
                    + " begin delete from "
                    + AnnotatedCallLog.TABLE
                    + " where "
                    + AnnotatedCallLog._ID
                    + " in (select "
                    + AnnotatedCallLog._ID
                    + " from "
                    + AnnotatedCallLog.TABLE
                    + " where "
                    + AnnotatedCallLog.CALL_TYPE
                    + " != "
                    + Calls.VOICEMAIL_TYPE
                    + " order by timestamp limit (select count(*)-%d"
                    + " from "
                    + AnnotatedCallLog.TABLE
                    + " where "
                    + AnnotatedCallLog.CALL_TYPE
                    + " != "
                    + Calls.VOICEMAIL_TYPE
                    + ")); end;";
    private static final String CREATE_INDEX_ON_CALL_TYPE_SQL =
            "create index call_type_index on "
                    + AnnotatedCallLog.TABLE
                    + " ("
                    + AnnotatedCallLog.CALL_TYPE
                    + ");";
    private static final String CREATE_INDEX_ON_NUMBER_SQL =
            "create index number_index on "
                    + AnnotatedCallLog.TABLE
                    + " ("
                    + AnnotatedCallLog.NUMBER
                    + ");";
    private final Context appContext;
    private final int maxRows;
    private final ListeningExecutorService backgroundExecutor;

    @Inject
    public AnnotatedCallLogDatabaseHelper(
            @ApplicationContext Context appContext,
            @AnnotatedCallLogMaxRows int maxRows,
            @BackgroundExecutor ListeningExecutorService backgroundExecutor) {
        super(appContext, FILENAME, null, VERSION);

        this.appContext = appContext;
        this.maxRows = maxRows;
        this.backgroundExecutor = backgroundExecutor;
    }

    private static void upgradeToV2(SQLiteDatabase db) {
        db.execSQL(
                "alter table "
                        + AnnotatedCallLog.TABLE
                        + " add column "
                        + AnnotatedCallLog.CALL_MAPPING_ID
                        + " text;");
        db.execSQL(
                "update "
                        + AnnotatedCallLog.TABLE
                        + " set "
                        + AnnotatedCallLog.CALL_MAPPING_ID
                        + " = "
                        + AnnotatedCallLog.TIMESTAMP);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        LogUtil.enterBlock("AnnotatedCallLogDatabaseHelper.onCreate");
        long startTime = System.currentTimeMillis();
        db.execSQL(CREATE_TABLE_SQL);
        db.execSQL(String.format(Locale.US, CREATE_TRIGGER_SQL, maxRows, maxRows));
        db.execSQL(CREATE_INDEX_ON_CALL_TYPE_SQL);
        db.execSQL(CREATE_INDEX_ON_NUMBER_SQL);
        // TODO(zachh): Consider logging impression.
        LogUtil.i(
                "AnnotatedCallLogDatabaseHelper.onCreate",
                "took: %dms",
                System.currentTimeMillis() - startTime);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            upgradeToV2(db);
        }
    }

    /**
     * Closes the database and deletes it.
     */
    public ListenableFuture<Void> delete() {
        return backgroundExecutor.submit(
                () -> {
                    close();
                    appContext.deleteDatabase(FILENAME);
                    return null;
                });
    }
}
