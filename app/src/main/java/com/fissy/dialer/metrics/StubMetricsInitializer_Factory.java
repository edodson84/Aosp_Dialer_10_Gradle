package com.fissy.dialer.metrics;

import javax.annotation.Generated;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public enum StubMetricsInitializer_Factory implements Factory<StubMetricsInitializer> {
    INSTANCE;

    public static Factory<StubMetricsInitializer> create() {
        return INSTANCE;
    }

    @Override
    public StubMetricsInitializer get() {
        return new StubMetricsInitializer();
    }
}
