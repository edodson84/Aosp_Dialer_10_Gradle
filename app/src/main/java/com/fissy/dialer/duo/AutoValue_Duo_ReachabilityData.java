package com.fissy.dialer.duo;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_Duo_ReachabilityData extends Duo.ReachabilityData {

    private final Duo.ReachabilityData.Status status;
    private final String number;
    private final boolean audioCallable;
    private final boolean videoCallable;
    private final boolean supportsUpgrade;

    AutoValue_Duo_ReachabilityData(
            Duo.ReachabilityData.Status status,
            String number,
            boolean audioCallable,
            boolean videoCallable,
            boolean supportsUpgrade) {
        if (status == null) {
            throw new NullPointerException("Null status");
        }
        this.status = status;
        if (number == null) {
            throw new NullPointerException("Null number");
        }
        this.number = number;
        this.audioCallable = audioCallable;
        this.videoCallable = videoCallable;
        this.supportsUpgrade = supportsUpgrade;
    }

    @Override
    public Duo.ReachabilityData.Status status() {
        return status;
    }

    @Override
    public String number() {
        return number;
    }

    @Override
    public boolean audioCallable() {
        return audioCallable;
    }

    @Override
    public boolean videoCallable() {
        return videoCallable;
    }

    @Override
    public boolean supportsUpgrade() {
        return supportsUpgrade;
    }

    @Override
    public String toString() {
        return "ReachabilityData{"
                + "status=" + status + ", "
                + "number=" + number + ", "
                + "audioCallable=" + audioCallable + ", "
                + "videoCallable=" + videoCallable + ", "
                + "supportsUpgrade=" + supportsUpgrade
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Duo.ReachabilityData) {
            Duo.ReachabilityData that = (Duo.ReachabilityData) o;
            return (this.status.equals(that.status()))
                    && (this.number.equals(that.number()))
                    && (this.audioCallable == that.audioCallable())
                    && (this.videoCallable == that.videoCallable())
                    && (this.supportsUpgrade == that.supportsUpgrade());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= this.status.hashCode();
        h *= 1000003;
        h ^= this.number.hashCode();
        h *= 1000003;
        h ^= this.audioCallable ? 1231 : 1237;
        h *= 1000003;
        h ^= this.videoCallable ? 1231 : 1237;
        h *= 1000003;
        h ^= this.supportsUpgrade ? 1231 : 1237;
        return h;
    }

}
