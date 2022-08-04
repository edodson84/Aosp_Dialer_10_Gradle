package com.fissy.dialer.calllog;

import android.content.SharedPreferences;
import com.google.common.util.concurrent.ListeningExecutorService;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AnnotatedCallLogMigrator_Factory implements Factory<AnnotatedCallLogMigrator> {
  private final Provider<SharedPreferences> sharedPreferencesProvider;

  private final Provider<ListeningExecutorService> backgroundExecutorProvider;

  private final Provider<RefreshAnnotatedCallLogWorker> refreshAnnotatedCallLogWorkerProvider;

  public AnnotatedCallLogMigrator_Factory(
      Provider<SharedPreferences> sharedPreferencesProvider,
      Provider<ListeningExecutorService> backgroundExecutorProvider,
      Provider<RefreshAnnotatedCallLogWorker> refreshAnnotatedCallLogWorkerProvider) {
    assert sharedPreferencesProvider != null;
    this.sharedPreferencesProvider = sharedPreferencesProvider;
    assert backgroundExecutorProvider != null;
    this.backgroundExecutorProvider = backgroundExecutorProvider;
    assert refreshAnnotatedCallLogWorkerProvider != null;
    this.refreshAnnotatedCallLogWorkerProvider = refreshAnnotatedCallLogWorkerProvider;
  }

  @Override
  public AnnotatedCallLogMigrator get() {
    return new AnnotatedCallLogMigrator(
        sharedPreferencesProvider.get(),
        backgroundExecutorProvider.get(),
        refreshAnnotatedCallLogWorkerProvider.get());
  }

  public static Factory<AnnotatedCallLogMigrator> create(
      Provider<SharedPreferences> sharedPreferencesProvider,
      Provider<ListeningExecutorService> backgroundExecutorProvider,
      Provider<RefreshAnnotatedCallLogWorker> refreshAnnotatedCallLogWorkerProvider) {
    return new AnnotatedCallLogMigrator_Factory(
        sharedPreferencesProvider,
        backgroundExecutorProvider,
        refreshAnnotatedCallLogWorkerProvider);
  }
}
