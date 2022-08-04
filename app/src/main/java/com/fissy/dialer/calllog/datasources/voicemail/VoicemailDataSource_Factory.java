package com.fissy.dialer.calllog.datasources.voicemail;

import android.content.Context;
import com.google.common.util.concurrent.ListeningExecutorService;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class VoicemailDataSource_Factory implements Factory<VoicemailDataSource> {
  private final Provider<Context> appContextProvider;

  private final Provider<ListeningExecutorService> backgroundExecutorProvider;

  public VoicemailDataSource_Factory(
      Provider<Context> appContextProvider,
      Provider<ListeningExecutorService> backgroundExecutorProvider) {
    assert appContextProvider != null;
    this.appContextProvider = appContextProvider;
    assert backgroundExecutorProvider != null;
    this.backgroundExecutorProvider = backgroundExecutorProvider;
  }

  @Override
  public VoicemailDataSource get() {
    return new VoicemailDataSource(appContextProvider.get(), backgroundExecutorProvider.get());
  }

  public static Factory<VoicemailDataSource> create(
      Provider<Context> appContextProvider,
      Provider<ListeningExecutorService> backgroundExecutorProvider) {
    return new VoicemailDataSource_Factory(appContextProvider, backgroundExecutorProvider);
  }
}
