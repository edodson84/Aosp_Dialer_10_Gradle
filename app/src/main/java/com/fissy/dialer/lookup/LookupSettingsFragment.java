/*
 * Copyright (C) 2014 The CyanogenMod Project
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

package com.fissy.dialer.lookup;

import android.content.Context;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;

import com.fissy.dialer.R;

public class LookupSettingsFragment extends PreferenceFragment
        implements Preference.OnPreferenceChangeListener {

    private static final String KEY_ENABLE_FORWARD_LOOKUP = "enable_forward_lookup";

    private SwitchPreference enableForwardLookup;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.lookup_settings);

        enableForwardLookup = (SwitchPreference) findPreference(KEY_ENABLE_FORWARD_LOOKUP);

        enableForwardLookup.setOnPreferenceChangeListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();

        restoreLookupProviderSwitches();
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        Context context = getContext();

        if (preference == enableForwardLookup) {
            LookupSettings.setForwardLookupEnabled(context, (Boolean) newValue);
        }

        return true;
    }

    private void restoreLookupProviderSwitches() {
        Context context = getContext();

        enableForwardLookup.setChecked(LookupSettings.isForwardLookupEnabled(context));
    }
}
