package com.android.bubble.stub;

import javax.annotation.Generated;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public enum BubbleStub_Factory implements Factory<BubbleStub> {
    INSTANCE;

    public static Factory<BubbleStub> create() {
        return INSTANCE;
    }

    @Override
    public BubbleStub get() {
        return new BubbleStub();
    }
}
