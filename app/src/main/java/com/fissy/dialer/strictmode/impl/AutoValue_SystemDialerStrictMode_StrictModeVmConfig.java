package com.fissy.dialer.strictmode.impl;

import androidx.annotation.Nullable;

import java.util.Map;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_SystemDialerStrictMode_StrictModeVmConfig extends SystemDialerStrictMode.StrictModeVmConfig {

    private final Map<Class<?>, Integer> maxInstanceLimits;

    private AutoValue_SystemDialerStrictMode_StrictModeVmConfig(
            @Nullable Map<Class<?>, Integer> maxInstanceLimits) {
        this.maxInstanceLimits = maxInstanceLimits;
    }

    @Nullable
    @Override
    Map<Class<?>, Integer> maxInstanceLimits() {
        return maxInstanceLimits;
    }

    @Override
    public String toString() {
        return "StrictModeVmConfig{"
                + "maxInstanceLimits=" + maxInstanceLimits
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof SystemDialerStrictMode.StrictModeVmConfig) {
            SystemDialerStrictMode.StrictModeVmConfig that = (SystemDialerStrictMode.StrictModeVmConfig) o;
            return ((this.maxInstanceLimits == null) ? (that.maxInstanceLimits() == null) : this.maxInstanceLimits.equals(that.maxInstanceLimits()));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= (maxInstanceLimits == null) ? 0 : this.maxInstanceLimits.hashCode();
        return h;
    }

    static final class Builder extends SystemDialerStrictMode.StrictModeVmConfig.Builder {
        private Map<Class<?>, Integer> maxInstanceLimits;

        Builder() {
        }

        @Override
        public SystemDialerStrictMode.StrictModeVmConfig.Builder setMaxInstanceLimits(@Nullable Map<Class<?>, Integer> maxInstanceLimits) {
            this.maxInstanceLimits = maxInstanceLimits;
            return this;
        }

        @Override
        public SystemDialerStrictMode.StrictModeVmConfig build() {
            return new AutoValue_SystemDialerStrictMode_StrictModeVmConfig(
                    this.maxInstanceLimits);
        }
    }

}
