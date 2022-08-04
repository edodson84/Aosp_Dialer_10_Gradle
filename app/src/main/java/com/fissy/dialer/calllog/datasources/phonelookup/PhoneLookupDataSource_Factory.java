package com.fissy.dialer.calllog.datasources.phonelookup;

import android.content.Context;
import com.fissy.dialer.phonelookup.composite.CompositePhoneLookup;
import com.fissy.dialer.phonelookup.database.PhoneLookupHistoryDatabaseHelper;
import com.google.common.util.concurrent.ListeningExecutorService;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PhoneLookupDataSource_Factory implements Factory<PhoneLookupDataSource> {
  private final Provider<Context> appContextProvider;

  private final Provider<CompositePhoneLookup> compositePhoneLookupProvider;

  private final Provider<ListeningExecutorService> backgroundExecutorServiceProvider;

  private final Provider<ListeningExecutorService> lightweightExecutorServiceProvider;

  private final Provider<PhoneLookupHistoryDatabaseHelper> phoneLookupHistoryDatabaseHelperProvider;

  public PhoneLookupDataSource_Factory(
      Provider<Context> appContextProvider,
      Provider<CompositePhoneLookup> compositePhoneLookupProvider,
      Provider<ListeningExecutorService> backgroundExecutorServiceProvider,
      Provider<ListeningExecutorService> lightweightExecutorServiceProvider,
      Provider<PhoneLookupHistoryDatabaseHelper> phoneLookupHistoryDatabaseHelperProvider) {
    assert appContextProvider != null;
    this.appContextProvider = appContextProvider;
    assert compositePhoneLookupProvider != null;
    this.compositePhoneLookupProvider = compositePhoneLookupProvider;
    assert backgroundExecutorServiceProvider != null;
    this.backgroundExecutorServiceProvider = backgroundExecutorServiceProvider;
    assert lightweightExecutorServiceProvider != null;
    this.lightweightExecutorServiceProvider = lightweightExecutorServiceProvider;
    assert phoneLookupHistoryDatabaseHelperProvider != null;
    this.phoneLookupHistoryDatabaseHelperProvider = phoneLookupHistoryDatabaseHelperProvider;
  }

  @Override
  public PhoneLookupDataSource get() {
    return new PhoneLookupDataSource(
        appContextProvider.get(),
        compositePhoneLookupProvider.get(),
        backgroundExecutorServiceProvider.get(),
        lightweightExecutorServiceProvider.get(),
        phoneLookupHistoryDatabaseHelperProvider.get());
  }

  public static Factory<PhoneLookupDataSource> create(
      Provider<Context> appContextProvider,
      Provider<CompositePhoneLookup> compositePhoneLookupProvider,
      Provider<ListeningExecutorService> backgroundExecutorServiceProvider,
      Provider<ListeningExecutorService> lightweightExecutorServiceProvider,
      Provider<PhoneLookupHistoryDatabaseHelper> phoneLookupHistoryDatabaseHelperProvider) {
    return new PhoneLookupDataSource_Factory(
        appContextProvider,
        compositePhoneLookupProvider,
        backgroundExecutorServiceProvider,
        lightweightExecutorServiceProvider,
        phoneLookupHistoryDatabaseHelperProvider);
  }
}
