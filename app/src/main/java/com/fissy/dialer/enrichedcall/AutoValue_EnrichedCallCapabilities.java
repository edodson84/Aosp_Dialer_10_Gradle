package com.fissy.dialer.enrichedcall;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_EnrichedCallCapabilities extends EnrichedCallCapabilities {

    private final boolean callComposerCapable;
    private final boolean postCallCapable;
    private final boolean videoShareCapable;
    private final boolean temporarilyUnavailable;

    private AutoValue_EnrichedCallCapabilities(
            boolean callComposerCapable,
            boolean postCallCapable,
            boolean videoShareCapable,
            boolean temporarilyUnavailable) {
        this.callComposerCapable = callComposerCapable;
        this.postCallCapable = postCallCapable;
        this.videoShareCapable = videoShareCapable;
        this.temporarilyUnavailable = temporarilyUnavailable;
    }

    @Override
    public boolean isCallComposerCapable() {
        return callComposerCapable;
    }

    @Override
    public boolean isPostCallCapable() {
        return postCallCapable;
    }

    @Override
    public boolean isVideoShareCapable() {
        return videoShareCapable;
    }

    @Override
    public boolean isTemporarilyUnavailable() {
        return temporarilyUnavailable;
    }

    @Override
    public String toString() {
        return "EnrichedCallCapabilities{"
                + "callComposerCapable=" + callComposerCapable + ", "
                + "postCallCapable=" + postCallCapable + ", "
                + "videoShareCapable=" + videoShareCapable + ", "
                + "temporarilyUnavailable=" + temporarilyUnavailable
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof EnrichedCallCapabilities) {
            EnrichedCallCapabilities that = (EnrichedCallCapabilities) o;
            return (this.callComposerCapable == that.isCallComposerCapable())
                    && (this.postCallCapable == that.isPostCallCapable())
                    && (this.videoShareCapable == that.isVideoShareCapable())
                    && (this.temporarilyUnavailable == that.isTemporarilyUnavailable());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= this.callComposerCapable ? 1231 : 1237;
        h *= 1000003;
        h ^= this.postCallCapable ? 1231 : 1237;
        h *= 1000003;
        h ^= this.videoShareCapable ? 1231 : 1237;
        h *= 1000003;
        h ^= this.temporarilyUnavailable ? 1231 : 1237;
        return h;
    }

    @Override
    public EnrichedCallCapabilities.Builder toBuilder() {
        return new Builder(this);
    }

    static final class Builder extends EnrichedCallCapabilities.Builder {
        private Boolean callComposerCapable;
        private Boolean postCallCapable;
        private Boolean videoShareCapable;
        private Boolean temporarilyUnavailable;

        Builder() {
        }

        private Builder(EnrichedCallCapabilities source) {
            this.callComposerCapable = source.isCallComposerCapable();
            this.postCallCapable = source.isPostCallCapable();
            this.videoShareCapable = source.isVideoShareCapable();
            this.temporarilyUnavailable = source.isTemporarilyUnavailable();
        }

        @Override
        public EnrichedCallCapabilities.Builder setCallComposerCapable(boolean callComposerCapable) {
            this.callComposerCapable = callComposerCapable;
            return this;
        }

        @Override
        public EnrichedCallCapabilities.Builder setPostCallCapable(boolean postCallCapable) {
            this.postCallCapable = postCallCapable;
            return this;
        }

        @Override
        public EnrichedCallCapabilities.Builder setVideoShareCapable(boolean videoShareCapable) {
            this.videoShareCapable = videoShareCapable;
            return this;
        }

        @Override
        public EnrichedCallCapabilities.Builder setTemporarilyUnavailable(boolean temporarilyUnavailable) {
            this.temporarilyUnavailable = temporarilyUnavailable;
            return this;
        }

        @Override
        public EnrichedCallCapabilities build() {
            String missing = "";
            if (this.callComposerCapable == null) {
                missing += " callComposerCapable";
            }
            if (this.postCallCapable == null) {
                missing += " postCallCapable";
            }
            if (this.videoShareCapable == null) {
                missing += " videoShareCapable";
            }
            if (this.temporarilyUnavailable == null) {
                missing += " temporarilyUnavailable";
            }
            if (!missing.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + missing);
            }
            return new AutoValue_EnrichedCallCapabilities(
                    this.callComposerCapable,
                    this.postCallCapable,
                    this.videoShareCapable,
                    this.temporarilyUnavailable);
        }
    }

}
