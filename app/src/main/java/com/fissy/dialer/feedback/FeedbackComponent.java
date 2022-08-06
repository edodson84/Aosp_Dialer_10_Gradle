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

package com.fissy.dialer.feedback;

import android.content.Context;
import androidx.annotation.NonNull;

import com.android.incallui.call.CallList;
import com.fissy.dialer.inject.HasRootComponent;

import dagger.Subcomponent;

/**
 * Subcomponent that can be used to access the feedback implementation.
 */
@Subcomponent
public abstract class FeedbackComponent {
    public static FeedbackComponent get(Context context) {
        return ((HasComponent) ((HasRootComponent) context.getApplicationContext()).component())
                .feedbackComponent();
    }

    @NonNull
    public abstract CallList.Listener getCallFeedbackListener();

    @NonNull
    public abstract FeedbackSender getCallFeedbackSender();

    /**
     * Used to refer to the root application component.
     */
    public interface HasComponent {
        FeedbackComponent feedbackComponent();
    }
}
