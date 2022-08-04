
package com.fissy.dialer.databasepopulator;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.util.List;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ContactsPopulator_Contact extends ContactsPopulator.Contact {

  private final String accountType;
  private final String accountName;
  private final String name;
  private final boolean isStarred;
  private final int pinned;
  private final ByteArrayOutputStream photoStream;
  private final List<ContactsPopulator.PhoneNumber> phoneNumbers;
  private final List<ContactsPopulator.Email> emails;

  private AutoValue_ContactsPopulator_Contact(
      String accountType,
      String accountName,
      @Nullable String name,
      boolean isStarred,
      int pinned,
      @Nullable ByteArrayOutputStream photoStream,
      List<ContactsPopulator.PhoneNumber> phoneNumbers,
      List<ContactsPopulator.Email> emails) {
    this.accountType = accountType;
    this.accountName = accountName;
    this.name = name;
    this.isStarred = isStarred;
    this.pinned = pinned;
    this.photoStream = photoStream;
    this.phoneNumbers = phoneNumbers;
    this.emails = emails;
  }

  @NonNull
  @Override
  String getAccountType() {
    return accountType;
  }

  @NonNull
  @Override
  String getAccountName() {
    return accountName;
  }

  @Nullable
  @Override
  String getName() {
    return name;
  }

  @Override
  boolean getIsStarred() {
    return isStarred;
  }

  @Override
  int getPinned() {
    return pinned;
  }

  @Nullable
  @Override
  ByteArrayOutputStream getPhotoStream() {
    return photoStream;
  }

  @NonNull
  @Override
  List<ContactsPopulator.PhoneNumber> getPhoneNumbers() {
    return phoneNumbers;
  }

  @NonNull
  @Override
  List<ContactsPopulator.Email> getEmails() {
    return emails;
  }

  @Override
  public String toString() {
    return "Contact{"
        + "accountType=" + accountType + ", "
        + "accountName=" + accountName + ", "
        + "name=" + name + ", "
        + "isStarred=" + isStarred + ", "
        + "pinned=" + pinned + ", "
        + "photoStream=" + photoStream + ", "
        + "phoneNumbers=" + phoneNumbers + ", "
        + "emails=" + emails
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ContactsPopulator.Contact) {
      ContactsPopulator.Contact that = (ContactsPopulator.Contact) o;
      return (this.accountType.equals(that.getAccountType()))
           && (this.accountName.equals(that.getAccountName()))
           && ((this.name == null) ? (that.getName() == null) : this.name.equals(that.getName()))
           && (this.isStarred == that.getIsStarred())
           && (this.pinned == that.getPinned())
           && ((this.photoStream == null) ? (that.getPhotoStream() == null) : this.photoStream.equals(that.getPhotoStream()))
           && (this.phoneNumbers.equals(that.getPhoneNumbers()))
           && (this.emails.equals(that.getEmails()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.accountType.hashCode();
    h *= 1000003;
    h ^= this.accountName.hashCode();
    h *= 1000003;
    h ^= (name == null) ? 0 : this.name.hashCode();
    h *= 1000003;
    h ^= this.isStarred ? 1231 : 1237;
    h *= 1000003;
    h ^= this.pinned;
    h *= 1000003;
    h ^= (photoStream == null) ? 0 : this.photoStream.hashCode();
    h *= 1000003;
    h ^= this.phoneNumbers.hashCode();
    h *= 1000003;
    h ^= this.emails.hashCode();
    return h;
  }

  static final class Builder extends ContactsPopulator.Contact.Builder {
    private String accountType;
    private String accountName;
    private String name;
    private Boolean isStarred;
    private Integer pinned;
    private ByteArrayOutputStream photoStream;
    private List<ContactsPopulator.PhoneNumber> phoneNumbers;
    private List<ContactsPopulator.Email> emails;
    Builder() {
    }
    @Override
    ContactsPopulator.Contact.Builder setAccountType(String accountType) {
      if (accountType == null) {
        throw new NullPointerException("Null accountType");
      }
      this.accountType = accountType;
      return this;
    }
    @Override
    ContactsPopulator.Contact.Builder setAccountName(String accountName) {
      if (accountName == null) {
        throw new NullPointerException("Null accountName");
      }
      this.accountName = accountName;
      return this;
    }
    @Override
    ContactsPopulator.Contact.Builder setName(@Nullable String name) {
      this.name = name;
      return this;
    }
    @Override
    ContactsPopulator.Contact.Builder setIsStarred(boolean isStarred) {
      this.isStarred = isStarred;
      return this;
    }
    @Override
    ContactsPopulator.Contact.Builder setPinned(int pinned) {
      this.pinned = pinned;
      return this;
    }
    @Override
    ContactsPopulator.Contact.Builder setPhotoStream(@Nullable ByteArrayOutputStream photoStream) {
      this.photoStream = photoStream;
      return this;
    }
    @Override
    ContactsPopulator.Contact.Builder setPhoneNumbers(List<ContactsPopulator.PhoneNumber> phoneNumbers) {
      if (phoneNumbers == null) {
        throw new NullPointerException("Null phoneNumbers");
      }
      this.phoneNumbers = phoneNumbers;
      return this;
    }
    @Override
    ContactsPopulator.Contact.Builder setEmails(List<ContactsPopulator.Email> emails) {
      if (emails == null) {
        throw new NullPointerException("Null emails");
      }
      this.emails = emails;
      return this;
    }
    @Override
    ContactsPopulator.Contact build() {
      String missing = "";
      if (this.accountType == null) {
        missing += " accountType";
      }
      if (this.accountName == null) {
        missing += " accountName";
      }
      if (this.isStarred == null) {
        missing += " isStarred";
      }
      if (this.pinned == null) {
        missing += " pinned";
      }
      if (this.phoneNumbers == null) {
        missing += " phoneNumbers";
      }
      if (this.emails == null) {
        missing += " emails";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_ContactsPopulator_Contact(
          this.accountType,
          this.accountName,
          this.name,
          this.isStarred,
          this.pinned,
          this.photoStream,
          this.phoneNumbers,
          this.emails);
    }
  }

}
