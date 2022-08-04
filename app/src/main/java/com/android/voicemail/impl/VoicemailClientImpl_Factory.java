package com.android.voicemail.impl;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum VoicemailClientImpl_Factory implements Factory<VoicemailClientImpl> {
  INSTANCE;

  @Override
  public VoicemailClientImpl get() {
    return new VoicemailClientImpl();
  }

  public static Factory<VoicemailClientImpl> create() {
    return INSTANCE;
  }
}
