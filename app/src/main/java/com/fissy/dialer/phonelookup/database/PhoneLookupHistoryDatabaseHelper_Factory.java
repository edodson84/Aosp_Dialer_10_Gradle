package com.fissy.dialer.phonelookup.database;

import android.content.Context;

import com.android.utils.ReflectUtils;
import com.google.common.util.concurrent.ListeningExecutorService;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PhoneLookupHistoryDatabaseHelper_Factory
    implements Factory<PhoneLookupHistoryDatabaseHelper> {
  private final MembersInjector<PhoneLookupHistoryDatabaseHelper>
      phoneLookupHistoryDatabaseHelperMembersInjector;

  private final Provider<Context> appContextProvider;

  private final Provider<ListeningExecutorService> backgroundExecutorProvider;

  public PhoneLookupHistoryDatabaseHelper_Factory(
      MembersInjector<PhoneLookupHistoryDatabaseHelper>
          phoneLookupHistoryDatabaseHelperMembersInjector,
      Provider<Context> appContextProvider,
      Provider<ListeningExecutorService> backgroundExecutorProvider) {
    assert phoneLookupHistoryDatabaseHelperMembersInjector != null;
    this.phoneLookupHistoryDatabaseHelperMembersInjector =
        phoneLookupHistoryDatabaseHelperMembersInjector;
    assert appContextProvider != null;
    this.appContextProvider = appContextProvider;
    assert backgroundExecutorProvider != null;
    this.backgroundExecutorProvider = backgroundExecutorProvider;
  }

  @Override
  public PhoneLookupHistoryDatabaseHelper get() {
   /* return MembersInjectors.injectMembers(
        phoneLookupHistoryDatabaseHelperMembersInjector,
        new PhoneLookupHistoryDatabaseHelper(
            appContextProvider.get(), backgroundExecutorProvider.get()));*/
    return new PhoneLookupHistoryDatabaseHelper(
            appContextProvider.get(), backgroundExecutorProvider.get());
  }

  public static Factory<PhoneLookupHistoryDatabaseHelper> create(
      MembersInjector<PhoneLookupHistoryDatabaseHelper>
          phoneLookupHistoryDatabaseHelperMembersInjector,
      Provider<Context> appContextProvider,
      Provider<ListeningExecutorService> backgroundExecutorProvider) {
    return new PhoneLookupHistoryDatabaseHelper_Factory(
        phoneLookupHistoryDatabaseHelperMembersInjector,
        appContextProvider,
        backgroundExecutorProvider);
  }
}
