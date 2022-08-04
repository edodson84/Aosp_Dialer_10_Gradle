package com.fissy.dialer.metrics;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum StubMetrics_Factory implements Factory<StubMetrics> {
  INSTANCE;

  @Override
  public StubMetrics get() {
    return new StubMetrics();
  }

  public static Factory<StubMetrics> create() {
    return INSTANCE;
  }
}
