package com.fissy.dialer.common.concurrent;

import dagger.internal.Factory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DefaultDialerExecutorFactory_Factory
    implements Factory<DefaultDialerExecutorFactory> {
  private final Provider<ExecutorService> nonUiThreadPoolProvider;

  private final Provider<ScheduledExecutorService> nonUiSerialExecutorProvider;

  private final Provider<ExecutorService> uiThreadPoolProvider;

  private final Provider<ScheduledExecutorService> uiSerialExecutorProvider;

  public DefaultDialerExecutorFactory_Factory(
      Provider<ExecutorService> nonUiThreadPoolProvider,
      Provider<ScheduledExecutorService> nonUiSerialExecutorProvider,
      Provider<ExecutorService> uiThreadPoolProvider,
      Provider<ScheduledExecutorService> uiSerialExecutorProvider) {
    assert nonUiThreadPoolProvider != null;
    this.nonUiThreadPoolProvider = nonUiThreadPoolProvider;
    assert nonUiSerialExecutorProvider != null;
    this.nonUiSerialExecutorProvider = nonUiSerialExecutorProvider;
    assert uiThreadPoolProvider != null;
    this.uiThreadPoolProvider = uiThreadPoolProvider;
    assert uiSerialExecutorProvider != null;
    this.uiSerialExecutorProvider = uiSerialExecutorProvider;
  }

  @Override
  public DefaultDialerExecutorFactory get() {
    return new DefaultDialerExecutorFactory(
        nonUiThreadPoolProvider.get(),
        nonUiSerialExecutorProvider.get(),
        uiThreadPoolProvider.get(),
        uiSerialExecutorProvider.get());
  }

  public static Factory<DefaultDialerExecutorFactory> create(
      Provider<ExecutorService> nonUiThreadPoolProvider,
      Provider<ScheduledExecutorService> nonUiSerialExecutorProvider,
      Provider<ExecutorService> uiThreadPoolProvider,
      Provider<ScheduledExecutorService> uiSerialExecutorProvider) {
    return new DefaultDialerExecutorFactory_Factory(
        nonUiThreadPoolProvider,
        nonUiSerialExecutorProvider,
        uiThreadPoolProvider,
        uiSerialExecutorProvider);
  }
}
