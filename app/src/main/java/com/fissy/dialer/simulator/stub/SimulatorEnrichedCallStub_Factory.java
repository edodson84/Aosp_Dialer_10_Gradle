package com.fissy.dialer.simulator.stub;

import javax.annotation.Generated;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public enum SimulatorEnrichedCallStub_Factory implements Factory<SimulatorEnrichedCallStub> {
    INSTANCE;

    public static Factory<SimulatorEnrichedCallStub> create() {
        return INSTANCE;
    }

    @Override
    public SimulatorEnrichedCallStub get() {
        return new SimulatorEnrichedCallStub();
    }
}
