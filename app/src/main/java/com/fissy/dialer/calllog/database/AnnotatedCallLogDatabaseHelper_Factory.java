package com.fissy.dialer.calllog.database;

import android.content.Context;

import com.google.common.util.concurrent.ListeningExecutorService;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.MembersInjector;
import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class AnnotatedCallLogDatabaseHelper_Factory
        implements Factory<AnnotatedCallLogDatabaseHelper> {
    private final MembersInjector<AnnotatedCallLogDatabaseHelper>
            annotatedCallLogDatabaseHelperMembersInjector;

    private final Provider<Context> appContextProvider;

    private final Provider<Integer> maxRowsProvider;

    private final Provider<ListeningExecutorService> backgroundExecutorProvider;

    public AnnotatedCallLogDatabaseHelper_Factory(
            MembersInjector<AnnotatedCallLogDatabaseHelper> annotatedCallLogDatabaseHelperMembersInjector,
            Provider<Context> appContextProvider,
            Provider<Integer> maxRowsProvider,
            Provider<ListeningExecutorService> backgroundExecutorProvider) {
        assert annotatedCallLogDatabaseHelperMembersInjector != null;
        this.annotatedCallLogDatabaseHelperMembersInjector =
                annotatedCallLogDatabaseHelperMembersInjector;
        assert appContextProvider != null;
        this.appContextProvider = appContextProvider;
        assert maxRowsProvider != null;
        this.maxRowsProvider = maxRowsProvider;
        assert backgroundExecutorProvider != null;
        this.backgroundExecutorProvider = backgroundExecutorProvider;
    }

    public static Factory<AnnotatedCallLogDatabaseHelper> create(
            MembersInjector<AnnotatedCallLogDatabaseHelper> annotatedCallLogDatabaseHelperMembersInjector,
            Provider<Context> appContextProvider,
            Provider<Integer> maxRowsProvider,
            Provider<ListeningExecutorService> backgroundExecutorProvider) {
        return new AnnotatedCallLogDatabaseHelper_Factory(
                annotatedCallLogDatabaseHelperMembersInjector,
                appContextProvider,
                maxRowsProvider,
                backgroundExecutorProvider);
    }

    @Override
    public AnnotatedCallLogDatabaseHelper get() {
        return new AnnotatedCallLogDatabaseHelper(
                appContextProvider.get(), maxRowsProvider.get(), backgroundExecutorProvider.get());
   /* return MembersInjectors.injectMembers(
        annotatedCallLogDatabaseHelperMembersInjector,
        new AnnotatedCallLogDatabaseHelper(
            appContextProvider.get(), maxRowsProvider.get(), backgroundExecutorProvider.get()));*/
    }
}
