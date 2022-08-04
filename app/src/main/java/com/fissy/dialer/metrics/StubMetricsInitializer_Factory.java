package com.fissy.dialer.metrics;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum StubMetricsInitializer_Factory implements Factory<StubMetricsInitializer> {
  INSTANCE;

  @Override
  public StubMetricsInitializer get() {
    return new StubMetricsInitializer();
  }

  public static Factory<StubMetricsInitializer> create() {
    return INSTANCE;
  }
}
