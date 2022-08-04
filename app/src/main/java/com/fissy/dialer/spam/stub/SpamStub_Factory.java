package com.fissy.dialer.spam.stub;

import com.google.common.util.concurrent.ListeningExecutorService;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SpamStub_Factory implements Factory<SpamStub> {
  private final Provider<ListeningExecutorService> backgroundExecutorServiceProvider;

  public SpamStub_Factory(Provider<ListeningExecutorService> backgroundExecutorServiceProvider) {
    assert backgroundExecutorServiceProvider != null;
    this.backgroundExecutorServiceProvider = backgroundExecutorServiceProvider;
  }

  @Override
  public SpamStub get() {
    return new SpamStub(backgroundExecutorServiceProvider.get());
  }

  public static Factory<SpamStub> create(
      Provider<ListeningExecutorService> backgroundExecutorServiceProvider) {
    return new SpamStub_Factory(backgroundExecutorServiceProvider);
  }
}
