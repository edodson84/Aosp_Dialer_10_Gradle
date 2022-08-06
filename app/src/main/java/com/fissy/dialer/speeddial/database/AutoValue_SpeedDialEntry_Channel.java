package com.fissy.dialer.speeddial.database;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_SpeedDialEntry_Channel extends SpeedDialEntry.Channel {

    private final String number;
    private final int phoneType;
    private final String label;
    private final int technology;

    private AutoValue_SpeedDialEntry_Channel(
            String number,
            int phoneType,
            String label,
            int technology) {
        this.number = number;
        this.phoneType = phoneType;
        this.label = label;
        this.technology = technology;
    }

    @Override
    public String number() {
        return number;
    }

    @Override
    public int phoneType() {
        return phoneType;
    }

    @Override
    public String label() {
        return label;
    }

    @SpeedDialEntry.Channel.Technology
    @Override
    public int technology() {
        return technology;
    }

    @Override
    public String toString() {
        return "Channel{"
                + "number=" + number + ", "
                + "phoneType=" + phoneType + ", "
                + "label=" + label + ", "
                + "technology=" + technology
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof SpeedDialEntry.Channel) {
            SpeedDialEntry.Channel that = (SpeedDialEntry.Channel) o;
            return (this.number.equals(that.number()))
                    && (this.phoneType == that.phoneType())
                    && (this.label.equals(that.label()))
                    && (this.technology == that.technology());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= this.number.hashCode();
        h *= 1000003;
        h ^= this.phoneType;
        h *= 1000003;
        h ^= this.label.hashCode();
        h *= 1000003;
        h ^= this.technology;
        return h;
    }

    @Override
    public SpeedDialEntry.Channel.Builder toBuilder() {
        return new Builder(this);
    }

    static final class Builder extends SpeedDialEntry.Channel.Builder {
        private String number;
        private Integer phoneType;
        private String label;
        private Integer technology;

        Builder() {
        }

        private Builder(SpeedDialEntry.Channel source) {
            this.number = source.number();
            this.phoneType = source.phoneType();
            this.label = source.label();
            this.technology = source.technology();
        }

        @Override
        public SpeedDialEntry.Channel.Builder setNumber(String number) {
            if (number == null) {
                throw new NullPointerException("Null number");
            }
            this.number = number;
            return this;
        }

        @Override
        public SpeedDialEntry.Channel.Builder setPhoneType(int phoneType) {
            this.phoneType = phoneType;
            return this;
        }

        @Override
        public SpeedDialEntry.Channel.Builder setLabel(String label) {
            if (label == null) {
                throw new NullPointerException("Null label");
            }
            this.label = label;
            return this;
        }

        @Override
        public SpeedDialEntry.Channel.Builder setTechnology(int technology) {
            this.technology = technology;
            return this;
        }

        @Override
        public SpeedDialEntry.Channel build() {
            String missing = "";
            if (this.number == null) {
                missing += " number";
            }
            if (this.phoneType == null) {
                missing += " phoneType";
            }
            if (this.label == null) {
                missing += " label";
            }
            if (this.technology == null) {
                missing += " technology";
            }
            if (!missing.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + missing);
            }
            return new AutoValue_SpeedDialEntry_Channel(
                    this.number,
                    this.phoneType,
                    this.label,
                    this.technology);
        }
    }

}
