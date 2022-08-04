package com.fissy.dialer.enrichedcall.stub;

import com.fissy.dialer.enrichedcall.RcsVideoShareFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum StubEnrichedCallModule_ProvidesRcsVideoShareFactoryFactory
    implements Factory<RcsVideoShareFactory> {
  INSTANCE;

  @Override
  public RcsVideoShareFactory get() {
    return Preconditions.checkNotNull(
        StubEnrichedCallModule.providesRcsVideoShareFactory(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<RcsVideoShareFactory> create() {
    return INSTANCE;
  }
}
