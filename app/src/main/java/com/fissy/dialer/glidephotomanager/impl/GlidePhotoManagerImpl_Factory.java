package com.fissy.dialer.glidephotomanager.impl;

import android.content.Context;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class GlidePhotoManagerImpl_Factory implements Factory<GlidePhotoManagerImpl> {
    private final Provider<Context> appContextProvider;

    public GlidePhotoManagerImpl_Factory(Provider<Context> appContextProvider) {
        assert appContextProvider != null;
        this.appContextProvider = appContextProvider;
    }

    public static Factory<GlidePhotoManagerImpl> create(Provider<Context> appContextProvider) {
        return new GlidePhotoManagerImpl_Factory(appContextProvider);
    }

    @Override
    public GlidePhotoManagerImpl get() {
        return new GlidePhotoManagerImpl(appContextProvider.get());
    }
}
