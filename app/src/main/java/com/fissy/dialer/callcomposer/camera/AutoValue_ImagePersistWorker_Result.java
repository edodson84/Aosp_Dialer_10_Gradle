package com.fissy.dialer.callcomposer.camera;

import android.net.Uri;

import androidx.annotation.NonNull;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_ImagePersistWorker_Result extends ImagePersistWorker.Result {

    private final Uri uri;
    private final int width;
    private final int height;

    private AutoValue_ImagePersistWorker_Result(
            Uri uri,
            int width,
            int height) {
        this.uri = uri;
        this.width = width;
        this.height = height;
    }

    @NonNull
    @Override
    Uri getUri() {
        return uri;
    }

    @Override
    int getWidth() {
        return width;
    }

    @Override
    int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Result{"
                + "uri=" + uri + ", "
                + "width=" + width + ", "
                + "height=" + height
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof ImagePersistWorker.Result) {
            ImagePersistWorker.Result that = (ImagePersistWorker.Result) o;
            return (this.uri.equals(that.getUri()))
                    && (this.width == that.getWidth())
                    && (this.height == that.getHeight());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= this.uri.hashCode();
        h *= 1000003;
        h ^= this.width;
        h *= 1000003;
        h ^= this.height;
        return h;
    }

    static final class Builder extends ImagePersistWorker.Result.Builder {
        private Uri uri;
        private Integer width;
        private Integer height;

        Builder() {
        }

        @Override
        ImagePersistWorker.Result.Builder setUri(@NonNull Uri uri) {
            if (uri == null) {
                throw new NullPointerException("Null uri");
            }
            this.uri = uri;
            return this;
        }

        @Override
        ImagePersistWorker.Result.Builder setWidth(int width) {
            this.width = width;
            return this;
        }

        @Override
        ImagePersistWorker.Result.Builder setHeight(int height) {
            this.height = height;
            return this;
        }

        @Override
        ImagePersistWorker.Result build() {
            String missing = "";
            if (this.uri == null) {
                missing += " uri";
            }
            if (this.width == null) {
                missing += " width";
            }
            if (this.height == null) {
                missing += " height";
            }
            if (!missing.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + missing);
            }
            return new AutoValue_ImagePersistWorker_Result(
                    this.uri,
                    this.width,
                    this.height);
        }
    }

}
