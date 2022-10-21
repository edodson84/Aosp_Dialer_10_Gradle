// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: packages/apps/Dialer/java/com/fissy/dialer/logging/contact_source.proto

package com.fissy.dialer.logging;

/**
 * Protobuf type {@code com.fissy.dialer.logging.ContactSource}
 */
public final class ContactSource extends
        com.google.protobuf.GeneratedMessageLite<
                ContactSource, ContactSource.Builder> implements
        // @@protoc_insertion_point(message_implements:com.fissy.dialer.logging.ContactSource)
        ContactSourceOrBuilder {
    // @@protoc_insertion_point(class_scope:com.fissy.dialer.logging.ContactSource)
    private static final com.fissy.dialer.logging.ContactSource DEFAULT_INSTANCE;
    private static volatile com.google.protobuf.Parser<ContactSource> PARSER;

    static {
        DEFAULT_INSTANCE = new ContactSource();
        DEFAULT_INSTANCE.makeImmutable();
    }

    private ContactSource() {
    }

    public static com.fissy.dialer.logging.ContactSource parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, data);
    }

    public static com.fissy.dialer.logging.ContactSource parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static com.fissy.dialer.logging.ContactSource parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, data);
    }

    public static com.fissy.dialer.logging.ContactSource parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static com.fissy.dialer.logging.ContactSource parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, input);
    }

    public static com.fissy.dialer.logging.ContactSource parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static com.fissy.dialer.logging.ContactSource parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static com.fissy.dialer.logging.ContactSource parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static com.fissy.dialer.logging.ContactSource parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, input);
    }

    public static com.fissy.dialer.logging.ContactSource parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(com.fissy.dialer.logging.ContactSource prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    public static com.fissy.dialer.logging.ContactSource getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<ContactSource> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
        unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
        int size = memoizedSerializedSize;
        if (size != -1) return size;

        size = 0;
        size += unknownFields.getSerializedSize();
        memoizedSerializedSize = size;
        return size;
    }

    protected final Object dynamicMethod(
            com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
            Object arg0, Object arg1) {
        switch (method) {
            case NEW_MUTABLE_INSTANCE: {
                return new com.fissy.dialer.logging.ContactSource();
            }
            case IS_INITIALIZED: {
                return DEFAULT_INSTANCE;
            }
            case MAKE_IMMUTABLE: {
                return null;
            }
            case NEW_BUILDER: {
                return new Builder();
            }
            case VISIT: {
                Visitor visitor = (Visitor) arg0;
                com.fissy.dialer.logging.ContactSource other = (com.fissy.dialer.logging.ContactSource) arg1;
                return this;
            }
            case MERGE_FROM_STREAM: {
                com.google.protobuf.CodedInputStream input =
                        (com.google.protobuf.CodedInputStream) arg0;
                com.google.protobuf.ExtensionRegistryLite extensionRegistry =
                        (com.google.protobuf.ExtensionRegistryLite) arg1;
                try {
                    boolean done = false;
                    while (!done) {
                        int tag = input.readTag();
                        if (tag == 0) {
                            done = true;
                        } else {
                            if (!parseUnknownField(tag, input)) {
                                done = true;
                            }
                        }
                    }
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    throw new RuntimeException(e.setUnfinishedMessage(this));
                } catch (java.io.IOException e) {
                    throw new RuntimeException(
                            new com.google.protobuf.InvalidProtocolBufferException(
                                    e.getMessage()).setUnfinishedMessage(this));
                }
            }
            case GET_DEFAULT_INSTANCE: {
                return DEFAULT_INSTANCE;
            }
            case GET_PARSER: {
                if (PARSER == null) {
                    synchronized (com.fissy.dialer.logging.ContactSource.class) {
                        if (PARSER == null) {
                            PARSER = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        }
                    }
                }
                return PARSER;
            }
        }
        throw new UnsupportedOperationException();
    }

    /**
     * <pre>
     * Applies only to reports made from call history. If we have contact
     * information for the phone number, this field indicates its source.
     * Note that it represents the contact's status on the user's device at the
     * time they made the spam report, which could be different from the
     * number's status at the time they made or received the call.
     * Type definitions are from the CachedContactInfo interface in
     * CachedNumberLookupService.java
     * </pre>
     * <p>
     * Protobuf enum {@code com.fissy.dialer.logging.ContactSource.Type}
     */
    public enum Type
            implements com.google.protobuf.Internal.EnumLite {
        /**
         * <code>UNKNOWN_SOURCE_TYPE = 0;</code>
         */
        UNKNOWN_SOURCE_TYPE(0),
        /**
         * <pre>
         * Personal contact
         * </pre>
         *
         * <code>SOURCE_TYPE_DIRECTORY = 1;</code>
         */
        SOURCE_TYPE_DIRECTORY(1),
        /**
         * <pre>
         * Contact from a custom extended directory
         * </pre>
         *
         * <code>SOURCE_TYPE_EXTENDED = 2;</code>
         */
        SOURCE_TYPE_EXTENDED(2),
        /**
         * <pre>
         * Business number found via the People API
         * </pre>
         *
         * <code>SOURCE_TYPE_PLACES = 3;</code>
         */
        SOURCE_TYPE_PLACES(3),
        /**
         * <pre>
         * Non-business number found via the People API
         * </pre>
         *
         * <code>SOURCE_TYPE_PROFILE = 4;</code>
         */
        SOURCE_TYPE_PROFILE(4),
        /**
         * <pre>
         * Number has Caller Name Presentation (CNAP) information. Calls in this
         * category would have had ContactLookupResultType NOT_FOUND originally.
         * </pre>
         *
         * <code>SOURCE_TYPE_CNAP = 5;</code>
         */
        SOURCE_TYPE_CNAP(5),
        /**
         * <code>SOURCE_TYPE_CEQUINT_CALLER_ID = 6;</code>
         */
        SOURCE_TYPE_CEQUINT_CALLER_ID(6),
        /**
         * <pre>
         * A remote source not listed below
         * </pre>
         *
         * <code>SOURCE_TYPE_REMOTE_OTHER = 7;</code>
         */
        SOURCE_TYPE_REMOTE_OTHER(7),
        /**
         * <pre>
         * Manually-entered caller ID data
         * </pre>
         *
         * <code>SOURCE_TYPE_REMOTE_MANUAL = 8;</code>
         */
        SOURCE_TYPE_REMOTE_MANUAL(8),
        /**
         * <pre>
         * Google Voice short code data
         * </pre>
         *
         * <code>SOURCE_TYPE_REMOTE_GOOGLE_VOICE = 9;</code>
         */
        SOURCE_TYPE_REMOTE_GOOGLE_VOICE(9),
        /**
         * <pre>
         * Customer Service Applications data
         * </pre>
         *
         * <code>SOURCE_TYPE_REMOTE_CSA = 10;</code>
         */
        SOURCE_TYPE_REMOTE_CSA(10),
        /**
         * <pre>
         * Knowledge Graph data
         * </pre>
         *
         * <code>SOURCE_TYPE_REMOTE_KNOWLEDGE_GRAPH = 11;</code>
         */
        SOURCE_TYPE_REMOTE_KNOWLEDGE_GRAPH(11),
        ;

        /**
         * <code>UNKNOWN_SOURCE_TYPE = 0;</code>
         */
        public static final int UNKNOWN_SOURCE_TYPE_VALUE = 0;
        /**
         * <pre>
         * Personal contact
         * </pre>
         *
         * <code>SOURCE_TYPE_DIRECTORY = 1;</code>
         */
        public static final int SOURCE_TYPE_DIRECTORY_VALUE = 1;
        /**
         * <pre>
         * Contact from a custom extended directory
         * </pre>
         *
         * <code>SOURCE_TYPE_EXTENDED = 2;</code>
         */
        public static final int SOURCE_TYPE_EXTENDED_VALUE = 2;
        /**
         * <pre>
         * Business number found via the People API
         * </pre>
         *
         * <code>SOURCE_TYPE_PLACES = 3;</code>
         */
        public static final int SOURCE_TYPE_PLACES_VALUE = 3;
        /**
         * <pre>
         * Non-business number found via the People API
         * </pre>
         *
         * <code>SOURCE_TYPE_PROFILE = 4;</code>
         */
        public static final int SOURCE_TYPE_PROFILE_VALUE = 4;
        /**
         * <pre>
         * Number has Caller Name Presentation (CNAP) information. Calls in this
         * category would have had ContactLookupResultType NOT_FOUND originally.
         * </pre>
         *
         * <code>SOURCE_TYPE_CNAP = 5;</code>
         */
        public static final int SOURCE_TYPE_CNAP_VALUE = 5;
        /**
         * <code>SOURCE_TYPE_CEQUINT_CALLER_ID = 6;</code>
         */
        public static final int SOURCE_TYPE_CEQUINT_CALLER_ID_VALUE = 6;
        /**
         * <pre>
         * A remote source not listed below
         * </pre>
         *
         * <code>SOURCE_TYPE_REMOTE_OTHER = 7;</code>
         */
        public static final int SOURCE_TYPE_REMOTE_OTHER_VALUE = 7;
        /**
         * <pre>
         * Manually-entered caller ID data
         * </pre>
         *
         * <code>SOURCE_TYPE_REMOTE_MANUAL = 8;</code>
         */
        public static final int SOURCE_TYPE_REMOTE_MANUAL_VALUE = 8;
        /**
         * <pre>
         * Google Voice short code data
         * </pre>
         *
         * <code>SOURCE_TYPE_REMOTE_GOOGLE_VOICE = 9;</code>
         */
        public static final int SOURCE_TYPE_REMOTE_GOOGLE_VOICE_VALUE = 9;
        /**
         * <pre>
         * Customer Service Applications data
         * </pre>
         *
         * <code>SOURCE_TYPE_REMOTE_CSA = 10;</code>
         */
        public static final int SOURCE_TYPE_REMOTE_CSA_VALUE = 10;
        /**
         * <pre>
         * Knowledge Graph data
         * </pre>
         *
         * <code>SOURCE_TYPE_REMOTE_KNOWLEDGE_GRAPH = 11;</code>
         */
        public static final int SOURCE_TYPE_REMOTE_KNOWLEDGE_GRAPH_VALUE = 11;
        private static final com.google.protobuf.Internal.EnumLiteMap<
                Type> internalValueMap =
                number -> Type.forNumber(number);
        private final int value;

        Type(int value) {
            this.value = value;
        }

        /**
         * @deprecated Use {@link #forNumber(int)} instead.
         */
        @java.lang.Deprecated
        public static Type valueOf(int value) {
            return forNumber(value);
        }

        public static Type forNumber(int value) {
            switch (value) {
                case 0:
                    return UNKNOWN_SOURCE_TYPE;
                case 1:
                    return SOURCE_TYPE_DIRECTORY;
                case 2:
                    return SOURCE_TYPE_EXTENDED;
                case 3:
                    return SOURCE_TYPE_PLACES;
                case 4:
                    return SOURCE_TYPE_PROFILE;
                case 5:
                    return SOURCE_TYPE_CNAP;
                case 6:
                    return SOURCE_TYPE_CEQUINT_CALLER_ID;
                case 7:
                    return SOURCE_TYPE_REMOTE_OTHER;
                case 8:
                    return SOURCE_TYPE_REMOTE_MANUAL;
                case 9:
                    return SOURCE_TYPE_REMOTE_GOOGLE_VOICE;
                case 10:
                    return SOURCE_TYPE_REMOTE_CSA;
                case 11:
                    return SOURCE_TYPE_REMOTE_KNOWLEDGE_GRAPH;
                default:
                    return null;
            }
        }

        public static com.google.protobuf.Internal.EnumLiteMap<Type>
        internalGetValueMap() {
            return internalValueMap;
        }

        public final int getNumber() {
            return value;
        }

        // @@protoc_insertion_point(enum_scope:com.fissy.dialer.logging.ContactSource.Type)
    }

    /**
     * Protobuf type {@code com.fissy.dialer.logging.ContactSource}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageLite.Builder<
                    com.fissy.dialer.logging.ContactSource, Builder> implements
            // @@protoc_insertion_point(builder_implements:com.fissy.dialer.logging.ContactSource)
            com.fissy.dialer.logging.ContactSourceOrBuilder {
        // Construct using com.fissy.dialer.logging.ContactSource.newBuilder()
        private Builder() {
            super(DEFAULT_INSTANCE);
        }


        // @@protoc_insertion_point(builder_scope:com.fissy.dialer.logging.ContactSource)
    }
}

