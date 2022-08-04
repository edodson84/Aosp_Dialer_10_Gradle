package com.fissy.dialer.phonelookup.cp2;

import android.content.Context;
import com.fissy.dialer.configprovider.ConfigProvider;
import com.google.common.util.concurrent.ListeningExecutorService;
import dagger.internal.Factory;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Cp2ExtendedDirectoryPhoneLookup_Factory
    implements Factory<Cp2ExtendedDirectoryPhoneLookup> {
  private final Provider<Context> appContextProvider;

  private final Provider<ListeningExecutorService> backgroundExecutorServiceProvider;

  private final Provider<ListeningExecutorService> lightweightExecutorServiceProvider;

  private final Provider<ScheduledExecutorService> scheduledExecutorServiceProvider;

  private final Provider<ConfigProvider> configProvider;

  private final Provider<MissingPermissionsOperations> missingPermissionsOperationsProvider;

  public Cp2ExtendedDirectoryPhoneLookup_Factory(
      Provider<Context> appContextProvider,
      Provider<ListeningExecutorService> backgroundExecutorServiceProvider,
      Provider<ListeningExecutorService> lightweightExecutorServiceProvider,
      Provider<ScheduledExecutorService> scheduledExecutorServiceProvider,
      Provider<ConfigProvider> configProvider,
      Provider<MissingPermissionsOperations> missingPermissionsOperationsProvider) {
    assert appContextProvider != null;
    this.appContextProvider = appContextProvider;
    assert backgroundExecutorServiceProvider != null;
    this.backgroundExecutorServiceProvider = backgroundExecutorServiceProvider;
    assert lightweightExecutorServiceProvider != null;
    this.lightweightExecutorServiceProvider = lightweightExecutorServiceProvider;
    assert scheduledExecutorServiceProvider != null;
    this.scheduledExecutorServiceProvider = scheduledExecutorServiceProvider;
    assert configProvider != null;
    this.configProvider = configProvider;
    assert missingPermissionsOperationsProvider != null;
    this.missingPermissionsOperationsProvider = missingPermissionsOperationsProvider;
  }

  @Override
  public Cp2ExtendedDirectoryPhoneLookup get() {
    return new Cp2ExtendedDirectoryPhoneLookup(
        appContextProvider.get(),
        backgroundExecutorServiceProvider.get(),
        lightweightExecutorServiceProvider.get(),
        scheduledExecutorServiceProvider.get(),
        configProvider.get(),
        missingPermissionsOperationsProvider.get());
  }

  public static Factory<Cp2ExtendedDirectoryPhoneLookup> create(
      Provider<Context> appContextProvider,
      Provider<ListeningExecutorService> backgroundExecutorServiceProvider,
      Provider<ListeningExecutorService> lightweightExecutorServiceProvider,
      Provider<ScheduledExecutorService> scheduledExecutorServiceProvider,
      Provider<ConfigProvider> configProvider,
      Provider<MissingPermissionsOperations> missingPermissionsOperationsProvider) {
    return new Cp2ExtendedDirectoryPhoneLookup_Factory(
        appContextProvider,
        backgroundExecutorServiceProvider,
        lightweightExecutorServiceProvider,
        scheduledExecutorServiceProvider,
        configProvider,
        missingPermissionsOperationsProvider);
  }
}
