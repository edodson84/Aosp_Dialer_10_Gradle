package com.fissy.dialer.logging;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_LoggingBindings_ContactsProviderMatchInfo extends LoggingBindings.ContactsProviderMatchInfo {

    private final boolean matchedContact;
    private final boolean inputNumberValid;
    private final int inputNumberLength;
    private final int matchedNumberLength;
    private final boolean inputNumberHasPostdialDigits;
    private final boolean matchedNumberHasPostdialDigits;

    private AutoValue_LoggingBindings_ContactsProviderMatchInfo(
            boolean matchedContact,
            boolean inputNumberValid,
            int inputNumberLength,
            int matchedNumberLength,
            boolean inputNumberHasPostdialDigits,
            boolean matchedNumberHasPostdialDigits) {
        this.matchedContact = matchedContact;
        this.inputNumberValid = inputNumberValid;
        this.inputNumberLength = inputNumberLength;
        this.matchedNumberLength = matchedNumberLength;
        this.inputNumberHasPostdialDigits = inputNumberHasPostdialDigits;
        this.matchedNumberHasPostdialDigits = matchedNumberHasPostdialDigits;
    }

    @Override
    public boolean matchedContact() {
        return matchedContact;
    }

    @Override
    public boolean inputNumberValid() {
        return inputNumberValid;
    }

    @Override
    public int inputNumberLength() {
        return inputNumberLength;
    }

    @Override
    public int matchedNumberLength() {
        return matchedNumberLength;
    }

    @Override
    public boolean inputNumberHasPostdialDigits() {
        return inputNumberHasPostdialDigits;
    }

    @Override
    public boolean matchedNumberHasPostdialDigits() {
        return matchedNumberHasPostdialDigits;
    }

    @Override
    public String toString() {
        return "ContactsProviderMatchInfo{"
                + "matchedContact=" + matchedContact + ", "
                + "inputNumberValid=" + inputNumberValid + ", "
                + "inputNumberLength=" + inputNumberLength + ", "
                + "matchedNumberLength=" + matchedNumberLength + ", "
                + "inputNumberHasPostdialDigits=" + inputNumberHasPostdialDigits + ", "
                + "matchedNumberHasPostdialDigits=" + matchedNumberHasPostdialDigits
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof LoggingBindings.ContactsProviderMatchInfo) {
            LoggingBindings.ContactsProviderMatchInfo that = (LoggingBindings.ContactsProviderMatchInfo) o;
            return (this.matchedContact == that.matchedContact())
                    && (this.inputNumberValid == that.inputNumberValid())
                    && (this.inputNumberLength == that.inputNumberLength())
                    && (this.matchedNumberLength == that.matchedNumberLength())
                    && (this.inputNumberHasPostdialDigits == that.inputNumberHasPostdialDigits())
                    && (this.matchedNumberHasPostdialDigits == that.matchedNumberHasPostdialDigits());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= this.matchedContact ? 1231 : 1237;
        h *= 1000003;
        h ^= this.inputNumberValid ? 1231 : 1237;
        h *= 1000003;
        h ^= this.inputNumberLength;
        h *= 1000003;
        h ^= this.matchedNumberLength;
        h *= 1000003;
        h ^= this.inputNumberHasPostdialDigits ? 1231 : 1237;
        h *= 1000003;
        h ^= this.matchedNumberHasPostdialDigits ? 1231 : 1237;
        return h;
    }

    static final class Builder extends LoggingBindings.ContactsProviderMatchInfo.Builder {
        private Boolean matchedContact;
        private Boolean inputNumberValid;
        private Integer inputNumberLength;
        private Integer matchedNumberLength;
        private Boolean inputNumberHasPostdialDigits;
        private Boolean matchedNumberHasPostdialDigits;

        Builder() {
        }

        @Override
        public LoggingBindings.ContactsProviderMatchInfo.Builder setMatchedContact(boolean matchedContact) {
            this.matchedContact = matchedContact;
            return this;
        }

        @Override
        public LoggingBindings.ContactsProviderMatchInfo.Builder setInputNumberValid(boolean inputNumberValid) {
            this.inputNumberValid = inputNumberValid;
            return this;
        }

        @Override
        public LoggingBindings.ContactsProviderMatchInfo.Builder setInputNumberLength(int inputNumberLength) {
            this.inputNumberLength = inputNumberLength;
            return this;
        }

        @Override
        public LoggingBindings.ContactsProviderMatchInfo.Builder setMatchedNumberLength(int matchedNumberLength) {
            this.matchedNumberLength = matchedNumberLength;
            return this;
        }

        @Override
        public LoggingBindings.ContactsProviderMatchInfo.Builder setInputNumberHasPostdialDigits(boolean inputNumberHasPostdialDigits) {
            this.inputNumberHasPostdialDigits = inputNumberHasPostdialDigits;
            return this;
        }

        @Override
        public LoggingBindings.ContactsProviderMatchInfo.Builder setMatchedNumberHasPostdialDigits(boolean matchedNumberHasPostdialDigits) {
            this.matchedNumberHasPostdialDigits = matchedNumberHasPostdialDigits;
            return this;
        }

        @Override
        public LoggingBindings.ContactsProviderMatchInfo build() {
            String missing = "";
            if (this.matchedContact == null) {
                missing += " matchedContact";
            }
            if (this.inputNumberValid == null) {
                missing += " inputNumberValid";
            }
            if (this.inputNumberLength == null) {
                missing += " inputNumberLength";
            }
            if (this.matchedNumberLength == null) {
                missing += " matchedNumberLength";
            }
            if (this.inputNumberHasPostdialDigits == null) {
                missing += " inputNumberHasPostdialDigits";
            }
            if (this.matchedNumberHasPostdialDigits == null) {
                missing += " matchedNumberHasPostdialDigits";
            }
            if (!missing.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + missing);
            }
            return new AutoValue_LoggingBindings_ContactsProviderMatchInfo(
                    this.matchedContact,
                    this.inputNumberValid,
                    this.inputNumberLength,
                    this.matchedNumberLength,
                    this.inputNumberHasPostdialDigits,
                    this.matchedNumberHasPostdialDigits);
        }
    }

}
