package com.fissy.dialer.precall.impl;

import com.fissy.dialer.preferredsim.PreferredAccountWorker;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class CallingAccountSelector_Factory implements Factory<CallingAccountSelector> {
    private final Provider<PreferredAccountWorker> preferredAccountWorkerProvider;

    public CallingAccountSelector_Factory(
            Provider<PreferredAccountWorker> preferredAccountWorkerProvider) {
        assert preferredAccountWorkerProvider != null;
        this.preferredAccountWorkerProvider = preferredAccountWorkerProvider;
    }

    public static Factory<CallingAccountSelector> create(
            Provider<PreferredAccountWorker> preferredAccountWorkerProvider) {
        return new CallingAccountSelector_Factory(preferredAccountWorkerProvider);
    }

    @Override
    public CallingAccountSelector get() {
        return new CallingAccountSelector(preferredAccountWorkerProvider.get());
    }
}
