package com.fissy.dialer.contacts;

import android.content.Context;

import com.fissy.dialer.contacts.displaypreference.ContactDisplayPreferences;
import com.fissy.dialer.contacts.displaypreference.ContactDisplayPreferencesImpl;
import com.fissy.dialer.contacts.displaypreference.ContactDisplayPreferencesStub;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class ContactsModule_ProvideContactDisplayPreferencesFactory
        implements Factory<ContactDisplayPreferences> {
    private final Provider<Context> appContextProvider;

    private final Provider<ContactDisplayPreferencesImpl> implProvider;

    private final Provider<ContactDisplayPreferencesStub> stubProvider;

    public ContactsModule_ProvideContactDisplayPreferencesFactory(
            Provider<Context> appContextProvider,
            Provider<ContactDisplayPreferencesImpl> implProvider,
            Provider<ContactDisplayPreferencesStub> stubProvider) {
        assert appContextProvider != null;
        this.appContextProvider = appContextProvider;
        assert implProvider != null;
        this.implProvider = implProvider;
        assert stubProvider != null;
        this.stubProvider = stubProvider;
    }

    public static Factory<ContactDisplayPreferences> create(
            Provider<Context> appContextProvider,
            Provider<ContactDisplayPreferencesImpl> implProvider,
            Provider<ContactDisplayPreferencesStub> stubProvider) {
        return new ContactsModule_ProvideContactDisplayPreferencesFactory(
                appContextProvider, implProvider, stubProvider);
    }

    @Override
    public ContactDisplayPreferences get() {
        return Preconditions.checkNotNull(
                ContactsModule.provideContactDisplayPreferences(
                        appContextProvider.get(), DoubleCheck.lazy(implProvider), stubProvider.get()),
                "Cannot return null from a non-@Nullable @Provides method");
    }
}
