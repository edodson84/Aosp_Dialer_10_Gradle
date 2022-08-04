package com.fissy.dialer.calllog.ui;

import android.content.Context;
import com.fissy.dialer.phonelookup.composite.CompositePhoneLookup;
import com.google.common.util.concurrent.ListeningExecutorService;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RealtimeRowProcessor_Factory implements Factory<RealtimeRowProcessor> {
  private final Provider<Context> appContextProvider;

  private final Provider<ListeningExecutorService> uiExecutorProvider;

  private final Provider<ListeningExecutorService> backgroundExecutorProvider;

  private final Provider<CompositePhoneLookup> compositePhoneLookupProvider;

  public RealtimeRowProcessor_Factory(
      Provider<Context> appContextProvider,
      Provider<ListeningExecutorService> uiExecutorProvider,
      Provider<ListeningExecutorService> backgroundExecutorProvider,
      Provider<CompositePhoneLookup> compositePhoneLookupProvider) {
    assert appContextProvider != null;
    this.appContextProvider = appContextProvider;
    assert uiExecutorProvider != null;
    this.uiExecutorProvider = uiExecutorProvider;
    assert backgroundExecutorProvider != null;
    this.backgroundExecutorProvider = backgroundExecutorProvider;
    assert compositePhoneLookupProvider != null;
    this.compositePhoneLookupProvider = compositePhoneLookupProvider;
  }

  @Override
  public RealtimeRowProcessor get() {
    return new RealtimeRowProcessor(
        appContextProvider.get(),
        uiExecutorProvider.get(),
        backgroundExecutorProvider.get(),
        compositePhoneLookupProvider.get());
  }

  public static Factory<RealtimeRowProcessor> create(
      Provider<Context> appContextProvider,
      Provider<ListeningExecutorService> uiExecutorProvider,
      Provider<ListeningExecutorService> backgroundExecutorProvider,
      Provider<CompositePhoneLookup> compositePhoneLookupProvider) {
    return new RealtimeRowProcessor_Factory(
        appContextProvider,
        uiExecutorProvider,
        backgroundExecutorProvider,
        compositePhoneLookupProvider);
  }
}
