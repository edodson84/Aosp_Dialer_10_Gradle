
package com.android.incallui.incall.protocol;

import android.support.annotation.Nullable;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_SecondaryInfo extends SecondaryInfo {

  private final boolean shouldShow;
  private final String name;
  private final boolean nameIsNumber;
  private final String label;
  private final String providerLabel;
  private final boolean isConference;
  private final boolean isVideoCall;
  private final boolean isFullscreen;

  private AutoValue_SecondaryInfo(
      boolean shouldShow,
      @Nullable String name,
      boolean nameIsNumber,
      @Nullable String label,
      @Nullable String providerLabel,
      boolean isConference,
      boolean isVideoCall,
      boolean isFullscreen) {
    this.shouldShow = shouldShow;
    this.name = name;
    this.nameIsNumber = nameIsNumber;
    this.label = label;
    this.providerLabel = providerLabel;
    this.isConference = isConference;
    this.isVideoCall = isVideoCall;
    this.isFullscreen = isFullscreen;
  }

  @Override
  public boolean shouldShow() {
    return shouldShow;
  }

  @Nullable
  @Override
  public String name() {
    return name;
  }

  @Override
  public boolean nameIsNumber() {
    return nameIsNumber;
  }

  @Nullable
  @Override
  public String label() {
    return label;
  }

  @Nullable
  @Override
  public String providerLabel() {
    return providerLabel;
  }

  @Override
  public boolean isConference() {
    return isConference;
  }

  @Override
  public boolean isVideoCall() {
    return isVideoCall;
  }

  @Override
  public boolean isFullscreen() {
    return isFullscreen;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SecondaryInfo) {
      SecondaryInfo that = (SecondaryInfo) o;
      return (this.shouldShow == that.shouldShow())
           && ((this.name == null) ? (that.name() == null) : this.name.equals(that.name()))
           && (this.nameIsNumber == that.nameIsNumber())
           && ((this.label == null) ? (that.label() == null) : this.label.equals(that.label()))
           && ((this.providerLabel == null) ? (that.providerLabel() == null) : this.providerLabel.equals(that.providerLabel()))
           && (this.isConference == that.isConference())
           && (this.isVideoCall == that.isVideoCall())
           && (this.isFullscreen == that.isFullscreen());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.shouldShow ? 1231 : 1237;
    h *= 1000003;
    h ^= (name == null) ? 0 : this.name.hashCode();
    h *= 1000003;
    h ^= this.nameIsNumber ? 1231 : 1237;
    h *= 1000003;
    h ^= (label == null) ? 0 : this.label.hashCode();
    h *= 1000003;
    h ^= (providerLabel == null) ? 0 : this.providerLabel.hashCode();
    h *= 1000003;
    h ^= this.isConference ? 1231 : 1237;
    h *= 1000003;
    h ^= this.isVideoCall ? 1231 : 1237;
    h *= 1000003;
    h ^= this.isFullscreen ? 1231 : 1237;
    return h;
  }

  static final class Builder extends SecondaryInfo.Builder {
    private Boolean shouldShow;
    private String name;
    private Boolean nameIsNumber;
    private String label;
    private String providerLabel;
    private Boolean isConference;
    private Boolean isVideoCall;
    private Boolean isFullscreen;
    Builder() {
    }
    @Override
    public SecondaryInfo.Builder setShouldShow(boolean shouldShow) {
      this.shouldShow = shouldShow;
      return this;
    }
    @Override
    public SecondaryInfo.Builder setName(@Nullable String name) {
      this.name = name;
      return this;
    }
    @Override
    public SecondaryInfo.Builder setNameIsNumber(boolean nameIsNumber) {
      this.nameIsNumber = nameIsNumber;
      return this;
    }
    @Override
    public SecondaryInfo.Builder setLabel(@Nullable String label) {
      this.label = label;
      return this;
    }
    @Override
    public SecondaryInfo.Builder setProviderLabel(@Nullable String providerLabel) {
      this.providerLabel = providerLabel;
      return this;
    }
    @Override
    public SecondaryInfo.Builder setIsConference(boolean isConference) {
      this.isConference = isConference;
      return this;
    }
    @Override
    public SecondaryInfo.Builder setIsVideoCall(boolean isVideoCall) {
      this.isVideoCall = isVideoCall;
      return this;
    }
    @Override
    public SecondaryInfo.Builder setIsFullscreen(boolean isFullscreen) {
      this.isFullscreen = isFullscreen;
      return this;
    }
    @Override
    public SecondaryInfo build() {
      String missing = "";
      if (this.shouldShow == null) {
        missing += " shouldShow";
      }
      if (this.nameIsNumber == null) {
        missing += " nameIsNumber";
      }
      if (this.isConference == null) {
        missing += " isConference";
      }
      if (this.isVideoCall == null) {
        missing += " isVideoCall";
      }
      if (this.isFullscreen == null) {
        missing += " isFullscreen";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_SecondaryInfo(
          this.shouldShow,
          this.name,
          this.nameIsNumber,
          this.label,
          this.providerLabel,
          this.isConference,
          this.isVideoCall,
          this.isFullscreen);
    }
  }

}
