package com.fissy.dialer.feedback.stub;

import com.fissy.dialer.logging.LoggingBindings;
import com.fissy.dialer.logging.LoggingBindingsFactory;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class StubFeedbackModule_ProvideLoggingBindingsFactory
        implements Factory<LoggingBindings> {
    private final Provider<LoggingBindingsFactory> factoryProvider;

    public StubFeedbackModule_ProvideLoggingBindingsFactory(
            Provider<LoggingBindingsFactory> factoryProvider) {
        assert factoryProvider != null;
        this.factoryProvider = factoryProvider;
    }

    public static Factory<LoggingBindings> create(Provider<LoggingBindingsFactory> factoryProvider) {
        return new StubFeedbackModule_ProvideLoggingBindingsFactory(factoryProvider);
    }

    @Override
    public LoggingBindings get() {
        return Preconditions.checkNotNull(
                StubFeedbackModule.provideLoggingBindings(factoryProvider.get()),
                "Cannot return null from a non-@Nullable @Provides method");
    }
}
