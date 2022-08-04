
package com.fissy.dialer.assisteddialing;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_TransformationInfo extends TransformationInfo {

  private final String originalNumber;
  private final String transformedNumber;
  private final String userHomeCountryCode;
  private final String userRoamingCountryCode;
  private final int transformedNumberCountryCallingCode;

  private AutoValue_TransformationInfo(
      String originalNumber,
      String transformedNumber,
      String userHomeCountryCode,
      String userRoamingCountryCode,
      int transformedNumberCountryCallingCode) {
    this.originalNumber = originalNumber;
    this.transformedNumber = transformedNumber;
    this.userHomeCountryCode = userHomeCountryCode;
    this.userRoamingCountryCode = userRoamingCountryCode;
    this.transformedNumberCountryCallingCode = transformedNumberCountryCallingCode;
  }

  @Override
  public String originalNumber() {
    return originalNumber;
  }

  @Override
  public String transformedNumber() {
    return transformedNumber;
  }

  @Override
  public String userHomeCountryCode() {
    return userHomeCountryCode;
  }

  @Override
  public String userRoamingCountryCode() {
    return userRoamingCountryCode;
  }

  @Override
  public int transformedNumberCountryCallingCode() {
    return transformedNumberCountryCallingCode;
  }

  @Override
  public String toString() {
    return "TransformationInfo{"
        + "originalNumber=" + originalNumber + ", "
        + "transformedNumber=" + transformedNumber + ", "
        + "userHomeCountryCode=" + userHomeCountryCode + ", "
        + "userRoamingCountryCode=" + userRoamingCountryCode + ", "
        + "transformedNumberCountryCallingCode=" + transformedNumberCountryCallingCode
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TransformationInfo) {
      TransformationInfo that = (TransformationInfo) o;
      return (this.originalNumber.equals(that.originalNumber()))
           && (this.transformedNumber.equals(that.transformedNumber()))
           && (this.userHomeCountryCode.equals(that.userHomeCountryCode()))
           && (this.userRoamingCountryCode.equals(that.userRoamingCountryCode()))
           && (this.transformedNumberCountryCallingCode == that.transformedNumberCountryCallingCode());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.originalNumber.hashCode();
    h *= 1000003;
    h ^= this.transformedNumber.hashCode();
    h *= 1000003;
    h ^= this.userHomeCountryCode.hashCode();
    h *= 1000003;
    h ^= this.userRoamingCountryCode.hashCode();
    h *= 1000003;
    h ^= this.transformedNumberCountryCallingCode;
    return h;
  }

  static final class Builder extends TransformationInfo.Builder {
    private String originalNumber;
    private String transformedNumber;
    private String userHomeCountryCode;
    private String userRoamingCountryCode;
    private Integer transformedNumberCountryCallingCode;
    Builder() {
    }
    @Override
    public TransformationInfo.Builder setOriginalNumber(String originalNumber) {
      if (originalNumber == null) {
        throw new NullPointerException("Null originalNumber");
      }
      this.originalNumber = originalNumber;
      return this;
    }
    @Override
    public TransformationInfo.Builder setTransformedNumber(String transformedNumber) {
      if (transformedNumber == null) {
        throw new NullPointerException("Null transformedNumber");
      }
      this.transformedNumber = transformedNumber;
      return this;
    }
    @Override
    public TransformationInfo.Builder setUserHomeCountryCode(String userHomeCountryCode) {
      if (userHomeCountryCode == null) {
        throw new NullPointerException("Null userHomeCountryCode");
      }
      this.userHomeCountryCode = userHomeCountryCode;
      return this;
    }
    @Override
    public TransformationInfo.Builder setUserRoamingCountryCode(String userRoamingCountryCode) {
      if (userRoamingCountryCode == null) {
        throw new NullPointerException("Null userRoamingCountryCode");
      }
      this.userRoamingCountryCode = userRoamingCountryCode;
      return this;
    }
    @Override
    public TransformationInfo.Builder setTransformedNumberCountryCallingCode(int transformedNumberCountryCallingCode) {
      this.transformedNumberCountryCallingCode = transformedNumberCountryCallingCode;
      return this;
    }
    @Override
    public TransformationInfo build() {
      String missing = "";
      if (this.originalNumber == null) {
        missing += " originalNumber";
      }
      if (this.transformedNumber == null) {
        missing += " transformedNumber";
      }
      if (this.userHomeCountryCode == null) {
        missing += " userHomeCountryCode";
      }
      if (this.userRoamingCountryCode == null) {
        missing += " userRoamingCountryCode";
      }
      if (this.transformedNumberCountryCallingCode == null) {
        missing += " transformedNumberCountryCallingCode";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_TransformationInfo(
          this.originalNumber,
          this.transformedNumber,
          this.userHomeCountryCode,
          this.userRoamingCountryCode,
          this.transformedNumberCountryCallingCode);
    }
  }

}
