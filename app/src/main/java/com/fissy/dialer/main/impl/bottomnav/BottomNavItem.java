/*
 * Copyright (C) 2018 The Android Open Source Project
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

package com.fissy.dialer.main.impl.bottomnav;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StringRes;

import com.fissy.dialer.R;
import com.fissy.dialer.ThemeUtils;
import com.fissy.dialer.common.Assert;
import com.fissy.dialer.configprovider.ConfigProviderComponent;

/**
 * Navigation item in a bottom nav.
 */
public final class BottomNavItem extends LinearLayout {

    private ImageView image;
    private TextView text;
    private TextView notificationBadge;

    public BottomNavItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        image = findViewById(R.id.bottom_nav_item_image);
        text = findViewById(R.id.bottom_nav_item_text);
        notificationBadge = findViewById(R.id.notification_badge);

    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if (selected) {
            image.setBackgroundTintList(ColorStateList.valueOf(ThemeUtils.resolveColor(getContext(), R.attr.colorPrimary)));
            image.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.white, null)));
            text.setTextColor(ColorStateList.valueOf(ThemeUtils.resolveColor(getContext(), R.attr.colorPrimary)));
        } else {
            image.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(android.R.color.transparent, null)));
            image.setImageTintList(ColorStateList.valueOf(ThemeUtils.resolveColor(getContext(), android.R.attr.colorControlNormal)));
            text.setTextColor(ColorStateList.valueOf(ThemeUtils.resolveColor(getContext(), android.R.attr.colorControlNormal)));
        }
    }

    void setup(@StringRes int stringRes, @DrawableRes int drawableRes) {
        text.setText(stringRes);
        image.setImageResource(drawableRes);
    }

    void setNotificationCount(int count) {
        Assert.checkArgument(count >= 0, "Invalid count: " + count);
        if (count == 0) {
            notificationBadge.setVisibility(View.INVISIBLE);
        } else {
            String countString = Integer.toString(count);

            boolean use99PlusCount =
                    ConfigProviderComponent.get(getContext())
                            .getConfigProvider()
                            .getBoolean("use_99_plus", false);
            boolean use9Plus = !use99PlusCount;

            if (use99PlusCount && count > 99) {
                countString = getContext().getString(R.string.bottom_nav_count_99_plus);
            } else if (use9Plus && count > 9) {
                countString = getContext().getString(R.string.bottom_nav_count_9_plus);
            }
            notificationBadge.setVisibility(View.VISIBLE);
            notificationBadge.setText(countString);

            @Px int margin;
            if (countString.length() == 1) {
                margin = getContext().getResources().getDimensionPixelSize(R.dimen.badge_margin_length_1);
            } else if (countString.length() == 2) {
                margin = getContext().getResources().getDimensionPixelSize(R.dimen.badge_margin_length_2);
            } else {
                margin = getContext().getResources().getDimensionPixelSize(R.dimen.badge_margin_length_3);
            }

            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) image.getLayoutParams();
            params.setMarginStart(margin);
            params.setMarginEnd(margin);
            image.setLayoutParams(params);
        }
    }
}
