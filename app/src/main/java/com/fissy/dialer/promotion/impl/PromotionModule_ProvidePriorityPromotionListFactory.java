package com.fissy.dialer.promotion.impl;

import com.fissy.dialer.promotion.Promotion;
import com.google.common.collect.ImmutableList;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class PromotionModule_ProvidePriorityPromotionListFactory
        implements Factory<ImmutableList<Promotion>> {
    private final Provider<RttPromotion> rttPromotionProvider;

    private final Provider<DuoPromotion> duoPromotionProvider;

    public PromotionModule_ProvidePriorityPromotionListFactory(
            Provider<RttPromotion> rttPromotionProvider, Provider<DuoPromotion> duoPromotionProvider) {
        assert rttPromotionProvider != null;
        this.rttPromotionProvider = rttPromotionProvider;
        assert duoPromotionProvider != null;
        this.duoPromotionProvider = duoPromotionProvider;
    }

    public static Factory<ImmutableList<Promotion>> create(
            Provider<RttPromotion> rttPromotionProvider, Provider<DuoPromotion> duoPromotionProvider) {
        return new PromotionModule_ProvidePriorityPromotionListFactory(
                rttPromotionProvider, duoPromotionProvider);
    }

    @Override
    public ImmutableList<Promotion> get() {
        return Preconditions.checkNotNull(
                PromotionModule.providePriorityPromotionList(
                        rttPromotionProvider.get(), duoPromotionProvider.get()),
                "Cannot return null from a non-@Nullable @Provides method");
    }
}
