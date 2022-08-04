package com.fissy.dialer.calllog;

import android.content.Context;
import com.fissy.dialer.calllog.datasources.DataSources;
import com.google.common.util.concurrent.ListeningExecutorService;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CallLogFramework_Factory implements Factory<CallLogFramework> {
  private final Provider<Context> appContextProvider;

  private final Provider<DataSources> dataSourcesProvider;

  private final Provider<AnnotatedCallLogMigrator> annotatedCallLogMigratorProvider;

  private final Provider<ListeningExecutorService> uiExecutorProvider;

  private final Provider<CallLogState> callLogStateProvider;

  public CallLogFramework_Factory(
      Provider<Context> appContextProvider,
      Provider<DataSources> dataSourcesProvider,
      Provider<AnnotatedCallLogMigrator> annotatedCallLogMigratorProvider,
      Provider<ListeningExecutorService> uiExecutorProvider,
      Provider<CallLogState> callLogStateProvider) {
    assert appContextProvider != null;
    this.appContextProvider = appContextProvider;
    assert dataSourcesProvider != null;
    this.dataSourcesProvider = dataSourcesProvider;
    assert annotatedCallLogMigratorProvider != null;
    this.annotatedCallLogMigratorProvider = annotatedCallLogMigratorProvider;
    assert uiExecutorProvider != null;
    this.uiExecutorProvider = uiExecutorProvider;
    assert callLogStateProvider != null;
    this.callLogStateProvider = callLogStateProvider;
  }

  @Override
  public CallLogFramework get() {
    return new CallLogFramework(
        appContextProvider.get(),
        dataSourcesProvider.get(),
        annotatedCallLogMigratorProvider.get(),
        uiExecutorProvider.get(),
        callLogStateProvider.get());
  }

  public static Factory<CallLogFramework> create(
      Provider<Context> appContextProvider,
      Provider<DataSources> dataSourcesProvider,
      Provider<AnnotatedCallLogMigrator> annotatedCallLogMigratorProvider,
      Provider<ListeningExecutorService> uiExecutorProvider,
      Provider<CallLogState> callLogStateProvider) {
    return new CallLogFramework_Factory(
        appContextProvider,
        dataSourcesProvider,
        annotatedCallLogMigratorProvider,
        uiExecutorProvider,
        callLogStateProvider);
  }
}
