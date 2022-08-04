package com.fissy.dialer.glidephotomanager.impl;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

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

  @Override
  public GlidePhotoManagerImpl get() {
    return new GlidePhotoManagerImpl(appContextProvider.get());
  }

  public static Factory<GlidePhotoManagerImpl> create(Provider<Context> appContextProvider) {
    return new GlidePhotoManagerImpl_Factory(appContextProvider);
  }
}
