package com.fissy.dialer.commandline.impl;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Version_Factory implements Factory<Version> {
  private final Provider<Context> contextProvider;

  public Version_Factory(Provider<Context> contextProvider) {
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public Version get() {
    return new Version(contextProvider.get());
  }

  public static Factory<Version> create(Provider<Context> contextProvider) {
    return new Version_Factory(contextProvider);
  }
}
