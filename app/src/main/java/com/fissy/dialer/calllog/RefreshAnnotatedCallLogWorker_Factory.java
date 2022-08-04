package com.fissy.dialer.calllog;

import android.content.Context;
import android.content.SharedPreferences;
import com.fissy.dialer.calllog.database.MutationApplier;
import com.fissy.dialer.calllog.datasources.DataSources;
import com.fissy.dialer.metrics.FutureTimer;
import com.google.common.util.concurrent.ListeningExecutorService;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RefreshAnnotatedCallLogWorker_Factory
    implements Factory<RefreshAnnotatedCallLogWorker> {
  private final Provider<Context> appContextProvider;

  private final Provider<DataSources> dataSourcesProvider;

  private final Provider<SharedPreferences> sharedPreferencesProvider;

  private final Provider<MutationApplier> mutationApplierProvider;

  private final Provider<FutureTimer> futureTimerProvider;

  private final Provider<CallLogState> callLogStateProvider;

  private final Provider<CallLogCacheUpdater> callLogCacheUpdaterProvider;

  private final Provider<ListeningExecutorService> backgroundExecutorServiceProvider;

  private final Provider<ListeningExecutorService> lightweightExecutorServiceProvider;

  public RefreshAnnotatedCallLogWorker_Factory(
      Provider<Context> appContextProvider,
      Provider<DataSources> dataSourcesProvider,
      Provider<SharedPreferences> sharedPreferencesProvider,
      Provider<MutationApplier> mutationApplierProvider,
      Provider<FutureTimer> futureTimerProvider,
      Provider<CallLogState> callLogStateProvider,
      Provider<CallLogCacheUpdater> callLogCacheUpdaterProvider,
      Provider<ListeningExecutorService> backgroundExecutorServiceProvider,
      Provider<ListeningExecutorService> lightweightExecutorServiceProvider) {
    assert appContextProvider != null;
    this.appContextProvider = appContextProvider;
    assert dataSourcesProvider != null;
    this.dataSourcesProvider = dataSourcesProvider;
    assert sharedPreferencesProvider != null;
    this.sharedPreferencesProvider = sharedPreferencesProvider;
    assert mutationApplierProvider != null;
    this.mutationApplierProvider = mutationApplierProvider;
    assert futureTimerProvider != null;
    this.futureTimerProvider = futureTimerProvider;
    assert callLogStateProvider != null;
    this.callLogStateProvider = callLogStateProvider;
    assert callLogCacheUpdaterProvider != null;
    this.callLogCacheUpdaterProvider = callLogCacheUpdaterProvider;
    assert backgroundExecutorServiceProvider != null;
    this.backgroundExecutorServiceProvider = backgroundExecutorServiceProvider;
    assert lightweightExecutorServiceProvider != null;
    this.lightweightExecutorServiceProvider = lightweightExecutorServiceProvider;
  }

  @Override
  public RefreshAnnotatedCallLogWorker get() {
    return new RefreshAnnotatedCallLogWorker(
        appContextProvider.get(),
        dataSourcesProvider.get(),
        sharedPreferencesProvider.get(),
        mutationApplierProvider.get(),
        futureTimerProvider.get(),
        callLogStateProvider.get(),
        callLogCacheUpdaterProvider.get(),
        backgroundExecutorServiceProvider.get(),
        lightweightExecutorServiceProvider.get());
  }

  public static Factory<RefreshAnnotatedCallLogWorker> create(
      Provider<Context> appContextProvider,
      Provider<DataSources> dataSourcesProvider,
      Provider<SharedPreferences> sharedPreferencesProvider,
      Provider<MutationApplier> mutationApplierProvider,
      Provider<FutureTimer> futureTimerProvider,
      Provider<CallLogState> callLogStateProvider,
      Provider<CallLogCacheUpdater> callLogCacheUpdaterProvider,
      Provider<ListeningExecutorService> backgroundExecutorServiceProvider,
      Provider<ListeningExecutorService> lightweightExecutorServiceProvider) {
    return new RefreshAnnotatedCallLogWorker_Factory(
        appContextProvider,
        dataSourcesProvider,
        sharedPreferencesProvider,
        mutationApplierProvider,
        futureTimerProvider,
        callLogStateProvider,
        callLogCacheUpdaterProvider,
        backgroundExecutorServiceProvider,
        lightweightExecutorServiceProvider);
  }
}
