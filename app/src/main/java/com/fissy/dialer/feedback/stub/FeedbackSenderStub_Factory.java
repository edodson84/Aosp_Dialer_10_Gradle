package com.fissy.dialer.feedback.stub;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum FeedbackSenderStub_Factory implements Factory<FeedbackSenderStub> {
  INSTANCE;

  @Override
  public FeedbackSenderStub get() {
    return new FeedbackSenderStub();
  }

  public static Factory<FeedbackSenderStub> create() {
    return INSTANCE;
  }
}
