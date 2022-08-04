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

package com.fissy.dialer.binary.aosp;

import com.android.bubble.stub.StubBubbleModule;
import com.fissy.dialer.activecalls.ActiveCallsModule;
import com.fissy.dialer.binary.basecomponent.BaseDialerRootComponent;
import com.fissy.dialer.calllog.CallLogModule;
import com.fissy.dialer.calllog.config.CallLogConfigModule;
import com.fissy.dialer.commandline.CommandLineModule;
import com.fissy.dialer.common.concurrent.DialerExecutorModule;
import com.fissy.dialer.configprovider.SharedPrefConfigProviderModule;
import com.fissy.dialer.contacts.ContactsModule;
import com.fissy.dialer.duo.stub.StubDuoModule;
import com.fissy.dialer.enrichedcall.stub.StubEnrichedCallModule;
import com.fissy.dialer.feedback.stub.StubFeedbackModule;
import com.fissy.dialer.glidephotomanager.GlidePhotoManagerModule;
import com.fissy.dialer.inject.ContextModule;
import com.fissy.dialer.metrics.StubMetricsModule;
import com.fissy.dialer.phonelookup.PhoneLookupModule;
import com.fissy.dialer.phonenumbergeoutil.impl.PhoneNumberGeoUtilModule;
import com.fissy.dialer.precall.impl.PreCallModule;
import com.fissy.dialer.preferredsim.PreferredSimModule;
import com.fissy.dialer.preferredsim.suggestion.stub.StubSimSuggestionModule;
import com.fissy.dialer.promotion.impl.PromotionModule;
import com.fissy.dialer.simulator.impl.SimulatorModule;
import com.fissy.dialer.simulator.stub.StubSimulatorEnrichedCallModule;
import com.fissy.dialer.spam.stub.StubSpamModule;
import com.fissy.dialer.storage.StorageModule;
import com.fissy.dialer.strictmode.impl.SystemStrictModeModule;
import com.fissy.dialer.theme.base.impl.AospThemeModule;
import com.android.incallui.calllocation.stub.StubCallLocationModule;
import com.android.incallui.maps.stub.StubMapsModule;
import com.android.incallui.speakeasy.StubSpeakEasyModule;
import com.android.voicemail.impl.VoicemailModule;
import dagger.Component;
import javax.inject.Singleton;

/** Root component for the AOSP Dialer application. */
@Singleton
@Component(
    modules = {
      ActiveCallsModule.class,
      CallLogModule.class,
      CallLogConfigModule.class,
      CommandLineModule.class,
      ContactsModule.class,
      ContextModule.class,
      DialerExecutorModule.class,
      GlidePhotoManagerModule.class,
      PhoneLookupModule.class,
      PhoneNumberGeoUtilModule.class,
      PreCallModule.class,
      PreferredSimModule.class,
      PromotionModule.class,
      SharedPrefConfigProviderModule.class,
      SimulatorModule.class,
      StubSimulatorEnrichedCallModule.class,
      StorageModule.class,
      StubCallLocationModule.class,
      StubDuoModule.class,
      StubEnrichedCallModule.class,
      StubBubbleModule.class,
      StubMetricsModule.class,
      StubFeedbackModule.class,
      StubMapsModule.class,
      StubSimSuggestionModule.class,
      StubSpamModule.class,
      StubSpeakEasyModule.class,
      SystemStrictModeModule.class,
      AospThemeModule.class,
      VoicemailModule.class,
    })
public interface AospDialerRootComponent extends BaseDialerRootComponent {}
