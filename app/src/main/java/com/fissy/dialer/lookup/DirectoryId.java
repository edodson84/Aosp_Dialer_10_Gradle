package com.fissy.dialer.lookup;

import android.provider.ContactsContract;

public class DirectoryId {
    // default contacts directory
    public static final long DEFAULT = ContactsContract.Directory.DEFAULT;

    // id for a non existant directory
    public static final long NULL = Long.MAX_VALUE;

    // id for nearby forward lookup results (not a real directory)
    public static final long NEARBY = NULL - 1;

    // id for people forward lookup results (not a real directory)
    public static final long PEOPLE = NULL - 2;

}
