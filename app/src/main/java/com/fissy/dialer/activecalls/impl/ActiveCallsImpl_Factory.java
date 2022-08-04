package com.fissy.dialer.activecalls.impl;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum ActiveCallsImpl_Factory implements Factory<ActiveCallsImpl> {
  INSTANCE;

  @Override
  public ActiveCallsImpl get() {
    return new ActiveCallsImpl();
  }

  public static Factory<ActiveCallsImpl> create() {
    return INSTANCE;
  }
}
