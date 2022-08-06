package com.fissy.dialer.theme.base.impl;

import android.content.Context;

import com.fissy.dialer.theme.base.Theme;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class AospThemeModule_ProvideThemeModuleFactory implements Factory<Theme> {
    private final Provider<Context> contextProvider;

    public AospThemeModule_ProvideThemeModuleFactory(Provider<Context> contextProvider) {
        assert contextProvider != null;
        this.contextProvider = contextProvider;
    }

    public static Factory<Theme> create(Provider<Context> contextProvider) {
        return new AospThemeModule_ProvideThemeModuleFactory(contextProvider);
    }

    @Override
    public Theme get() {
        return Preconditions.checkNotNull(
                AospThemeModule.provideThemeModule(contextProvider.get()),
                "Cannot return null from a non-@Nullable @Provides method");
    }
}
