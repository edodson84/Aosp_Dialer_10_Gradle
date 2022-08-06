package com.fissy.dialer.phonelookup.cp2;

import android.content.Context;
import android.content.SharedPreferences;

import com.fissy.dialer.configprovider.ConfigProvider;
import com.google.common.util.concurrent.ListeningExecutorService;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class Cp2DefaultDirectoryPhoneLookup_Factory
        implements Factory<Cp2DefaultDirectoryPhoneLookup> {
    private final Provider<Context> appContextProvider;

    private final Provider<SharedPreferences> sharedPreferencesProvider;

    private final Provider<ListeningExecutorService> backgroundExecutorServiceProvider;

    private final Provider<ListeningExecutorService> lightweightExecutorServiceProvider;

    private final Provider<ConfigProvider> configProvider;

    private final Provider<MissingPermissionsOperations> missingPermissionsOperationsProvider;

    public Cp2DefaultDirectoryPhoneLookup_Factory(
            Provider<Context> appContextProvider,
            Provider<SharedPreferences> sharedPreferencesProvider,
            Provider<ListeningExecutorService> backgroundExecutorServiceProvider,
            Provider<ListeningExecutorService> lightweightExecutorServiceProvider,
            Provider<ConfigProvider> configProvider,
            Provider<MissingPermissionsOperations> missingPermissionsOperationsProvider) {
        assert appContextProvider != null;
        this.appContextProvider = appContextProvider;
        assert sharedPreferencesProvider != null;
        this.sharedPreferencesProvider = sharedPreferencesProvider;
        assert backgroundExecutorServiceProvider != null;
        this.backgroundExecutorServiceProvider = backgroundExecutorServiceProvider;
        assert lightweightExecutorServiceProvider != null;
        this.lightweightExecutorServiceProvider = lightweightExecutorServiceProvider;
        assert configProvider != null;
        this.configProvider = configProvider;
        assert missingPermissionsOperationsProvider != null;
        this.missingPermissionsOperationsProvider = missingPermissionsOperationsProvider;
    }

    public static Factory<Cp2DefaultDirectoryPhoneLookup> create(
            Provider<Context> appContextProvider,
            Provider<SharedPreferences> sharedPreferencesProvider,
            Provider<ListeningExecutorService> backgroundExecutorServiceProvider,
            Provider<ListeningExecutorService> lightweightExecutorServiceProvider,
            Provider<ConfigProvider> configProvider,
            Provider<MissingPermissionsOperations> missingPermissionsOperationsProvider) {
        return new Cp2DefaultDirectoryPhoneLookup_Factory(
                appContextProvider,
                sharedPreferencesProvider,
                backgroundExecutorServiceProvider,
                lightweightExecutorServiceProvider,
                configProvider,
                missingPermissionsOperationsProvider);
    }

    @Override
    public Cp2DefaultDirectoryPhoneLookup get() {
        return new Cp2DefaultDirectoryPhoneLookup(
                appContextProvider.get(),
                sharedPreferencesProvider.get(),
                backgroundExecutorServiceProvider.get(),
                lightweightExecutorServiceProvider.get(),
                configProvider.get(),
                missingPermissionsOperationsProvider.get());
    }
}
