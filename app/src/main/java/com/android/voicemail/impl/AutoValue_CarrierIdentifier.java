
package com.android.voicemail.impl;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_CarrierIdentifier extends CarrierIdentifier {

  private final String mccMnc;
  private final String gid1;

  private AutoValue_CarrierIdentifier(
      String mccMnc,
      String gid1) {
    this.mccMnc = mccMnc;
    this.gid1 = gid1;
  }

  @Override
  public String mccMnc() {
    return mccMnc;
  }

  @Override
  public String gid1() {
    return gid1;
  }

  @Override
  public String toString() {
    return "CarrierIdentifier{"
        + "mccMnc=" + mccMnc + ", "
        + "gid1=" + gid1
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CarrierIdentifier) {
      CarrierIdentifier that = (CarrierIdentifier) o;
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

  static final class Builder extends CarrierIdentifier.Builder {
    private String mccMnc;
    private String gid1;
    Builder() {
    }
    @Override
    public CarrierIdentifier.Builder setMccMnc(String mccMnc) {
      if (mccMnc == null) {
        throw new NullPointerException("Null mccMnc");
      }
      this.mccMnc = mccMnc;
      return this;
    }
    @Override
    public CarrierIdentifier.Builder setGid1(String gid1) {
      if (gid1 == null) {
        throw new NullPointerException("Null gid1");
      }
      this.gid1 = gid1;
      return this;
    }
    @Override
    public CarrierIdentifier build() {
      String missing = "";
      if (this.mccMnc == null) {
        missing += " mccMnc";
      }
      if (this.gid1 == null) {
        missing += " gid1";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_CarrierIdentifier(
          this.mccMnc,
          this.gid1);
    }
  }

}
