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
 * limitations under the License.
 */

package com.fissy.dialer.configprovider;

import com.fissy.dialer.inject.DialerVariant;
import com.fissy.dialer.inject.InstallIn;
import com.fissy.dialer.storage.StorageModule;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

/**
 * Dagger module providing {@link ConfigProvider} based on shared preferences.
 */
@InstallIn(variants = {DialerVariant.DIALER_TEST})
@Module(includes = StorageModule.class)
public abstract class SharedPrefConfigProviderModule {

    private SharedPrefConfigProviderModule() {
    }

    @Binds
    @Singleton
    abstract ConfigProvider to(SharedPrefConfigProvider impl);
}
