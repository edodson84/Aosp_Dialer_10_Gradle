package com.fissy.dialer.commandline.impl;

import android.content.Context;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class Help_Factory implements Factory<Help> {
    private final Provider<Context> contextProvider;

    public Help_Factory(Provider<Context> contextProvider) {
        assert contextProvider != null;
        this.contextProvider = contextProvider;
    }

    public static Factory<Help> create(Provider<Context> contextProvider) {
        return new Help_Factory(contextProvider);
    }

    @Override
    public Help get() {
        return new Help(contextProvider.get());
    }
}
