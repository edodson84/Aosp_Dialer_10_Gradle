package com.fissy.dialer.calllog;

import com.fissy.dialer.calllog.datasources.DataSources;
import com.fissy.dialer.calllog.datasources.phonelookup.PhoneLookupDataSource;
import com.fissy.dialer.calllog.datasources.systemcalllog.SystemCallLogDataSource;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class CallLogModule_ProvideCallLogDataSourcesFactory implements Factory<DataSources> {
    private final Provider<SystemCallLogDataSource> systemCallLogDataSourceProvider;

    private final Provider<PhoneLookupDataSource> phoneLookupDataSourceProvider;

    public CallLogModule_ProvideCallLogDataSourcesFactory(
            Provider<SystemCallLogDataSource> systemCallLogDataSourceProvider,
            Provider<PhoneLookupDataSource> phoneLookupDataSourceProvider) {
        assert systemCallLogDataSourceProvider != null;
        this.systemCallLogDataSourceProvider = systemCallLogDataSourceProvider;
        assert phoneLookupDataSourceProvider != null;
        this.phoneLookupDataSourceProvider = phoneLookupDataSourceProvider;
    }

    public static Factory<DataSources> create(
            Provider<SystemCallLogDataSource> systemCallLogDataSourceProvider,
            Provider<PhoneLookupDataSource> phoneLookupDataSourceProvider) {
        return new CallLogModule_ProvideCallLogDataSourcesFactory(
                systemCallLogDataSourceProvider,
                phoneLookupDataSourceProvider);
    }

    @Override
    public DataSources get() {
        return Preconditions.checkNotNull(
                CallLogModule.provideCallLogDataSources(
                        systemCallLogDataSourceProvider.get(),
                        phoneLookupDataSourceProvider.get()),
                "Cannot return null from a non-@Nullable @Provides method");
    }
}
