
package com.fissy.dialer.activecalls;

import android.telecom.PhoneAccountHandle;
import com.google.common.base.Optional;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ActiveCallInfo extends ActiveCallInfo {

  private final Optional<PhoneAccountHandle> phoneAccountHandle;

  private AutoValue_ActiveCallInfo(
      Optional<PhoneAccountHandle> phoneAccountHandle) {
    this.phoneAccountHandle = phoneAccountHandle;
  }

  @Override
  public Optional<PhoneAccountHandle> phoneAccountHandle() {
    return phoneAccountHandle;
  }

  @Override
  public String toString() {
    return "ActiveCallInfo{"
        + "phoneAccountHandle=" + phoneAccountHandle
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ActiveCallInfo) {
      ActiveCallInfo that = (ActiveCallInfo) o;
      return (this.phoneAccountHandle.equals(that.phoneAccountHandle()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.phoneAccountHandle.hashCode();
    return h;
  }

  static final class Builder extends ActiveCallInfo.Builder {
    private Optional<PhoneAccountHandle> phoneAccountHandle = Optional.absent();
    Builder() {
    }
    @Override
    public ActiveCallInfo.Builder setPhoneAccountHandle(Optional<PhoneAccountHandle> phoneAccountHandle) {
      if (phoneAccountHandle == null) {
        throw new NullPointerException("Null phoneAccountHandle");
      }
      this.phoneAccountHandle = phoneAccountHandle;
      return this;
    }
    @Override
    public ActiveCallInfo build() {
      return new AutoValue_ActiveCallInfo(
          this.phoneAccountHandle);
    }
  }

}
