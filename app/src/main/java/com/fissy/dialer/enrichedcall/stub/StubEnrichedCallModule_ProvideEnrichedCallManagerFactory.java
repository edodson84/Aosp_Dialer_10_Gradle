package com.fissy.dialer.enrichedcall.stub;

import com.fissy.dialer.enrichedcall.EnrichedCallManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum StubEnrichedCallModule_ProvideEnrichedCallManagerFactory
    implements Factory<EnrichedCallManager> {
  INSTANCE;

  @Override
  public EnrichedCallManager get() {
    return Preconditions.checkNotNull(
        StubEnrichedCallModule.provideEnrichedCallManager(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<EnrichedCallManager> create() {
    return INSTANCE;
  }
}
