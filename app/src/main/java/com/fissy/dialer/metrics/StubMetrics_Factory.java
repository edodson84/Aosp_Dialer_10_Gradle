package com.fissy.dialer.metrics;

import javax.annotation.Generated;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public enum StubMetrics_Factory implements Factory<StubMetrics> {
    INSTANCE;

    public static Factory<StubMetrics> create() {
        return INSTANCE;
    }

    @Override
    public StubMetrics get() {
        return new StubMetrics();
    }
}
