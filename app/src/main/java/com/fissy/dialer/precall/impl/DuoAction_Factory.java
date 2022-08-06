package com.fissy.dialer.precall.impl;

import com.google.common.util.concurrent.ListeningExecutorService;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class DuoAction_Factory implements Factory<DuoAction> {
    private final Provider<ListeningExecutorService> uiExecutorProvider;

    public DuoAction_Factory(Provider<ListeningExecutorService> uiExecutorProvider) {
        assert uiExecutorProvider != null;
        this.uiExecutorProvider = uiExecutorProvider;
    }

    public static Factory<DuoAction> create(Provider<ListeningExecutorService> uiExecutorProvider) {
        return new DuoAction_Factory(uiExecutorProvider);
    }

    @Override
    public DuoAction get() {
        return new DuoAction(uiExecutorProvider.get());
    }
}
