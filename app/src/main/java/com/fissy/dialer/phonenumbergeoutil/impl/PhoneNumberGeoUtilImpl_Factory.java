package com.fissy.dialer.phonenumbergeoutil.impl;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum PhoneNumberGeoUtilImpl_Factory implements Factory<PhoneNumberGeoUtilImpl> {
  INSTANCE;

  @Override
  public PhoneNumberGeoUtilImpl get() {
    return new PhoneNumberGeoUtilImpl();
  }

  public static Factory<PhoneNumberGeoUtilImpl> create() {
    return INSTANCE;
  }
}
