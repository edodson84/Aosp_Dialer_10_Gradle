/*
 * Copyright (C) 2018 The Android Open Source Project
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

package com.fissy.dialer.theme.base.impl;

import android.content.Context;
import com.fissy.dialer.inject.ApplicationContext;
import com.fissy.dialer.inject.DialerVariant;
import com.fissy.dialer.inject.InstallIn;
import com.fissy.dialer.theme.base.Theme;
import dagger.Module;
import dagger.Provides;

/** Module which binds {@link AospThemeImpl}. */
@InstallIn(variants = {DialerVariant.DIALER_TEST})
@Module
public class AospThemeModule {

  @Provides
  static Theme provideThemeModule(@ApplicationContext Context context) {
    return new AospThemeImpl(context);
  }
}
