package com.fissy.dialer.calllog.config;

import android.content.Context;
import android.content.SharedPreferences;

import com.fissy.dialer.calllog.CallLogFramework;
import com.fissy.dialer.configprovider.ConfigProvider;
import com.google.common.util.concurrent.ListeningExecutorService;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class CallLogConfigImpl_Factory implements Factory<CallLogConfigImpl> {
    private final Provider<Context> appContextProvider;

    private final Provider<CallLogFramework> callLogFrameworkProvider;

    private final Provider<SharedPreferences> sharedPreferencesProvider;

    private final Provider<ConfigProvider> configProvider;

    private final Provider<ListeningExecutorService> backgroundExecutorProvider;

    public CallLogConfigImpl_Factory(
            Provider<Context> appContextProvider,
            Provider<CallLogFramework> callLogFrameworkProvider,
            Provider<SharedPreferences> sharedPreferencesProvider,
            Provider<ConfigProvider> configProvider,
            Provider<ListeningExecutorService> backgroundExecutorProvider) {
        assert appContextProvider != null;
        this.appContextProvider = appContextProvider;
        assert callLogFrameworkProvider != null;
        this.callLogFrameworkProvider = callLogFrameworkProvider;
        assert sharedPreferencesProvider != null;
        this.sharedPreferencesProvider = sharedPreferencesProvider;
        assert configProvider != null;
        this.configProvider = configProvider;
        assert backgroundExecutorProvider != null;
        this.backgroundExecutorProvider = backgroundExecutorProvider;
    }

    public static Factory<CallLogConfigImpl> create(
            Provider<Context> appContextProvider,
            Provider<CallLogFramework> callLogFrameworkProvider,
            Provider<SharedPreferences> sharedPreferencesProvider,
            Provider<ConfigProvider> configProvider,
            Provider<ListeningExecutorService> backgroundExecutorProvider) {
        return new CallLogConfigImpl_Factory(
                appContextProvider,
                callLogFrameworkProvider,
                sharedPreferencesProvider,
                configProvider,
                backgroundExecutorProvider);
    }

    @Override
    public CallLogConfigImpl get() {
        return new CallLogConfigImpl(
                appContextProvider.get(),
                callLogFrameworkProvider.get(),
                sharedPreferencesProvider.get(),
                configProvider.get(),
                backgroundExecutorProvider.get());
    }
}
