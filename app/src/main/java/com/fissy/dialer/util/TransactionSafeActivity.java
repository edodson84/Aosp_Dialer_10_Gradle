/*
 * Copyright (C) 2011 The Android Open Source Project
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
package com.fissy.dialer.util;


import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.fissy.dialer.R;
import com.fissy.dialer.app.settings.ThemeOptionsSettingsFragment;

/**
 * A common superclass that keeps track of whether an {@link Activity} has saved its state yet or
 * not.
 */
public abstract class TransactionSafeActivity extends AppCompatActivity{

    private boolean isSafeToCommitTransactions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isSafeToCommitTransactions = true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        isSafeToCommitTransactions = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        isSafeToCommitTransactions = true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        isSafeToCommitTransactions = false;
    }

    public boolean isSafeToCommitTransactions() {
        return isSafeToCommitTransactions;
    }
}
