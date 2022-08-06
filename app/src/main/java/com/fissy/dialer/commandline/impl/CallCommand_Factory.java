package com.fissy.dialer.commandline.impl;

import android.content.Context;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class CallCommand_Factory implements Factory<CallCommand> {
    private final Provider<Context> appContextProvider;

    public CallCommand_Factory(Provider<Context> appContextProvider) {
        assert appContextProvider != null;
        this.appContextProvider = appContextProvider;
    }

    public static Factory<CallCommand> create(Provider<Context> appContextProvider) {
        return new CallCommand_Factory(appContextProvider);
    }

    @Override
    public CallCommand get() {
        return new CallCommand(appContextProvider.get());
    }
}
