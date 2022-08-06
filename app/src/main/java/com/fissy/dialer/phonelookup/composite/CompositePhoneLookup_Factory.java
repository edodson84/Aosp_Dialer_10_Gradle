package com.fissy.dialer.phonelookup.composite;

import android.content.Context;

import com.fissy.dialer.calllog.CallLogState;
import com.fissy.dialer.metrics.FutureTimer;
import com.fissy.dialer.phonelookup.PhoneLookup;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListeningExecutorService;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class CompositePhoneLookup_Factory implements Factory<CompositePhoneLookup> {
    private final Provider<Context> appContextProvider;

    private final Provider<ImmutableList<PhoneLookup>> phoneLookupsProvider;

    private final Provider<FutureTimer> futureTimerProvider;

    private final Provider<CallLogState> callLogStateProvider;

    private final Provider<ListeningExecutorService> lightweightExecutorServiceProvider;

    public CompositePhoneLookup_Factory(
            Provider<Context> appContextProvider,
            Provider<ImmutableList<PhoneLookup>> phoneLookupsProvider,
            Provider<FutureTimer> futureTimerProvider,
            Provider<CallLogState> callLogStateProvider,
            Provider<ListeningExecutorService> lightweightExecutorServiceProvider) {
        assert appContextProvider != null;
        this.appContextProvider = appContextProvider;
        assert phoneLookupsProvider != null;
        this.phoneLookupsProvider = phoneLookupsProvider;
        assert futureTimerProvider != null;
        this.futureTimerProvider = futureTimerProvider;
        assert callLogStateProvider != null;
        this.callLogStateProvider = callLogStateProvider;
        assert lightweightExecutorServiceProvider != null;
        this.lightweightExecutorServiceProvider = lightweightExecutorServiceProvider;
    }

    public static Factory<CompositePhoneLookup> create(
            Provider<Context> appContextProvider,
            Provider<ImmutableList<PhoneLookup>> phoneLookupsProvider,
            Provider<FutureTimer> futureTimerProvider,
            Provider<CallLogState> callLogStateProvider,
            Provider<ListeningExecutorService> lightweightExecutorServiceProvider) {
        return new CompositePhoneLookup_Factory(
                appContextProvider,
                phoneLookupsProvider,
                futureTimerProvider,
                callLogStateProvider,
                lightweightExecutorServiceProvider);
    }

    @Override
    public CompositePhoneLookup get() {
        return new CompositePhoneLookup(
                appContextProvider.get(),
                phoneLookupsProvider.get(),
                futureTimerProvider.get(),
                callLogStateProvider.get(),
                lightweightExecutorServiceProvider.get());
    }
}
