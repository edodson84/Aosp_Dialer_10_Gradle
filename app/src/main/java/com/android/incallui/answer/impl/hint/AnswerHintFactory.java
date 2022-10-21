/*
 * Copyright (C) 2016 The Android Open Source Project
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

package com.android.incallui.answer.impl.hint;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

import com.android.incallui.util.AccessibilityUtil;
import com.fissy.dialer.common.LogUtil;
import com.fissy.dialer.configprovider.ConfigProviderComponent;
import com.fissy.dialer.storage.StorageComponent;

/**
 * Selects a AnswerHint to show. If there's no suitable hints {@link EmptyAnswerHint} will be used,
 * which does nothing.
 */
public class AnswerHintFactory {

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    static final String CONFIG_ANSWER_HINT_ANSWERED_THRESHOLD_KEY = "answer_hint_answered_threshold";

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    static final String CONFIG_ANSWER_HINT_WHITELISTED_DEVICES_KEY =
            "answer_hint_whitelisted_devices";
    @VisibleForTesting
    static final String ANSWERED_COUNT_PREFERENCE_KEY = "answer_hint_answered_count";
    // Most popular devices released before NDR1 is whitelisted. Their user are likely to have seen
    // the legacy UI.
    private static final String DEFAULT_WHITELISTED_DEVICES_CSV =
            "/hammerhead//bullhead//angler//shamu//gm4g//gm4g_s//AQ4501//gce_x86_phone//gm4gtkc_s/"
                    + "/Sparkle_V//Mi-498//AQ4502//imobileiq2//A65//H940//m8_google//m0xx//A10//ctih220/"
                    + "/Mi438S//bacon/";


    public static void increaseAnsweredCount(Context context) {
        SharedPreferences sharedPreferences = StorageComponent.get(context).unencryptedSharedPrefs();
        int answeredCount = sharedPreferences.getInt(ANSWERED_COUNT_PREFERENCE_KEY, 0);
        sharedPreferences.edit().putInt(ANSWERED_COUNT_PREFERENCE_KEY, answeredCount + 1).apply();
    }

    @VisibleForTesting
    static boolean shouldShowAnswerHint(Context context, String device) {
        if (AccessibilityUtil.isTouchExplorationEnabled(context)) {
            return false;
        }
        // Devices that has the legacy dialer installed are whitelisted as they are likely to go through
        // a UX change during updates.


        // If the user has gone through the process a few times we can assume they have learnt the
        // method.
        int answeredCount =
                StorageComponent.get(context)
                        .unencryptedSharedPrefs()
                        .getInt(ANSWERED_COUNT_PREFERENCE_KEY, 0);
        long threshold =
                ConfigProviderComponent.get(context)
                        .getConfigProvider()
                        .getLong(CONFIG_ANSWER_HINT_ANSWERED_THRESHOLD_KEY, 3);
        LogUtil.i(
                "AnswerHintFactory.shouldShowAnswerHint",
                "answerCount: %d, threshold: %d",
                answeredCount,
                threshold);
        return answeredCount < threshold;
    }

    /**
     * @param device         should be the value of{@link Build#PRODUCT}.
     *                       string.
     */
    private static boolean isDeviceWhitelisted(Context context, String device) {
        return ConfigProviderComponent.get(context)
                .getConfigProvider()
                .getString(CONFIG_ANSWER_HINT_WHITELISTED_DEVICES_KEY, DEFAULT_WHITELISTED_DEVICES_CSV)
                .contains("/" + device + "/");
    }

    @NonNull
    public AnswerHint create(Context context, long puckUpDuration, long puckUpDelay) {
        if (shouldShowAnswerHint(context, Build.PRODUCT)) {
            return new DotAnswerHint(context, puckUpDuration, puckUpDelay);
        }
        return new EmptyAnswerHint();
    }
}
