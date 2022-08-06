package com.fissy.dialer.speeddial.loader;

import android.content.Context;

import com.fissy.dialer.contacts.displaypreference.ContactDisplayPreferences;
import com.fissy.dialer.contacts.hiresphoto.HighResolutionPhotoRequester;
import com.google.common.util.concurrent.ListeningExecutorService;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class SpeedDialUiItemMutator_Factory implements Factory<SpeedDialUiItemMutator> {
    private final Provider<Context> appContextProvider;

    private final Provider<ListeningExecutorService> backgroundExecutorProvider;

    private final Provider<ContactDisplayPreferences> contactDisplayPreferencesProvider;

    private final Provider<HighResolutionPhotoRequester> highResolutionPhotoRequesterProvider;

    public SpeedDialUiItemMutator_Factory(
            Provider<Context> appContextProvider,
            Provider<ListeningExecutorService> backgroundExecutorProvider,
            Provider<ContactDisplayPreferences> contactDisplayPreferencesProvider,
            Provider<HighResolutionPhotoRequester> highResolutionPhotoRequesterProvider) {
        assert appContextProvider != null;
        this.appContextProvider = appContextProvider;
        assert backgroundExecutorProvider != null;
        this.backgroundExecutorProvider = backgroundExecutorProvider;
        assert contactDisplayPreferencesProvider != null;
        this.contactDisplayPreferencesProvider = contactDisplayPreferencesProvider;
        assert highResolutionPhotoRequesterProvider != null;
        this.highResolutionPhotoRequesterProvider = highResolutionPhotoRequesterProvider;
    }

    public static Factory<SpeedDialUiItemMutator> create(
            Provider<Context> appContextProvider,
            Provider<ListeningExecutorService> backgroundExecutorProvider,
            Provider<ContactDisplayPreferences> contactDisplayPreferencesProvider,
            Provider<HighResolutionPhotoRequester> highResolutionPhotoRequesterProvider) {
        return new SpeedDialUiItemMutator_Factory(
                appContextProvider,
                backgroundExecutorProvider,
                contactDisplayPreferencesProvider,
                highResolutionPhotoRequesterProvider);
    }

    @Override
    public SpeedDialUiItemMutator get() {
        return new SpeedDialUiItemMutator(
                appContextProvider.get(),
                backgroundExecutorProvider.get(),
                contactDisplayPreferencesProvider.get(),
                highResolutionPhotoRequesterProvider.get());
    }
}
