package com.fissy.dialer.commandline.impl;

import javax.annotation.Generated;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public enum Echo_Factory implements Factory<Echo> {
    INSTANCE;

    public static Factory<Echo> create() {
        return INSTANCE;
    }

    @Override
    public Echo get() {
        return new Echo();
    }
}
