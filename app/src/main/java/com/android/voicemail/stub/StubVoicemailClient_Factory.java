package com.android.voicemail.stub;

import javax.annotation.Generated;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public enum StubVoicemailClient_Factory implements Factory<StubVoicemailClient> {
    INSTANCE;

    public static Factory<StubVoicemailClient> create() {
        return INSTANCE;
    }

    @Override
    public StubVoicemailClient get() {
        return new StubVoicemailClient();
    }
}
