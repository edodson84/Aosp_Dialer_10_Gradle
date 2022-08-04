package com.fissy.dialer.phonelookup.emergency;

import android.content.Context;
import com.google.common.util.concurrent.ListeningExecutorService;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class EmergencyPhoneLookup_Factory implements Factory<EmergencyPhoneLookup> {
  private final Provider<Context> appContextProvider;

  private final Provider<ListeningExecutorService> backgroundExecutorServiceProvider;

  public EmergencyPhoneLookup_Factory(
      Provider<Context> appContextProvider,
      Provider<ListeningExecutorService> backgroundExecutorServiceProvider) {
    assert appContextProvider != null;
    this.appContextProvider = appContextProvider;
    assert backgroundExecutorServiceProvider != null;
    this.backgroundExecutorServiceProvider = backgroundExecutorServiceProvider;
  }

  @Override
  public EmergencyPhoneLookup get() {
    return new EmergencyPhoneLookup(
        appContextProvider.get(), backgroundExecutorServiceProvider.get());
  }

  public static Factory<EmergencyPhoneLookup> create(
      Provider<Context> appContextProvider,
      Provider<ListeningExecutorService> backgroundExecutorServiceProvider) {
    return new EmergencyPhoneLookup_Factory(appContextProvider, backgroundExecutorServiceProvider);
  }
}
