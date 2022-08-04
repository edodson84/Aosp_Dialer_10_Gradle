
package com.android.bubble;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import java.util.List;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_BubbleInfo extends BubbleInfo {

  private final int primaryColor;
  private final Icon primaryIcon;
  private final Drawable avatar;
  private final int startingYPosition;
  private final List<BubbleInfo.Action> actions;

  private AutoValue_BubbleInfo(
      int primaryColor,
      Icon primaryIcon,
      @Nullable Drawable avatar,
      int startingYPosition,
      List<BubbleInfo.Action> actions) {
    this.primaryColor = primaryColor;
    this.primaryIcon = primaryIcon;
    this.avatar = avatar;
    this.startingYPosition = startingYPosition;
    this.actions = actions;
  }

  @ColorInt
  @Override
  public int getPrimaryColor() {
    return primaryColor;
  }

  @Override
  public Icon getPrimaryIcon() {
    return primaryIcon;
  }

  @Nullable
  @Override
  public Drawable getAvatar() {
    return avatar;
  }

  @Px
  @Override
  public int getStartingYPosition() {
    return startingYPosition;
  }

  @NonNull
  @Override
  public List<BubbleInfo.Action> getActions() {
    return actions;
  }

  @Override
  public String toString() {
    return "BubbleInfo{"
        + "primaryColor=" + primaryColor + ", "
        + "primaryIcon=" + primaryIcon + ", "
        + "avatar=" + avatar + ", "
        + "startingYPosition=" + startingYPosition + ", "
        + "actions=" + actions
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof BubbleInfo) {
      BubbleInfo that = (BubbleInfo) o;
      return (this.primaryColor == that.getPrimaryColor())
           && (this.primaryIcon.equals(that.getPrimaryIcon()))
           && ((this.avatar == null) ? (that.getAvatar() == null) : this.avatar.equals(that.getAvatar()))
           && (this.startingYPosition == that.getStartingYPosition())
           && (this.actions.equals(that.getActions()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.primaryColor;
    h *= 1000003;
    h ^= this.primaryIcon.hashCode();
    h *= 1000003;
    h ^= (avatar == null) ? 0 : this.avatar.hashCode();
    h *= 1000003;
    h ^= this.startingYPosition;
    h *= 1000003;
    h ^= this.actions.hashCode();
    return h;
  }

  static final class Builder extends BubbleInfo.Builder {
    private Integer primaryColor;
    private Icon primaryIcon;
    private Drawable avatar;
    private Integer startingYPosition;
    private List<BubbleInfo.Action> actions;
    Builder() {
    }
    @Override
    public BubbleInfo.Builder setPrimaryColor(int primaryColor) {
      this.primaryColor = primaryColor;
      return this;
    }
    @Override
    public BubbleInfo.Builder setPrimaryIcon(Icon primaryIcon) {
      if (primaryIcon == null) {
        throw new NullPointerException("Null primaryIcon");
      }
      this.primaryIcon = primaryIcon;
      return this;
    }
    @Override
    public BubbleInfo.Builder setAvatar(@Nullable Drawable avatar) {
      this.avatar = avatar;
      return this;
    }
    @Override
    public BubbleInfo.Builder setStartingYPosition(int startingYPosition) {
      this.startingYPosition = startingYPosition;
      return this;
    }
    @Override
    public BubbleInfo.Builder setActions(List<BubbleInfo.Action> actions) {
      if (actions == null) {
        throw new NullPointerException("Null actions");
      }
      this.actions = actions;
      return this;
    }
    @Override
    public BubbleInfo build() {
      String missing = "";
      if (this.primaryColor == null) {
        missing += " primaryColor";
      }
      if (this.primaryIcon == null) {
        missing += " primaryIcon";
      }
      if (this.startingYPosition == null) {
        missing += " startingYPosition";
      }
      if (this.actions == null) {
        missing += " actions";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_BubbleInfo(
          this.primaryColor,
          this.primaryIcon,
          this.avatar,
          this.startingYPosition,
          this.actions);
    }
  }

}
