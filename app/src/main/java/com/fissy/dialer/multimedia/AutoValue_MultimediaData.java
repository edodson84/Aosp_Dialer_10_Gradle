
package com.fissy.dialer.multimedia;

import android.location.Location;
import android.net.Uri;
import android.support.annotation.Nullable;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_MultimediaData extends MultimediaData {

  private final String text;
  private final Location location;
  private final Uri imageUri;
  private final String imageContentType;
  private final boolean important;

  private AutoValue_MultimediaData(
      @Nullable String text,
      @Nullable Location location,
      @Nullable Uri imageUri,
      @Nullable String imageContentType,
      boolean important) {
    this.text = text;
    this.location = location;
    this.imageUri = imageUri;
    this.imageContentType = imageContentType;
    this.important = important;
  }

  @Nullable
  @Override
  public String getText() {
    return text;
  }

  @Nullable
  @Override
  public Location getLocation() {
    return location;
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
  public boolean isImportant() {
    return important;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof MultimediaData) {
      MultimediaData that = (MultimediaData) o;
      return ((this.text == null) ? (that.getText() == null) : this.text.equals(that.getText()))
           && ((this.location == null) ? (that.getLocation() == null) : this.location.equals(that.getLocation()))
           && ((this.imageUri == null) ? (that.getImageUri() == null) : this.imageUri.equals(that.getImageUri()))
           && ((this.imageContentType == null) ? (that.getImageContentType() == null) : this.imageContentType.equals(that.getImageContentType()))
           && (this.important == that.isImportant());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (text == null) ? 0 : this.text.hashCode();
    h *= 1000003;
    h ^= (location == null) ? 0 : this.location.hashCode();
    h *= 1000003;
    h ^= (imageUri == null) ? 0 : this.imageUri.hashCode();
    h *= 1000003;
    h ^= (imageContentType == null) ? 0 : this.imageContentType.hashCode();
    h *= 1000003;
    h ^= this.important ? 1231 : 1237;
    return h;
  }

  static final class Builder extends MultimediaData.Builder {
    private String text;
    private Location location;
    private Uri imageUri;
    private String imageContentType;
    private Boolean important;
    Builder() {
    }
    @Override
    public MultimediaData.Builder setText(@Nullable String text) {
      this.text = text;
      return this;
    }
    @Override
    public MultimediaData.Builder setLocation(@Nullable Location location) {
      this.location = location;
      return this;
    }
    @Override
    MultimediaData.Builder setImageUri(@Nullable Uri imageUri) {
      this.imageUri = imageUri;
      return this;
    }
    @Override
    MultimediaData.Builder setImageContentType(@Nullable String imageContentType) {
      this.imageContentType = imageContentType;
      return this;
    }
    @Override
    public MultimediaData.Builder setImportant(boolean important) {
      this.important = important;
      return this;
    }
    @Override
    public MultimediaData build() {
      String missing = "";
      if (this.important == null) {
        missing += " important";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_MultimediaData(
          this.text,
          this.location,
          this.imageUri,
          this.imageContentType,
          this.important);
    }
  }

}
