package com.android.voicemail.stub;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum StubVoicemailClient_Factory implements Factory<StubVoicemailClient> {
  INSTANCE;

  @Override
  public StubVoicemailClient get() {
    return new StubVoicemailClient();
  }

  public static Factory<StubVoicemailClient> create() {
    return INSTANCE;
  }
}
