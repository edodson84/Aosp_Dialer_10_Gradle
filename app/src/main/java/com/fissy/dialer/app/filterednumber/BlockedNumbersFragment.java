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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import com.fissy.dialer.R;
import com.fissy.dialer.blocking.BlockedNumbersMigrator;
import com.fissy.dialer.blocking.FilteredNumberCompat;
import com.fissy.dialer.blocking.FilteredNumbersUtil;
import com.fissy.dialer.database.FilteredNumberContract;

/**
 * TODO(calderwoodra): documentation
 */
public class BlockedNumbersFragment extends ListFragment
        implements LoaderManager.LoaderCallbacks<Cursor>,
        View.OnClickListener {

    protected View migratePromoView;
    private TextView blockedNumbersText;
    private TextView footerText;
    private BlockedNumbersAdapter adapter;
    private View importSettings;
    private View blockedNumbersDisabledForEmergency;
    private View blockedNumberListDivider;

    public BlockedNumbersFragment() {
    }

    @Override
    public Context getContext() {
        return getActivity();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        getListView().addHeaderView(View.inflate(getContext(), R.layout.blocked_number_header, null));
        getListView().addFooterView(View.inflate(getContext(), R.layout.blocked_number_footer, null));

        if (adapter == null) {
            adapter =
                    BlockedNumbersAdapter.newBlockedNumbersAdapter(
                            getContext(), requireActivity().getSupportFragmentManager());
        }
        setListAdapter(adapter);

        blockedNumbersText = getListView().findViewById(R.id.blocked_number_text_view);
        migratePromoView = getListView().findViewById(R.id.migrate_promo);
        getListView().findViewById(R.id.migrate_promo_allow_button).setOnClickListener(this);
        importSettings = getListView().findViewById(R.id.import_settings);
        blockedNumbersDisabledForEmergency =
                getListView().findViewById(R.id.blocked_numbers_disabled_for_emergency);
        blockedNumberListDivider = requireActivity().findViewById(R.id.blocked_number_list_divider);
        getListView().findViewById(R.id.import_button).setOnClickListener(this);
        getListView().findViewById(R.id.view_numbers_button).setOnClickListener(this);

        footerText = requireActivity().findViewById(R.id.blocked_number_footer_textview);
    }

    @Override
    public void onDestroy() {
        setListAdapter(null);
        super.onDestroy();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        LoaderManager.getInstance(this).initLoader(0, null, this);
    }

    @Override
    public void onResume() {
        super.onResume();

        // If the device can use the framework blocking solution, users should not be able to add
        // new blocked numbers from the Blocked Management UI. They will be shown a promo card
        // asking them to migrate to new blocking instead.
        if (FilteredNumberCompat.canUseNewFiltering()) {
            migratePromoView.setVisibility(View.VISIBLE);
            blockedNumbersText.setVisibility(View.GONE);
            blockedNumberListDivider.setVisibility(View.GONE);
            importSettings.setVisibility(View.GONE);
            getListView().findViewById(R.id.import_button).setOnClickListener(null);
            getListView().findViewById(R.id.view_numbers_button).setOnClickListener(null);
            blockedNumbersDisabledForEmergency.setVisibility(View.GONE);
            footerText.setVisibility(View.GONE);
        } else {
            FilteredNumbersUtil.checkForSendToVoicemailContact(
                    getActivity(),
                    hasSendToVoicemailContact -> {
                        final int visibility = hasSendToVoicemailContact ? View.VISIBLE : View.GONE;
                        importSettings.setVisibility(visibility);
                    });
        }

        // All views except migrate and the block list are hidden when new filtering is available
        if (!FilteredNumberCompat.canUseNewFiltering()
                && FilteredNumbersUtil.hasRecentEmergencyCall(getContext())) {
            blockedNumbersDisabledForEmergency.setVisibility(View.VISIBLE);
        } else {
            blockedNumbersDisabledForEmergency.setVisibility(View.GONE);
        }

    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.blocked_number_fragment, container, false);
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        final String[] projection = {
                FilteredNumberContract.FilteredNumberColumns._ID,
                FilteredNumberContract.FilteredNumberColumns.COUNTRY_ISO,
                FilteredNumberContract.FilteredNumberColumns.NUMBER,
                FilteredNumberContract.FilteredNumberColumns.NORMALIZED_NUMBER
        };
        final String selection =
                FilteredNumberContract.FilteredNumberColumns.TYPE
                        + "="
                        + FilteredNumberContract.FilteredNumberTypes.BLOCKED_NUMBER;
        return new CursorLoader(
                requireContext(),
                FilteredNumberContract.FilteredNumber.CONTENT_URI,
                projection,
                selection,
                null,
                null);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);
        if (FilteredNumberCompat.canUseNewFiltering() || data.getCount() == 0) {
            blockedNumberListDivider.setVisibility(View.INVISIBLE);
        } else {
            blockedNumberListDivider.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        adapter.swapCursor(null);
    }

    @Override
    public void onClick(final View view) {
        final BlockedNumbersSettingsActivity activity = (BlockedNumbersSettingsActivity) getActivity();
        if (activity == null) {
            return;
        }

        int resId = view.getId();
        if (resId == R.id.view_numbers_button) {
            activity.showNumbersToImportPreviewUi();
        } else if (resId == R.id.import_button) {
            FilteredNumbersUtil.importSendToVoicemailContacts(
                    activity,
                    () -> importSettings.setVisibility(View.GONE));
        } else if (resId == R.id.migrate_promo_allow_button) {
            view.setEnabled(false);
            new BlockedNumbersMigrator(getContext())
                    .migrate(
                            () -> {
                                requireContext()
                                        .startActivity(
                                                FilteredNumberCompat.createManageBlockedNumbersIntent(getContext()));
                                // Remove this activity from the backstack
                                activity.finish();
                            });
        }
    }


}
