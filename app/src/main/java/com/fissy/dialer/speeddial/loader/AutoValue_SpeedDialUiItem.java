package com.fissy.dialer.speeddial.loader;

import androidx.annotation.Nullable;

import com.fissy.dialer.speeddial.database.SpeedDialEntry;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_SpeedDialUiItem extends SpeedDialUiItem {

    private final Long speedDialEntryId;
    private final Optional<Integer> pinnedPosition;
    private final String name;
    private final long contactId;
    private final String lookupKey;
    private final boolean isStarred;
    private final long photoId;
    private final String photoUri;
    private final ImmutableList<SpeedDialEntry.Channel> channels;
    private final SpeedDialEntry.Channel defaultChannel;

    private AutoValue_SpeedDialUiItem(
            @Nullable Long speedDialEntryId,
            Optional<Integer> pinnedPosition,
            String name,
            long contactId,
            String lookupKey,
            boolean isStarred,
            long photoId,
            String photoUri,
            ImmutableList<SpeedDialEntry.Channel> channels,
            @Nullable SpeedDialEntry.Channel defaultChannel) {
        this.speedDialEntryId = speedDialEntryId;
        this.pinnedPosition = pinnedPosition;
        this.name = name;
        this.contactId = contactId;
        this.lookupKey = lookupKey;
        this.isStarred = isStarred;
        this.photoId = photoId;
        this.photoUri = photoUri;
        this.channels = channels;
        this.defaultChannel = defaultChannel;
    }

    @Nullable
    @Override
    public Long speedDialEntryId() {
        return speedDialEntryId;
    }

    @Override
    public Optional<Integer> pinnedPosition() {
        return pinnedPosition;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public long contactId() {
        return contactId;
    }

    @Override
    public String lookupKey() {
        return lookupKey;
    }

    @Override
    public boolean isStarred() {
        return isStarred;
    }

    @Override
    public long photoId() {
        return photoId;
    }

    @Override
    public String photoUri() {
        return photoUri;
    }

    @Override
    public ImmutableList<SpeedDialEntry.Channel> channels() {
        return channels;
    }

    @Nullable
    @Override
    public SpeedDialEntry.Channel defaultChannel() {
        return defaultChannel;
    }

    @Override
    public String toString() {
        return "SpeedDialUiItem{"
                + "speedDialEntryId=" + speedDialEntryId + ", "
                + "pinnedPosition=" + pinnedPosition + ", "
                + "name=" + name + ", "
                + "contactId=" + contactId + ", "
                + "lookupKey=" + lookupKey + ", "
                + "isStarred=" + isStarred + ", "
                + "photoId=" + photoId + ", "
                + "photoUri=" + photoUri + ", "
                + "channels=" + channels + ", "
                + "defaultChannel=" + defaultChannel
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof SpeedDialUiItem) {
            SpeedDialUiItem that = (SpeedDialUiItem) o;
            return ((this.speedDialEntryId == null) ? (that.speedDialEntryId() == null) : this.speedDialEntryId.equals(that.speedDialEntryId()))
                    && (this.pinnedPosition.equals(that.pinnedPosition()))
                    && (this.name.equals(that.name()))
                    && (this.contactId == that.contactId())
                    && (this.lookupKey.equals(that.lookupKey()))
                    && (this.isStarred == that.isStarred())
                    && (this.photoId == that.photoId())
                    && (this.photoUri.equals(that.photoUri()))
                    && (this.channels.equals(that.channels()))
                    && ((this.defaultChannel == null) ? (that.defaultChannel() == null) : this.defaultChannel.equals(that.defaultChannel()));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= (speedDialEntryId == null) ? 0 : this.speedDialEntryId.hashCode();
        h *= 1000003;
        h ^= this.pinnedPosition.hashCode();
        h *= 1000003;
        h ^= this.name.hashCode();
        h *= 1000003;
        h ^= (int) ((this.contactId >>> 32) ^ this.contactId);
        h *= 1000003;
        h ^= this.lookupKey.hashCode();
        h *= 1000003;
        h ^= this.isStarred ? 1231 : 1237;
        h *= 1000003;
        h ^= (int) ((this.photoId >>> 32) ^ this.photoId);
        h *= 1000003;
        h ^= this.photoUri.hashCode();
        h *= 1000003;
        h ^= this.channels.hashCode();
        h *= 1000003;
        h ^= (defaultChannel == null) ? 0 : this.defaultChannel.hashCode();
        return h;
    }

    @Override
    public SpeedDialUiItem.Builder toBuilder() {
        return new Builder(this);
    }

    static final class Builder extends SpeedDialUiItem.Builder {
        private Long speedDialEntryId;
        private Optional<Integer> pinnedPosition = Optional.absent();
        private String name;
        private Long contactId;
        private String lookupKey;
        private Boolean isStarred;
        private Long photoId;
        private String photoUri;
        private ImmutableList<SpeedDialEntry.Channel> channels;
        private SpeedDialEntry.Channel defaultChannel;

        Builder() {
        }

        private Builder(SpeedDialUiItem source) {
            this.speedDialEntryId = source.speedDialEntryId();
            this.pinnedPosition = source.pinnedPosition();
            this.name = source.name();
            this.contactId = source.contactId();
            this.lookupKey = source.lookupKey();
            this.isStarred = source.isStarred();
            this.photoId = source.photoId();
            this.photoUri = source.photoUri();
            this.channels = source.channels();
            this.defaultChannel = source.defaultChannel();
        }

        @Override
        public SpeedDialUiItem.Builder setSpeedDialEntryId(@Nullable Long speedDialEntryId) {
            this.speedDialEntryId = speedDialEntryId;
            return this;
        }

        @Override
        public SpeedDialUiItem.Builder setPinnedPosition(Optional<Integer> pinnedPosition) {
            if (pinnedPosition == null) {
                throw new NullPointerException("Null pinnedPosition");
            }
            this.pinnedPosition = pinnedPosition;
            return this;
        }

        @Override
        public SpeedDialUiItem.Builder setName(String name) {
            if (name == null) {
                throw new NullPointerException("Null name");
            }
            this.name = name;
            return this;
        }

        @Override
        public SpeedDialUiItem.Builder setContactId(long contactId) {
            this.contactId = contactId;
            return this;
        }

        @Override
        public SpeedDialUiItem.Builder setLookupKey(String lookupKey) {
            if (lookupKey == null) {
                throw new NullPointerException("Null lookupKey");
            }
            this.lookupKey = lookupKey;
            return this;
        }

        @Override
        public SpeedDialUiItem.Builder setIsStarred(boolean isStarred) {
            this.isStarred = isStarred;
            return this;
        }

        @Override
        public SpeedDialUiItem.Builder setPhotoId(long photoId) {
            this.photoId = photoId;
            return this;
        }

        @Override
        public SpeedDialUiItem.Builder setPhotoUri(String photoUri) {
            if (photoUri == null) {
                throw new NullPointerException("Null photoUri");
            }
            this.photoUri = photoUri;
            return this;
        }

        @Override
        public SpeedDialUiItem.Builder setChannels(ImmutableList<SpeedDialEntry.Channel> channels) {
            if (channels == null) {
                throw new NullPointerException("Null channels");
            }
            this.channels = channels;
            return this;
        }

        @Override
        public SpeedDialUiItem.Builder setDefaultChannel(@Nullable SpeedDialEntry.Channel defaultChannel) {
            this.defaultChannel = defaultChannel;
            return this;
        }

        @Override
        public SpeedDialUiItem build() {
            String missing = "";
            if (this.name == null) {
                missing += " name";
            }
            if (this.contactId == null) {
                missing += " contactId";
            }
            if (this.lookupKey == null) {
                missing += " lookupKey";
            }
            if (this.isStarred == null) {
                missing += " isStarred";
            }
            if (this.photoId == null) {
                missing += " photoId";
            }
            if (this.photoUri == null) {
                missing += " photoUri";
            }
            if (this.channels == null) {
                missing += " channels";
            }
            if (!missing.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + missing);
            }
            return new AutoValue_SpeedDialUiItem(
                    this.speedDialEntryId,
                    this.pinnedPosition,
                    this.name,
                    this.contactId,
                    this.lookupKey,
                    this.isStarred,
                    this.photoId,
                    this.photoUri,
                    this.channels,
                    this.defaultChannel);
        }
    }

}
