package com.fissy.dialer.calllog;

import android.content.Context;
import com.google.common.util.concurrent.ListeningExecutorService;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CallLogCacheUpdater_Factory implements Factory<CallLogCacheUpdater> {
  private final Provider<Context> appContextProvider;

  private final Provider<ListeningExecutorService> backgroundExecutorProvider;

  private final Provider<CallLogState> callLogStateProvider;

  public CallLogCacheUpdater_Factory(
      Provider<Context> appContextProvider,
      Provider<ListeningExecutorService> backgroundExecutorProvider,
      Provider<CallLogState> callLogStateProvider) {
    assert appContextProvider != null;
    this.appContextProvider = appContextProvider;
    assert backgroundExecutorProvider != null;
    this.backgroundExecutorProvider = backgroundExecutorProvider;
    assert callLogStateProvider != null;
    this.callLogStateProvider = callLogStateProvider;
  }

  @Override
  public CallLogCacheUpdater get() {
    return new CallLogCacheUpdater(
        appContextProvider.get(), backgroundExecutorProvider.get(), callLogStateProvider.get());
  }

  public static Factory<CallLogCacheUpdater> create(
      Provider<Context> appContextProvider,
      Provider<ListeningExecutorService> backgroundExecutorProvider,
      Provider<CallLogState> callLogStateProvider) {
    return new CallLogCacheUpdater_Factory(
        appContextProvider, backgroundExecutorProvider, callLogStateProvider);
  }
}
