package com.android.voicemail.impl;

import javax.annotation.Generated;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public enum VoicemailClientImpl_Factory implements Factory<VoicemailClientImpl> {
    INSTANCE;

    public static Factory<VoicemailClientImpl> create() {
        return INSTANCE;
    }

    @Override
    public VoicemailClientImpl get() {
        return new VoicemailClientImpl();
    }
}
