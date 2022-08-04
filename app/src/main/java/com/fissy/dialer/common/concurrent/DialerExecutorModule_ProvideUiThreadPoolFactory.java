package com.fissy.dialer.common.concurrent;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.concurrent.ExecutorService;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum DialerExecutorModule_ProvideUiThreadPoolFactory implements Factory<ExecutorService> {
  INSTANCE;

  @Override
  public ExecutorService get() {
    return Preconditions.checkNotNull(
        DialerExecutorModule.provideUiThreadPool(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ExecutorService> create() {
    return INSTANCE;
  }
}
