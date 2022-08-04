package com.android.incallui.speakeasy;

import com.google.common.base.Optional;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum StubSpeakEasyModule_ProvideSpeakEasySettingsObjectFactory
    implements Factory<Optional<Object>> {
  INSTANCE;

  @Override
  public Optional<Object> get() {
    return Preconditions.checkNotNull(
        StubSpeakEasyModule.provideSpeakEasySettingsObject(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Optional<Object>> create() {
    return INSTANCE;
  }
}
