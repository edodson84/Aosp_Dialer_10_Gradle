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

import android.app.FragmentManager;
import android.content.Context;
import android.database.Cursor;
import android.view.View;

import com.fissy.dialer.R;
import com.fissy.dialer.blocking.BlockNumberDialogFragment;
import com.fissy.dialer.contactphoto.ContactPhotoManager;
import com.fissy.dialer.database.FilteredNumberContract.FilteredNumberColumns;
import com.fissy.dialer.location.GeoUtil;
import com.fissy.dialer.logging.InteractionEvent;
import com.fissy.dialer.logging.Logger;
import com.fissy.dialer.phonenumbercache.ContactInfoHelper;
import com.fissy.dialer.phonenumberutil.PhoneNumberHelper;

/**
 * TODO(calderwoodra): documentation
 */
public class BlockedNumbersAdapter extends NumbersAdapter {

    private BlockedNumbersAdapter(
            Context context,
            FragmentManager fragmentManager,
            ContactInfoHelper contactInfoHelper,
            ContactPhotoManager contactPhotoManager) {
        super(context, fragmentManager, contactInfoHelper, contactPhotoManager);
    }

    public static BlockedNumbersAdapter newBlockedNumbersAdapter(
            Context context, FragmentManager fragmentManager) {
        return new BlockedNumbersAdapter(
                context,
                fragmentManager,
                new ContactInfoHelper(context, GeoUtil.getCurrentCountryIso(context)),
                ContactPhotoManager.getInstance(context));
    }

    @Override
    public void bindView(View view, final Context context, Cursor cursor) {
        super.bindView(view, context, cursor);
        final Integer id = cursor.getInt(cursor.getColumnIndex(FilteredNumberColumns._ID));
        final String countryIso =
                cursor.getString(cursor.getColumnIndex(FilteredNumberColumns.COUNTRY_ISO));
        final String number = cursor.getString(cursor.getColumnIndex(FilteredNumberColumns.NUMBER));

        final View deleteButton = view.findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(
                view1 -> BlockNumberDialogFragment.show(
                        id,
                        number,
                        countryIso,
                        PhoneNumberHelper.formatNumber(getContext(), number, countryIso),
                        R.id.blocked_numbers_activity_container,
                        getFragmentManager(),
                        new BlockNumberDialogFragment.Callback() {
                            @Override
                            public void onFilterNumberSuccess() {
                            }

                            @Override
                            public void onUnfilterNumberSuccess() {
                                Logger.get(context)
                                        .logInteraction(InteractionEvent.Type.UNBLOCK_NUMBER_MANAGEMENT_SCREEN);
                            }

                            @Override
                            public void onChangeFilteredNumberUndo() {
                            }
                        }));

        updateView(view, number, countryIso);
    }

    @Override
    public boolean isEmpty() {
        // Always return false, so that the header with blocking-related options always shows.
        return false;
    }
}
