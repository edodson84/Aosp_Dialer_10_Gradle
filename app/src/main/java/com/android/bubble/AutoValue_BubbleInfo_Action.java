
package com.android.bubble;

import android.app.PendingIntent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_BubbleInfo_Action extends BubbleInfo.Action {

  private final Drawable iconDrawable;
  private final Drawable secondaryIconDrawable;
  private final CharSequence name;
  private final PendingIntent intent;
  private final boolean checkable;
  private final boolean checked;

  private AutoValue_BubbleInfo_Action(
      Drawable iconDrawable,
      @Nullable Drawable secondaryIconDrawable,
      CharSequence name,
      PendingIntent intent,
      boolean checkable,
      boolean checked) {
    this.iconDrawable = iconDrawable;
    this.secondaryIconDrawable = secondaryIconDrawable;
    this.name = name;
    this.intent = intent;
    this.checkable = checkable;
    this.checked = checked;
  }

  @Override
  public Drawable getIconDrawable() {
    return iconDrawable;
  }

  @Nullable
  @Override
  public Drawable getSecondaryIconDrawable() {
    return secondaryIconDrawable;
  }

  @NonNull
  @Override
  public CharSequence getName() {
    return name;
  }

  @NonNull
  @Override
  public PendingIntent getIntent() {
    return intent;
  }

  @Override
  public boolean isCheckable() {
    return checkable;
  }

  @Override
  public boolean isChecked() {
    return checked;
  }

  @Override
  public String toString() {
    return "Action{"
        + "iconDrawable=" + iconDrawable + ", "
        + "secondaryIconDrawable=" + secondaryIconDrawable + ", "
        + "name=" + name + ", "
        + "intent=" + intent + ", "
        + "checkable=" + checkable + ", "
        + "checked=" + checked
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof BubbleInfo.Action) {
      BubbleInfo.Action that = (BubbleInfo.Action) o;
      return (this.iconDrawable.equals(that.getIconDrawable()))
           && ((this.secondaryIconDrawable == null) ? (that.getSecondaryIconDrawable() == null) : this.secondaryIconDrawable.equals(that.getSecondaryIconDrawable()))
           && (this.name.equals(that.getName()))
           && (this.intent.equals(that.getIntent()))
           && (this.checkable == that.isCheckable())
           && (this.checked == that.isChecked());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.iconDrawable.hashCode();
    h *= 1000003;
    h ^= (secondaryIconDrawable == null) ? 0 : this.secondaryIconDrawable.hashCode();
    h *= 1000003;
    h ^= this.name.hashCode();
    h *= 1000003;
    h ^= this.intent.hashCode();
    h *= 1000003;
    h ^= this.checkable ? 1231 : 1237;
    h *= 1000003;
    h ^= this.checked ? 1231 : 1237;
    return h;
  }

  static final class Builder extends BubbleInfo.Action.Builder {
    private Drawable iconDrawable;
    private Drawable secondaryIconDrawable;
    private CharSequence name;
    private PendingIntent intent;
    private Boolean checkable;
    private Boolean checked;
    Builder() {
    }
    @Override
    public BubbleInfo.Action.Builder setIconDrawable(Drawable iconDrawable) {
      if (iconDrawable == null) {
        throw new NullPointerException("Null iconDrawable");
      }
      this.iconDrawable = iconDrawable;
      return this;
    }
    @Override
    public BubbleInfo.Action.Builder setSecondaryIconDrawable(@Nullable Drawable secondaryIconDrawable) {
      this.secondaryIconDrawable = secondaryIconDrawable;
      return this;
    }
    @Override
    public BubbleInfo.Action.Builder setName(CharSequence name) {
      if (name == null) {
        throw new NullPointerException("Null name");
      }
      this.name = name;
      return this;
    }
    @Override
    public BubbleInfo.Action.Builder setIntent(PendingIntent intent) {
      if (intent == null) {
        throw new NullPointerException("Null intent");
      }
      this.intent = intent;
      return this;
    }
    @Override
    public BubbleInfo.Action.Builder setCheckable(boolean checkable) {
      this.checkable = checkable;
      return this;
    }
    @Override
    public BubbleInfo.Action.Builder setChecked(boolean checked) {
      this.checked = checked;
      return this;
    }
    @Override
    public BubbleInfo.Action build() {
      String missing = "";
      if (this.iconDrawable == null) {
        missing += " iconDrawable";
      }
      if (this.name == null) {
        missing += " name";
      }
      if (this.intent == null) {
        missing += " intent";
      }
      if (this.checkable == null) {
        missing += " checkable";
      }
      if (this.checked == null) {
        missing += " checked";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_BubbleInfo_Action(
          this.iconDrawable,
          this.secondaryIconDrawable,
          this.name,
          this.intent,
          this.checkable,
          this.checked);
    }
  }

}
