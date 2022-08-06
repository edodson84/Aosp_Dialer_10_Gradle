package com.fissy.dialer.storage;

import android.content.Context;
import android.content.SharedPreferences;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class StorageModule_ProvideUnencryptedSharedPrefsFactory
        implements Factory<SharedPreferences> {
    private final Provider<Context> appContextProvider;

    public StorageModule_ProvideUnencryptedSharedPrefsFactory(Provider<Context> appContextProvider) {
        assert appContextProvider != null;
        this.appContextProvider = appContextProvider;
    }

    public static Factory<SharedPreferences> create(Provider<Context> appContextProvider) {
        return new StorageModule_ProvideUnencryptedSharedPrefsFactory(appContextProvider);
    }

    @Override
    public SharedPreferences get() {
        return Preconditions.checkNotNull(
                StorageModule.provideUnencryptedSharedPrefs(appContextProvider.get()),
                "Cannot return null from a non-@Nullable @Provides method");
    }
}
