package com.fissy.dialer.duo.stub;

import javax.annotation.Generated;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public enum DuoStub_Factory implements Factory<DuoStub> {
    INSTANCE;

    public static Factory<DuoStub> create() {
        return INSTANCE;
    }

    @Override
    public DuoStub get() {
        return new DuoStub();
    }
}
