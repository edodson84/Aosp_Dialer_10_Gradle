/*
 * Copyright (C) 2013 The Android Open Source Project
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

package com.fissy.dialer.binary.common;

import android.app.Application;
import android.os.Trace;
import androidx.annotation.NonNull;
import androidx.core.os.BuildCompat;

import com.fissy.dialer.blocking.BlockedNumbersAutoMigrator;
import com.fissy.dialer.blocking.FilteredNumberAsyncQueryHandler;
import com.fissy.dialer.calllog.CallLogComponent;
import com.fissy.dialer.calllog.CallLogFramework;
import com.fissy.dialer.calllog.config.CallLogConfig;
import com.fissy.dialer.calllog.config.CallLogConfigComponent;
import com.fissy.dialer.callrecord.CallRecordingAutoMigrator;
import com.fissy.dialer.common.LogUtil;
import com.fissy.dialer.common.concurrent.DialerExecutorComponent;
import com.fissy.dialer.inject.HasRootComponent;
import com.fissy.dialer.notification.NotificationChannelManager;
import com.fissy.dialer.persistentlog.PersistentLogger;
import com.fissy.dialer.strictmode.StrictModeComponent;

/**
 * A common application subclass for all Dialer build variants.
 */
public abstract class DialerApplication extends Application implements HasRootComponent {

    private volatile Object rootComponent;

    @Override
    public void onCreate() {
        Trace.beginSection("DialerApplication.onCreate");
        StrictModeComponent.get(this).getDialerStrictMode().onApplicationCreate(this);
        super.onCreate();
        new BlockedNumbersAutoMigrator(
                this.getApplicationContext(),
                new FilteredNumberAsyncQueryHandler(this),
                DialerExecutorComponent.get(this).dialerExecutorFactory())
                .asyncAutoMigrate();
        new CallRecordingAutoMigrator(
                this.getApplicationContext(),
                DialerExecutorComponent.get(this).dialerExecutorFactory())
                .asyncAutoMigrate();
        initializeAnnotatedCallLog();
        PersistentLogger.initialize(this);

        if (BuildCompat.isAtLeastO()) {
            NotificationChannelManager.initChannels(this);
        }
        Trace.endSection();
    }

    private void initializeAnnotatedCallLog() {
        CallLogConfig callLogConfig = CallLogConfigComponent.get(this).callLogConfig();
        callLogConfig.schedulePollingJob();

        if (callLogConfig.isCallLogFrameworkEnabled()) {
            CallLogFramework callLogFramework = CallLogComponent.get(this).callLogFramework();
            callLogFramework.registerContentObservers();
        } else {
            LogUtil.i("DialerApplication.initializeAnnotatedCallLog", "framework not enabled");
        }
    }

    /**
     * Returns a new instance of the root component for the application. Sub classes should define a
     * root component that extends all the sub components "HasComponent" intefaces. The component
     * should specify all modules that the application supports and provide stubs for the remainder.
     */
    @NonNull
    protected abstract Object buildRootComponent();

    /**
     * Returns a cached instance of application's root component.
     */
    @Override
    @NonNull
    public final Object component() {
        Object result = rootComponent;
        if (result == null) {
            synchronized (this) {
                result = rootComponent;
                if (result == null) {
                    rootComponent = result = buildRootComponent();
                }
            }
        }
        return result;
    }
}
