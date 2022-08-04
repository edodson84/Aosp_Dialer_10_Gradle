package com.android.bubble.stub;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum BubbleStub_Factory implements Factory<BubbleStub> {
  INSTANCE;

  @Override
  public BubbleStub get() {
    return new BubbleStub();
  }

  public static Factory<BubbleStub> create() {
    return INSTANCE;
  }
}
