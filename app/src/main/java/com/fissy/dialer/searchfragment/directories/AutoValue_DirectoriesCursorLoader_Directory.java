
package com.fissy.dialer.searchfragment.directories;

import android.support.annotation.Nullable;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_DirectoriesCursorLoader_Directory extends DirectoriesCursorLoader.Directory {

  private final long getId;
  private final String getDisplayName;
  private final boolean supportsPhotos;

  AutoValue_DirectoriesCursorLoader_Directory(
      long getId,
      @Nullable String getDisplayName,
      boolean supportsPhotos) {
    this.getId = getId;
    this.getDisplayName = getDisplayName;
    this.supportsPhotos = supportsPhotos;
  }

  @Override
  public long getId() {
    return getId;
  }

  @Nullable
  @Override
  public String getDisplayName() {
    return getDisplayName;
  }

  @Override
  public boolean supportsPhotos() {
    return supportsPhotos;
  }

  @Override
  public String toString() {
    return "Directory{"
        + "getId=" + getId + ", "
        + "getDisplayName=" + getDisplayName + ", "
        + "supportsPhotos=" + supportsPhotos
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DirectoriesCursorLoader.Directory) {
      DirectoriesCursorLoader.Directory that = (DirectoriesCursorLoader.Directory) o;
      return (this.getId == that.getId())
           && ((this.getDisplayName == null) ? (that.getDisplayName() == null) : this.getDisplayName.equals(that.getDisplayName()))
           && (this.supportsPhotos == that.supportsPhotos());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (int) ((this.getId >>> 32) ^ this.getId);
    h *= 1000003;
    h ^= (getDisplayName == null) ? 0 : this.getDisplayName.hashCode();
    h *= 1000003;
    h ^= this.supportsPhotos ? 1231 : 1237;
    return h;
  }

}
