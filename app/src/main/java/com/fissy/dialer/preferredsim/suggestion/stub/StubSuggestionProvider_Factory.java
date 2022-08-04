package com.fissy.dialer.preferredsim.suggestion.stub;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum StubSuggestionProvider_Factory implements Factory<StubSuggestionProvider> {
  INSTANCE;

  @Override
  public StubSuggestionProvider get() {
    return new StubSuggestionProvider();
  }

  public static Factory<StubSuggestionProvider> create() {
    return INSTANCE;
  }
}
