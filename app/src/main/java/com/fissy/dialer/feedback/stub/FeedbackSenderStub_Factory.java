package com.fissy.dialer.feedback.stub;

import javax.annotation.Generated;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public enum FeedbackSenderStub_Factory implements Factory<FeedbackSenderStub> {
    INSTANCE;

    public static Factory<FeedbackSenderStub> create() {
        return INSTANCE;
    }

    @Override
    public FeedbackSenderStub get() {
        return new FeedbackSenderStub();
    }
}
