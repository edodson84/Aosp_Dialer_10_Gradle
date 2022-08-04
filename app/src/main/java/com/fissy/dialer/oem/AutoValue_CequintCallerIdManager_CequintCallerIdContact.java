
package com.fissy.dialer.oem;

import android.support.annotation.Nullable;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_CequintCallerIdManager_CequintCallerIdContact extends CequintCallerIdManager.CequintCallerIdContact {

  private final String name;
  private final String geolocation;
  private final String photoUri;

  private AutoValue_CequintCallerIdManager_CequintCallerIdContact(
      @Nullable String name,
      @Nullable String geolocation,
      @Nullable String photoUri) {
    this.name = name;
    this.geolocation = geolocation;
    this.photoUri = photoUri;
  }

  @Nullable
  @Override
  public String name() {
    return name;
  }

  @Nullable
  @Override
  public String geolocation() {
    return geolocation;
  }

  @Nullable
  @Override
  public String photoUri() {
    return photoUri;
  }

  @Override
  public String toString() {
    return "CequintCallerIdContact{"
        + "name=" + name + ", "
        + "geolocation=" + geolocation + ", "
        + "photoUri=" + photoUri
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CequintCallerIdManager.CequintCallerIdContact) {
      CequintCallerIdManager.CequintCallerIdContact that = (CequintCallerIdManager.CequintCallerIdContact) o;
      return ((this.name == null) ? (that.name() == null) : this.name.equals(that.name()))
           && ((this.geolocation == null) ? (that.geolocation() == null) : this.geolocation.equals(that.geolocation()))
           && ((this.photoUri == null) ? (that.photoUri() == null) : this.photoUri.equals(that.photoUri()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (name == null) ? 0 : this.name.hashCode();
    h *= 1000003;
    h ^= (geolocation == null) ? 0 : this.geolocation.hashCode();
    h *= 1000003;
    h ^= (photoUri == null) ? 0 : this.photoUri.hashCode();
    return h;
  }

  static final class Builder extends CequintCallerIdManager.CequintCallerIdContact.Builder {
    private String name;
    private String geolocation;
    private String photoUri;
    Builder() {
    }
    @Override
    CequintCallerIdManager.CequintCallerIdContact.Builder setName(@Nullable String name) {
      this.name = name;
      return this;
    }
    @Override
    CequintCallerIdManager.CequintCallerIdContact.Builder setGeolocation(@Nullable String geolocation) {
      this.geolocation = geolocation;
      return this;
    }
    @Override
    CequintCallerIdManager.CequintCallerIdContact.Builder setPhotoUri(@Nullable String photoUri) {
      this.photoUri = photoUri;
      return this;
    }
    @Override
    CequintCallerIdManager.CequintCallerIdContact build() {
      return new AutoValue_CequintCallerIdManager_CequintCallerIdContact(
          this.name,
          this.geolocation,
          this.photoUri);
    }
  }

}
