package com.fissy.dialer.phonelookup.blockednumber;

import android.content.Context;

import com.fissy.dialer.calllog.observer.MarkDirtyObserver;
import com.google.common.util.concurrent.ListeningExecutorService;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class SystemBlockedNumberPhoneLookup_Factory
        implements Factory<SystemBlockedNumberPhoneLookup> {
    private final Provider<Context> appContextProvider;

    private final Provider<ListeningExecutorService> executorServiceProvider;

    private final Provider<MarkDirtyObserver> markDirtyObserverProvider;

    public SystemBlockedNumberPhoneLookup_Factory(
            Provider<Context> appContextProvider,
            Provider<ListeningExecutorService> executorServiceProvider,
            Provider<MarkDirtyObserver> markDirtyObserverProvider) {
        assert appContextProvider != null;
        this.appContextProvider = appContextProvider;
        assert executorServiceProvider != null;
        this.executorServiceProvider = executorServiceProvider;
        assert markDirtyObserverProvider != null;
        this.markDirtyObserverProvider = markDirtyObserverProvider;
    }

    public static Factory<SystemBlockedNumberPhoneLookup> create(
            Provider<Context> appContextProvider,
            Provider<ListeningExecutorService> executorServiceProvider,
            Provider<MarkDirtyObserver> markDirtyObserverProvider) {
        return new SystemBlockedNumberPhoneLookup_Factory(
                appContextProvider, executorServiceProvider, markDirtyObserverProvider);
    }

    @Override
    public SystemBlockedNumberPhoneLookup get() {
        return new SystemBlockedNumberPhoneLookup(
                appContextProvider.get(), executorServiceProvider.get(), markDirtyObserverProvider.get());
    }
}
