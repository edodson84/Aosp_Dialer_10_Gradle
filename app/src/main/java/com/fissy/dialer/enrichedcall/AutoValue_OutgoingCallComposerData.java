package com.fissy.dialer.enrichedcall;

import android.net.Uri;

import androidx.annotation.Nullable;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_OutgoingCallComposerData extends OutgoingCallComposerData {

    private final String subject;
    private final Uri imageUri;
    private final String imageContentType;

    private AutoValue_OutgoingCallComposerData(
            @Nullable String subject,
            @Nullable Uri imageUri,
            @Nullable String imageContentType) {
        this.subject = subject;
        this.imageUri = imageUri;
        this.imageContentType = imageContentType;
    }

    @Nullable
    @Override
    public String getSubject() {
        return subject;
    }

    @Nullable
    @Override
    public Uri getImageUri() {
        return imageUri;
    }

    @Nullable
    @Override
    public String getImageContentType() {
        return imageContentType;
    }

    @Override
    public String toString() {
        return "OutgoingCallComposerData{"
                + "subject=" + subject + ", "
                + "imageUri=" + imageUri + ", "
                + "imageContentType=" + imageContentType
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof OutgoingCallComposerData) {
            OutgoingCallComposerData that = (OutgoingCallComposerData) o;
            return ((this.subject == null) ? (that.getSubject() == null) : this.subject.equals(that.getSubject()))
                    && ((this.imageUri == null) ? (that.getImageUri() == null) : this.imageUri.equals(that.getImageUri()))
                    && ((this.imageContentType == null) ? (that.getImageContentType() == null) : this.imageContentType.equals(that.getImageContentType()));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= (subject == null) ? 0 : this.subject.hashCode();
        h *= 1000003;
        h ^= (imageUri == null) ? 0 : this.imageUri.hashCode();
        h *= 1000003;
        h ^= (imageContentType == null) ? 0 : this.imageContentType.hashCode();
        return h;
    }

    static final class Builder extends OutgoingCallComposerData.Builder {
        private String subject;
        private Uri imageUri;
        private String imageContentType;

        Builder() {
        }

        @Override
        public OutgoingCallComposerData.Builder setSubject(@Nullable String subject) {
            this.subject = subject;
            return this;
        }

        @Override
        OutgoingCallComposerData.Builder setImageUri(@Nullable Uri imageUri) {
            this.imageUri = imageUri;
            return this;
        }

        @Override
        OutgoingCallComposerData.Builder setImageContentType(@Nullable String imageContentType) {
            this.imageContentType = imageContentType;
            return this;
        }

        @Override
        OutgoingCallComposerData autoBuild() {
            return new AutoValue_OutgoingCallComposerData(
                    this.subject,
                    this.imageUri,
                    this.imageContentType);
        }
    }

}
