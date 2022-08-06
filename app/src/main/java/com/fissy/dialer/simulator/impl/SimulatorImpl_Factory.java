package com.fissy.dialer.simulator.impl;

import javax.annotation.Generated;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public enum SimulatorImpl_Factory implements Factory<SimulatorImpl> {
    INSTANCE;

    public static Factory<SimulatorImpl> create() {
        return INSTANCE;
    }

    @Override
    public SimulatorImpl get() {
        return new SimulatorImpl();
    }
}
