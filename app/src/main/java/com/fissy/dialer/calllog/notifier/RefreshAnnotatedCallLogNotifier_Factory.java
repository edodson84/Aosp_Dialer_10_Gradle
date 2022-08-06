package com.fissy.dialer.calllog.notifier;

import android.content.Context;
import android.content.SharedPreferences;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class RefreshAnnotatedCallLogNotifier_Factory
        implements Factory<RefreshAnnotatedCallLogNotifier> {
    private final Provider<Context> appContextProvider;

    private final Provider<SharedPreferences> sharedPreferencesProvider;

    public RefreshAnnotatedCallLogNotifier_Factory(
            Provider<Context> appContextProvider, Provider<SharedPreferences> sharedPreferencesProvider) {
        assert appContextProvider != null;
        this.appContextProvider = appContextProvider;
        assert sharedPreferencesProvider != null;
        this.sharedPreferencesProvider = sharedPreferencesProvider;
    }

    public static Factory<RefreshAnnotatedCallLogNotifier> create(
            Provider<Context> appContextProvider, Provider<SharedPreferences> sharedPreferencesProvider) {
        return new RefreshAnnotatedCallLogNotifier_Factory(
                appContextProvider, sharedPreferencesProvider);
    }

    @Override
    public RefreshAnnotatedCallLogNotifier get() {
        return new RefreshAnnotatedCallLogNotifier(
                appContextProvider.get(), sharedPreferencesProvider.get());
    }
}
