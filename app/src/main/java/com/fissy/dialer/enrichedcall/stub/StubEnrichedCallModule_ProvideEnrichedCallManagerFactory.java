package com.fissy.dialer.enrichedcall.stub;

import com.fissy.dialer.enrichedcall.EnrichedCallManager;

import javax.annotation.Generated;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public enum StubEnrichedCallModule_ProvideEnrichedCallManagerFactory
        implements Factory<EnrichedCallManager> {
    INSTANCE;

    public static Factory<EnrichedCallManager> create() {
        return INSTANCE;
    }

    @Override
    public EnrichedCallManager get() {
        return Preconditions.checkNotNull(
                StubEnrichedCallModule.provideEnrichedCallManager(),
                "Cannot return null from a non-@Nullable @Provides method");
    }
}
