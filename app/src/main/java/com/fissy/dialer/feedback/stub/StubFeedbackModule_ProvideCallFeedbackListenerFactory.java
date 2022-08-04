package com.fissy.dialer.feedback.stub;

import android.content.Context;
import com.android.incallui.call.CallList;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class StubFeedbackModule_ProvideCallFeedbackListenerFactory
    implements Factory<CallList.Listener> {
  private final Provider<Context> contextProvider;

  public StubFeedbackModule_ProvideCallFeedbackListenerFactory(Provider<Context> contextProvider) {
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public CallList.Listener get() {
    return Preconditions.checkNotNull(
        StubFeedbackModule.provideCallFeedbackListener(contextProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<CallList.Listener> create(Provider<Context> contextProvider) {
    return new StubFeedbackModule_ProvideCallFeedbackListenerFactory(contextProvider);
  }
}
