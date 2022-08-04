
package com.fissy.dialer.databasepopulator;

import android.support.annotation.NonNull;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_VoicemailPopulator_Voicemail extends VoicemailPopulator.Voicemail {

  private final String phoneNumber;
  private final String transcription;
  private final long durationSeconds;
  private final long timeMillis;
  private final boolean isRead;
  private final String phoneAccountComponentName;

  private AutoValue_VoicemailPopulator_Voicemail(
      String phoneNumber,
      String transcription,
      long durationSeconds,
      long timeMillis,
      boolean isRead,
      String phoneAccountComponentName) {
    this.phoneNumber = phoneNumber;
    this.transcription = transcription;
    this.durationSeconds = durationSeconds;
    this.timeMillis = timeMillis;
    this.isRead = isRead;
    this.phoneAccountComponentName = phoneAccountComponentName;
  }

  @NonNull
  @Override
  public String getPhoneNumber() {
    return phoneNumber;
  }

  @NonNull
  @Override
  public String getTranscription() {
    return transcription;
  }

  @Override
  public long getDurationSeconds() {
    return durationSeconds;
  }

  @Override
  public long getTimeMillis() {
    return timeMillis;
  }

  @Override
  public boolean getIsRead() {
    return isRead;
  }

  @Override
  public String getPhoneAccountComponentName() {
    return phoneAccountComponentName;
  }

  @Override
  public String toString() {
    return "Voicemail{"
        + "phoneNumber=" + phoneNumber + ", "
        + "transcription=" + transcription + ", "
        + "durationSeconds=" + durationSeconds + ", "
        + "timeMillis=" + timeMillis + ", "
        + "isRead=" + isRead + ", "
        + "phoneAccountComponentName=" + phoneAccountComponentName
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof VoicemailPopulator.Voicemail) {
      VoicemailPopulator.Voicemail that = (VoicemailPopulator.Voicemail) o;
      return (this.phoneNumber.equals(that.getPhoneNumber()))
           && (this.transcription.equals(that.getTranscription()))
           && (this.durationSeconds == that.getDurationSeconds())
           && (this.timeMillis == that.getTimeMillis())
           && (this.isRead == that.getIsRead())
           && (this.phoneAccountComponentName.equals(that.getPhoneAccountComponentName()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.phoneNumber.hashCode();
    h *= 1000003;
    h ^= this.transcription.hashCode();
    h *= 1000003;
    h ^= (int) ((this.durationSeconds >>> 32) ^ this.durationSeconds);
    h *= 1000003;
    h ^= (int) ((this.timeMillis >>> 32) ^ this.timeMillis);
    h *= 1000003;
    h ^= this.isRead ? 1231 : 1237;
    h *= 1000003;
    h ^= this.phoneAccountComponentName.hashCode();
    return h;
  }

  static final class Builder extends VoicemailPopulator.Voicemail.Builder {
    private String phoneNumber;
    private String transcription;
    private Long durationSeconds;
    private Long timeMillis;
    private Boolean isRead;
    private String phoneAccountComponentName;
    Builder() {
    }
    @Override
    public VoicemailPopulator.Voicemail.Builder setPhoneNumber(String phoneNumber) {
      if (phoneNumber == null) {
        throw new NullPointerException("Null phoneNumber");
      }
      this.phoneNumber = phoneNumber;
      return this;
    }
    @Override
    public VoicemailPopulator.Voicemail.Builder setTranscription(String transcription) {
      if (transcription == null) {
        throw new NullPointerException("Null transcription");
      }
      this.transcription = transcription;
      return this;
    }
    @Override
    public VoicemailPopulator.Voicemail.Builder setDurationSeconds(long durationSeconds) {
      this.durationSeconds = durationSeconds;
      return this;
    }
    @Override
    public VoicemailPopulator.Voicemail.Builder setTimeMillis(long timeMillis) {
      this.timeMillis = timeMillis;
      return this;
    }
    @Override
    public VoicemailPopulator.Voicemail.Builder setIsRead(boolean isRead) {
      this.isRead = isRead;
      return this;
    }
    @Override
    public VoicemailPopulator.Voicemail.Builder setPhoneAccountComponentName(String phoneAccountComponentName) {
      if (phoneAccountComponentName == null) {
        throw new NullPointerException("Null phoneAccountComponentName");
      }
      this.phoneAccountComponentName = phoneAccountComponentName;
      return this;
    }
    @Override
    public VoicemailPopulator.Voicemail build() {
      String missing = "";
      if (this.phoneNumber == null) {
        missing += " phoneNumber";
      }
      if (this.transcription == null) {
        missing += " transcription";
      }
      if (this.durationSeconds == null) {
        missing += " durationSeconds";
      }
      if (this.timeMillis == null) {
        missing += " timeMillis";
      }
      if (this.isRead == null) {
        missing += " isRead";
      }
      if (this.phoneAccountComponentName == null) {
        missing += " phoneAccountComponentName";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_VoicemailPopulator_Voicemail(
          this.phoneNumber,
          this.transcription,
          this.durationSeconds,
          this.timeMillis,
          this.isRead,
          this.phoneAccountComponentName);
    }
  }

}
