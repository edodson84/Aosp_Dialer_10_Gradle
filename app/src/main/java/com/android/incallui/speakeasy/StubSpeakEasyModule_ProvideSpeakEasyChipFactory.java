package com.android.incallui.speakeasy;

import com.google.common.base.Optional;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum StubSpeakEasyModule_ProvideSpeakEasyChipFactory implements Factory<Optional<Integer>> {
  INSTANCE;

  @Override
  public Optional<Integer> get() {
    return Preconditions.checkNotNull(
        StubSpeakEasyModule.provideSpeakEasyChip(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Optional<Integer>> create() {
    return INSTANCE;
  }
}
