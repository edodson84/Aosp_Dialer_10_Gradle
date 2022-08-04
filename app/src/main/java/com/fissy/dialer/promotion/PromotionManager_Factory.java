package com.fissy.dialer.promotion;

import com.google.common.collect.ImmutableList;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PromotionManager_Factory implements Factory<PromotionManager> {
  private final Provider<ImmutableList<Promotion>> priorityPromotionListProvider;

  public PromotionManager_Factory(
      Provider<ImmutableList<Promotion>> priorityPromotionListProvider) {
    assert priorityPromotionListProvider != null;
    this.priorityPromotionListProvider = priorityPromotionListProvider;
  }

  @Override
  public PromotionManager get() {
    return new PromotionManager(priorityPromotionListProvider.get());
  }

  public static Factory<PromotionManager> create(
      Provider<ImmutableList<Promotion>> priorityPromotionListProvider) {
    return new PromotionManager_Factory(priorityPromotionListProvider);
  }
}
