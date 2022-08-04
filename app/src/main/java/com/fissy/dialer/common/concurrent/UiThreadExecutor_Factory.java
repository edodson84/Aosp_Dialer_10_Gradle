package com.fissy.dialer.common.concurrent;

import com.android.utils.ReflectUtils;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UiThreadExecutor_Factory implements Factory<UiThreadExecutor> {
  private final MembersInjector<UiThreadExecutor> uiThreadExecutorMembersInjector;

  public UiThreadExecutor_Factory(
      MembersInjector<UiThreadExecutor> uiThreadExecutorMembersInjector) {
    assert uiThreadExecutorMembersInjector != null;
    this.uiThreadExecutorMembersInjector = uiThreadExecutorMembersInjector;
  }

  @Override
  public UiThreadExecutor get() {
    //return MembersInjectors.injectMembers(uiThreadExecutorMembersInjector, new UiThreadExecutor());
    return new UiThreadExecutor();
  }

  public static Factory<UiThreadExecutor> create(
      MembersInjector<UiThreadExecutor> uiThreadExecutorMembersInjector) {
    return new UiThreadExecutor_Factory(uiThreadExecutorMembersInjector);
  }
}
