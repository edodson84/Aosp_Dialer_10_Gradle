package com.fissy.dialer.contacts.hiresphoto;

import android.content.Context;
import com.google.common.util.concurrent.ListeningExecutorService;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HighResolutionPhotoRequesterImpl_Factory
    implements Factory<HighResolutionPhotoRequesterImpl> {
  private final Provider<Context> appContextProvider;

  private final Provider<ListeningExecutorService> backgroundExecutorProvider;

  public HighResolutionPhotoRequesterImpl_Factory(
      Provider<Context> appContextProvider,
      Provider<ListeningExecutorService> backgroundExecutorProvider) {
    assert appContextProvider != null;
    this.appContextProvider = appContextProvider;
    assert backgroundExecutorProvider != null;
    this.backgroundExecutorProvider = backgroundExecutorProvider;
  }

  @Override
  public HighResolutionPhotoRequesterImpl get() {
    return new HighResolutionPhotoRequesterImpl(
        appContextProvider.get(), backgroundExecutorProvider.get());
  }

  public static Factory<HighResolutionPhotoRequesterImpl> create(
      Provider<Context> appContextProvider,
      Provider<ListeningExecutorService> backgroundExecutorProvider) {
    return new HighResolutionPhotoRequesterImpl_Factory(
        appContextProvider, backgroundExecutorProvider);
  }
}
