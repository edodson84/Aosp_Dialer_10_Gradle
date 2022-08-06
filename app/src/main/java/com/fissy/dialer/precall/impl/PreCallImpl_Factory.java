package com.fissy.dialer.precall.impl;

import com.fissy.dialer.precall.PreCallAction;
import com.google.common.collect.ImmutableList;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class PreCallImpl_Factory implements Factory<PreCallImpl> {
    private final Provider<ImmutableList<PreCallAction>> actionsProvider;

    public PreCallImpl_Factory(Provider<ImmutableList<PreCallAction>> actionsProvider) {
        assert actionsProvider != null;
        this.actionsProvider = actionsProvider;
    }

    public static Factory<PreCallImpl> create(
            Provider<ImmutableList<PreCallAction>> actionsProvider) {
        return new PreCallImpl_Factory(actionsProvider);
    }

    @Override
    public PreCallImpl get() {
        return new PreCallImpl(actionsProvider.get());
    }
}
