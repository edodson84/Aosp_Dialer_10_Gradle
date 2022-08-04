package com.fissy.dialer.precall.impl;

import com.fissy.dialer.precall.PreCallAction;
import com.google.common.collect.ImmutableList;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PreCallImpl_Factory implements Factory<PreCallImpl> {
  private final Provider<ImmutableList<PreCallAction>> actionsProvider;

  public PreCallImpl_Factory(Provider<ImmutableList<PreCallAction>> actionsProvider) {
    assert actionsProvider != null;
    this.actionsProvider = actionsProvider;
  }

  @Override
  public PreCallImpl get() {
    return new PreCallImpl(actionsProvider.get());
  }

  public static Factory<PreCallImpl> create(
      Provider<ImmutableList<PreCallAction>> actionsProvider) {
    return new PreCallImpl_Factory(actionsProvider);
  }
}
