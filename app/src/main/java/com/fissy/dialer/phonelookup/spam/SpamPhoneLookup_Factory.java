package com.fissy.dialer.phonelookup.spam;

import android.content.SharedPreferences;
import com.fissy.dialer.spam.Spam;
import com.google.common.util.concurrent.ListeningExecutorService;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SpamPhoneLookup_Factory implements Factory<SpamPhoneLookup> {
  private final Provider<ListeningExecutorService> backgroundExecutorServiceProvider;

  private final Provider<ListeningExecutorService> lightweightExecutorServiceProvider;

  private final Provider<SharedPreferences> sharedPreferencesProvider;

  private final Provider<Spam> spamProvider;

  public SpamPhoneLookup_Factory(
      Provider<ListeningExecutorService> backgroundExecutorServiceProvider,
      Provider<ListeningExecutorService> lightweightExecutorServiceProvider,
      Provider<SharedPreferences> sharedPreferencesProvider,
      Provider<Spam> spamProvider) {
    assert backgroundExecutorServiceProvider != null;
    this.backgroundExecutorServiceProvider = backgroundExecutorServiceProvider;
    assert lightweightExecutorServiceProvider != null;
    this.lightweightExecutorServiceProvider = lightweightExecutorServiceProvider;
    assert sharedPreferencesProvider != null;
    this.sharedPreferencesProvider = sharedPreferencesProvider;
    assert spamProvider != null;
    this.spamProvider = spamProvider;
  }

  @Override
  public SpamPhoneLookup get() {
    return new SpamPhoneLookup(
        backgroundExecutorServiceProvider.get(),
        lightweightExecutorServiceProvider.get(),
        sharedPreferencesProvider.get(),
        spamProvider.get());
  }

  public static Factory<SpamPhoneLookup> create(
      Provider<ListeningExecutorService> backgroundExecutorServiceProvider,
      Provider<ListeningExecutorService> lightweightExecutorServiceProvider,
      Provider<SharedPreferences> sharedPreferencesProvider,
      Provider<Spam> spamProvider) {
    return new SpamPhoneLookup_Factory(
        backgroundExecutorServiceProvider,
        lightweightExecutorServiceProvider,
        sharedPreferencesProvider,
        spamProvider);
  }
}
