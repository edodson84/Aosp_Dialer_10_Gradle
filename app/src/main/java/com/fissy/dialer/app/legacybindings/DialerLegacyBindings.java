/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.fissy.dialer.app.legacybindings;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import com.fissy.dialer.app.calllog.CallLogAdapter;
import com.fissy.dialer.app.calllog.calllogcache.CallLogCache;
import com.fissy.dialer.app.contactinfo.ContactInfoCache;
import com.fissy.dialer.app.voicemail.VoicemailPlaybackPresenter;
import com.fissy.dialer.blocking.FilteredNumberAsyncQueryHandler;

/**
 * These are old bindings between Dialer and the container application. All new bindings should be
 * added to the bindings module and not here.
 */
public interface DialerLegacyBindings {

  /**
   * activityType must be one of following constants: CallLogAdapter.ACTIVITY_TYPE_CALL_LOG, or
   * CallLogAdapter.ACTIVITY_TYPE_DIALTACTS.
   */
  CallLogAdapter newCallLogAdapter(
      Activity activity,
      ViewGroup alertContainer,
      CallLogAdapter.CallFetcher callFetcher,
      CallLogAdapter.MultiSelectRemoveView multiSelectRemoveView,
      CallLogAdapter.OnActionModeStateChangedListener actionModeStateChangedListener,
      CallLogCache callLogCache,
      ContactInfoCache contactInfoCache,
      VoicemailPlaybackPresenter voicemailPlaybackPresenter,
      @NonNull FilteredNumberAsyncQueryHandler filteredNumberAsyncQueryHandler,
      int activityType);
}
