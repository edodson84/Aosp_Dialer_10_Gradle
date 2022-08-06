package com.fissy.dialer.feedback.stub;

import com.fissy.dialer.feedback.FeedbackSender;

import javax.annotation.Generated;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public enum StubFeedbackModule_ProvideCallFeedbackSenderFactory implements Factory<FeedbackSender> {
    INSTANCE;

    public static Factory<FeedbackSender> create() {
        return INSTANCE;
    }

    @Override
    public FeedbackSender get() {
        return Preconditions.checkNotNull(
                StubFeedbackModule.provideCallFeedbackSender(),
                "Cannot return null from a non-@Nullable @Provides method");
    }
}
