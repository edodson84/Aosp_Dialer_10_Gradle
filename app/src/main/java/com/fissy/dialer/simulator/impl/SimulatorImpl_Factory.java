package com.fissy.dialer.simulator.impl;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum SimulatorImpl_Factory implements Factory<SimulatorImpl> {
  INSTANCE;

  @Override
  public SimulatorImpl get() {
    return new SimulatorImpl();
  }

  public static Factory<SimulatorImpl> create() {
    return INSTANCE;
  }
}
