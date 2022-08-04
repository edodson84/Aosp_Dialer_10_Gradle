package com.fissy.dialer.contacts.displaypreference;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ContactDisplayPreferencesImpl_Factory
    implements Factory<ContactDisplayPreferencesImpl> {
  private final Provider<Context> appContextProvider;

  public ContactDisplayPreferencesImpl_Factory(Provider<Context> appContextProvider) {
    assert appContextProvider != null;
    this.appContextProvider = appContextProvider;
  }

  @Override
  public ContactDisplayPreferencesImpl get() {
    return new ContactDisplayPreferencesImpl(appContextProvider.get());
  }

  public static Factory<ContactDisplayPreferencesImpl> create(
      Provider<Context> appContextProvider) {
    return new ContactDisplayPreferencesImpl_Factory(appContextProvider);
  }
}
