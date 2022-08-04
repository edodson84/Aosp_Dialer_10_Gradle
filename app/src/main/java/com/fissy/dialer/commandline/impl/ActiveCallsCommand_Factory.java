package com.fissy.dialer.commandline.impl;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActiveCallsCommand_Factory implements Factory<ActiveCallsCommand> {
  private final Provider<Context> appContextProvider;

  public ActiveCallsCommand_Factory(Provider<Context> appContextProvider) {
    assert appContextProvider != null;
    this.appContextProvider = appContextProvider;
  }

  @Override
  public ActiveCallsCommand get() {
    return new ActiveCallsCommand(appContextProvider.get());
  }

  public static Factory<ActiveCallsCommand> create(Provider<Context> appContextProvider) {
    return new ActiveCallsCommand_Factory(appContextProvider);
  }
}
