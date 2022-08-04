package com.fissy.dialer.phonelookup.cnap;

import android.content.Context;
import com.google.common.util.concurrent.ListeningExecutorService;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CnapPhoneLookup_Factory implements Factory<CnapPhoneLookup> {
  private final Provider<Context> appContextProvider;

  private final Provider<ListeningExecutorService> backgroundExecutorServiceProvider;

  public CnapPhoneLookup_Factory(
      Provider<Context> appContextProvider,
      Provider<ListeningExecutorService> backgroundExecutorServiceProvider) {
    assert appContextProvider != null;
    this.appContextProvider = appContextProvider;
    assert backgroundExecutorServiceProvider != null;
    this.backgroundExecutorServiceProvider = backgroundExecutorServiceProvider;
  }

  @Override
  public CnapPhoneLookup get() {
    return new CnapPhoneLookup(appContextProvider.get(), backgroundExecutorServiceProvider.get());
  }

  public static Factory<CnapPhoneLookup> create(
      Provider<Context> appContextProvider,
      Provider<ListeningExecutorService> backgroundExecutorServiceProvider) {
    return new CnapPhoneLookup_Factory(appContextProvider, backgroundExecutorServiceProvider);
  }
}
