
package com.fissy.dialer.spam.status;

import com.google.common.base.Optional;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_SpamMetadata extends SpamMetadata {

  private final Optional<GlobalSpamListStatus> globalSpamListStatus;
  private final Optional<UserSpamListStatus> userSpamListStatus;

  private AutoValue_SpamMetadata(
      Optional<GlobalSpamListStatus> globalSpamListStatus,
      Optional<UserSpamListStatus> userSpamListStatus) {
    this.globalSpamListStatus = globalSpamListStatus;
    this.userSpamListStatus = userSpamListStatus;
  }

  @Override
  public Optional<GlobalSpamListStatus> globalSpamListStatus() {
    return globalSpamListStatus;
  }

  @Override
  public Optional<UserSpamListStatus> userSpamListStatus() {
    return userSpamListStatus;
  }

  @Override
  public String toString() {
    return "SpamMetadata{"
        + "globalSpamListStatus=" + globalSpamListStatus + ", "
        + "userSpamListStatus=" + userSpamListStatus
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SpamMetadata) {
      SpamMetadata that = (SpamMetadata) o;
      return (this.globalSpamListStatus.equals(that.globalSpamListStatus()))
           && (this.userSpamListStatus.equals(that.userSpamListStatus()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.globalSpamListStatus.hashCode();
    h *= 1000003;
    h ^= this.userSpamListStatus.hashCode();
    return h;
  }

  static final class Builder extends SpamMetadata.Builder {
    private Optional<GlobalSpamListStatus> globalSpamListStatus = Optional.absent();
    private Optional<UserSpamListStatus> userSpamListStatus = Optional.absent();
    Builder() {
    }
    @Override
    public SpamMetadata.Builder setGlobalSpamListStatus(GlobalSpamListStatus globalSpamListStatus) {
      if (globalSpamListStatus == null) {
        throw new NullPointerException("Null globalSpamListStatus");
      }
      this.globalSpamListStatus = Optional.of(globalSpamListStatus);
      return this;
    }
    @Override
    public SpamMetadata.Builder setUserSpamListStatus(UserSpamListStatus userSpamListStatus) {
      if (userSpamListStatus == null) {
        throw new NullPointerException("Null userSpamListStatus");
      }
      this.userSpamListStatus = Optional.of(userSpamListStatus);
      return this;
    }
    @Override
    public SpamMetadata build() {
      return new AutoValue_SpamMetadata(
          this.globalSpamListStatus,
          this.userSpamListStatus);
    }
  }

}
