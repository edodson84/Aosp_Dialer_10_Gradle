/*
 * Copyright (C) 2015 The Android Open Source Project
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
package com.fissy.dialer.app.filterednumber;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.ListFragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import com.fissy.dialer.R;
import com.fissy.dialer.blocking.FilteredNumbersUtil;

import java.util.Objects;

/**
 * TODO(calderwoodra): documentation
 */
public class ViewNumbersToImportFragment extends ListFragment
        implements LoaderManager.LoaderCallbacks<Cursor>, View.OnClickListener {

    private ViewNumbersToImportAdapter adapter;

    @Override
    public Context getContext() {
        return getActivity();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (adapter == null) {
            adapter =
                    ViewNumbersToImportAdapter.newViewNumbersToImportAdapter(
                            getContext(), requireActivity().getSupportFragmentManager());
        }
        setListAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        setListAdapter(null);
        super.onDestroy();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        androidx.loader.app.LoaderManager.getInstance(this).initLoader(0, null, this);
    }

    @Override
    public void onResume() {
        super.onResume();

        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        Objects.requireNonNull(actionBar).setTitle(R.string.import_send_to_voicemail_numbers_label);
        actionBar.setDisplayShowCustomEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);

        requireActivity().findViewById(R.id.cancel_button).setOnClickListener(this);
        requireActivity().findViewById(R.id.import_button).setOnClickListener(this);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_numbers_to_import_fragment, container, false);
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(
                requireContext(),
                Phone.CONTENT_URI,
                FilteredNumbersUtil.PhoneQuery.PROJECTION,
                FilteredNumbersUtil.PhoneQuery.SELECT_SEND_TO_VOICEMAIL_TRUE,
                null,
                null);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        adapter.swapCursor(null);
    }

    @Override
    public void onClick(final View view) {
        if (view.getId() == R.id.import_button) {
            FilteredNumbersUtil.importSendToVoicemailContacts(
                    getContext(),
                    () -> {
                        if (getActivity() != null) {
                            getActivity().onBackPressed();
                        }
                    });
        } else if (view.getId() == R.id.cancel_button) {
            requireActivity().onBackPressed();
        }
    }
}
