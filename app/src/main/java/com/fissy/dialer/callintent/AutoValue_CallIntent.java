package com.fissy.dialer.callintent;

import android.net.Uri;
import android.telecom.PhoneAccountHandle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.common.collect.ImmutableMap;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_CallIntent extends CallIntent {

    private final Uri number;
    private final CallSpecificAppData callSpecificAppData;
    private final PhoneAccountHandle phoneAccountHandle;
    private final boolean isVideoCall;
    private final String callSubject;
    private final boolean allowAssistedDial;
    private final ImmutableMap<String, String> stringInCallUiIntentExtras;
    private final ImmutableMap<String, Long> longInCallUiIntentExtras;
    private final ImmutableMap<String, String> stringPlaceCallExtras;
    private final ImmutableMap<String, Long> longPlaceCallExtras;

    private AutoValue_CallIntent(
            Uri number,
            CallSpecificAppData callSpecificAppData,
            @Nullable PhoneAccountHandle phoneAccountHandle,
            boolean isVideoCall,
            @Nullable String callSubject,
            boolean allowAssistedDial,
            ImmutableMap<String, String> stringInCallUiIntentExtras,
            ImmutableMap<String, Long> longInCallUiIntentExtras,
            ImmutableMap<String, String> stringPlaceCallExtras,
            ImmutableMap<String, Long> longPlaceCallExtras) {
        this.number = number;
        this.callSpecificAppData = callSpecificAppData;
        this.phoneAccountHandle = phoneAccountHandle;
        this.isVideoCall = isVideoCall;
        this.callSubject = callSubject;
        this.allowAssistedDial = allowAssistedDial;
        this.stringInCallUiIntentExtras = stringInCallUiIntentExtras;
        this.longInCallUiIntentExtras = longInCallUiIntentExtras;
        this.stringPlaceCallExtras = stringPlaceCallExtras;
        this.longPlaceCallExtras = longPlaceCallExtras;
    }

    @Override
    Uri number() {
        return number;
    }

    @Override
    CallSpecificAppData callSpecificAppData() {
        return callSpecificAppData;
    }

    @Nullable
    @Override
    PhoneAccountHandle phoneAccountHandle() {
        return phoneAccountHandle;
    }

    @Override
    boolean isVideoCall() {
        return isVideoCall;
    }

    @Nullable
    @Override
    String callSubject() {
        return callSubject;
    }

    @Override
    boolean allowAssistedDial() {
        return allowAssistedDial;
    }

    @Override
    ImmutableMap<String, String> stringInCallUiIntentExtras() {
        return stringInCallUiIntentExtras;
    }

    @Override
    ImmutableMap<String, Long> longInCallUiIntentExtras() {
        return longInCallUiIntentExtras;
    }

    @Override
    ImmutableMap<String, String> stringPlaceCallExtras() {
        return stringPlaceCallExtras;
    }

    @Override
    ImmutableMap<String, Long> longPlaceCallExtras() {
        return longPlaceCallExtras;
    }

    @Override
    public String toString() {
        return "CallIntent{"
                + "number=" + number + ", "
                + "callSpecificAppData=" + callSpecificAppData + ", "
                + "phoneAccountHandle=" + phoneAccountHandle + ", "
                + "isVideoCall=" + isVideoCall + ", "
                + "callSubject=" + callSubject + ", "
                + "allowAssistedDial=" + allowAssistedDial + ", "
                + "stringInCallUiIntentExtras=" + stringInCallUiIntentExtras + ", "
                + "longInCallUiIntentExtras=" + longInCallUiIntentExtras + ", "
                + "stringPlaceCallExtras=" + stringPlaceCallExtras + ", "
                + "longPlaceCallExtras=" + longPlaceCallExtras
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof CallIntent) {
            CallIntent that = (CallIntent) o;
            return (this.number.equals(that.number()))
                    && (this.callSpecificAppData.equals(that.callSpecificAppData()))
                    && ((this.phoneAccountHandle == null) ? (that.phoneAccountHandle() == null) : this.phoneAccountHandle.equals(that.phoneAccountHandle()))
                    && (this.isVideoCall == that.isVideoCall())
                    && ((this.callSubject == null) ? (that.callSubject() == null) : this.callSubject.equals(that.callSubject()))
                    && (this.allowAssistedDial == that.allowAssistedDial())
                    && (this.stringInCallUiIntentExtras.equals(that.stringInCallUiIntentExtras()))
                    && (this.longInCallUiIntentExtras.equals(that.longInCallUiIntentExtras()))
                    && (this.stringPlaceCallExtras.equals(that.stringPlaceCallExtras()))
                    && (this.longPlaceCallExtras.equals(that.longPlaceCallExtras()));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= this.number.hashCode();
        h *= 1000003;
        h ^= this.callSpecificAppData.hashCode();
        h *= 1000003;
        h ^= (phoneAccountHandle == null) ? 0 : this.phoneAccountHandle.hashCode();
        h *= 1000003;
        h ^= this.isVideoCall ? 1231 : 1237;
        h *= 1000003;
        h ^= (callSubject == null) ? 0 : this.callSubject.hashCode();
        h *= 1000003;
        h ^= this.allowAssistedDial ? 1231 : 1237;
        h *= 1000003;
        h ^= this.stringInCallUiIntentExtras.hashCode();
        h *= 1000003;
        h ^= this.longInCallUiIntentExtras.hashCode();
        h *= 1000003;
        h ^= this.stringPlaceCallExtras.hashCode();
        h *= 1000003;
        h ^= this.longPlaceCallExtras.hashCode();
        return h;
    }

    @Override
    public CallIntent.Builder toBuilder() {
        return new Builder(this);
    }

    static final class Builder extends CallIntent.Builder {
        private Uri number;
        private CallSpecificAppData callSpecificAppData;
        private PhoneAccountHandle phoneAccountHandle;
        private Boolean isVideoCall;
        private String callSubject;
        private Boolean allowAssistedDial;
        private ImmutableMap.Builder<String, String> stringInCallUiIntentExtrasBuilder$;
        private ImmutableMap<String, String> stringInCallUiIntentExtras;
        private ImmutableMap.Builder<String, Long> longInCallUiIntentExtrasBuilder$;
        private ImmutableMap<String, Long> longInCallUiIntentExtras;
        private ImmutableMap.Builder<String, String> stringPlaceCallExtrasBuilder$;
        private ImmutableMap<String, String> stringPlaceCallExtras;
        private ImmutableMap.Builder<String, Long> longPlaceCallExtrasBuilder$;
        private ImmutableMap<String, Long> longPlaceCallExtras;

        Builder() {
        }

        private Builder(CallIntent source) {
            this.number = source.number();
            this.callSpecificAppData = source.callSpecificAppData();
            this.phoneAccountHandle = source.phoneAccountHandle();
            this.isVideoCall = source.isVideoCall();
            this.callSubject = source.callSubject();
            this.allowAssistedDial = source.allowAssistedDial();
            this.stringInCallUiIntentExtras = source.stringInCallUiIntentExtras();
            this.longInCallUiIntentExtras = source.longInCallUiIntentExtras();
            this.stringPlaceCallExtras = source.stringPlaceCallExtras();
            this.longPlaceCallExtras = source.longPlaceCallExtras();
        }

        @Override
        public CallIntent.Builder setNumber(@NonNull Uri number) {
            if (number == null) {
                throw new NullPointerException("Null number");
            }
            this.number = number;
            return this;
        }

        @Override
        public CallIntent.Builder setCallSpecificAppData(@NonNull CallSpecificAppData callSpecificAppData) {
            if (callSpecificAppData == null) {
                throw new NullPointerException("Null callSpecificAppData");
            }
            this.callSpecificAppData = callSpecificAppData;
            return this;
        }

        @Override
        CallSpecificAppData callSpecificAppData() {
            if (callSpecificAppData == null) {
                throw new IllegalStateException("Property \"callSpecificAppData\" has not been set");
            }
            return callSpecificAppData;
        }

        @Override
        public CallIntent.Builder setPhoneAccountHandle(@Nullable PhoneAccountHandle phoneAccountHandle) {
            this.phoneAccountHandle = phoneAccountHandle;
            return this;
        }

        @Override
        public CallIntent.Builder setIsVideoCall(boolean isVideoCall) {
            this.isVideoCall = isVideoCall;
            return this;
        }

        @Override
        public CallIntent.Builder setCallSubject(@Nullable String callSubject) {
            this.callSubject = callSubject;
            return this;
        }

        @Override
        public CallIntent.Builder setAllowAssistedDial(boolean allowAssistedDial) {
            this.allowAssistedDial = allowAssistedDial;
            return this;
        }

        @Override
        ImmutableMap.Builder<String, String> stringInCallUiIntentExtrasBuilder() {
            if (stringInCallUiIntentExtrasBuilder$ == null) {
                if (stringInCallUiIntentExtras == null) {
                    stringInCallUiIntentExtrasBuilder$ = ImmutableMap.builder();
                } else {
                    stringInCallUiIntentExtrasBuilder$ = ImmutableMap.builder();
                    stringInCallUiIntentExtrasBuilder$.putAll(stringInCallUiIntentExtras);
                    stringInCallUiIntentExtras = null;
                }
            }
            return stringInCallUiIntentExtrasBuilder$;
        }

        @Override
        ImmutableMap.Builder<String, Long> longInCallUiIntentExtrasBuilder() {
            if (longInCallUiIntentExtrasBuilder$ == null) {
                if (longInCallUiIntentExtras == null) {
                    longInCallUiIntentExtrasBuilder$ = ImmutableMap.builder();
                } else {
                    longInCallUiIntentExtrasBuilder$ = ImmutableMap.builder();
                    longInCallUiIntentExtrasBuilder$.putAll(longInCallUiIntentExtras);
                    longInCallUiIntentExtras = null;
                }
            }
            return longInCallUiIntentExtrasBuilder$;
        }

        @Override
        ImmutableMap.Builder<String, String> stringPlaceCallExtrasBuilder() {
            if (stringPlaceCallExtrasBuilder$ == null) {
                if (stringPlaceCallExtras == null) {
                    stringPlaceCallExtrasBuilder$ = ImmutableMap.builder();
                } else {
                    stringPlaceCallExtrasBuilder$ = ImmutableMap.builder();
                    stringPlaceCallExtrasBuilder$.putAll(stringPlaceCallExtras);
                    stringPlaceCallExtras = null;
                }
            }
            return stringPlaceCallExtrasBuilder$;
        }

        @Override
        ImmutableMap.Builder<String, Long> longPlaceCallExtrasBuilder() {
            if (longPlaceCallExtrasBuilder$ == null) {
                if (longPlaceCallExtras == null) {
                    longPlaceCallExtrasBuilder$ = ImmutableMap.builder();
                } else {
                    longPlaceCallExtrasBuilder$ = ImmutableMap.builder();
                    longPlaceCallExtrasBuilder$.putAll(longPlaceCallExtras);
                    longPlaceCallExtras = null;
                }
            }
            return longPlaceCallExtrasBuilder$;
        }

        @Override
        CallIntent autoBuild() {
            if (stringInCallUiIntentExtrasBuilder$ != null) {
                this.stringInCallUiIntentExtras = stringInCallUiIntentExtrasBuilder$.build();
            } else if (this.stringInCallUiIntentExtras == null) {
                this.stringInCallUiIntentExtras = ImmutableMap.of();
            }
            if (longInCallUiIntentExtrasBuilder$ != null) {
                this.longInCallUiIntentExtras = longInCallUiIntentExtrasBuilder$.build();
            } else if (this.longInCallUiIntentExtras == null) {
                this.longInCallUiIntentExtras = ImmutableMap.of();
            }
            if (stringPlaceCallExtrasBuilder$ != null) {
                this.stringPlaceCallExtras = stringPlaceCallExtrasBuilder$.build();
            } else if (this.stringPlaceCallExtras == null) {
                this.stringPlaceCallExtras = ImmutableMap.of();
            }
            if (longPlaceCallExtrasBuilder$ != null) {
                this.longPlaceCallExtras = longPlaceCallExtrasBuilder$.build();
            } else if (this.longPlaceCallExtras == null) {
                this.longPlaceCallExtras = ImmutableMap.of();
            }
            String missing = "";
            if (this.number == null) {
                missing += " number";
            }
            if (this.callSpecificAppData == null) {
                missing += " callSpecificAppData";
            }
            if (this.isVideoCall == null) {
                missing += " isVideoCall";
            }
            if (this.allowAssistedDial == null) {
                missing += " allowAssistedDial";
            }
            if (!missing.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + missing);
            }
            return new AutoValue_CallIntent(
                    this.number,
                    this.callSpecificAppData,
                    this.phoneAccountHandle,
                    this.isVideoCall,
                    this.callSubject,
                    this.allowAssistedDial,
                    this.stringInCallUiIntentExtras,
                    this.longInCallUiIntentExtras,
                    this.stringPlaceCallExtras,
                    this.longPlaceCallExtras);
        }
    }

}
