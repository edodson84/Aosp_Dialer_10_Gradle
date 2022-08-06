package com.android.voicemail.impl;

import android.content.Context;

import com.android.voicemail.VoicemailClient;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class VoicemailModule_ProvideVoicemailClientFactory
        implements Factory<VoicemailClient> {
    private final Provider<Context> contextProvider;

    public VoicemailModule_ProvideVoicemailClientFactory(Provider<Context> contextProvider) {
        assert contextProvider != null;
        this.contextProvider = contextProvider;
    }

    public static Factory<VoicemailClient> create(Provider<Context> contextProvider) {
        return new VoicemailModule_ProvideVoicemailClientFactory(contextProvider);
    }

    @Override
    public VoicemailClient get() {
        return Preconditions.checkNotNull(
                VoicemailModule.provideVoicemailClient(contextProvider.get()),
                "Cannot return null from a non-@Nullable @Provides method");
    }
}
