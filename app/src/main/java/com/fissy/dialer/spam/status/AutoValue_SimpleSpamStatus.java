package com.fissy.dialer.spam.status;

import com.google.common.base.Optional;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_SimpleSpamStatus extends SimpleSpamStatus {

    private final boolean spam;
    private final Optional<Long> timestampMillis;
    private final SpamMetadata spamMetadata;

    private AutoValue_SimpleSpamStatus(
            boolean spam,
            Optional<Long> timestampMillis,
            SpamMetadata spamMetadata) {
        this.spam = spam;
        this.timestampMillis = timestampMillis;
        this.spamMetadata = spamMetadata;
    }

    @Override
    public boolean isSpam() {
        return spam;
    }

    @Override
    public Optional<Long> getTimestampMillis() {
        return timestampMillis;
    }

    @Override
    public SpamMetadata getSpamMetadata() {
        return spamMetadata;
    }

    @Override
    public String toString() {
        return "SimpleSpamStatus{"
                + "spam=" + spam + ", "
                + "timestampMillis=" + timestampMillis + ", "
                + "spamMetadata=" + spamMetadata
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof SimpleSpamStatus) {
            SimpleSpamStatus that = (SimpleSpamStatus) o;
            return (this.spam == that.isSpam())
                    && (this.timestampMillis.equals(that.getTimestampMillis()))
                    && (this.spamMetadata.equals(that.getSpamMetadata()));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= this.spam ? 1231 : 1237;
        h *= 1000003;
        h ^= this.timestampMillis.hashCode();
        h *= 1000003;
        h ^= this.spamMetadata.hashCode();
        return h;
    }

    static final class Builder extends SimpleSpamStatus.Builder {
        private Boolean spam;
        private Optional<Long> timestampMillis = Optional.absent();
        private SpamMetadata spamMetadata;

        Builder() {
        }

        @Override
        public SimpleSpamStatus.Builder setSpam(boolean spam) {
            this.spam = spam;
            return this;
        }

        @Override
        SimpleSpamStatus.Builder setTimestampMillis(Optional<Long> timestampMillis) {
            if (timestampMillis == null) {
                throw new NullPointerException("Null timestampMillis");
            }
            this.timestampMillis = timestampMillis;
            return this;
        }

        @Override
        public SimpleSpamStatus.Builder setSpamMetadata(SpamMetadata spamMetadata) {
            if (spamMetadata == null) {
                throw new NullPointerException("Null spamMetadata");
            }
            this.spamMetadata = spamMetadata;
            return this;
        }

        @Override
        public SimpleSpamStatus build() {
            String missing = "";
            if (this.spam == null) {
                missing += " spam";
            }
            if (this.spamMetadata == null) {
                missing += " spamMetadata";
            }
            if (!missing.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + missing);
            }
            return new AutoValue_SimpleSpamStatus(
                    this.spam,
                    this.timestampMillis,
                    this.spamMetadata);
        }
    }

}
