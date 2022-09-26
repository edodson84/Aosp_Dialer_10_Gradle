/*
 * Copyright (C) 2014 The Android Open Source Project
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

package com.android.phone.common.dialpad;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.RippleDrawable;
import android.text.Spannable;
import android.text.style.TtsSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fissy.dialer.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * View that displays a twelve-key phone dialpad.
 */
public class DialpadView extends LinearLayout {

    private final ColorStateList mRippleColor;
    private final int[] mButtonIds = new int[]{R.id.zero, R.id.one, R.id.two, R.id.three,
            R.id.four, R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine, R.id.star,
            R.id.pound};
    private EditText mDigits;

    // For animation.

    public DialpadView(Context context) {
        this(context, null);
    }

    public DialpadView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DialpadView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        @SuppressLint("CustomViewStyleable") TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Dialpad);
        mRippleColor = a.getColorStateList(R.styleable.Dialpad_dialpad_key_button_touch_tint);
        a.recycle();

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setupKeypad();
        mDigits = (EditText) findViewById(R.id.digits);

        AccessibilityManager accessibilityManager = (AccessibilityManager)
                getContext().getSystemService(Context.ACCESSIBILITY_SERVICE);
        if (accessibilityManager.isEnabled()) {
            // The text view must be selected to send accessibility events.
            mDigits.setSelected(true);
        }
    }

    private void setupKeypad() {
        final int[] letterIds = new int[]{
                R.string.dialpad_0_letters,
                R.string.dialpad_1_letters,
                R.string.dialpad_2_letters,
                R.string.dialpad_3_letters,
                R.string.dialpad_4_letters,
                R.string.dialpad_5_letters,
                R.string.dialpad_6_letters,
                R.string.dialpad_7_letters,
                R.string.dialpad_8_letters,
                R.string.dialpad_9_letters,
                R.string.dialpad_star_letters,
                R.string.dialpad_pound_letters
        };

        final Resources resources = getContext().getResources();

        DialpadKeyButton dialpadKey;
        TextView numberView;
        TextView lettersView;

        final NumberFormat nf;

        nf = DecimalFormat.getInstance(Locale.ENGLISH);

        for (int i = 0; i < mButtonIds.length; i++) {
            dialpadKey = (DialpadKeyButton) findViewById(mButtonIds[i]);
            numberView = (TextView) dialpadKey.findViewById(R.id.dialpad_key_number);
            lettersView = (TextView) dialpadKey.findViewById(R.id.dialpad_key_letters);

            final String numberString;
            final CharSequence numberContentDescription;
            if (mButtonIds[i] == R.id.pound) {
                numberString = resources.getString(R.string.dialpad_pound_number);
                numberContentDescription = numberString;
            } else if (mButtonIds[i] == R.id.star) {
                numberString = resources.getString(R.string.dialpad_star_number);
                numberContentDescription = numberString;
            } else {
                numberString = nf.format(i);
                // The content description is used for Talkback key presses. The number is
                // separated by a "," to introduce a slight delay. Convert letters into a verbatim
                // span so that they are read as letters instead of as one word.
                String letters = resources.getString(letterIds[i]);
                Spannable spannable =
                        Spannable.Factory.getInstance().newSpannable(numberString + "," + letters);
                spannable.setSpan(
                        (new TtsSpan.VerbatimBuilder(letters)).build(),
                        numberString.length() + 1,
                        numberString.length() + 1 + letters.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                numberContentDescription = spannable;
            }

            @SuppressLint("UseCompatLoadingForDrawables") final RippleDrawable rippleBackground = (RippleDrawable)
                    getContext().getDrawable(R.drawable.btn_dialpad_key);
            if (mRippleColor != null) {
                rippleBackground.setColor(mRippleColor);
            }

            numberView.setText(numberString);
            numberView.setElegantTextHeight(false);
            dialpadKey.setContentDescription(numberContentDescription);
            dialpadKey.setBackground(rippleBackground);

            if (lettersView != null) {
                lettersView.setText(resources.getString(letterIds[i]));
            }
        }

        final DialpadKeyButton one = (DialpadKeyButton) findViewById(R.id.one);
        one.setLongHoverContentDescription(
                resources.getText(R.string.description_voicemail_button));

        final DialpadKeyButton zero = (DialpadKeyButton) findViewById(R.id.zero);
        zero.setLongHoverContentDescription(
                resources.getText(R.string.description_image_button_plus));

    }

    /**
     * Always returns true for onHoverEvent callbacks, to fix problems with accessibility due to
     * the dialpad overlaying other fragments.
     */
    @Override
    public boolean onHoverEvent(MotionEvent event) {
        return true;
    }


    public EditText getDigits() {
        return mDigits;
    }

}
