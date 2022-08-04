package com.fissy.dialer.inject;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ContextModule_ProvideContextFactory implements Factory<Context> {
  private final ContextModule module;

  public ContextModule_ProvideContextFactory(ContextModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Context get() {
    return Preconditions.checkNotNull(
        module.provideContext(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Context> create(ContextModule module) {
    return new ContextModule_ProvideContextFactory(module);
  }
}
