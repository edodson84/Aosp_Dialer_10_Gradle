package com.fissy.dialer.commandline.impl;

import android.content.Context;

import com.google.common.util.concurrent.ListeningExecutorService;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class BlockingCommand_Factory implements Factory<BlockingCommand> {
    private final Provider<Context> contextProvider;

    private final Provider<ListeningExecutorService> executorServiceProvider;

    public BlockingCommand_Factory(
            Provider<Context> contextProvider,
            Provider<ListeningExecutorService> executorServiceProvider) {
        assert contextProvider != null;
        this.contextProvider = contextProvider;
        assert executorServiceProvider != null;
        this.executorServiceProvider = executorServiceProvider;
    }

    public static Factory<BlockingCommand> create(
            Provider<Context> contextProvider,
            Provider<ListeningExecutorService> executorServiceProvider) {
        return new BlockingCommand_Factory(contextProvider, executorServiceProvider);
    }

    @Override
    public BlockingCommand get() {
        return new BlockingCommand(contextProvider.get(), executorServiceProvider.get());
    }
}
