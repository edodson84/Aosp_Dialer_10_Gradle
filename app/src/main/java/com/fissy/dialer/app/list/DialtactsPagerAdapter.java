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

package com.fissy.dialer.app.list;

import androidx.fragment.app.Fragment;
import android.view.ViewGroup;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.fissy.dialer.app.calllog.CallLogFragment;
import com.fissy.dialer.common.Assert;
import com.fissy.dialer.common.LogUtil;
import com.fissy.dialer.contactsfragment.ContactsFragment;
import com.fissy.dialer.contactsfragment.ContactsFragment.Header;
import com.fissy.dialer.database.CallLogQueryHandler;
import com.fissy.dialer.util.ViewUtil;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ViewPager adapter for {@link com.fissy.dialer.app.DialtactsActivity}.
 */
public class DialtactsPagerAdapter extends FragmentPagerAdapter {

    public static final int TAB_INDEX_SPEED_DIAL = 0;
    public static final int TAB_INDEX_HISTORY = 1;
    public static final int TAB_INDEX_ALL_CONTACTS = 2;
    public static final int TAB_COUNT_DEFAULT = 3;
    private final List<Fragment> fragments = new ArrayList<>();
    private final String[] tabTitles;
    private OldSpeedDialFragment oldSpeedDialFragment;
    private CallLogFragment callLogFragment;
    private ContactsFragment contactsFragment;

    public DialtactsPagerAdapter(
            FragmentManager fm, String[] tabTitles) {
        super(fm);
        this.tabTitles = tabTitles;
        fragments.addAll(Collections.nCopies(TAB_COUNT_DEFAULT, null));
    }

    @Override
    public long getItemId(int position) {
        return getRtlPosition(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        LogUtil.d("ViewPagerAdapter.getItem", "position: %d", position);
        switch (getRtlPosition(position)) {
            case TAB_INDEX_SPEED_DIAL:
                if (oldSpeedDialFragment == null) {
                    oldSpeedDialFragment = new OldSpeedDialFragment();
                }
                return oldSpeedDialFragment;
            case TAB_INDEX_HISTORY:
                if (callLogFragment == null) {
                    callLogFragment = new CallLogFragment(CallLogQueryHandler.CALL_TYPE_ALL);
                }
                return callLogFragment;
            case TAB_INDEX_ALL_CONTACTS:
                if (contactsFragment == null) {
                    contactsFragment = ContactsFragment.newInstance(Header.ADD_CONTACT);
                }
                return contactsFragment;
            default:
                throw Assert.createIllegalStateFailException("No fragment at position " + position);
        }
    }

    @NonNull
    @Override
    public Fragment instantiateItem(@NonNull ViewGroup container, int position) {
        LogUtil.d("ViewPagerAdapter.instantiateItem", "position: %d", position);
        // On rotation the FragmentManager handles rotation. Therefore getItem() isn't called.
        // Copy the fragments that the FragmentManager finds so that we can store them in
        // instance variables for later.
        final Fragment fragment = (Fragment) super.instantiateItem(container, position);
        if (fragment instanceof OldSpeedDialFragment) {
            oldSpeedDialFragment = (OldSpeedDialFragment) fragment;
        } else if (fragment instanceof CallLogFragment && position == TAB_INDEX_HISTORY) {
            callLogFragment = (CallLogFragment) fragment;
        } else if (fragment instanceof ContactsFragment) {
            contactsFragment = (ContactsFragment) fragment;
        }
        fragments.set(position, fragment);
        return fragment;
    }

    /**
     * When {@link PagerAdapter#notifyDataSetChanged} is called, this method
     * is called on all pages to determine whether they need to be recreated. When the voicemail tab
     * is removed, the view needs to be recreated by returning POSITION_NONE. If notifyDataSetChanged
     * is called for some other reason, the voicemail tab is recreated only if it is active. All other
     * tabs do not need to be recreated and POSITION_UNCHANGED is returned.
     */
    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_UNCHANGED;
    }

    @Override
    public int getCount() {
        return TAB_COUNT_DEFAULT;
    }

    @Override
    public CharSequence getPageTitle(@TabIndex int position) {
        return tabTitles[position];
    }

    public int getRtlPosition(int position) {
        if (ViewUtil.isRtl()) {
            return getCount() - 1 - position;
        }
        return position;
    }

    /**
     * IntDef for indices of ViewPager tabs.
     */
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({TAB_INDEX_SPEED_DIAL, TAB_INDEX_HISTORY, TAB_INDEX_ALL_CONTACTS})
    public @interface TabIndex {
    }
}
