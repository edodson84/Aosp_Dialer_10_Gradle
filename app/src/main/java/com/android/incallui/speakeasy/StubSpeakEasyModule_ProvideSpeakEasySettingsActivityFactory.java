package com.android.incallui.speakeasy;

import android.preference.PreferenceActivity;

import com.google.common.base.Optional;

import javax.annotation.Generated;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public enum StubSpeakEasyModule_ProvideSpeakEasySettingsActivityFactory
        implements Factory<Optional<PreferenceActivity>> {
    INSTANCE;

    public static Factory<Optional<PreferenceActivity>> create() {
        return INSTANCE;
    }

    @Override
    public Optional<PreferenceActivity> get() {
        return Preconditions.checkNotNull(
                StubSpeakEasyModule.provideSpeakEasySettingsActivity(),
                "Cannot return null from a non-@Nullable @Provides method");
    }
}
