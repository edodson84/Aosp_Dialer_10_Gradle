/*
 * Copyright (C) 2017 The Android Open Source Project
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
 * limitations under the License.
 */

package com.fissy.dialer.voicemail.listui;

import android.content.Context;
import android.text.TextUtils;

import com.fissy.dialer.R;
import com.fissy.dialer.calllogutils.CallLogDates;
import com.fissy.dialer.common.LogUtil;
import com.fissy.dialer.time.Clock;
import com.fissy.dialer.voicemail.model.VoicemailEntry;
import java.util.concurrent.TimeUnit;

/**
 * Computes the primary text for voicemail entries.
 *
 * <p>These text values are shown in the voicemail tab.
 */
public class VoicemailEntryText {

  public static String buildPrimaryVoicemailText(Context context, VoicemailEntry data) {
    StringBuilder primaryText = new StringBuilder();
    if (!TextUtils.isEmpty(data.getNumberAttributes().getName())) {
      primaryText.append(data.getNumberAttributes().getName());
    } else if (!TextUtils.isEmpty(data.getFormattedNumber())) {
      primaryText.append(data.getFormattedNumber());
    } else {
      // TODO(uabdullah): Handle CallLog.Calls.PRESENTATION_*, including Verizon restricted numbers.
      primaryText.append(context.getText(R.string.voicemail_entry_unknown));
    }
    return primaryText.toString();
  }

  /**
   * Uses the new date and location formatting rules to format the location and date in the new
   * voicemail tab.
   *
   * <p>Rules: $Location • Date
   *
   * <p>Examples:
   *
   * <p>Jun 20 San Francisco • Now
   *
   * <p>Markham, ON • Jul 27
   *
   * <p>Toledo, OH • 12:15 PM
   *
   * <p>Date rules: if < 1 minute ago: "Now"; else if today: HH:MM(am|pm); else if < 3 days: day;
   * else: MON D *
   *
   * @return $Location • Date
   */
  public static String buildSecondaryVoicemailText(
      Context context, Clock clock, VoicemailEntry voicemailEntry) {
    return secondaryTextPrefix(context, clock, voicemailEntry);
  }

  private static String secondaryTextPrefix(
      Context context, Clock clock, VoicemailEntry voicemailEntry) {
    StringBuilder secondaryText = new StringBuilder();
    String location = voicemailEntry.getGeocodedLocation();
    if (!TextUtils.isEmpty(location)) {
      secondaryText.append(location);
    }
    if (secondaryText.length() > 0) {
      secondaryText.append(" • ");
    }
    secondaryText.append(
        CallLogDates.newCallLogTimestampLabel(
            context,
            clock.currentTimeMillis(),
            voicemailEntry.getTimestamp(),
            /* abbreviateDateTime = */ true));

    long duration = voicemailEntry.getDuration();
    if (duration >= 0) {
      secondaryText.append(" • ");
      String formattedDuration = getVoicemailDuration(context, voicemailEntry);
      secondaryText.append(formattedDuration);
    }
    return secondaryText.toString();
  }

  static String getVoicemailDuration(Context context, VoicemailEntry voicemailEntry) {
    long minutes = TimeUnit.SECONDS.toMinutes(voicemailEntry.getDuration());
    long seconds = voicemailEntry.getDuration() - TimeUnit.MINUTES.toSeconds(minutes);

    // The format for duration is "MM:SS" and we never expect the duration to be > 5 minutes
    // However an incorrect duration could be set by the framework/someone to be >99, and in that
    // case cap it at 99, for the UI to still be able to display it in "MM:SS" format.
    if (minutes > 99) {
      LogUtil.w(
          "VoicemailEntryText.getVoicemailDuration",
          "Duration was %d",
          voicemailEntry.getDuration());
      minutes = 99;
    }
    return context.getString(R.string.voicemailDurationFormat, minutes, seconds);
  }
}
