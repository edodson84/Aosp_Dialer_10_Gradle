package com.fissy.dialer.spam.stub;

import javax.annotation.Generated;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public enum SpamSettingsStub_Factory implements Factory<SpamSettingsStub> {
    INSTANCE;

    public static Factory<SpamSettingsStub> create() {
        return INSTANCE;
    }

    @Override
    public SpamSettingsStub get() {
        return new SpamSettingsStub();
    }
}
