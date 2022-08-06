package com.android.incallui.incall.protocol;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.Nullable;

import com.fissy.dialer.multimedia.MultimediaData;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_PrimaryInfo extends PrimaryInfo {

    private final String number;
    private final String name;
    private final boolean nameIsNumber;
    private final String label;
    private final String location;
    private final Drawable photo;
    private final Uri photoUri;
    private final int photoType;
    private final boolean isSipCall;
    private final boolean isContactPhotoShown;
    private final boolean isWorkCall;
    private final boolean isSpam;
    private final boolean isLocalContact;
    private final boolean answeringDisconnectsOngoingCall;
    private final boolean shouldShowLocation;
    private final String contactInfoLookupKey;
    private final MultimediaData multimediaData;
    private final boolean showInCallButtonGrid;
    private final int numberPresentation;

    private AutoValue_PrimaryInfo(
            @Nullable String number,
            @Nullable String name,
            boolean nameIsNumber,
            @Nullable String label,
            @Nullable String location,
            @Nullable Drawable photo,
            @Nullable Uri photoUri,
            int photoType,
            boolean isSipCall,
            boolean isContactPhotoShown,
            boolean isWorkCall,
            boolean isSpam,
            boolean isLocalContact,
            boolean answeringDisconnectsOngoingCall,
            boolean shouldShowLocation,
            @Nullable String contactInfoLookupKey,
            @Nullable MultimediaData multimediaData,
            boolean showInCallButtonGrid,
            int numberPresentation) {
        this.number = number;
        this.name = name;
        this.nameIsNumber = nameIsNumber;
        this.label = label;
        this.location = location;
        this.photo = photo;
        this.photoUri = photoUri;
        this.photoType = photoType;
        this.isSipCall = isSipCall;
        this.isContactPhotoShown = isContactPhotoShown;
        this.isWorkCall = isWorkCall;
        this.isSpam = isSpam;
        this.isLocalContact = isLocalContact;
        this.answeringDisconnectsOngoingCall = answeringDisconnectsOngoingCall;
        this.shouldShowLocation = shouldShowLocation;
        this.contactInfoLookupKey = contactInfoLookupKey;
        this.multimediaData = multimediaData;
        this.showInCallButtonGrid = showInCallButtonGrid;
        this.numberPresentation = numberPresentation;
    }

    @Nullable
    @Override
    public String number() {
        return number;
    }

    @Nullable
    @Override
    public String name() {
        return name;
    }

    @Override
    public boolean nameIsNumber() {
        return nameIsNumber;
    }

    @Nullable
    @Override
    public String label() {
        return label;
    }

    @Nullable
    @Override
    public String location() {
        return location;
    }

    @Nullable
    @Override
    public Drawable photo() {
        return photo;
    }

    @Nullable
    @Override
    public Uri photoUri() {
        return photoUri;
    }

    @ContactPhotoType
    @Override
    public int photoType() {
        return photoType;
    }

    @Override
    public boolean isSipCall() {
        return isSipCall;
    }

    @Override
    public boolean isContactPhotoShown() {
        return isContactPhotoShown;
    }

    @Override
    public boolean isWorkCall() {
        return isWorkCall;
    }

    @Override
    public boolean isSpam() {
        return isSpam;
    }

    @Override
    public boolean isLocalContact() {
        return isLocalContact;
    }

    @Override
    public boolean answeringDisconnectsOngoingCall() {
        return answeringDisconnectsOngoingCall;
    }

    @Override
    public boolean shouldShowLocation() {
        return shouldShowLocation;
    }

    @Nullable
    @Override
    public String contactInfoLookupKey() {
        return contactInfoLookupKey;
    }

    @Nullable
    @Override
    public MultimediaData multimediaData() {
        return multimediaData;
    }

    @Override
    public boolean showInCallButtonGrid() {
        return showInCallButtonGrid;
    }

    @Override
    public int numberPresentation() {
        return numberPresentation;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof PrimaryInfo) {
            PrimaryInfo that = (PrimaryInfo) o;
            return ((this.number == null) ? (that.number() == null) : this.number.equals(that.number()))
                    && ((this.name == null) ? (that.name() == null) : this.name.equals(that.name()))
                    && (this.nameIsNumber == that.nameIsNumber())
                    && ((this.label == null) ? (that.label() == null) : this.label.equals(that.label()))
                    && ((this.location == null) ? (that.location() == null) : this.location.equals(that.location()))
                    && ((this.photo == null) ? (that.photo() == null) : this.photo.equals(that.photo()))
                    && ((this.photoUri == null) ? (that.photoUri() == null) : this.photoUri.equals(that.photoUri()))
                    && (this.photoType == that.photoType())
                    && (this.isSipCall == that.isSipCall())
                    && (this.isContactPhotoShown == that.isContactPhotoShown())
                    && (this.isWorkCall == that.isWorkCall())
                    && (this.isSpam == that.isSpam())
                    && (this.isLocalContact == that.isLocalContact())
                    && (this.answeringDisconnectsOngoingCall == that.answeringDisconnectsOngoingCall())
                    && (this.shouldShowLocation == that.shouldShowLocation())
                    && ((this.contactInfoLookupKey == null) ? (that.contactInfoLookupKey() == null) : this.contactInfoLookupKey.equals(that.contactInfoLookupKey()))
                    && ((this.multimediaData == null) ? (that.multimediaData() == null) : this.multimediaData.equals(that.multimediaData()))
                    && (this.showInCallButtonGrid == that.showInCallButtonGrid())
                    && (this.numberPresentation == that.numberPresentation());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= (number == null) ? 0 : this.number.hashCode();
        h *= 1000003;
        h ^= (name == null) ? 0 : this.name.hashCode();
        h *= 1000003;
        h ^= this.nameIsNumber ? 1231 : 1237;
        h *= 1000003;
        h ^= (label == null) ? 0 : this.label.hashCode();
        h *= 1000003;
        h ^= (location == null) ? 0 : this.location.hashCode();
        h *= 1000003;
        h ^= (photo == null) ? 0 : this.photo.hashCode();
        h *= 1000003;
        h ^= (photoUri == null) ? 0 : this.photoUri.hashCode();
        h *= 1000003;
        h ^= this.photoType;
        h *= 1000003;
        h ^= this.isSipCall ? 1231 : 1237;
        h *= 1000003;
        h ^= this.isContactPhotoShown ? 1231 : 1237;
        h *= 1000003;
        h ^= this.isWorkCall ? 1231 : 1237;
        h *= 1000003;
        h ^= this.isSpam ? 1231 : 1237;
        h *= 1000003;
        h ^= this.isLocalContact ? 1231 : 1237;
        h *= 1000003;
        h ^= this.answeringDisconnectsOngoingCall ? 1231 : 1237;
        h *= 1000003;
        h ^= this.shouldShowLocation ? 1231 : 1237;
        h *= 1000003;
        h ^= (contactInfoLookupKey == null) ? 0 : this.contactInfoLookupKey.hashCode();
        h *= 1000003;
        h ^= (multimediaData == null) ? 0 : this.multimediaData.hashCode();
        h *= 1000003;
        h ^= this.showInCallButtonGrid ? 1231 : 1237;
        h *= 1000003;
        h ^= this.numberPresentation;
        return h;
    }

    static final class Builder extends PrimaryInfo.Builder {
        private String number;
        private String name;
        private Boolean nameIsNumber;
        private String label;
        private String location;
        private Drawable photo;
        private Uri photoUri;
        private Integer photoType;
        private Boolean isSipCall;
        private Boolean isContactPhotoShown;
        private Boolean isWorkCall;
        private Boolean isSpam;
        private Boolean isLocalContact;
        private Boolean answeringDisconnectsOngoingCall;
        private Boolean shouldShowLocation;
        private String contactInfoLookupKey;
        private MultimediaData multimediaData;
        private Boolean showInCallButtonGrid;
        private Integer numberPresentation;

        Builder() {
        }

        @Override
        public PrimaryInfo.Builder setNumber(@Nullable String number) {
            this.number = number;
            return this;
        }

        @Override
        public PrimaryInfo.Builder setName(@Nullable String name) {
            this.name = name;
            return this;
        }

        @Override
        public PrimaryInfo.Builder setNameIsNumber(boolean nameIsNumber) {
            this.nameIsNumber = nameIsNumber;
            return this;
        }

        @Override
        public PrimaryInfo.Builder setLabel(@Nullable String label) {
            this.label = label;
            return this;
        }

        @Override
        public PrimaryInfo.Builder setLocation(@Nullable String location) {
            this.location = location;
            return this;
        }

        @Override
        public PrimaryInfo.Builder setPhoto(@Nullable Drawable photo) {
            this.photo = photo;
            return this;
        }

        @Override
        public PrimaryInfo.Builder setPhotoUri(@Nullable Uri photoUri) {
            this.photoUri = photoUri;
            return this;
        }

        @Override
        public PrimaryInfo.Builder setPhotoType(int photoType) {
            this.photoType = photoType;
            return this;
        }

        @Override
        public PrimaryInfo.Builder setIsSipCall(boolean isSipCall) {
            this.isSipCall = isSipCall;
            return this;
        }

        @Override
        public PrimaryInfo.Builder setIsContactPhotoShown(boolean isContactPhotoShown) {
            this.isContactPhotoShown = isContactPhotoShown;
            return this;
        }

        @Override
        public PrimaryInfo.Builder setIsWorkCall(boolean isWorkCall) {
            this.isWorkCall = isWorkCall;
            return this;
        }

        @Override
        public PrimaryInfo.Builder setIsSpam(boolean isSpam) {
            this.isSpam = isSpam;
            return this;
        }

        @Override
        public PrimaryInfo.Builder setIsLocalContact(boolean isLocalContact) {
            this.isLocalContact = isLocalContact;
            return this;
        }

        @Override
        public PrimaryInfo.Builder setAnsweringDisconnectsOngoingCall(boolean answeringDisconnectsOngoingCall) {
            this.answeringDisconnectsOngoingCall = answeringDisconnectsOngoingCall;
            return this;
        }

        @Override
        public PrimaryInfo.Builder setShouldShowLocation(boolean shouldShowLocation) {
            this.shouldShowLocation = shouldShowLocation;
            return this;
        }

        @Override
        public PrimaryInfo.Builder setContactInfoLookupKey(@Nullable String contactInfoLookupKey) {
            this.contactInfoLookupKey = contactInfoLookupKey;
            return this;
        }

        @Override
        public PrimaryInfo.Builder setMultimediaData(@Nullable MultimediaData multimediaData) {
            this.multimediaData = multimediaData;
            return this;
        }

        @Override
        public PrimaryInfo.Builder setShowInCallButtonGrid(boolean showInCallButtonGrid) {
            this.showInCallButtonGrid = showInCallButtonGrid;
            return this;
        }

        @Override
        public PrimaryInfo.Builder setNumberPresentation(int numberPresentation) {
            this.numberPresentation = numberPresentation;
            return this;
        }

        @Override
        public PrimaryInfo build() {
            String missing = "";
            if (this.nameIsNumber == null) {
                missing += " nameIsNumber";
            }
            if (this.photoType == null) {
                missing += " photoType";
            }
            if (this.isSipCall == null) {
                missing += " isSipCall";
            }
            if (this.isContactPhotoShown == null) {
                missing += " isContactPhotoShown";
            }
            if (this.isWorkCall == null) {
                missing += " isWorkCall";
            }
            if (this.isSpam == null) {
                missing += " isSpam";
            }
            if (this.isLocalContact == null) {
                missing += " isLocalContact";
            }
            if (this.answeringDisconnectsOngoingCall == null) {
                missing += " answeringDisconnectsOngoingCall";
            }
            if (this.shouldShowLocation == null) {
                missing += " shouldShowLocation";
            }
            if (this.showInCallButtonGrid == null) {
                missing += " showInCallButtonGrid";
            }
            if (this.numberPresentation == null) {
                missing += " numberPresentation";
            }
            if (!missing.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + missing);
            }
            return new AutoValue_PrimaryInfo(
                    this.number,
                    this.name,
                    this.nameIsNumber,
                    this.label,
                    this.location,
                    this.photo,
                    this.photoUri,
                    this.photoType,
                    this.isSipCall,
                    this.isContactPhotoShown,
                    this.isWorkCall,
                    this.isSpam,
                    this.isLocalContact,
                    this.answeringDisconnectsOngoingCall,
                    this.shouldShowLocation,
                    this.contactInfoLookupKey,
                    this.multimediaData,
                    this.showInCallButtonGrid,
                    this.numberPresentation);
        }
    }

}
