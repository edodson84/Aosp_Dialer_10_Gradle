package com.fissy.dialer.calllog.database;

import com.fissy.dialer.metrics.FutureTimer;
import com.google.common.util.concurrent.ListeningExecutorService;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class Coalescer_Factory implements Factory<Coalescer> {
    private final Provider<ListeningExecutorService> backgroundExecutorServiceProvider;

    private final Provider<FutureTimer> futureTimerProvider;

    public Coalescer_Factory(
            Provider<ListeningExecutorService> backgroundExecutorServiceProvider,
            Provider<FutureTimer> futureTimerProvider) {
        assert backgroundExecutorServiceProvider != null;
        this.backgroundExecutorServiceProvider = backgroundExecutorServiceProvider;
        assert futureTimerProvider != null;
        this.futureTimerProvider = futureTimerProvider;
    }

    public static Factory<Coalescer> create(
            Provider<ListeningExecutorService> backgroundExecutorServiceProvider,
            Provider<FutureTimer> futureTimerProvider) {
        return new Coalescer_Factory(backgroundExecutorServiceProvider, futureTimerProvider);
    }

    @Override
    public Coalescer get() {
        return new Coalescer(backgroundExecutorServiceProvider.get(), futureTimerProvider.get());
    }
}
