package com.fissy.dialer.phonelookup.cequint;

import android.content.Context;

import com.google.common.util.concurrent.ListeningExecutorService;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class CequintPhoneLookup_Factory implements Factory<CequintPhoneLookup> {
    private final Provider<Context> appContextProvider;

    private final Provider<ListeningExecutorService> backgroundExecutorServiceProvider;

    private final Provider<ListeningExecutorService> lightweightExecutorServiceProvider;

    public CequintPhoneLookup_Factory(
            Provider<Context> appContextProvider,
            Provider<ListeningExecutorService> backgroundExecutorServiceProvider,
            Provider<ListeningExecutorService> lightweightExecutorServiceProvider) {
        assert appContextProvider != null;
        this.appContextProvider = appContextProvider;
        assert backgroundExecutorServiceProvider != null;
        this.backgroundExecutorServiceProvider = backgroundExecutorServiceProvider;
        assert lightweightExecutorServiceProvider != null;
        this.lightweightExecutorServiceProvider = lightweightExecutorServiceProvider;
    }

    public static Factory<CequintPhoneLookup> create(
            Provider<Context> appContextProvider,
            Provider<ListeningExecutorService> backgroundExecutorServiceProvider,
            Provider<ListeningExecutorService> lightweightExecutorServiceProvider) {
        return new CequintPhoneLookup_Factory(
                appContextProvider, backgroundExecutorServiceProvider, lightweightExecutorServiceProvider);
    }

    @Override
    public CequintPhoneLookup get() {
        return new CequintPhoneLookup(
                appContextProvider.get(),
                backgroundExecutorServiceProvider.get(),
                lightweightExecutorServiceProvider.get());
    }
}
