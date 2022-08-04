
package com.fissy.dialer.preferredsim;

import android.telecom.PhoneAccountHandle;
import com.android.contacts.common.widget.SelectPhoneAccountDialogOptions;
import com.fissy.dialer.preferredsim.suggestion.SuggestionProvider;
import com.google.common.base.Optional;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_PreferredAccountWorker_Result extends PreferredAccountWorker.Result {

  private final Optional<PhoneAccountHandle> selectedPhoneAccountHandle;
  private final Optional<SelectPhoneAccountDialogOptions.Builder> dialogOptionsBuilder;
  private final Optional<String> dataId;
  private final Optional<SuggestionProvider.Suggestion> suggestion;

  private AutoValue_PreferredAccountWorker_Result(
      Optional<PhoneAccountHandle> selectedPhoneAccountHandle,
      Optional<SelectPhoneAccountDialogOptions.Builder> dialogOptionsBuilder,
      Optional<String> dataId,
      Optional<SuggestionProvider.Suggestion> suggestion) {
    this.selectedPhoneAccountHandle = selectedPhoneAccountHandle;
    this.dialogOptionsBuilder = dialogOptionsBuilder;
    this.dataId = dataId;
    this.suggestion = suggestion;
  }

  @Override
  public Optional<PhoneAccountHandle> getSelectedPhoneAccountHandle() {
    return selectedPhoneAccountHandle;
  }

  @Override
  public Optional<SelectPhoneAccountDialogOptions.Builder> getDialogOptionsBuilder() {
    return dialogOptionsBuilder;
  }

  @Override
  public Optional<String> getDataId() {
    return dataId;
  }

  @Override
  public Optional<SuggestionProvider.Suggestion> getSuggestion() {
    return suggestion;
  }

  @Override
  public String toString() {
    return "Result{"
        + "selectedPhoneAccountHandle=" + selectedPhoneAccountHandle + ", "
        + "dialogOptionsBuilder=" + dialogOptionsBuilder + ", "
        + "dataId=" + dataId + ", "
        + "suggestion=" + suggestion
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PreferredAccountWorker.Result) {
      PreferredAccountWorker.Result that = (PreferredAccountWorker.Result) o;
      return (this.selectedPhoneAccountHandle.equals(that.getSelectedPhoneAccountHandle()))
           && (this.dialogOptionsBuilder.equals(that.getDialogOptionsBuilder()))
           && (this.dataId.equals(that.getDataId()))
           && (this.suggestion.equals(that.getSuggestion()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.selectedPhoneAccountHandle.hashCode();
    h *= 1000003;
    h ^= this.dialogOptionsBuilder.hashCode();
    h *= 1000003;
    h ^= this.dataId.hashCode();
    h *= 1000003;
    h ^= this.suggestion.hashCode();
    return h;
  }

  static final class Builder extends PreferredAccountWorker.Result.Builder {
    private Optional<PhoneAccountHandle> selectedPhoneAccountHandle = Optional.absent();
    private Optional<SelectPhoneAccountDialogOptions.Builder> dialogOptionsBuilder = Optional.absent();
    private Optional<String> dataId = Optional.absent();
    private Optional<SuggestionProvider.Suggestion> suggestion = Optional.absent();
    Builder() {
    }
    @Override
    PreferredAccountWorker.Result.Builder setSelectedPhoneAccountHandle(PhoneAccountHandle selectedPhoneAccountHandle) {
      if (selectedPhoneAccountHandle == null) {
        throw new NullPointerException("Null selectedPhoneAccountHandle");
      }
      this.selectedPhoneAccountHandle = Optional.of(selectedPhoneAccountHandle);
      return this;
    }
    @Override
    PreferredAccountWorker.Result.Builder setDialogOptionsBuilder(SelectPhoneAccountDialogOptions.Builder dialogOptionsBuilder) {
      if (dialogOptionsBuilder == null) {
        throw new NullPointerException("Null dialogOptionsBuilder");
      }
      this.dialogOptionsBuilder = Optional.of(dialogOptionsBuilder);
      return this;
    }
    @Override
    public PreferredAccountWorker.Result.Builder setDataId(String dataId) {
      if (dataId == null) {
        throw new NullPointerException("Null dataId");
      }
      this.dataId = Optional.of(dataId);
      return this;
    }
    @Override
    public PreferredAccountWorker.Result.Builder setSuggestion(SuggestionProvider.Suggestion suggestion) {
      if (suggestion == null) {
        throw new NullPointerException("Null suggestion");
      }
      this.suggestion = Optional.of(suggestion);
      return this;
    }
    @Override
    public PreferredAccountWorker.Result build() {
      return new AutoValue_PreferredAccountWorker_Result(
          this.selectedPhoneAccountHandle,
          this.dialogOptionsBuilder,
          this.dataId,
          this.suggestion);
    }
  }

}
