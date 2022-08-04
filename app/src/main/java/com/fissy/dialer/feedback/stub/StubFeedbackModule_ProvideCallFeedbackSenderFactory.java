package com.fissy.dialer.feedback.stub;

import com.fissy.dialer.feedback.FeedbackSender;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum StubFeedbackModule_ProvideCallFeedbackSenderFactory implements Factory<FeedbackSender> {
  INSTANCE;

  @Override
  public FeedbackSender get() {
    return Preconditions.checkNotNull(
        StubFeedbackModule.provideCallFeedbackSender(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<FeedbackSender> create() {
    return INSTANCE;
  }
}
