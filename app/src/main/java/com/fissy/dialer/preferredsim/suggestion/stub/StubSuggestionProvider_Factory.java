package com.fissy.dialer.preferredsim.suggestion.stub;

import javax.annotation.Generated;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public enum StubSuggestionProvider_Factory implements Factory<StubSuggestionProvider> {
    INSTANCE;

    public static Factory<StubSuggestionProvider> create() {
        return INSTANCE;
    }

    @Override
    public StubSuggestionProvider get() {
        return new StubSuggestionProvider();
    }
}
