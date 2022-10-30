/*
 * Copyright (C) 2013 The Android Open Source Project
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
package com.fissy.dialer.app.settings;

import static com.fissy.dialer.app.settings.DialerSettingsActivity.PrefsFragment.ThemeButtonBehavior.DARK;
import static com.fissy.dialer.app.settings.DialerSettingsActivity.PrefsFragment.ThemeButtonBehavior.LIGHT;
import static com.fissy.dialer.app.settings.DialerSettingsActivity.PrefsFragment.ThemeButtonBehavior.SYSTEM;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.Settings;
import android.telecom.TelecomManager;
import android.telephony.CarrierConfigManager;
import android.telephony.TelephonyManager;
import android.view.MenuItem;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.preference.CheckBoxPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;

import com.fissy.dialer.R;
import com.fissy.dialer.blocking.FilteredNumberCompat;
import com.fissy.dialer.callrecord.impl.CallRecorderService;
import com.fissy.dialer.common.LogUtil;
import com.fissy.dialer.compat.telephony.TelephonyManagerCompat;
import com.fissy.dialer.lookup.LookupSettings;
import com.fissy.dialer.main.impl.MainActivity;
import com.fissy.dialer.main.impl.MainActivityPeer;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.Objects;


public class DialerSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LogUtil.enterBlock("DialerSettingsActivity.onCreate");
        PrefsFragment.ThemeButtonBehavior mThemeBehavior = PrefsFragment.getThemeButtonBehavior(MainActivityPeer.themeprefs);

        if (mThemeBehavior == PrefsFragment.ThemeButtonBehavior.DARK) {
            getTheme().applyStyle(R.style.DialerDark, true);
        }
        if (mThemeBehavior == PrefsFragment.ThemeButtonBehavior.LIGHT) {
            getTheme().applyStyle(R.style.DialerLight, true);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);
        CollapsingToolbarLayout coll_toolbar = findViewById(R.id.collapsing_toolbar_layout);
        coll_toolbar.setTitle("Settings");

        // Create the prefs fragment in code to ensure it's created before PreferenceDialogFragment
        if (savedInstanceState == null) {
            String PREFS_FRAGMENT_TAG = "prefs_fragment";
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main, new PrefsFragment(), PREFS_FRAGMENT_TAG)
                    .disallowAddToBackStack()
                    .commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
    }

    public static class PrefsFragment extends PreferenceFragmentCompat implements
            Preference.OnPreferenceChangeListener,
            Preference.OnPreferenceClickListener {

        public static final String KEY_THEME = "key_theme";
        public static final String SYSTEM_THEME_BEHAVIOR = "0";
        public static final String THEME_BEHAVIOR_DARK = "1";
        public static final String THEME_BEHAVIOR_LIGHT = "2";
        private static final String SHARED_PREFERENCES_NAME = "theme_settings";
        private static final String KEY_ENABLE_FORWARD_LOOKUP = "enable_forward_lookup";
        private static final String KEY_RINGTONE = "button_ringtone_key";
        private static final String KEY_VIBRATE = "button_vibrate_on_ring";
        private static final String KEY_DTMF_TONE_LENGTH = "button_dtmf_settings";
        private static final String KEY_DTMF_TONE = "button_play_dtmf_tone";
        private static final String KEY_QUICK_RESPONSE = "quick_response_key";
        private static final String KEY_CALL_SETTINGS = "call_settings_key";
        private static final String KEY_CALL_BLOCKING = "call_blocking_key";
        private static final String KEY_ACCESSIBILITY = "accessibility_key";
        private static final int NO_DTMF_TONE = 0;
        private static final int PLAY_DTMF_TONE = 1;
        private static final int NO_VIBRATION_FOR_CALLS = 0;
        private static final int DO_VIBRATION_FOR_CALLS = 1;
        private static final int DTMF_TONE_TYPE_NORMAL = 0;
        ListPreference mDtmfToneLength;
        CheckBoxPreference mPlayDtmfTone;
        CheckBoxPreference mVibrateWhenRinging;
        SwitchPreferenceCompat Lookup;
        private String existingValue;
        final ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Uri ringtone = Objects.requireNonNull(result.getData()).getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI);
                            if (ringtone != null) {
                                existingValue = ringtone.toString();
                            } else {
                                // "Silent" was selected
                                existingValue = "";
                            }
                        }
                    }
                });

        public static SharedPreferences getSharedPreferences(Context context) {
            return context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        }

        public static ThemeButtonBehavior getThemeButtonBehavior(SharedPreferences prefs) {
            final String value = prefs.getString(KEY_THEME, SYSTEM_THEME_BEHAVIOR);
            switch (value) {
                case SYSTEM_THEME_BEHAVIOR:
                    return SYSTEM;
                case THEME_BEHAVIOR_DARK:
                    return DARK;
                case THEME_BEHAVIOR_LIGHT:
                    return LIGHT;
                default:
                    throw new IllegalArgumentException("Unknown theme button behavior: " + value);
            }
        }

        @Override
        public boolean onPreferenceClick(@NonNull Preference preference) {
            if (preference.getKey().equals(KEY_DTMF_TONE)) {
                Settings.System.putInt(requireActivity().getContentResolver(),
                        Settings.System.DTMF_TONE_WHEN_DIALING,
                        mPlayDtmfTone.isChecked() ? PLAY_DTMF_TONE : NO_DTMF_TONE);
            }
            if (preference.getKey().equals(KEY_QUICK_RESPONSE)) {
                Intent quickResponseSettingsIntent = new Intent(TelecomManager.ACTION_SHOW_RESPOND_VIA_SMS_SETTINGS);
                startActivity(quickResponseSettingsIntent);
            }
            if (preference.getKey().equals(KEY_CALL_SETTINGS)) {
                Intent phoneAccountSettingsIntent = new Intent(TelecomManager.ACTION_CHANGE_PHONE_ACCOUNTS);
                phoneAccountSettingsIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(phoneAccountSettingsIntent);
            }
            if (preference.getKey().equals(KEY_CALL_BLOCKING)) {
                if (FilteredNumberCompat.canCurrentUserOpenBlockSettings(getContext())) {
                    Intent blockingSettingsIntent = FilteredNumberCompat.createManageBlockedNumbersIntent(getContext());
                    startActivity(blockingSettingsIntent);
                }
            }
            if (preference.getKey().equals(KEY_ACCESSIBILITY)) {
                TelephonyManager telephonyManager =
                        (TelephonyManager) requireActivity().getSystemService(Context.TELEPHONY_SERVICE);
                if ((TelephonyManagerCompat.isTtyModeSupported(telephonyManager)
                        || TelephonyManagerCompat.isHearingAidCompatibilitySupported(telephonyManager))) {
                    Intent accessSettingsIntent = new Intent(TelecomManager.ACTION_SHOW_CALL_ACCESSIBILITY_SETTINGS);
                    startActivity(accessSettingsIntent);
                }
            }
            return true;
        }

        @Override
        public void onCreatePreferences(Bundle bundle, String rootKey) {
            addPreferencesFromResource(R.xml.settings);
            Context context = getContext();
            ListPreference Theme = findPreference(KEY_THEME);
            Objects.requireNonNull(Theme).setSummary(Theme.getEntry());
            Theme.setOnPreferenceChangeListener(this);
            Lookup = findPreference(KEY_ENABLE_FORWARD_LOOKUP);
            Objects.requireNonNull(Lookup).setChecked(LookupSettings.isForwardLookupEnabled(context));
            Lookup.setOnPreferenceChangeListener(this);
            Preference Ringtone = findPreference(KEY_RINGTONE);

            Objects.requireNonNull(Ringtone).setOnPreferenceClickListener(preference -> {
                Intent intent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
                intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, RingtoneManager.TYPE_RINGTONE);
                intent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_DEFAULT, true);
                intent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_SILENT, true);
                intent.putExtra(RingtoneManager.EXTRA_RINGTONE_DEFAULT_URI, Settings.System.DEFAULT_RINGTONE_URI);

                if (existingValue != null) {
                    if (existingValue.length() == 0) {
                        // Select "Silent"
                        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_EXISTING_URI, (Uri) null);
                    } else {
                        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_EXISTING_URI, Uri.parse(existingValue));
                    }
                } else {
                    // No ringtone has been selected, set to the default
                    intent.putExtra(RingtoneManager.EXTRA_RINGTONE_EXISTING_URI, Settings.System.DEFAULT_RINGTONE_URI);
                }
                mStartForResult.launch(intent);
                return true;
            });

            Preference Quickresponses = findPreference(KEY_QUICK_RESPONSE);
            Objects.requireNonNull(Quickresponses).setOnPreferenceClickListener(this);
            Preference Callsettings = findPreference(KEY_CALL_SETTINGS);
            Objects.requireNonNull(Callsettings).setOnPreferenceClickListener(this);
            Preference Callblocking = findPreference(KEY_CALL_BLOCKING);
            Objects.requireNonNull(Callblocking).setOnPreferenceClickListener(this);
            Preference Accessibility = findPreference(KEY_ACCESSIBILITY);
            Objects.requireNonNull(Accessibility).setOnPreferenceClickListener(this);
            mVibrateWhenRinging = findPreference(
                    Objects.requireNonNull(context).getString(R.string.vibrate_on_preference_key));
            mPlayDtmfTone = findPreference(
                    context.getString(R.string.play_dtmf_preference_key));
            mDtmfToneLength = findPreference(
                    context.getString(R.string.dtmf_tone_length_preference_key));

            if (hasVibrator()) {
                Objects.requireNonNull(mVibrateWhenRinging).setOnPreferenceChangeListener(this);
            } else {
                getPreferenceScreen().removePreferenceRecursively(context.getString(R.string.vibrate_on_preference_key));
            }

            Objects.requireNonNull(mPlayDtmfTone).setOnPreferenceChangeListener(this);
            mPlayDtmfTone.setChecked(shouldPlayDtmfTone());

            TelephonyManager telephonyManager =
                    (TelephonyManager) requireActivity().getSystemService(Context.TELEPHONY_SERVICE);
            if (telephonyManager.canChangeDtmfToneLength()
                    && (telephonyManager.isWorldPhone() || !shouldHideCarrierSettings())) {
                Objects.requireNonNull(mDtmfToneLength).setOnPreferenceChangeListener(this);
                mDtmfToneLength.setValueIndex(
                        Settings.System.getInt(context.getContentResolver(),
                                Settings.System.DTMF_TONE_TYPE_WHEN_DIALING,
                                DTMF_TONE_TYPE_NORMAL));
            } else {
                getPreferenceScreen().removePreferenceRecursively(context.getString(R.string.dtmf_tone_length_preference_key));
            }
            if (!CallRecorderService.isEnabled(requireActivity())) {
                getPreferenceScreen().removePreferenceRecursively(context.getString(R.string.call_recording_category_key));
            }

        }

        @Override
        public void onResume() {
            super.onResume();
            if (mVibrateWhenRinging != null) {
                mVibrateWhenRinging.setChecked(shouldVibrateWhenRinging());
            }
            Context context = getContext();
            Lookup.setChecked(LookupSettings.isForwardLookupEnabled(context));
        }

        @Override
        public boolean onPreferenceChange(@NonNull Preference pref, Object newValue) {
            Context context = getContext();
            if (KEY_THEME.equals(pref.getKey())) {
                ListPreference preference = (ListPreference) pref;
                int index = preference.findIndexOfValue((String) newValue);
                preference.setSummary(preference.getEntries()[index]);
                settheme(context, newValue.toString());
                MainActivity.main.recreate();
                requireActivity().recreate();
            }
            if (KEY_ENABLE_FORWARD_LOOKUP.equals(pref.getKey())) {
                LookupSettings.setForwardLookupEnabled(context, (Boolean) newValue);
            }
            if (KEY_VIBRATE.equals(pref.getKey())) {
                boolean doVibrate = (Boolean) newValue;
                Settings.System.putInt(requireActivity().getContentResolver(),
                        Settings.System.VIBRATE_WHEN_RINGING,
                        doVibrate ? DO_VIBRATION_FOR_CALLS : NO_VIBRATION_FOR_CALLS);
            }
            if (KEY_DTMF_TONE_LENGTH.equals(pref.getKey())) {
                int index = mDtmfToneLength.findIndexOfValue((String) newValue);
                Settings.System.putInt(requireActivity().getContentResolver(),
                        Settings.System.DTMF_TONE_TYPE_WHEN_DIALING, index);
            }
            return true;
        }

        public void settheme(Context context, String value) {
            getSharedPreferences(context).edit().putString(KEY_THEME, value).apply();
        }

        private boolean hasVibrator() {
            Vibrator vibrator = (Vibrator) requireActivity().getSystemService(Context.VIBRATOR_SERVICE);
            return vibrator != null && vibrator.hasVibrator();
        }

        private boolean shouldVibrateWhenRinging() {
            int vibrateWhenRingingSetting = Settings.System.getInt(requireActivity().getContentResolver(),
                    Settings.System.VIBRATE_WHEN_RINGING,
                    NO_VIBRATION_FOR_CALLS);
            return hasVibrator() && (vibrateWhenRingingSetting == DO_VIBRATION_FOR_CALLS);
        }

        private boolean shouldPlayDtmfTone() {
            int dtmfToneSetting = Settings.System.getInt(requireActivity().getContentResolver(),
                    Settings.System.DTMF_TONE_WHEN_DIALING,
                    PLAY_DTMF_TONE);
            return dtmfToneSetting == PLAY_DTMF_TONE;
        }

        private boolean shouldHideCarrierSettings() {
            CarrierConfigManager configManager = (CarrierConfigManager) requireActivity().getSystemService(
                    Context.CARRIER_CONFIG_SERVICE);
            if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
            return configManager.getConfig().getBoolean(
                    CarrierConfigManager.KEY_HIDE_CARRIER_NETWORK_SETTINGS_BOOL);
        }

        public enum ThemeButtonBehavior {SYSTEM, DARK, LIGHT}

    }
}
