package com.fissy.dialer.strictmode.impl;

import javax.annotation.Generated;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public enum SystemDialerStrictMode_Factory implements Factory<SystemDialerStrictMode> {
    INSTANCE;

    public static Factory<SystemDialerStrictMode> create() {
        return INSTANCE;
    }

    @Override
    public SystemDialerStrictMode get() {
        return new SystemDialerStrictMode();
    }
}
