package com.fissy.dialer.preferredsim.impl;

import android.content.Context;
import com.google.common.util.concurrent.ListeningExecutorService;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PreferredAccountWorkerImpl_Factory
    implements Factory<PreferredAccountWorkerImpl> {
  private final Provider<Context> appContextProvider;

  private final Provider<ListeningExecutorService> backgroundExecutorProvider;

  public PreferredAccountWorkerImpl_Factory(
      Provider<Context> appContextProvider,
      Provider<ListeningExecutorService> backgroundExecutorProvider) {
    assert appContextProvider != null;
    this.appContextProvider = appContextProvider;
    assert backgroundExecutorProvider != null;
    this.backgroundExecutorProvider = backgroundExecutorProvider;
  }

  @Override
  public PreferredAccountWorkerImpl get() {
    return new PreferredAccountWorkerImpl(
        appContextProvider.get(), backgroundExecutorProvider.get());
  }

  public static Factory<PreferredAccountWorkerImpl> create(
      Provider<Context> appContextProvider,
      Provider<ListeningExecutorService> backgroundExecutorProvider) {
    return new PreferredAccountWorkerImpl_Factory(appContextProvider, backgroundExecutorProvider);
  }
}
