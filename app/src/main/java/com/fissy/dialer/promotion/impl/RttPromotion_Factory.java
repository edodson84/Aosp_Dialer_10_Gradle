package com.fissy.dialer.promotion.impl;

import android.content.Context;
import android.content.SharedPreferences;

import com.fissy.dialer.configprovider.ConfigProvider;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class RttPromotion_Factory implements Factory<RttPromotion> {
    private final Provider<Context> contextProvider;

    private final Provider<SharedPreferences> sharedPreferencesProvider;

    private final Provider<ConfigProvider> configProvider;

    public RttPromotion_Factory(
            Provider<Context> contextProvider,
            Provider<SharedPreferences> sharedPreferencesProvider,
            Provider<ConfigProvider> configProvider) {
        assert contextProvider != null;
        this.contextProvider = contextProvider;
        assert sharedPreferencesProvider != null;
        this.sharedPreferencesProvider = sharedPreferencesProvider;
        assert configProvider != null;
        this.configProvider = configProvider;
    }

    public static Factory<RttPromotion> create(
            Provider<Context> contextProvider,
            Provider<SharedPreferences> sharedPreferencesProvider,
            Provider<ConfigProvider> configProvider) {
        return new RttPromotion_Factory(contextProvider, sharedPreferencesProvider, configProvider);
    }

    @Override
    public RttPromotion get() {
        return new RttPromotion(
                contextProvider.get(), sharedPreferencesProvider.get(), configProvider.get());
    }
}
