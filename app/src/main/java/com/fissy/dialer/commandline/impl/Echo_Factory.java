package com.fissy.dialer.commandline.impl;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum Echo_Factory implements Factory<Echo> {
  INSTANCE;

  @Override
  public Echo get() {
    return new Echo();
  }

  public static Factory<Echo> create() {
    return INSTANCE;
  }
}
