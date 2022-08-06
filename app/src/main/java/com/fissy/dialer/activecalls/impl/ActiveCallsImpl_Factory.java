package com.fissy.dialer.activecalls.impl;

import javax.annotation.Generated;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public enum ActiveCallsImpl_Factory implements Factory<ActiveCallsImpl> {
    INSTANCE;

    public static Factory<ActiveCallsImpl> create() {
        return INSTANCE;
    }

    @Override
    public ActiveCallsImpl get() {
        return new ActiveCallsImpl();
    }
}
