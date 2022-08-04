package com.fissy.dialer.commandline.impl;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CallCommand_Factory implements Factory<CallCommand> {
  private final Provider<Context> appContextProvider;

  public CallCommand_Factory(Provider<Context> appContextProvider) {
    assert appContextProvider != null;
    this.appContextProvider = appContextProvider;
  }

  @Override
  public CallCommand get() {
    return new CallCommand(appContextProvider.get());
  }

  public static Factory<CallCommand> create(Provider<Context> appContextProvider) {
    return new CallCommand_Factory(appContextProvider);
  }
}
