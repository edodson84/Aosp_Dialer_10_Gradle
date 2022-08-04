package com.fissy.dialer.common.concurrent;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum DialerExecutorModule_ProvideUiSerialExecutorServiceFactory
    implements Factory<ScheduledExecutorService> {
  INSTANCE;

  @Override
  public ScheduledExecutorService get() {
    return Preconditions.checkNotNull(
        DialerExecutorModule.provideUiSerialExecutorService(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ScheduledExecutorService> create() {
    return INSTANCE;
  }
}
