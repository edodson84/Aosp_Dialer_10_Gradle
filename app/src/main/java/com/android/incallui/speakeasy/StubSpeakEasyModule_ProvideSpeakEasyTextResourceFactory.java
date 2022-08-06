package com.android.incallui.speakeasy;

import com.google.common.base.Optional;

import javax.annotation.Generated;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public enum StubSpeakEasyModule_ProvideSpeakEasyTextResourceFactory
        implements Factory<Optional<Integer>> {
    INSTANCE;

    public static Factory<Optional<Integer>> create() {
        return INSTANCE;
    }

    @Override
    public Optional<Integer> get() {
        return Preconditions.checkNotNull(
                StubSpeakEasyModule.provideSpeakEasyTextResource(),
                "Cannot return null from a non-@Nullable @Provides method");
    }
}
