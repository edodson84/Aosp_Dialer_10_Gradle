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

package com.fissy.dialer.binary.basecomponent;

import com.android.bubble.BubbleComponent;
import com.android.incallui.calllocation.CallLocationComponent;
import com.android.incallui.maps.MapsComponent;
import com.android.incallui.speakeasy.SpeakEasyComponent;
import com.android.voicemail.VoicemailComponent;
import com.fissy.dialer.activecalls.ActiveCallsComponent;
import com.fissy.dialer.calllog.CallLogComponent;
import com.fissy.dialer.calllog.config.CallLogConfigComponent;
import com.fissy.dialer.calllog.database.CallLogDatabaseComponent;
import com.fissy.dialer.calllog.ui.CallLogUiComponent;
import com.fissy.dialer.commandline.CommandLineComponent;
import com.fissy.dialer.common.concurrent.DialerExecutorComponent;
import com.fissy.dialer.configprovider.ConfigProviderComponent;
import com.fissy.dialer.contacts.ContactsComponent;
import com.fissy.dialer.duo.DuoComponent;
import com.fissy.dialer.enrichedcall.EnrichedCallComponent;
import com.fissy.dialer.feedback.FeedbackComponent;
import com.fissy.dialer.glidephotomanager.GlidePhotoManagerComponent;
import com.fissy.dialer.metrics.MetricsComponent;
import com.fissy.dialer.phonelookup.PhoneLookupComponent;
import com.fissy.dialer.phonelookup.database.PhoneLookupDatabaseComponent;
import com.fissy.dialer.phonenumbergeoutil.PhoneNumberGeoUtilComponent;
import com.fissy.dialer.precall.PreCallComponent;
import com.fissy.dialer.preferredsim.PreferredSimComponent;
import com.fissy.dialer.preferredsim.suggestion.SimSuggestionComponent;
import com.fissy.dialer.promotion.PromotionComponent;
import com.fissy.dialer.simulator.SimulatorComponent;
import com.fissy.dialer.spam.SpamComponent;
import com.fissy.dialer.speeddial.loader.UiItemLoaderComponent;
import com.fissy.dialer.storage.StorageComponent;
import com.fissy.dialer.strictmode.StrictModeComponent;
import com.fissy.dialer.theme.base.ThemeComponent;

/**
 * Base class for the core application-wide component. All variants of the Dialer app should extend
 * from this component.
 */
public interface BaseDialerRootComponent
        extends ActiveCallsComponent.HasComponent,
        BubbleComponent.HasComponent,
        CallLocationComponent.HasComponent,
        CallLogComponent.HasComponent,
        CallLogConfigComponent.HasComponent,
        CallLogDatabaseComponent.HasComponent,
        CallLogUiComponent.HasComponent,
        ConfigProviderComponent.HasComponent,
        CommandLineComponent.HasComponent,
        ContactsComponent.HasComponent,
        DialerExecutorComponent.HasComponent,
        DuoComponent.HasComponent,
        EnrichedCallComponent.HasComponent,
        FeedbackComponent.HasComponent,
        GlidePhotoManagerComponent.HasComponent,
        MapsComponent.HasComponent,
        MetricsComponent.HasComponent,
        PhoneLookupComponent.HasComponent,
        PhoneLookupDatabaseComponent.HasComponent,
        PhoneNumberGeoUtilComponent.HasComponent,
        PreCallComponent.HasComponent,
        PreferredSimComponent.HasComponent,
        PromotionComponent.HasComponent,
        UiItemLoaderComponent.HasComponent,
        SimSuggestionComponent.HasComponent,
        SimulatorComponent.HasComponent,
        SpamComponent.HasComponent,
        SpeakEasyComponent.HasComponent,
        StorageComponent.HasComponent,
        StrictModeComponent.HasComponent,
        ThemeComponent.HasComponent,
        VoicemailComponent.HasComponent {
}
