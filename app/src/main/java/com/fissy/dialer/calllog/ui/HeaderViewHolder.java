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
package com.fissy.dialer.calllog.ui;

import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

import com.fissy.dialer.R;

/**
 * ViewHolder for {@link NewCallLogAdapter} to display "Today" or "Older" divider row.
 */
final class HeaderViewHolder extends ViewHolder {

    private final TextView headerTextView;

    HeaderViewHolder(View view) {
        super(view);
        headerTextView = view.findViewById(R.id.new_call_log_header_text);
    }

    void setHeader(@StringRes int header) {
        headerTextView.setText(header);
    }
}
