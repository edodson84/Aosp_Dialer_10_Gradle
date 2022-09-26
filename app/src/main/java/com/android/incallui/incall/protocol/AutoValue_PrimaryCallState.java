package com.android.incallui.incall.protocol;

import android.graphics.drawable.Drawable;
import android.telecom.DisconnectCause;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;

import com.android.incallui.videotech.utils.SessionModificationState;
import com.fissy.dialer.assisteddialing.TransformationInfo;
import com.fissy.dialer.preferredsim.suggestion.SuggestionProvider;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_PrimaryCallState extends PrimaryCallState {

    private final int state;
    private final boolean isVideoCall;
    private final int sessionModificationState;
    private final DisconnectCause disconnectCause;
    private final String connectionLabel;
    private final int primaryColor;
    private final SuggestionProvider.Reason simSuggestionReason;
    private final Drawable connectionIcon;
    private final String gatewayNumber;
    private final String callSubject;
    private final String callbackNumber;
    private final boolean isWifi;
    private final boolean isConference;
    private final boolean isWorkCall;
    private final boolean isHdAttempting;
    private final boolean isHdAudioCall;
    private final boolean isForwardedNumber;
    private final boolean shouldShowContactPhoto;
    private final long connectTimeMillis;
    private final boolean isVoiceMailNumber;
    private final boolean isRemotelyHeld;
    private final boolean isBusinessNumber;
    private final boolean supportsCallOnHold;
    private final int swapToSecondaryButtonState;
    private final boolean isAssistedDialed;
    private final String customLabel;
    private final TransformationInfo assistedDialingExtras;

    private AutoValue_PrimaryCallState(
            int state,
            boolean isVideoCall,
            int sessionModificationState,
            DisconnectCause disconnectCause,
            @Nullable String connectionLabel,
            int primaryColor,
            @Nullable SuggestionProvider.Reason simSuggestionReason,
            @Nullable Drawable connectionIcon,
            @Nullable String gatewayNumber,
            @Nullable String callSubject,
            @Nullable String callbackNumber,
            boolean isWifi,
            boolean isConference,
            boolean isWorkCall,
            boolean isHdAttempting,
            boolean isHdAudioCall,
            boolean isForwardedNumber,
            boolean shouldShowContactPhoto,
            long connectTimeMillis,
            boolean isVoiceMailNumber,
            boolean isRemotelyHeld,
            boolean isBusinessNumber,
            boolean supportsCallOnHold,
            int swapToSecondaryButtonState,
            boolean isAssistedDialed,
            @Nullable String customLabel,
            @Nullable TransformationInfo assistedDialingExtras) {
        this.state = state;
        this.isVideoCall = isVideoCall;
        this.sessionModificationState = sessionModificationState;
        this.disconnectCause = disconnectCause;
        this.connectionLabel = connectionLabel;
        this.primaryColor = primaryColor;
        this.simSuggestionReason = simSuggestionReason;
        this.connectionIcon = connectionIcon;
        this.gatewayNumber = gatewayNumber;
        this.callSubject = callSubject;
        this.callbackNumber = callbackNumber;
        this.isWifi = isWifi;
        this.isConference = isConference;
        this.isWorkCall = isWorkCall;
        this.isHdAttempting = isHdAttempting;
        this.isHdAudioCall = isHdAudioCall;
        this.isForwardedNumber = isForwardedNumber;
        this.shouldShowContactPhoto = shouldShowContactPhoto;
        this.connectTimeMillis = connectTimeMillis;
        this.isVoiceMailNumber = isVoiceMailNumber;
        this.isRemotelyHeld = isRemotelyHeld;
        this.isBusinessNumber = isBusinessNumber;
        this.supportsCallOnHold = supportsCallOnHold;
        this.swapToSecondaryButtonState = swapToSecondaryButtonState;
        this.isAssistedDialed = isAssistedDialed;
        this.customLabel = customLabel;
        this.assistedDialingExtras = assistedDialingExtras;
    }

    @Override
    public int state() {
        return state;
    }

    @Override
    public boolean isVideoCall() {
        return isVideoCall;
    }

    @SessionModificationState
    @Override
    public int sessionModificationState() {
        return sessionModificationState;
    }

    @Override
    public DisconnectCause disconnectCause() {
        return disconnectCause;
    }

    @Nullable
    @Override
    public String connectionLabel() {
        return connectionLabel;
    }

    @ColorInt
    @Override
    public int primaryColor() {
        return primaryColor;
    }

    @Nullable
    @Override
    public SuggestionProvider.Reason simSuggestionReason() {
        return simSuggestionReason;
    }

    @Nullable
    @Override
    public Drawable connectionIcon() {
        return connectionIcon;
    }

    @Nullable
    @Override
    public String gatewayNumber() {
        return gatewayNumber;
    }

    @Nullable
    @Override
    public String callSubject() {
        return callSubject;
    }

    @Nullable
    @Override
    public String callbackNumber() {
        return callbackNumber;
    }

    @Override
    public boolean isWifi() {
        return isWifi;
    }

    @Override
    public boolean isConference() {
        return isConference;
    }

    @Override
    public boolean isWorkCall() {
        return isWorkCall;
    }

    @Override
    public boolean isHdAttempting() {
        return isHdAttempting;
    }

    @Override
    public boolean isHdAudioCall() {
        return isHdAudioCall;
    }

    @Override
    public boolean isForwardedNumber() {
        return isForwardedNumber;
    }

    @Override
    public boolean shouldShowContactPhoto() {
        return shouldShowContactPhoto;
    }

    @Override
    public long connectTimeMillis() {
        return connectTimeMillis;
    }

    @Override
    public boolean isVoiceMailNumber() {
        return isVoiceMailNumber;
    }

    @Override
    public boolean isRemotelyHeld() {
        return isRemotelyHeld;
    }

    @Override
    public boolean isBusinessNumber() {
        return isBusinessNumber;
    }

    @Override
    public boolean supportsCallOnHold() {
        return supportsCallOnHold;
    }

    @PrimaryCallState.ButtonState
    @Override
    public int swapToSecondaryButtonState() {
        return swapToSecondaryButtonState;
    }

    @Override
    public boolean isAssistedDialed() {
        return isAssistedDialed;
    }

    @Nullable
    @Override
    public String customLabel() {
        return customLabel;
    }

    @Nullable
    @Override
    public TransformationInfo assistedDialingExtras() {
        return assistedDialingExtras;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof PrimaryCallState) {
            PrimaryCallState that = (PrimaryCallState) o;
            return (this.state == that.state())
                    && (this.isVideoCall == that.isVideoCall())
                    && (this.sessionModificationState == that.sessionModificationState())
                    && (this.disconnectCause.equals(that.disconnectCause()))
                    && ((this.connectionLabel == null) ? (that.connectionLabel() == null) : this.connectionLabel.equals(that.connectionLabel()))
                    && (this.primaryColor == that.primaryColor())
                    && ((this.simSuggestionReason == null) ? (that.simSuggestionReason() == null) : this.simSuggestionReason.equals(that.simSuggestionReason()))
                    && ((this.connectionIcon == null) ? (that.connectionIcon() == null) : this.connectionIcon.equals(that.connectionIcon()))
                    && ((this.gatewayNumber == null) ? (that.gatewayNumber() == null) : this.gatewayNumber.equals(that.gatewayNumber()))
                    && ((this.callSubject == null) ? (that.callSubject() == null) : this.callSubject.equals(that.callSubject()))
                    && ((this.callbackNumber == null) ? (that.callbackNumber() == null) : this.callbackNumber.equals(that.callbackNumber()))
                    && (this.isWifi == that.isWifi())
                    && (this.isConference == that.isConference())
                    && (this.isWorkCall == that.isWorkCall())
                    && (this.isHdAttempting == that.isHdAttempting())
                    && (this.isHdAudioCall == that.isHdAudioCall())
                    && (this.isForwardedNumber == that.isForwardedNumber())
                    && (this.shouldShowContactPhoto == that.shouldShowContactPhoto())
                    && (this.connectTimeMillis == that.connectTimeMillis())
                    && (this.isVoiceMailNumber == that.isVoiceMailNumber())
                    && (this.isRemotelyHeld == that.isRemotelyHeld())
                    && (this.isBusinessNumber == that.isBusinessNumber())
                    && (this.supportsCallOnHold == that.supportsCallOnHold())
                    && (this.swapToSecondaryButtonState == that.swapToSecondaryButtonState())
                    && (this.isAssistedDialed == that.isAssistedDialed())
                    && ((this.customLabel == null) ? (that.customLabel() == null) : this.customLabel.equals(that.customLabel()))
                    && ((this.assistedDialingExtras == null) ? (that.assistedDialingExtras() == null) : this.assistedDialingExtras.equals(that.assistedDialingExtras()));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= this.state;
        h *= 1000003;
        h ^= this.isVideoCall ? 1231 : 1237;
        h *= 1000003;
        h ^= this.sessionModificationState;
        h *= 1000003;
        h ^= this.disconnectCause.hashCode();
        h *= 1000003;
        h ^= (connectionLabel == null) ? 0 : this.connectionLabel.hashCode();
        h *= 1000003;
        h ^= this.primaryColor;
        h *= 1000003;
        h ^= (simSuggestionReason == null) ? 0 : this.simSuggestionReason.hashCode();
        h *= 1000003;
        h ^= (connectionIcon == null) ? 0 : this.connectionIcon.hashCode();
        h *= 1000003;
        h ^= (gatewayNumber == null) ? 0 : this.gatewayNumber.hashCode();
        h *= 1000003;
        h ^= (callSubject == null) ? 0 : this.callSubject.hashCode();
        h *= 1000003;
        h ^= (callbackNumber == null) ? 0 : this.callbackNumber.hashCode();
        h *= 1000003;
        h ^= this.isWifi ? 1231 : 1237;
        h *= 1000003;
        h ^= this.isConference ? 1231 : 1237;
        h *= 1000003;
        h ^= this.isWorkCall ? 1231 : 1237;
        h *= 1000003;
        h ^= this.isHdAttempting ? 1231 : 1237;
        h *= 1000003;
        h ^= this.isHdAudioCall ? 1231 : 1237;
        h *= 1000003;
        h ^= this.isForwardedNumber ? 1231 : 1237;
        h *= 1000003;
        h ^= this.shouldShowContactPhoto ? 1231 : 1237;
        h *= 1000003;
        h ^= (int) ((this.connectTimeMillis >>> 32) ^ this.connectTimeMillis);
        h *= 1000003;
        h ^= this.isVoiceMailNumber ? 1231 : 1237;
        h *= 1000003;
        h ^= this.isRemotelyHeld ? 1231 : 1237;
        h *= 1000003;
        h ^= this.isBusinessNumber ? 1231 : 1237;
        h *= 1000003;
        h ^= this.supportsCallOnHold ? 1231 : 1237;
        h *= 1000003;
        h ^= this.swapToSecondaryButtonState;
        h *= 1000003;
        h ^= this.isAssistedDialed ? 1231 : 1237;
        h *= 1000003;
        h ^= (customLabel == null) ? 0 : this.customLabel.hashCode();
        h *= 1000003;
        h ^= (assistedDialingExtras == null) ? 0 : this.assistedDialingExtras.hashCode();
        return h;
    }

    static final class Builder extends PrimaryCallState.Builder {
        private Integer state;
        private Boolean isVideoCall;
        private Integer sessionModificationState;
        private DisconnectCause disconnectCause;
        private String connectionLabel;
        private Integer primaryColor;
        private SuggestionProvider.Reason simSuggestionReason;
        private Drawable connectionIcon;
        private String gatewayNumber;
        private String callSubject;
        private String callbackNumber;
        private Boolean isWifi;
        private Boolean isConference;
        private Boolean isWorkCall;
        private Boolean isHdAttempting;
        private Boolean isHdAudioCall;
        private Boolean isForwardedNumber;
        private Boolean shouldShowContactPhoto;
        private Long connectTimeMillis;
        private Boolean isVoiceMailNumber;
        private Boolean isRemotelyHeld;
        private Boolean isBusinessNumber;
        private Boolean supportsCallOnHold;
        private Integer swapToSecondaryButtonState;
        private Boolean isAssistedDialed;
        private String customLabel;
        private TransformationInfo assistedDialingExtras;

        Builder() {
        }

        @Override
        public PrimaryCallState.Builder setState(int state) {
            this.state = state;
            return this;
        }

        @Override
        public PrimaryCallState.Builder setIsVideoCall(boolean isVideoCall) {
            this.isVideoCall = isVideoCall;
            return this;
        }

        @Override
        public PrimaryCallState.Builder setSessionModificationState(int sessionModificationState) {
            this.sessionModificationState = sessionModificationState;
            return this;
        }

        @Override
        public PrimaryCallState.Builder setDisconnectCause(DisconnectCause disconnectCause) {
            if (disconnectCause == null) {
                throw new NullPointerException("Null disconnectCause");
            }
            this.disconnectCause = disconnectCause;
            return this;
        }

        @Override
        public PrimaryCallState.Builder setConnectionLabel(@Nullable String connectionLabel) {
            this.connectionLabel = connectionLabel;
            return this;
        }

        @Override
        public PrimaryCallState.Builder setPrimaryColor(int primaryColor) {
            this.primaryColor = primaryColor;
            return this;
        }

        @Override
        public PrimaryCallState.Builder setSimSuggestionReason(@Nullable SuggestionProvider.Reason simSuggestionReason) {
            this.simSuggestionReason = simSuggestionReason;
            return this;
        }

        @Override
        public PrimaryCallState.Builder setConnectionIcon(@Nullable Drawable connectionIcon) {
            this.connectionIcon = connectionIcon;
            return this;
        }

        @Override
        public PrimaryCallState.Builder setGatewayNumber(@Nullable String gatewayNumber) {
            this.gatewayNumber = gatewayNumber;
            return this;
        }

        @Override
        public PrimaryCallState.Builder setCallSubject(@Nullable String callSubject) {
            this.callSubject = callSubject;
            return this;
        }

        @Override
        public PrimaryCallState.Builder setCallbackNumber(@Nullable String callbackNumber) {
            this.callbackNumber = callbackNumber;
            return this;
        }

        @Override
        public PrimaryCallState.Builder setIsWifi(boolean isWifi) {
            this.isWifi = isWifi;
            return this;
        }

        @Override
        public PrimaryCallState.Builder setIsConference(boolean isConference) {
            this.isConference = isConference;
            return this;
        }

        @Override
        public PrimaryCallState.Builder setIsWorkCall(boolean isWorkCall) {
            this.isWorkCall = isWorkCall;
            return this;
        }

        @Override
        public PrimaryCallState.Builder setIsHdAttempting(boolean isHdAttempting) {
            this.isHdAttempting = isHdAttempting;
            return this;
        }

        @Override
        public PrimaryCallState.Builder setIsHdAudioCall(boolean isHdAudioCall) {
            this.isHdAudioCall = isHdAudioCall;
            return this;
        }

        @Override
        public PrimaryCallState.Builder setIsForwardedNumber(boolean isForwardedNumber) {
            this.isForwardedNumber = isForwardedNumber;
            return this;
        }

        @Override
        public PrimaryCallState.Builder setShouldShowContactPhoto(boolean shouldShowContactPhoto) {
            this.shouldShowContactPhoto = shouldShowContactPhoto;
            return this;
        }

        @Override
        public PrimaryCallState.Builder setConnectTimeMillis(long connectTimeMillis) {
            this.connectTimeMillis = connectTimeMillis;
            return this;
        }

        @Override
        public PrimaryCallState.Builder setIsVoiceMailNumber(boolean isVoiceMailNumber) {
            this.isVoiceMailNumber = isVoiceMailNumber;
            return this;
        }

        @Override
        public PrimaryCallState.Builder setIsRemotelyHeld(boolean isRemotelyHeld) {
            this.isRemotelyHeld = isRemotelyHeld;
            return this;
        }

        @Override
        public PrimaryCallState.Builder setIsBusinessNumber(boolean isBusinessNumber) {
            this.isBusinessNumber = isBusinessNumber;
            return this;
        }

        @Override
        public PrimaryCallState.Builder setSupportsCallOnHold(boolean supportsCallOnHold) {
            this.supportsCallOnHold = supportsCallOnHold;
            return this;
        }

        @Override
        public PrimaryCallState.Builder setSwapToSecondaryButtonState(int swapToSecondaryButtonState) {
            this.swapToSecondaryButtonState = swapToSecondaryButtonState;
            return this;
        }

        @Override
        public PrimaryCallState.Builder setIsAssistedDialed(boolean isAssistedDialed) {
            this.isAssistedDialed = isAssistedDialed;
            return this;
        }

        @Override
        public PrimaryCallState.Builder setCustomLabel(@Nullable String customLabel) {
            this.customLabel = customLabel;
            return this;
        }

        @Override
        public PrimaryCallState.Builder setAssistedDialingExtras(@Nullable TransformationInfo assistedDialingExtras) {
            this.assistedDialingExtras = assistedDialingExtras;
            return this;
        }

        @Override
        PrimaryCallState autoBuild() {
            String missing = "";
            if (this.state == null) {
                missing += " state";
            }
            if (this.isVideoCall == null) {
                missing += " isVideoCall";
            }
            if (this.sessionModificationState == null) {
                missing += " sessionModificationState";
            }
            if (this.disconnectCause == null) {
                missing += " disconnectCause";
            }
            if (this.primaryColor == null) {
                missing += " primaryColor";
            }
            if (this.isWifi == null) {
                missing += " isWifi";
            }
            if (this.isConference == null) {
                missing += " isConference";
            }
            if (this.isWorkCall == null) {
                missing += " isWorkCall";
            }
            if (this.isHdAttempting == null) {
                missing += " isHdAttempting";
            }
            if (this.isHdAudioCall == null) {
                missing += " isHdAudioCall";
            }
            if (this.isForwardedNumber == null) {
                missing += " isForwardedNumber";
            }
            if (this.shouldShowContactPhoto == null) {
                missing += " shouldShowContactPhoto";
            }
            if (this.connectTimeMillis == null) {
                missing += " connectTimeMillis";
            }
            if (this.isVoiceMailNumber == null) {
                missing += " isVoiceMailNumber";
            }
            if (this.isRemotelyHeld == null) {
                missing += " isRemotelyHeld";
            }
            if (this.isBusinessNumber == null) {
                missing += " isBusinessNumber";
            }
            if (this.supportsCallOnHold == null) {
                missing += " supportsCallOnHold";
            }
            if (this.swapToSecondaryButtonState == null) {
                missing += " swapToSecondaryButtonState";
            }
            if (this.isAssistedDialed == null) {
                missing += " isAssistedDialed";
            }
            if (!missing.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + missing);
            }
            return new AutoValue_PrimaryCallState(
                    this.state,
                    this.isVideoCall,
                    this.sessionModificationState,
                    this.disconnectCause,
                    this.connectionLabel,
                    this.primaryColor,
                    this.simSuggestionReason,
                    this.connectionIcon,
                    this.gatewayNumber,
                    this.callSubject,
                    this.callbackNumber,
                    this.isWifi,
                    this.isConference,
                    this.isWorkCall,
                    this.isHdAttempting,
                    this.isHdAudioCall,
                    this.isForwardedNumber,
                    this.shouldShowContactPhoto,
                    this.connectTimeMillis,
                    this.isVoiceMailNumber,
                    this.isRemotelyHeld,
                    this.isBusinessNumber,
                    this.supportsCallOnHold,
                    this.swapToSecondaryButtonState,
                    this.isAssistedDialed,
                    this.customLabel,
                    this.assistedDialingExtras);
        }
    }

}
