package com.fissy.dialer.commandline;

import com.fissy.dialer.function.Supplier;
import com.google.common.collect.ImmutableMap;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CommandLineModule_ProvideCommandSupplierFactory
    implements Factory<Supplier<ImmutableMap<String, Command>>> {
  private final Provider<CommandLineModule.AospCommandInjector> aospCommandInjectorProvider;

  public CommandLineModule_ProvideCommandSupplierFactory(
      Provider<CommandLineModule.AospCommandInjector> aospCommandInjectorProvider) {
    assert aospCommandInjectorProvider != null;
    this.aospCommandInjectorProvider = aospCommandInjectorProvider;
  }

  @Override
  public Supplier<ImmutableMap<String, Command>> get() {
    return Preconditions.checkNotNull(
        CommandLineModule.provideCommandSupplier(aospCommandInjectorProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Supplier<ImmutableMap<String, Command>>> create(
      Provider<CommandLineModule.AospCommandInjector> aospCommandInjectorProvider) {
    return new CommandLineModule_ProvideCommandSupplierFactory(aospCommandInjectorProvider);
  }
}
