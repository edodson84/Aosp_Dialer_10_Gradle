package com.fissy.dialer.feedback.stub;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CallFeedbackListenerStub_Factory implements Factory<CallFeedbackListenerStub> {
  private final Provider<Context> contextProvider;

  public CallFeedbackListenerStub_Factory(Provider<Context> contextProvider) {
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public CallFeedbackListenerStub get() {
    return new CallFeedbackListenerStub(contextProvider.get());
  }

  public static Factory<CallFeedbackListenerStub> create(Provider<Context> contextProvider) {
    return new CallFeedbackListenerStub_Factory(contextProvider);
  }
}
