package com.fissy.dialer.common.concurrent;

import java.util.concurrent.ExecutorService;

import javax.annotation.Generated;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public enum DialerExecutorModule_ProvideUiThreadPoolFactory implements Factory<ExecutorService> {
    INSTANCE;

    public static Factory<ExecutorService> create() {
        return INSTANCE;
    }

    @Override
    public ExecutorService get() {
        return Preconditions.checkNotNull(
                DialerExecutorModule.provideUiThreadPool(),
                "Cannot return null from a non-@Nullable @Provides method");
    }
}
