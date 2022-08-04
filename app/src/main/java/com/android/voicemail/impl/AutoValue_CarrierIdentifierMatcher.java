
package com.android.voicemail.impl;

import com.google.common.base.Optional;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_CarrierIdentifierMatcher extends CarrierIdentifierMatcher {

  private final String mccMnc;
  private final Optional<String> gid1;

  private AutoValue_CarrierIdentifierMatcher(
      String mccMnc,
      Optional<String> gid1) {
    this.mccMnc = mccMnc;
    this.gid1 = gid1;
  }

  @Override
  public String mccMnc() {
    return mccMnc;
  }

  @Override
  public Optional<String> gid1() {
    return gid1;
  }

  @Override
  public String toString() {
    return "CarrierIdentifierMatcher{"
        + "mccMnc=" + mccMnc + ", "
        + "gid1=" + gid1
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CarrierIdentifierMatcher) {
      CarrierIdentifierMatcher that = (CarrierIdentifierMatcher) o;
      return (this.mccMnc.equals(that.mccMnc()))
           && (this.gid1.equals(that.gid1()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.mccMnc.hashCode();
    h *= 1000003;
    h ^= this.gid1.hashCode();
    return h;
  }

  static final class Builder extends CarrierIdentifierMatcher.Builder {
    private String mccMnc;
    private Optional<String> gid1 = Optional.absent();
    Builder() {
    }
    @Override
    public CarrierIdentifierMatcher.Builder setMccMnc(String mccMnc) {
      if (mccMnc == null) {
        throw new NullPointerException("Null mccMnc");
      }
      this.mccMnc = mccMnc;
      return this;
    }
    @Override
    public CarrierIdentifierMatcher.Builder setGid1(String gid1) {
      if (gid1 == null) {
        throw new NullPointerException("Null gid1");
      }
      this.gid1 = Optional.of(gid1);
      return this;
    }
    @Override
    public CarrierIdentifierMatcher build() {
      String missing = "";
      if (this.mccMnc == null) {
        missing += " mccMnc";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_CarrierIdentifierMatcher(
          this.mccMnc,
          this.gid1);
    }
  }

}
