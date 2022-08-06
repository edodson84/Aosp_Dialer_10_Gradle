package com.fissy.dialer.calllog;

import android.content.SharedPreferences;

import com.google.common.util.concurrent.ListeningExecutorService;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class CallLogState_Factory implements Factory<CallLogState> {
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    private final Provider<ListeningExecutorService> backgroundExecutorProvider;

    public CallLogState_Factory(
            Provider<SharedPreferences> sharedPreferencesProvider,
            Provider<ListeningExecutorService> backgroundExecutorProvider) {
        assert sharedPreferencesProvider != null;
        this.sharedPreferencesProvider = sharedPreferencesProvider;
        assert backgroundExecutorProvider != null;
        this.backgroundExecutorProvider = backgroundExecutorProvider;
    }

    public static Factory<CallLogState> create(
            Provider<SharedPreferences> sharedPreferencesProvider,
            Provider<ListeningExecutorService> backgroundExecutorProvider) {
        return new CallLogState_Factory(sharedPreferencesProvider, backgroundExecutorProvider);
    }

    @Override
    public CallLogState get() {
        return new CallLogState(sharedPreferencesProvider.get(), backgroundExecutorProvider.get());
    }
}
