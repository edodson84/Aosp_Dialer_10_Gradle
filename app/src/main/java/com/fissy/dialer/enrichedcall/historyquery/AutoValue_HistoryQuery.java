
package com.fissy.dialer.enrichedcall.historyquery;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_HistoryQuery extends HistoryQuery {

  private final String number;
  private final long callStartTimestamp;
  private final long callEndTimestamp;

  AutoValue_HistoryQuery(
      String number,
      long callStartTimestamp,
      long callEndTimestamp) {
    if (number == null) {
      throw new NullPointerException("Null number");
    }
    this.number = number;
    this.callStartTimestamp = callStartTimestamp;
    this.callEndTimestamp = callEndTimestamp;
  }

  @Override
  public String getNumber() {
    return number;
  }

  @Override
  public long getCallStartTimestamp() {
    return callStartTimestamp;
  }

  @Override
  public long getCallEndTimestamp() {
    return callEndTimestamp;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HistoryQuery) {
      HistoryQuery that = (HistoryQuery) o;
      return (this.number.equals(that.getNumber()))
           && (this.callStartTimestamp == that.getCallStartTimestamp())
           && (this.callEndTimestamp == that.getCallEndTimestamp());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.number.hashCode();
    h *= 1000003;
    h ^= (int) ((this.callStartTimestamp >>> 32) ^ this.callStartTimestamp);
    h *= 1000003;
    h ^= (int) ((this.callEndTimestamp >>> 32) ^ this.callEndTimestamp);
    return h;
  }

}
