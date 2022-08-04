package com.fissy.dialer.spam.stub;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum SpamSettingsStub_Factory implements Factory<SpamSettingsStub> {
  INSTANCE;

  @Override
  public SpamSettingsStub get() {
    return new SpamSettingsStub();
  }

  public static Factory<SpamSettingsStub> create() {
    return INSTANCE;
  }
}
