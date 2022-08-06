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

package com.fissy.dialer.spam.status;

import com.google.auto.value.AutoValue;
import com.google.common.base.Optional;

/**
 * Holds information which can be used to determine a number's spam status.
 *
 * @see SpamStatus
 */
@AutoValue
public abstract class SpamMetadata {

    /**
     * Returns an empty spam metadata, no optional data is set.
     */
    public static SpamMetadata empty() {
        return builder().build();
    }

    public static SpamMetadata.Builder builder() {
        return new AutoValue_SpamMetadata.Builder();
    }

    public abstract Optional<GlobalSpamListStatus> globalSpamListStatus();

    public abstract Optional<UserSpamListStatus> userSpamListStatus();

    /**
     * Creates instances of SpamMetadata.
     */
    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder setGlobalSpamListStatus(GlobalSpamListStatus globalSpamListStatus);

        public abstract Builder setUserSpamListStatus(UserSpamListStatus userSpamListStatus);

        public abstract SpamMetadata build();
    }
}
