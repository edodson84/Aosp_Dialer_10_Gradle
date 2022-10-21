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
 * limitations under the License
 */

package com.android.incallui.incall.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.android.incallui.sessiondata.MultimediaFragment;
import com.fissy.dialer.common.Assert;
import com.fissy.dialer.multimedia.MultimediaData;

import java.util.Objects;

/**
 * View pager adapter for in call ui.
 */
public class InCallPagerAdapter extends FragmentStatePagerAdapter {

    private final boolean showInCallButtonGrid;
    @Nullable
    private MultimediaData attachments;

    public InCallPagerAdapter(
            FragmentManager fragmentManager,
            @Nullable MultimediaData attachments,
            boolean showInCallButtonGrid) {
        super(fragmentManager);
        this.attachments = attachments;
        this.showInCallButtonGrid = showInCallButtonGrid;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (!showInCallButtonGrid) {
            // TODO(calderwoodra): handle fragment invalidation for when the data changes.
            return MultimediaFragment.newInstance(
                    Objects.requireNonNull(attachments), true /* isInteractive */, false /* showAvatar */, false /* isSpam */);

        } else if (position == getButtonGridPosition()) {
            return InCallButtonGridFragment.newInstance();

        } else {
            return MultimediaFragment.newInstance(
                    Objects.requireNonNull(attachments), true /* isInteractive */, false /* showAvatar */, false /* isSpam */);
        }
    }

    @Override
    public int getCount() {
        int count = 0;
        if (showInCallButtonGrid) {
            count++;
        }
        if (attachments != null && attachments.hasData()) {
            count++;
        }
        Assert.checkArgument(count > 0, "InCallPager adapter doesn't have any pages.");
        return count;
    }

    public void setAttachments(@Nullable MultimediaData attachments) {
        if (this.attachments != attachments) {
            this.attachments = attachments;
            notifyDataSetChanged();
        }
    }

    public int getButtonGridPosition() {
        return getCount() - 1;
    }

    //this is called when notifyDataSetChanged() is called
    @Override
    public int getItemPosition(@NonNull Object object) {
        // refresh all fragments when data set changed
        return PagerAdapter.POSITION_NONE;
    }
}
