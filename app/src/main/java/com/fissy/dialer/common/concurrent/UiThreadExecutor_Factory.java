package com.fissy.dialer.common.concurrent;

import javax.annotation.Generated;

import dagger.MembersInjector;
import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class UiThreadExecutor_Factory implements Factory<UiThreadExecutor> {
    private final MembersInjector<UiThreadExecutor> uiThreadExecutorMembersInjector;

    public UiThreadExecutor_Factory(
            MembersInjector<UiThreadExecutor> uiThreadExecutorMembersInjector) {
        assert uiThreadExecutorMembersInjector != null;
        this.uiThreadExecutorMembersInjector = uiThreadExecutorMembersInjector;
    }

    public static Factory<UiThreadExecutor> create(
            MembersInjector<UiThreadExecutor> uiThreadExecutorMembersInjector) {
        return new UiThreadExecutor_Factory(uiThreadExecutorMembersInjector);
    }

    @Override
    public UiThreadExecutor get() {
        //return MembersInjectors.injectMembers(uiThreadExecutorMembersInjector, new UiThreadExecutor());
        return new UiThreadExecutor();
    }
}
