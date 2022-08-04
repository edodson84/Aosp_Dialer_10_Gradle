package com.fissy.dialer.calllog.datasources.systemcalllog;

import android.content.Context;
import android.content.SharedPreferences;
import com.fissy.dialer.calllog.database.AnnotatedCallLogDatabaseHelper;
import com.fissy.dialer.calllog.observer.MarkDirtyObserver;
import com.fissy.dialer.duo.Duo;
import com.google.common.util.concurrent.ListeningExecutorService;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SystemCallLogDataSource_Factory implements Factory<SystemCallLogDataSource> {
  private final Provider<Context> appContextProvider;

  private final Provider<ListeningExecutorService> backgroundExecutorServiceProvider;

  private final Provider<MarkDirtyObserver> markDirtyObserverProvider;

  private final Provider<SharedPreferences> sharedPreferencesProvider;

  private final Provider<AnnotatedCallLogDatabaseHelper> annotatedCallLogDatabaseHelperProvider;

  private final Provider<Duo> duoProvider;

  public SystemCallLogDataSource_Factory(
      Provider<Context> appContextProvider,
      Provider<ListeningExecutorService> backgroundExecutorServiceProvider,
      Provider<MarkDirtyObserver> markDirtyObserverProvider,
      Provider<SharedPreferences> sharedPreferencesProvider,
      Provider<AnnotatedCallLogDatabaseHelper> annotatedCallLogDatabaseHelperProvider,
      Provider<Duo> duoProvider) {
    assert appContextProvider != null;
    this.appContextProvider = appContextProvider;
    assert backgroundExecutorServiceProvider != null;
    this.backgroundExecutorServiceProvider = backgroundExecutorServiceProvider;
    assert markDirtyObserverProvider != null;
    this.markDirtyObserverProvider = markDirtyObserverProvider;
    assert sharedPreferencesProvider != null;
    this.sharedPreferencesProvider = sharedPreferencesProvider;
    assert annotatedCallLogDatabaseHelperProvider != null;
    this.annotatedCallLogDatabaseHelperProvider = annotatedCallLogDatabaseHelperProvider;
    assert duoProvider != null;
    this.duoProvider = duoProvider;
  }

  @Override
  public SystemCallLogDataSource get() {
    return new SystemCallLogDataSource(
        appContextProvider.get(),
        backgroundExecutorServiceProvider.get(),
        markDirtyObserverProvider.get(),
        sharedPreferencesProvider.get(),
        annotatedCallLogDatabaseHelperProvider.get(),
        duoProvider.get());
  }

  public static Factory<SystemCallLogDataSource> create(
      Provider<Context> appContextProvider,
      Provider<ListeningExecutorService> backgroundExecutorServiceProvider,
      Provider<MarkDirtyObserver> markDirtyObserverProvider,
      Provider<SharedPreferences> sharedPreferencesProvider,
      Provider<AnnotatedCallLogDatabaseHelper> annotatedCallLogDatabaseHelperProvider,
      Provider<Duo> duoProvider) {
    return new SystemCallLogDataSource_Factory(
        appContextProvider,
        backgroundExecutorServiceProvider,
        markDirtyObserverProvider,
        sharedPreferencesProvider,
        annotatedCallLogDatabaseHelperProvider,
        duoProvider);
  }
}
