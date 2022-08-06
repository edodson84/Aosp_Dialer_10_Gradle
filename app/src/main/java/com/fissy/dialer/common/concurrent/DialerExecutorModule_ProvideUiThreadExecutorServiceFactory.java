package com.fissy.dialer.common.concurrent;

import com.google.common.util.concurrent.ListeningExecutorService;

import javax.annotation.Generated;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public enum DialerExecutorModule_ProvideUiThreadExecutorServiceFactory
        implements Factory<ListeningExecutorService> {
    INSTANCE;

    public static Factory<ListeningExecutorService> create() {
        return INSTANCE;
    }

    @Override
    public ListeningExecutorService get() {
        return Preconditions.checkNotNull(
                DialerExecutorModule.provideUiThreadExecutorService(),
                "Cannot return null from a non-@Nullable @Provides method");
    }
}
