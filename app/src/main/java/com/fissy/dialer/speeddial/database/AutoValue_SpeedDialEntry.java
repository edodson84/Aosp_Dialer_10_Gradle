
package com.fissy.dialer.speeddial.database;

import android.support.annotation.Nullable;
import com.google.common.base.Optional;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_SpeedDialEntry extends SpeedDialEntry {

  private final Long id;
  private final Optional<Integer> pinnedPosition;
  private final long contactId;
  private final String lookupKey;
  private final SpeedDialEntry.Channel defaultChannel;

  private AutoValue_SpeedDialEntry(
      @Nullable Long id,
      Optional<Integer> pinnedPosition,
      long contactId,
      String lookupKey,
      @Nullable SpeedDialEntry.Channel defaultChannel) {
    this.id = id;
    this.pinnedPosition = pinnedPosition;
    this.contactId = contactId;
    this.lookupKey = lookupKey;
    this.defaultChannel = defaultChannel;
  }

  @Nullable
  @Override
  public Long id() {
    return id;
  }

  @Override
  public Optional<Integer> pinnedPosition() {
    return pinnedPosition;
  }

  @Override
  public long contactId() {
    return contactId;
  }

  @Override
  public String lookupKey() {
    return lookupKey;
  }

  @Nullable
  @Override
  public SpeedDialEntry.Channel defaultChannel() {
    return defaultChannel;
  }

  @Override
  public String toString() {
    return "SpeedDialEntry{"
        + "id=" + id + ", "
        + "pinnedPosition=" + pinnedPosition + ", "
        + "contactId=" + contactId + ", "
        + "lookupKey=" + lookupKey + ", "
        + "defaultChannel=" + defaultChannel
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SpeedDialEntry) {
      SpeedDialEntry that = (SpeedDialEntry) o;
      return ((this.id == null) ? (that.id() == null) : this.id.equals(that.id()))
           && (this.pinnedPosition.equals(that.pinnedPosition()))
           && (this.contactId == that.contactId())
           && (this.lookupKey.equals(that.lookupKey()))
           && ((this.defaultChannel == null) ? (that.defaultChannel() == null) : this.defaultChannel.equals(that.defaultChannel()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (id == null) ? 0 : this.id.hashCode();
    h *= 1000003;
    h ^= this.pinnedPosition.hashCode();
    h *= 1000003;
    h ^= (int) ((this.contactId >>> 32) ^ this.contactId);
    h *= 1000003;
    h ^= this.lookupKey.hashCode();
    h *= 1000003;
    h ^= (defaultChannel == null) ? 0 : this.defaultChannel.hashCode();
    return h;
  }

  @Override
  public SpeedDialEntry.Builder toBuilder() {
    return new Builder(this);
  }

  static final class Builder extends SpeedDialEntry.Builder {
    private Long id;
    private Optional<Integer> pinnedPosition = Optional.absent();
    private Long contactId;
    private String lookupKey;
    private SpeedDialEntry.Channel defaultChannel;
    Builder() {
    }
    private Builder(SpeedDialEntry source) {
      this.id = source.id();
      this.pinnedPosition = source.pinnedPosition();
      this.contactId = source.contactId();
      this.lookupKey = source.lookupKey();
      this.defaultChannel = source.defaultChannel();
    }
    @Override
    public SpeedDialEntry.Builder setId(@Nullable Long id) {
      this.id = id;
      return this;
    }
    @Override
    public SpeedDialEntry.Builder setPinnedPosition(Optional<Integer> pinnedPosition) {
      if (pinnedPosition == null) {
        throw new NullPointerException("Null pinnedPosition");
      }
      this.pinnedPosition = pinnedPosition;
      return this;
    }
    @Override
    public SpeedDialEntry.Builder setContactId(long contactId) {
      this.contactId = contactId;
      return this;
    }
    @Override
    public SpeedDialEntry.Builder setLookupKey(String lookupKey) {
      if (lookupKey == null) {
        throw new NullPointerException("Null lookupKey");
      }
      this.lookupKey = lookupKey;
      return this;
    }
    @Override
    public SpeedDialEntry.Builder setDefaultChannel(@Nullable SpeedDialEntry.Channel defaultChannel) {
      this.defaultChannel = defaultChannel;
      return this;
    }
    @Override
    public SpeedDialEntry build() {
      String missing = "";
      if (this.contactId == null) {
        missing += " contactId";
      }
      if (this.lookupKey == null) {
        missing += " lookupKey";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_SpeedDialEntry(
          this.id,
          this.pinnedPosition,
          this.contactId,
          this.lookupKey,
          this.defaultChannel);
    }
  }

}
