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

package com.fissy.dialer.app.settings;


import static com.fissy.dialer.app.settings.ThemeOptionsSettingsFragment.ThemeButtonBehavior.DARK;
import static com.fissy.dialer.app.settings.ThemeOptionsSettingsFragment.ThemeButtonBehavior.LIGHT;
import static com.fissy.dialer.app.settings.ThemeOptionsSettingsFragment.ThemeButtonBehavior.SYSTEM;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import com.fissy.dialer.R;
import com.fissy.dialer.app.calllog.CallLogFragment;
import com.fissy.dialer.main.impl.MainActivity;

public class ThemeOptionsSettingsFragment extends PreferenceFragment
        implements Preference.OnPreferenceChangeListener {

    public static final String KEY_THEME = "key_theme";
    public static final String SYSTEM_THEME_BEHAVIOR = "0";
    public static final String THEME_BEHAVIOR_DARK = "1";
    public static final String THEME_BEHAVIOR_LIGHT = "2";
    private static final String SHARED_PREFERENCES_NAME = "theme_settings";
    ListPreference theme;

    public static void settheme(Context context, String value) {
        getSharedPreferences(context).edit().putString(KEY_THEME, value).commit();
    }

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.theme_options_settings);
        Context context = getContext();
        theme = (ListPreference) findPreference(
                context.getString(R.string.theme_options_key));
        theme.setOnPreferenceChangeListener(this);
    }

    @Override
    public void onResume() {

        super.onResume();
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        Context context = getContext();
        if (preference == theme) {
            settheme(context, newValue.toString());
            MainActivity.main.recreate();
            getActivity().recreate();
        }
        return true;
    }

    public enum ThemeButtonBehavior {SYSTEM, DARK, LIGHT}

}
