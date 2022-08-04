package com.fissy.dialer.duo.stub;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum DuoStub_Factory implements Factory<DuoStub> {
  INSTANCE;

  @Override
  public DuoStub get() {
    return new DuoStub();
  }

  public static Factory<DuoStub> create() {
    return INSTANCE;
  }
}
