package com.fissy.dialer.simulator.impl;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_SimulatorPortalEntryGroup extends SimulatorPortalEntryGroup {

    private final ImmutableMap<String, Runnable> methods;
    private final ImmutableMap<String, SimulatorPortalEntryGroup> subPortals;

    private AutoValue_SimulatorPortalEntryGroup(
            ImmutableMap<String, Runnable> methods,
            ImmutableMap<String, SimulatorPortalEntryGroup> subPortals) {
        this.methods = methods;
        this.subPortals = subPortals;
    }

    @Override
    ImmutableMap<String, Runnable> methods() {
        return methods;
    }

    @Override
    ImmutableMap<String, SimulatorPortalEntryGroup> subPortals() {
        return subPortals;
    }

    @Override
    public String toString() {
        return "SimulatorPortalEntryGroup{"
                + "methods=" + methods + ", "
                + "subPortals=" + subPortals
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof SimulatorPortalEntryGroup) {
            SimulatorPortalEntryGroup that = (SimulatorPortalEntryGroup) o;
            return (this.methods.equals(that.methods()))
                    && (this.subPortals.equals(that.subPortals()));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= this.methods.hashCode();
        h *= 1000003;
        h ^= this.subPortals.hashCode();
        return h;
    }

    static final class Builder extends SimulatorPortalEntryGroup.Builder {
        private ImmutableMap<String, Runnable> methods;
        private ImmutableMap<String, SimulatorPortalEntryGroup> subPortals;

        Builder() {
        }

        @Override
        SimulatorPortalEntryGroup.Builder setMethods(Map<String, Runnable> methods) {
            if (methods == null) {
                throw new NullPointerException("Null methods");
            }
            this.methods = ImmutableMap.copyOf(methods);
            return this;
        }

        @Override
        SimulatorPortalEntryGroup.Builder setSubPortals(Map<String, SimulatorPortalEntryGroup> subPortals) {
            if (subPortals == null) {
                throw new NullPointerException("Null subPortals");
            }
            this.subPortals = ImmutableMap.copyOf(subPortals);
            return this;
        }

        @Override
        SimulatorPortalEntryGroup build() {
            String missing = "";
            if (this.methods == null) {
                missing += " methods";
            }
            if (this.subPortals == null) {
                missing += " subPortals";
            }
            if (!missing.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + missing);
            }
            return new AutoValue_SimulatorPortalEntryGroup(
                    this.methods,
                    this.subPortals);
        }
    }

}
