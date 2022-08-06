package com.fissy.dialer.phonelookup.cp2;

import android.content.Context;

import com.google.common.util.concurrent.ListeningExecutorService;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class MissingPermissionsOperations_Factory
        implements Factory<MissingPermissionsOperations> {
    private final Provider<Context> appContextProvider;

    private final Provider<ListeningExecutorService> backgroundExecutorProvider;

    private final Provider<ListeningExecutorService> lightweightExecutorProvider;

    public MissingPermissionsOperations_Factory(
            Provider<Context> appContextProvider,
            Provider<ListeningExecutorService> backgroundExecutorProvider,
            Provider<ListeningExecutorService> lightweightExecutorProvider) {
        assert appContextProvider != null;
        this.appContextProvider = appContextProvider;
        assert backgroundExecutorProvider != null;
        this.backgroundExecutorProvider = backgroundExecutorProvider;
        assert lightweightExecutorProvider != null;
        this.lightweightExecutorProvider = lightweightExecutorProvider;
    }

    public static Factory<MissingPermissionsOperations> create(
            Provider<Context> appContextProvider,
            Provider<ListeningExecutorService> backgroundExecutorProvider,
            Provider<ListeningExecutorService> lightweightExecutorProvider) {
        return new MissingPermissionsOperations_Factory(
                appContextProvider, backgroundExecutorProvider, lightweightExecutorProvider);
    }

    @Override
    public MissingPermissionsOperations get() {
        return new MissingPermissionsOperations(
                appContextProvider.get(),
                backgroundExecutorProvider.get(),
                lightweightExecutorProvider.get());
    }
}
