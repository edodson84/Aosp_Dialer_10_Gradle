package com.fissy.dialer.simulator.stub;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum SimulatorEnrichedCallStub_Factory implements Factory<SimulatorEnrichedCallStub> {
  INSTANCE;

  @Override
  public SimulatorEnrichedCallStub get() {
    return new SimulatorEnrichedCallStub();
  }

  public static Factory<SimulatorEnrichedCallStub> create() {
    return INSTANCE;
  }
}
