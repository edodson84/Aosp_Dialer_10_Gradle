package com.fissy.dialer.calllog.observer;

import com.fissy.dialer.calllog.notifier.RefreshAnnotatedCallLogNotifier;
import com.android.utils.ReflectUtils;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MarkDirtyObserver_Factory implements Factory<MarkDirtyObserver> {
  private final MembersInjector<MarkDirtyObserver> markDirtyObserverMembersInjector;

  private final Provider<RefreshAnnotatedCallLogNotifier> refreshAnnotatedCallLogNotifierProvider;

  public MarkDirtyObserver_Factory(
      MembersInjector<MarkDirtyObserver> markDirtyObserverMembersInjector,
      Provider<RefreshAnnotatedCallLogNotifier> refreshAnnotatedCallLogNotifierProvider) {
    assert markDirtyObserverMembersInjector != null;
    this.markDirtyObserverMembersInjector = markDirtyObserverMembersInjector;
    assert refreshAnnotatedCallLogNotifierProvider != null;
    this.refreshAnnotatedCallLogNotifierProvider = refreshAnnotatedCallLogNotifierProvider;
  }

  @Override
  public MarkDirtyObserver get() {
    /*return MembersInjectors.injectMembers(
        markDirtyObserverMembersInjector,
        new MarkDirtyObserver(refreshAnnotatedCallLogNotifierProvider.get()));*/
    return new MarkDirtyObserver(refreshAnnotatedCallLogNotifierProvider.get());
  }

  public static Factory<MarkDirtyObserver> create(
      MembersInjector<MarkDirtyObserver> markDirtyObserverMembersInjector,
      Provider<RefreshAnnotatedCallLogNotifier> refreshAnnotatedCallLogNotifierProvider) {
    return new MarkDirtyObserver_Factory(
        markDirtyObserverMembersInjector, refreshAnnotatedCallLogNotifierProvider);
  }
}
