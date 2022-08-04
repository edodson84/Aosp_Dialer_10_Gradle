package com.fissy.dialer.precall.impl;

import com.fissy.dialer.precall.PreCallAction;
import com.google.common.collect.ImmutableList;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PreCallModule_ProvideActionsFactory
    implements Factory<ImmutableList<PreCallAction>> {
  private final Provider<DuoAction> duoActionProvider;

  private final Provider<CallingAccountSelector> callingAccountSelectorProvider;

  public PreCallModule_ProvideActionsFactory(
      Provider<DuoAction> duoActionProvider,
      Provider<CallingAccountSelector> callingAccountSelectorProvider) {
    assert duoActionProvider != null;
    this.duoActionProvider = duoActionProvider;
    assert callingAccountSelectorProvider != null;
    this.callingAccountSelectorProvider = callingAccountSelectorProvider;
  }

  @Override
  public ImmutableList<PreCallAction> get() {
    return Preconditions.checkNotNull(
        PreCallModule.provideActions(duoActionProvider.get(), callingAccountSelectorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ImmutableList<PreCallAction>> create(
      Provider<DuoAction> duoActionProvider,
      Provider<CallingAccountSelector> callingAccountSelectorProvider) {
    return new PreCallModule_ProvideActionsFactory(
        duoActionProvider, callingAccountSelectorProvider);
  }
}
