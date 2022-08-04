package com.fissy.dialer.phonelookup;

import com.fissy.dialer.phonelookup.blockednumber.SystemBlockedNumberPhoneLookup;
import com.fissy.dialer.phonelookup.cequint.CequintPhoneLookup;
import com.fissy.dialer.phonelookup.cnap.CnapPhoneLookup;
import com.fissy.dialer.phonelookup.cp2.Cp2DefaultDirectoryPhoneLookup;
import com.fissy.dialer.phonelookup.cp2.Cp2ExtendedDirectoryPhoneLookup;
import com.fissy.dialer.phonelookup.emergency.EmergencyPhoneLookup;
import com.fissy.dialer.phonelookup.spam.SpamPhoneLookup;
import com.google.common.collect.ImmutableList;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PhoneLookupModule_ProvidePhoneLookupListFactory
    implements Factory<ImmutableList<PhoneLookup>> {
  private final Provider<CequintPhoneLookup> cequintPhoneLookupProvider;

  private final Provider<CnapPhoneLookup> cnapPhoneLookupProvider;

  private final Provider<Cp2DefaultDirectoryPhoneLookup> cp2DefaultDirectoryPhoneLookupProvider;

  private final Provider<Cp2ExtendedDirectoryPhoneLookup> cp2ExtendedDirectoryPhoneLookupProvider;

  private final Provider<EmergencyPhoneLookup> emergencyPhoneLookupProvider;

  private final Provider<SystemBlockedNumberPhoneLookup> systemBlockedNumberPhoneLookupProvider;

  private final Provider<SpamPhoneLookup> spamPhoneLookupProvider;

  public PhoneLookupModule_ProvidePhoneLookupListFactory(
      Provider<CequintPhoneLookup> cequintPhoneLookupProvider,
      Provider<CnapPhoneLookup> cnapPhoneLookupProvider,
      Provider<Cp2DefaultDirectoryPhoneLookup> cp2DefaultDirectoryPhoneLookupProvider,
      Provider<Cp2ExtendedDirectoryPhoneLookup> cp2ExtendedDirectoryPhoneLookupProvider,
      Provider<EmergencyPhoneLookup> emergencyPhoneLookupProvider,
      Provider<SystemBlockedNumberPhoneLookup> systemBlockedNumberPhoneLookupProvider,
      Provider<SpamPhoneLookup> spamPhoneLookupProvider) {
    assert cequintPhoneLookupProvider != null;
    this.cequintPhoneLookupProvider = cequintPhoneLookupProvider;
    assert cnapPhoneLookupProvider != null;
    this.cnapPhoneLookupProvider = cnapPhoneLookupProvider;
    assert cp2DefaultDirectoryPhoneLookupProvider != null;
    this.cp2DefaultDirectoryPhoneLookupProvider = cp2DefaultDirectoryPhoneLookupProvider;
    assert cp2ExtendedDirectoryPhoneLookupProvider != null;
    this.cp2ExtendedDirectoryPhoneLookupProvider = cp2ExtendedDirectoryPhoneLookupProvider;
    assert emergencyPhoneLookupProvider != null;
    this.emergencyPhoneLookupProvider = emergencyPhoneLookupProvider;
    assert systemBlockedNumberPhoneLookupProvider != null;
    this.systemBlockedNumberPhoneLookupProvider = systemBlockedNumberPhoneLookupProvider;
    assert spamPhoneLookupProvider != null;
    this.spamPhoneLookupProvider = spamPhoneLookupProvider;
  }

  @Override
  public ImmutableList<PhoneLookup> get() {
    return Preconditions.checkNotNull(
        PhoneLookupModule.providePhoneLookupList(
            cequintPhoneLookupProvider.get(),
            cnapPhoneLookupProvider.get(),
            cp2DefaultDirectoryPhoneLookupProvider.get(),
            cp2ExtendedDirectoryPhoneLookupProvider.get(),
            emergencyPhoneLookupProvider.get(),
            systemBlockedNumberPhoneLookupProvider.get(),
            spamPhoneLookupProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ImmutableList<PhoneLookup>> create(
      Provider<CequintPhoneLookup> cequintPhoneLookupProvider,
      Provider<CnapPhoneLookup> cnapPhoneLookupProvider,
      Provider<Cp2DefaultDirectoryPhoneLookup> cp2DefaultDirectoryPhoneLookupProvider,
      Provider<Cp2ExtendedDirectoryPhoneLookup> cp2ExtendedDirectoryPhoneLookupProvider,
      Provider<EmergencyPhoneLookup> emergencyPhoneLookupProvider,
      Provider<SystemBlockedNumberPhoneLookup> systemBlockedNumberPhoneLookupProvider,
      Provider<SpamPhoneLookup> spamPhoneLookupProvider) {
    return new PhoneLookupModule_ProvidePhoneLookupListFactory(
        cequintPhoneLookupProvider,
        cnapPhoneLookupProvider,
        cp2DefaultDirectoryPhoneLookupProvider,
        cp2ExtendedDirectoryPhoneLookupProvider,
        emergencyPhoneLookupProvider,
        systemBlockedNumberPhoneLookupProvider,
        spamPhoneLookupProvider);
  }
}
