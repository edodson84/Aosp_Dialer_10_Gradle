package com.fissy.dialer.simulator.impl;

import javax.annotation.Generated;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public enum SimulatorConnectionsBankImpl_Factory implements Factory<SimulatorConnectionsBankImpl> {
    INSTANCE;

    public static Factory<SimulatorConnectionsBankImpl> create() {
        return INSTANCE;
    }

    @Override
    public SimulatorConnectionsBankImpl get() {
        return new SimulatorConnectionsBankImpl();
    }
}
