package com.android.incallui.speakeasy;

import com.google.common.base.Optional;

import javax.annotation.Generated;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public enum StubSpeakEasyModule_ProvideSpeakEasySettingsObjectFactory
        implements Factory<Optional<Object>> {
    INSTANCE;

    public static Factory<Optional<Object>> create() {
        return INSTANCE;
    }

    @Override
    public Optional<Object> get() {
        return Preconditions.checkNotNull(
                StubSpeakEasyModule.provideSpeakEasySettingsObject(),
                "Cannot return null from a non-@Nullable @Provides method");
    }
}
