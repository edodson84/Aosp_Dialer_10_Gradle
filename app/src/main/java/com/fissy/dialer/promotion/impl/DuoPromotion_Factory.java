package com.fissy.dialer.promotion.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.fissy.dialer.configprovider.ConfigProvider;
import com.fissy.dialer.duo.Duo;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DuoPromotion_Factory implements Factory<DuoPromotion> {
  private final Provider<Context> contextProvider;

  private final Provider<ConfigProvider> configProvider;

  private final Provider<Duo> duoProvider;

  private final Provider<SharedPreferences> sharedPreferencesProvider;

  public DuoPromotion_Factory(
      Provider<Context> contextProvider,
      Provider<ConfigProvider> configProvider,
      Provider<Duo> duoProvider,
      Provider<SharedPreferences> sharedPreferencesProvider) {
    assert contextProvider != null;
    this.contextProvider = contextProvider;
    assert configProvider != null;
    this.configProvider = configProvider;
    assert duoProvider != null;
    this.duoProvider = duoProvider;
    assert sharedPreferencesProvider != null;
    this.sharedPreferencesProvider = sharedPreferencesProvider;
  }

  @Override
  public DuoPromotion get() {
    return new DuoPromotion(
        contextProvider.get(),
        configProvider.get(),
        duoProvider.get(),
        sharedPreferencesProvider.get());
  }

  public static Factory<DuoPromotion> create(
      Provider<Context> contextProvider,
      Provider<ConfigProvider> configProvider,
      Provider<Duo> duoProvider,
      Provider<SharedPreferences> sharedPreferencesProvider) {
    return new DuoPromotion_Factory(
        contextProvider, configProvider, duoProvider, sharedPreferencesProvider);
  }
}
