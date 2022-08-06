package com.fissy.dialer.assisteddialing.ui;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_AssistedDialingSettingFragment_DisplayNameAndCountryCodeTuple extends AssistedDialingSettingFragment.DisplayNameAndCountryCodeTuple {

    private final CharSequence countryDisplayname;
    private final CharSequence countryCode;

    AutoValue_AssistedDialingSettingFragment_DisplayNameAndCountryCodeTuple(
            CharSequence countryDisplayname,
            CharSequence countryCode) {
        if (countryDisplayname == null) {
            throw new NullPointerException("Null countryDisplayname");
        }
        this.countryDisplayname = countryDisplayname;
        if (countryCode == null) {
            throw new NullPointerException("Null countryCode");
        }
        this.countryCode = countryCode;
    }

    @Override
    CharSequence countryDisplayname() {
        return countryDisplayname;
    }

    @Override
    CharSequence countryCode() {
        return countryCode;
    }

    @Override
    public String toString() {
        return "DisplayNameAndCountryCodeTuple{"
                + "countryDisplayname=" + countryDisplayname + ", "
                + "countryCode=" + countryCode
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof AssistedDialingSettingFragment.DisplayNameAndCountryCodeTuple) {
            AssistedDialingSettingFragment.DisplayNameAndCountryCodeTuple that = (AssistedDialingSettingFragment.DisplayNameAndCountryCodeTuple) o;
            return (this.countryDisplayname.equals(that.countryDisplayname()))
                    && (this.countryCode.equals(that.countryCode()));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= this.countryDisplayname.hashCode();
        h *= 1000003;
        h ^= this.countryCode.hashCode();
        return h;
    }

}
