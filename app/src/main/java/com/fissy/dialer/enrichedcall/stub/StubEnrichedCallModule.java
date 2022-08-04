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

package com.fissy.dialer.enrichedcall.stub;

import com.fissy.dialer.enrichedcall.EnrichedCallManager;
import com.fissy.dialer.enrichedcall.RcsVideoShareFactory;
import com.fissy.dialer.inject.DialerVariant;
import com.fissy.dialer.inject.InstallIn;
import com.android.incallui.videotech.empty.EmptyVideoTech;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/** Module which binds {@link EnrichedCallManagerStub}. */
@InstallIn(variants = {DialerVariant.DIALER_TEST})
@Module
public class StubEnrichedCallModule {

  @Provides
  @Singleton
  static EnrichedCallManager provideEnrichedCallManager() {
    return new EnrichedCallManagerStub();
  }

  @Provides
  @Singleton
  static RcsVideoShareFactory providesRcsVideoShareFactory() {
    return (enrichedCallManager, videoTechListener, number) -> new EmptyVideoTech();
  }

  private StubEnrichedCallModule() {}
}
