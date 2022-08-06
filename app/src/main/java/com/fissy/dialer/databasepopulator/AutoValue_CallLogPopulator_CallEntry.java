package com.fissy.dialer.databasepopulator;

import androidx.annotation.NonNull;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_CallLogPopulator_CallEntry extends CallLogPopulator.CallEntry {

    private final String number;
    private final int type;
    private final int presentation;
    private final long timeMillis;

    private AutoValue_CallLogPopulator_CallEntry(
            String number,
            int type,
            int presentation,
            long timeMillis) {
        this.number = number;
        this.type = type;
        this.presentation = presentation;
        this.timeMillis = timeMillis;
    }

    @NonNull
    @Override
    String getNumber() {
        return number;
    }

    @Override
    int getType() {
        return type;
    }

    @Override
    int getPresentation() {
        return presentation;
    }

    @Override
    long getTimeMillis() {
        return timeMillis;
    }

    @Override
    public String toString() {
        return "CallEntry{"
                + "number=" + number + ", "
                + "type=" + type + ", "
                + "presentation=" + presentation + ", "
                + "timeMillis=" + timeMillis
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof CallLogPopulator.CallEntry) {
            CallLogPopulator.CallEntry that = (CallLogPopulator.CallEntry) o;
            return (this.number.equals(that.getNumber()))
                    && (this.type == that.getType())
                    && (this.presentation == that.getPresentation())
                    && (this.timeMillis == that.getTimeMillis());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= this.number.hashCode();
        h *= 1000003;
        h ^= this.type;
        h *= 1000003;
        h ^= this.presentation;
        h *= 1000003;
        h ^= (int) ((this.timeMillis >>> 32) ^ this.timeMillis);
        return h;
    }

    static final class Builder extends CallLogPopulator.CallEntry.Builder {
        private String number;
        private Integer type;
        private Integer presentation;
        private Long timeMillis;

        Builder() {
        }

        @Override
        CallLogPopulator.CallEntry.Builder setNumber(String number) {
            if (number == null) {
                throw new NullPointerException("Null number");
            }
            this.number = number;
            return this;
        }

        @Override
        CallLogPopulator.CallEntry.Builder setType(int type) {
            this.type = type;
            return this;
        }

        @Override
        CallLogPopulator.CallEntry.Builder setPresentation(int presentation) {
            this.presentation = presentation;
            return this;
        }

        @Override
        CallLogPopulator.CallEntry.Builder setTimeMillis(long timeMillis) {
            this.timeMillis = timeMillis;
            return this;
        }

        @Override
        CallLogPopulator.CallEntry build() {
            String missing = "";
            if (this.number == null) {
                missing += " number";
            }
            if (this.type == null) {
                missing += " type";
            }
            if (this.presentation == null) {
                missing += " presentation";
            }
            if (this.timeMillis == null) {
                missing += " timeMillis";
            }
            if (!missing.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + missing);
            }
            return new AutoValue_CallLogPopulator_CallEntry(
                    this.number,
                    this.type,
                    this.presentation,
                    this.timeMillis);
        }
    }

}
