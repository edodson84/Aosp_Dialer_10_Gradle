package com.fissy.dialer.calllog.database;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum CallLogDatabaseModule_ProvideMaxRowsFactory implements Factory<Integer> {
  INSTANCE;

  @Override
  public Integer get() {
    return Preconditions.checkNotNull(
        CallLogDatabaseModule.provideMaxRows(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Integer> create() {
    return INSTANCE;
  }
}
