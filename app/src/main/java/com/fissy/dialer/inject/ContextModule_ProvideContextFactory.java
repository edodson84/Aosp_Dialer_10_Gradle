package com.fissy.dialer.inject;

import android.content.Context;

import javax.annotation.Generated;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class ContextModule_ProvideContextFactory implements Factory<Context> {
    private final ContextModule module;

    public ContextModule_ProvideContextFactory(ContextModule module) {
        assert module != null;
        this.module = module;
    }

    public static Factory<Context> create(ContextModule module) {
        return new ContextModule_ProvideContextFactory(module);
    }

    @Override
    public Context get() {
        return Preconditions.checkNotNull(
                module.provideContext(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
