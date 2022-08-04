
package com.android.incallui.incall.impl;

import com.android.incallui.incall.protocol.InCallButtonIds;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_MappedButtonConfig_MappingInfo extends MappedButtonConfig.MappingInfo {

  private final int slot;
  private final int slotOrder;
  private final int conflictOrder;
  private final int mutuallyExclusiveButton;

  private AutoValue_MappedButtonConfig_MappingInfo(
      int slot,
      int slotOrder,
      int conflictOrder,
      int mutuallyExclusiveButton) {
    this.slot = slot;
    this.slotOrder = slotOrder;
    this.conflictOrder = conflictOrder;
    this.mutuallyExclusiveButton = mutuallyExclusiveButton;
  }

  @Override
  public int getSlot() {
    return slot;
  }

  @Override
  public int getSlotOrder() {
    return slotOrder;
  }

  @Override
  public int getConflictOrder() {
    return conflictOrder;
  }

  @InCallButtonIds
  @Override
  public int getMutuallyExclusiveButton() {
    return mutuallyExclusiveButton;
  }

  @Override
  public String toString() {
    return "MappingInfo{"
        + "slot=" + slot + ", "
        + "slotOrder=" + slotOrder + ", "
        + "conflictOrder=" + conflictOrder + ", "
        + "mutuallyExclusiveButton=" + mutuallyExclusiveButton
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof MappedButtonConfig.MappingInfo) {
      MappedButtonConfig.MappingInfo that = (MappedButtonConfig.MappingInfo) o;
      return (this.slot == that.getSlot())
           && (this.slotOrder == that.getSlotOrder())
           && (this.conflictOrder == that.getConflictOrder())
           && (this.mutuallyExclusiveButton == that.getMutuallyExclusiveButton());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.slot;
    h *= 1000003;
    h ^= this.slotOrder;
    h *= 1000003;
    h ^= this.conflictOrder;
    h *= 1000003;
    h ^= this.mutuallyExclusiveButton;
    return h;
  }

  static final class Builder extends MappedButtonConfig.MappingInfo.Builder {
    private Integer slot;
    private Integer slotOrder;
    private Integer conflictOrder;
    private Integer mutuallyExclusiveButton;
    Builder() {
    }
    @Override
    public MappedButtonConfig.MappingInfo.Builder setSlot(int slot) {
      this.slot = slot;
      return this;
    }
    @Override
    public MappedButtonConfig.MappingInfo.Builder setSlotOrder(int slotOrder) {
      this.slotOrder = slotOrder;
      return this;
    }
    @Override
    public MappedButtonConfig.MappingInfo.Builder setConflictOrder(int conflictOrder) {
      this.conflictOrder = conflictOrder;
      return this;
    }
    @Override
    public MappedButtonConfig.MappingInfo.Builder setMutuallyExclusiveButton(int mutuallyExclusiveButton) {
      this.mutuallyExclusiveButton = mutuallyExclusiveButton;
      return this;
    }
    @Override
    public MappedButtonConfig.MappingInfo build() {
      String missing = "";
      if (this.slot == null) {
        missing += " slot";
      }
      if (this.slotOrder == null) {
        missing += " slotOrder";
      }
      if (this.conflictOrder == null) {
        missing += " conflictOrder";
      }
      if (this.mutuallyExclusiveButton == null) {
        missing += " mutuallyExclusiveButton";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_MappedButtonConfig_MappingInfo(
          this.slot,
          this.slotOrder,
          this.conflictOrder,
          this.mutuallyExclusiveButton);
    }
  }

}
