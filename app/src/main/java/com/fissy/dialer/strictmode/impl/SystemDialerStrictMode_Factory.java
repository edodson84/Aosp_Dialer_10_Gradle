package com.fissy.dialer.strictmode.impl;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum SystemDialerStrictMode_Factory implements Factory<SystemDialerStrictMode> {
  INSTANCE;

  @Override
  public SystemDialerStrictMode get() {
    return new SystemDialerStrictMode();
  }

  public static Factory<SystemDialerStrictMode> create() {
    return INSTANCE;
  }
}
