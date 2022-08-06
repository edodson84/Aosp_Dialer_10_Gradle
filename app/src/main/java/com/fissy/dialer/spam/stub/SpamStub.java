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
 * limitations under the License.
 */

package com.fissy.dialer.spam.stub;

import androidx.annotation.Nullable;

import com.fissy.dialer.DialerPhoneNumber;
import com.fissy.dialer.common.concurrent.Annotations.BackgroundExecutor;
import com.fissy.dialer.logging.ContactLookupResult;
import com.fissy.dialer.logging.ContactSource;
import com.fissy.dialer.logging.ReportingLocation;
import com.fissy.dialer.spam.Spam;
import com.fissy.dialer.spam.status.SimpleSpamStatus;
import com.fissy.dialer.spam.status.SpamStatus;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;

import javax.inject.Inject;

/**
 * Default implementation of Spam.
 */
public class SpamStub implements Spam {

    private final ListeningExecutorService backgroundExecutorService;

    @Inject
    public SpamStub(@BackgroundExecutor ListeningExecutorService backgroundExecutorService) {
        this.backgroundExecutorService = backgroundExecutorService;
    }

    @Override
    public ListenableFuture<ImmutableMap<DialerPhoneNumber, SpamStatus>> batchCheckSpamStatus(
            ImmutableSet<DialerPhoneNumber> dialerPhoneNumbers) {
        return backgroundExecutorService.submit(
                () -> {
                    ImmutableMap.Builder<DialerPhoneNumber, SpamStatus> resultBuilder =
                            new ImmutableMap.Builder<>();
                    for (DialerPhoneNumber dialerPhoneNumber : dialerPhoneNumbers) {
                        resultBuilder.put(dialerPhoneNumber, SimpleSpamStatus.notSpam());
                    }
                    return resultBuilder.build();
                });
    }

    @Override
    public ListenableFuture<SpamStatus> checkSpamStatus(DialerPhoneNumber dialerPhoneNumber) {
        return Futures.immediateFuture(SimpleSpamStatus.notSpam());
    }

    @Override
    public ListenableFuture<SpamStatus> checkSpamStatus(
            String number, @Nullable String defaultCountryIso) {
        return Futures.immediateFuture(SimpleSpamStatus.notSpam());
    }

    @Override
    public ListenableFuture<Void> updateSpamListDownload(boolean isEnabledByUser) {
        // no-op
        return Futures.immediateFuture(null);
    }

    @Override
    public boolean checkSpamStatusSynchronous(String number, String countryIso) {
        return false;
    }

    @Override
    public ListenableFuture<Boolean> dataUpdatedSince(long timestampMillis) {
        return Futures.immediateFuture(false);
    }

    @Override
    public void reportSpamFromAfterCallNotification(
            String number,
            String countryIso,
            int callType,
            ReportingLocation.Type from,
            ContactLookupResult.Type contactLookupResultType) {
    }

    @Override
    public void reportSpamFromCallHistory(
            String number,
            String countryIso,
            int callType,
            ReportingLocation.Type from,
            ContactSource.Type contactSourceType) {
    }

    @Override
    public void reportNotSpamFromAfterCallNotification(
            String number,
            String countryIso,
            int callType,
            ReportingLocation.Type from,
            ContactLookupResult.Type contactLookupResultType) {
    }

    @Override
    public void reportNotSpamFromCallHistory(
            String number,
            String countryIso,
            int callType,
            ReportingLocation.Type from,
            ContactSource.Type contactSourceType) {
    }
}
