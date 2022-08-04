
package com.fissy.dialer.spam.status;

import com.google.common.base.Optional;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_GlobalSpamListStatus extends GlobalSpamListStatus {

  private final int status;
  private final Optional<Long> timestampMillis;

  AutoValue_GlobalSpamListStatus(
      int status,
      Optional<Long> timestampMillis) {
    this.status = status;
    if (timestampMillis == null) {
      throw new NullPointerException("Null timestampMillis");
    }
    this.timestampMillis = timestampMillis;
  }

  @GlobalSpamListStatus.Status
  @Override
  public int getStatus() {
    return status;
  }

  @Override
  public Optional<Long> getTimestampMillis() {
    return timestampMillis;
  }

  @Override
  public String toString() {
    return "GlobalSpamListStatus{"
        + "status=" + status + ", "
        + "timestampMillis=" + timestampMillis
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof GlobalSpamListStatus) {
      GlobalSpamListStatus that = (GlobalSpamListStatus) o;
      return (this.status == that.getStatus())
           && (this.timestampMillis.equals(that.getTimestampMillis()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.status;
    h *= 1000003;
    h ^= this.timestampMillis.hashCode();
    return h;
  }

}
