package com.fissy.dialer.metrics;

import com.google.common.util.concurrent.ListeningExecutorService;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class FutureTimer_Factory implements Factory<FutureTimer> {
    private final Provider<Metrics> metricsProvider;

    private final Provider<ListeningExecutorService> lightweightExecutorServiceProvider;

    public FutureTimer_Factory(
            Provider<Metrics> metricsProvider,
            Provider<ListeningExecutorService> lightweightExecutorServiceProvider) {
        assert metricsProvider != null;
        this.metricsProvider = metricsProvider;
        assert lightweightExecutorServiceProvider != null;
        this.lightweightExecutorServiceProvider = lightweightExecutorServiceProvider;
    }

    public static Factory<FutureTimer> create(
            Provider<Metrics> metricsProvider,
            Provider<ListeningExecutorService> lightweightExecutorServiceProvider) {
        return new FutureTimer_Factory(metricsProvider, lightweightExecutorServiceProvider);
    }

    @Override
    public FutureTimer get() {
        return new FutureTimer(metricsProvider.get(), lightweightExecutorServiceProvider.get());
    }
}
