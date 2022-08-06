package com.fissy.dialer.calllog;

import android.content.Context;

import com.google.common.util.concurrent.ListeningExecutorService;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class ClearMissedCalls_Factory implements Factory<ClearMissedCalls> {
    private final Provider<Context> appContextProvider;

    private final Provider<ListeningExecutorService> backgroundExecutorProvider;

    private final Provider<ListeningExecutorService> uiThreadExecutorProvider;

    public ClearMissedCalls_Factory(
            Provider<Context> appContextProvider,
            Provider<ListeningExecutorService> backgroundExecutorProvider,
            Provider<ListeningExecutorService> uiThreadExecutorProvider) {
        assert appContextProvider != null;
        this.appContextProvider = appContextProvider;
        assert backgroundExecutorProvider != null;
        this.backgroundExecutorProvider = backgroundExecutorProvider;
        assert uiThreadExecutorProvider != null;
        this.uiThreadExecutorProvider = uiThreadExecutorProvider;
    }

    public static Factory<ClearMissedCalls> create(
            Provider<Context> appContextProvider,
            Provider<ListeningExecutorService> backgroundExecutorProvider,
            Provider<ListeningExecutorService> uiThreadExecutorProvider) {
        return new ClearMissedCalls_Factory(
                appContextProvider, backgroundExecutorProvider, uiThreadExecutorProvider);
    }

    @Override
    public ClearMissedCalls get() {
        return new ClearMissedCalls(
                appContextProvider.get(), backgroundExecutorProvider.get(), uiThreadExecutorProvider.get());
    }
}
