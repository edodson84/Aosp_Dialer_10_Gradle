package com.fissy.dialer.spam.status;

import com.google.common.base.Optional;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_UserSpamListStatus extends UserSpamListStatus {

    private final int status;
    private final Optional<Long> timestampMillis;

    AutoValue_UserSpamListStatus(
            int status,
            Optional<Long> timestampMillis) {
        this.status = status;
        if (timestampMillis == null) {
            throw new NullPointerException("Null timestampMillis");
        }
        this.timestampMillis = timestampMillis;
    }

    @UserSpamListStatus.Status
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
        return "UserSpamListStatus{"
                + "status=" + status + ", "
                + "timestampMillis=" + timestampMillis
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof UserSpamListStatus) {
            UserSpamListStatus that = (UserSpamListStatus) o;
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
