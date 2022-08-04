package com.fissy.dialer.configprovider;

import android.content.SharedPreferences;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SharedPrefConfigProvider_Factory implements Factory<SharedPrefConfigProvider> {
  private final Provider<SharedPreferences> sharedPreferencesProvider;

  public SharedPrefConfigProvider_Factory(Provider<SharedPreferences> sharedPreferencesProvider) {
    assert sharedPreferencesProvider != null;
    this.sharedPreferencesProvider = sharedPreferencesProvider;
  }

  @Override
  public SharedPrefConfigProvider get() {
    return new SharedPrefConfigProvider(sharedPreferencesProvider.get());
  }

  public static Factory<SharedPrefConfigProvider> create(
      Provider<SharedPreferences> sharedPreferencesProvider) {
    return new SharedPrefConfigProvider_Factory(sharedPreferencesProvider);
  }
}
