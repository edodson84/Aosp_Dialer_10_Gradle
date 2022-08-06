package com.fissy.dialer.searchfragment.cp2;

import androidx.annotation.Nullable;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_Cp2Contact extends Cp2Contact {

    private final long phoneId;
    private final int phoneType;
    private final String phoneLabel;
    private final String phoneNumber;
    private final String displayName;
    private final int photoId;
    private final String photoUri;
    private final String lookupKey;
    private final int carrierPresence;
    private final int contactId;
    private final String companyName;
    private final String nickName;
    private final String mimeType;

    private AutoValue_Cp2Contact(
            long phoneId,
            int phoneType,
            @Nullable String phoneLabel,
            String phoneNumber,
            @Nullable String displayName,
            int photoId,
            @Nullable String photoUri,
            String lookupKey,
            int carrierPresence,
            int contactId,
            @Nullable String companyName,
            @Nullable String nickName,
            String mimeType) {
        this.phoneId = phoneId;
        this.phoneType = phoneType;
        this.phoneLabel = phoneLabel;
        this.phoneNumber = phoneNumber;
        this.displayName = displayName;
        this.photoId = photoId;
        this.photoUri = photoUri;
        this.lookupKey = lookupKey;
        this.carrierPresence = carrierPresence;
        this.contactId = contactId;
        this.companyName = companyName;
        this.nickName = nickName;
        this.mimeType = mimeType;
    }

    @Override
    public long phoneId() {
        return phoneId;
    }

    @Override
    public int phoneType() {
        return phoneType;
    }

    @Nullable
    @Override
    public String phoneLabel() {
        return phoneLabel;
    }

    @Override
    public String phoneNumber() {
        return phoneNumber;
    }

    @Nullable
    @Override
    public String displayName() {
        return displayName;
    }

    @Override
    public int photoId() {
        return photoId;
    }

    @Nullable
    @Override
    public String photoUri() {
        return photoUri;
    }

    @Override
    public String lookupKey() {
        return lookupKey;
    }

    @Override
    public int carrierPresence() {
        return carrierPresence;
    }

    @Override
    public int contactId() {
        return contactId;
    }

    @Nullable
    @Override
    public String companyName() {
        return companyName;
    }

    @Nullable
    @Override
    public String nickName() {
        return nickName;
    }

    @Override
    public String mimeType() {
        return mimeType;
    }

    @Override
    public String toString() {
        return "Cp2Contact{"
                + "phoneId=" + phoneId + ", "
                + "phoneType=" + phoneType + ", "
                + "phoneLabel=" + phoneLabel + ", "
                + "phoneNumber=" + phoneNumber + ", "
                + "displayName=" + displayName + ", "
                + "photoId=" + photoId + ", "
                + "photoUri=" + photoUri + ", "
                + "lookupKey=" + lookupKey + ", "
                + "carrierPresence=" + carrierPresence + ", "
                + "contactId=" + contactId + ", "
                + "companyName=" + companyName + ", "
                + "nickName=" + nickName + ", "
                + "mimeType=" + mimeType
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Cp2Contact) {
            Cp2Contact that = (Cp2Contact) o;
            return (this.phoneId == that.phoneId())
                    && (this.phoneType == that.phoneType())
                    && ((this.phoneLabel == null) ? (that.phoneLabel() == null) : this.phoneLabel.equals(that.phoneLabel()))
                    && (this.phoneNumber.equals(that.phoneNumber()))
                    && ((this.displayName == null) ? (that.displayName() == null) : this.displayName.equals(that.displayName()))
                    && (this.photoId == that.photoId())
                    && ((this.photoUri == null) ? (that.photoUri() == null) : this.photoUri.equals(that.photoUri()))
                    && (this.lookupKey.equals(that.lookupKey()))
                    && (this.carrierPresence == that.carrierPresence())
                    && (this.contactId == that.contactId())
                    && ((this.companyName == null) ? (that.companyName() == null) : this.companyName.equals(that.companyName()))
                    && ((this.nickName == null) ? (that.nickName() == null) : this.nickName.equals(that.nickName()))
                    && (this.mimeType.equals(that.mimeType()));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= (int) ((this.phoneId >>> 32) ^ this.phoneId);
        h *= 1000003;
        h ^= this.phoneType;
        h *= 1000003;
        h ^= (phoneLabel == null) ? 0 : this.phoneLabel.hashCode();
        h *= 1000003;
        h ^= this.phoneNumber.hashCode();
        h *= 1000003;
        h ^= (displayName == null) ? 0 : this.displayName.hashCode();
        h *= 1000003;
        h ^= this.photoId;
        h *= 1000003;
        h ^= (photoUri == null) ? 0 : this.photoUri.hashCode();
        h *= 1000003;
        h ^= this.lookupKey.hashCode();
        h *= 1000003;
        h ^= this.carrierPresence;
        h *= 1000003;
        h ^= this.contactId;
        h *= 1000003;
        h ^= (companyName == null) ? 0 : this.companyName.hashCode();
        h *= 1000003;
        h ^= (nickName == null) ? 0 : this.nickName.hashCode();
        h *= 1000003;
        h ^= this.mimeType.hashCode();
        return h;
    }

    @Override
    public Cp2Contact.Builder toBuilder() {
        return new Builder(this);
    }

    static final class Builder extends Cp2Contact.Builder {
        private Long phoneId;
        private Integer phoneType;
        private String phoneLabel;
        private String phoneNumber;
        private String displayName;
        private Integer photoId;
        private String photoUri;
        private String lookupKey;
        private Integer carrierPresence;
        private Integer contactId;
        private String companyName;
        private String nickName;
        private String mimeType;

        Builder() {
        }

        private Builder(Cp2Contact source) {
            this.phoneId = source.phoneId();
            this.phoneType = source.phoneType();
            this.phoneLabel = source.phoneLabel();
            this.phoneNumber = source.phoneNumber();
            this.displayName = source.displayName();
            this.photoId = source.photoId();
            this.photoUri = source.photoUri();
            this.lookupKey = source.lookupKey();
            this.carrierPresence = source.carrierPresence();
            this.contactId = source.contactId();
            this.companyName = source.companyName();
            this.nickName = source.nickName();
            this.mimeType = source.mimeType();
        }

        @Override
        public Cp2Contact.Builder setPhoneId(long phoneId) {
            this.phoneId = phoneId;
            return this;
        }

        @Override
        public Cp2Contact.Builder setPhoneType(int phoneType) {
            this.phoneType = phoneType;
            return this;
        }

        @Override
        public Cp2Contact.Builder setPhoneLabel(@Nullable String phoneLabel) {
            this.phoneLabel = phoneLabel;
            return this;
        }

        @Override
        public Cp2Contact.Builder setPhoneNumber(String phoneNumber) {
            if (phoneNumber == null) {
                throw new NullPointerException("Null phoneNumber");
            }
            this.phoneNumber = phoneNumber;
            return this;
        }

        @Override
        public Cp2Contact.Builder setDisplayName(@Nullable String displayName) {
            this.displayName = displayName;
            return this;
        }

        @Override
        public Cp2Contact.Builder setPhotoId(int photoId) {
            this.photoId = photoId;
            return this;
        }

        @Override
        public Cp2Contact.Builder setPhotoUri(@Nullable String photoUri) {
            this.photoUri = photoUri;
            return this;
        }

        @Override
        public Cp2Contact.Builder setLookupKey(String lookupKey) {
            if (lookupKey == null) {
                throw new NullPointerException("Null lookupKey");
            }
            this.lookupKey = lookupKey;
            return this;
        }

        @Override
        public Cp2Contact.Builder setCarrierPresence(int carrierPresence) {
            this.carrierPresence = carrierPresence;
            return this;
        }

        @Override
        public Cp2Contact.Builder setContactId(int contactId) {
            this.contactId = contactId;
            return this;
        }

        @Override
        public Cp2Contact.Builder setCompanyName(@Nullable String companyName) {
            this.companyName = companyName;
            return this;
        }

        @Override
        public Cp2Contact.Builder setNickName(@Nullable String nickName) {
            this.nickName = nickName;
            return this;
        }

        @Override
        public Cp2Contact.Builder setMimeType(String mimeType) {
            if (mimeType == null) {
                throw new NullPointerException("Null mimeType");
            }
            this.mimeType = mimeType;
            return this;
        }

        @Override
        public Cp2Contact build() {
            String missing = "";
            if (this.phoneId == null) {
                missing += " phoneId";
            }
            if (this.phoneType == null) {
                missing += " phoneType";
            }
            if (this.phoneNumber == null) {
                missing += " phoneNumber";
            }
            if (this.photoId == null) {
                missing += " photoId";
            }
            if (this.lookupKey == null) {
                missing += " lookupKey";
            }
            if (this.carrierPresence == null) {
                missing += " carrierPresence";
            }
            if (this.contactId == null) {
                missing += " contactId";
            }
            if (this.mimeType == null) {
                missing += " mimeType";
            }
            if (!missing.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + missing);
            }
            return new AutoValue_Cp2Contact(
                    this.phoneId,
                    this.phoneType,
                    this.phoneLabel,
                    this.phoneNumber,
                    this.displayName,
                    this.photoId,
                    this.photoUri,
                    this.lookupKey,
                    this.carrierPresence,
                    this.contactId,
                    this.companyName,
                    this.nickName,
                    this.mimeType);
        }
    }

}
