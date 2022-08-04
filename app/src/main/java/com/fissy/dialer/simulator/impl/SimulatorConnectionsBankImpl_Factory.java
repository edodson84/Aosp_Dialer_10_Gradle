package com.fissy.dialer.simulator.impl;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum SimulatorConnectionsBankImpl_Factory implements Factory<SimulatorConnectionsBankImpl> {
  INSTANCE;

  @Override
  public SimulatorConnectionsBankImpl get() {
    return new SimulatorConnectionsBankImpl();
  }

  public static Factory<SimulatorConnectionsBankImpl> create() {
    return INSTANCE;
  }
}
