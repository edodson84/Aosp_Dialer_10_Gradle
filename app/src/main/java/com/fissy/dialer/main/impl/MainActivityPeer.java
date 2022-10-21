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

package com.fissy.dialer.main.impl;

import android.Manifest;
import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.CallLog.Calls;
import android.provider.ContactsContract.QuickContact;
import android.telecom.PhoneAccount;
import android.text.method.LinkMovementMethod;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.android.contacts.common.list.OnPhoneNumberPickerActionListener;
import com.fissy.dialer.R;
import com.fissy.dialer.animation.AnimUtils;
import com.fissy.dialer.app.MainComponent;
import com.fissy.dialer.app.calllog.CallLogAdapter;
import com.fissy.dialer.app.calllog.CallLogFragment;
import com.fissy.dialer.app.calllog.CallLogFragment.CallLogFragmentListener;
import com.fissy.dialer.app.calllog.CallLogNotificationsService;
import com.fissy.dialer.app.calllog.IntentProvider;
import com.fissy.dialer.app.list.DragDropController;
import com.fissy.dialer.app.list.OldSpeedDialFragment;
import com.fissy.dialer.app.list.OnDragDropListener;
import com.fissy.dialer.app.list.OnListFragmentScrolledListener;
import com.fissy.dialer.app.list.PhoneFavoriteSquareTileView;
import com.fissy.dialer.app.list.RemoveView;
import com.fissy.dialer.app.settings.ThemeOptionsSettingsFragment;
import com.fissy.dialer.callcomposer.CallComposerActivity;
import com.fissy.dialer.calldetails.OldCallDetailsActivity;
import com.fissy.dialer.callintent.CallIntentBuilder;
import com.fissy.dialer.callintent.CallSpecificAppData;
import com.fissy.dialer.common.FragmentUtils.FragmentUtilListener;
import com.fissy.dialer.common.LogUtil;
import com.fissy.dialer.common.concurrent.DialerExecutorComponent;
import com.fissy.dialer.common.concurrent.SupportUiListener;
import com.fissy.dialer.common.concurrent.ThreadUtil;
import com.fissy.dialer.constants.ActivityRequestCodes;
import com.fissy.dialer.contactsfragment.ContactsFragment;
import com.fissy.dialer.contactsfragment.ContactsFragment.Header;
import com.fissy.dialer.contactsfragment.ContactsFragment.OnContactSelectedListener;
import com.fissy.dialer.database.CallLogQueryHandler;
import com.fissy.dialer.database.Database;
import com.fissy.dialer.dialpadview.DialpadFragment;
import com.fissy.dialer.dialpadview.DialpadFragment.DialpadListener;
import com.fissy.dialer.dialpadview.DialpadFragment.LastOutgoingCallCallback;
import com.fissy.dialer.dialpadview.DialpadFragment.OnDialpadQueryChangedListener;
import com.fissy.dialer.duo.DuoComponent;
import com.fissy.dialer.i18n.LocaleUtils;
import com.fissy.dialer.interactions.PhoneNumberInteraction;
import com.fissy.dialer.logging.DialerImpression;
import com.fissy.dialer.logging.Logger;
import com.fissy.dialer.logging.ScreenEvent;
import com.fissy.dialer.main.impl.bottomnav.BottomNavBar;
import com.fissy.dialer.main.impl.bottomnav.BottomNavBar.OnBottomNavTabSelectedListener;
import com.fissy.dialer.main.impl.bottomnav.BottomNavBar.TabIndex;
import com.fissy.dialer.main.impl.bottomnav.MissedCallCountObserver;
import com.fissy.dialer.main.impl.toolbar.MainToolbar;
import com.fissy.dialer.metrics.Metrics;
import com.fissy.dialer.metrics.MetricsComponent;
import com.fissy.dialer.postcall.PostCall;
import com.fissy.dialer.precall.PreCall;
import com.fissy.dialer.promotion.Promotion;
import com.fissy.dialer.promotion.Promotion.PromotionType;
import com.fissy.dialer.promotion.PromotionComponent;
import com.fissy.dialer.searchfragment.list.NewSearchFragment.SearchFragmentListener;
import com.fissy.dialer.smartdial.util.SmartDialPrefix;
import com.fissy.dialer.speeddial.SpeedDialFragment;
import com.fissy.dialer.storage.StorageComponent;
import com.fissy.dialer.telecom.TelecomUtil;
import com.fissy.dialer.util.DialerUtils;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * MainActivityPeer which implements all of the old fragments we know and love <3
 *
 * <p>TODO(calderwoodra): Deprecate this class when we launch NewmainActivityPeer.
 */
public class MainActivityPeer implements com.fissy.dialer.main.MainActivityPeer, FragmentUtilListener {

    private static final String KEY_SAVED_LANGUAGE_CODE = "saved_language_code";
    private static final String KEY_CURRENT_TAB = "current_tab";
    private static final String KEY_LAST_TAB = "last_tab";

    /**
     * Action and extra to let the activity know which tab to open up to.
     */
    private static final String ACTION_SHOW_TAB = "ACTION_SHOW_TAB";

    private static final String EXTRA_SHOW_TAB = "EXTRA_SHOW_TAB";
    public static SharedPreferences themeprefs;
    // TODO(calderwoodra): change to AppCompatActivity once new speed dial ships
    private final AppCompatActivity activity;
    // Contacts
    private MainOnContactSelectedListener onContactSelectedListener;
    // Dialpad and Search
    private MainDialpadFragmentHost dialpadFragmentHostInterface;
    private MainSearchController searchController;
    private MainOnDialpadQueryChangedListener onDialpadQueryChangedListener;
    private MainDialpadListener dialpadListener;
    private MainSearchFragmentListener searchFragmentListener;
    // Action Mode
    private MainCallLogAdapterOnActionModeStateChangedListener
            callLogAdapterOnActionModeStateChangedListener;
    // Call Log
    private MainCallLogHost callLogHostInterface;
    private MainCallLogFragmentListener callLogFragmentListener;
    private MainOnListFragmentScrolledListener onListFragmentScrolledListener;
    // Speed Dial
    private MainOnPhoneNumberPickerActionListener onPhoneNumberPickerActionListener;
    private MainOldSpeedDialFragmentHost oldSpeedDialFragmentHost;
    private MainSpeedDialFragmentHost speedDialFragmentHost;
    /**
     * Language the device was in last time {@link #onSaveInstanceState(Bundle)} was called.
     */
    private String savedLanguageCode;
    private LastTabController lastTabController;
    private BottomNavBar bottomNav;
    private final BroadcastReceiver disableCallLogFrameworkReceiver =
            new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {

                }
            };
    private View snackbarContainer;
    private MissedCallCountObserver missedCallCountObserver;
    private SupportUiListener<String> getLastOutgoingCallListener;
    private SupportUiListener<Integer> missedCallObserverUiListener;

    public MainActivityPeer(AppCompatActivity activity) {
        this.activity = activity;
    }

    static boolean isShowTabIntent(Intent intent) {
        return ACTION_SHOW_TAB.equals(intent.getAction()) && intent.hasExtra(EXTRA_SHOW_TAB);
    }

    static @TabIndex
    int getTabFromIntent(Intent intent) {
        return intent.getIntExtra(EXTRA_SHOW_TAB, -1);
    }


    @Override
    public void onActivityCreate(Bundle savedInstanceState) {
        LogUtil.enterBlock("MainActivityPeer.onActivityCreate");
        themeprefs = ThemeOptionsSettingsFragment.getSharedPreferences(activity);
        ThemeOptionsSettingsFragment.ThemeButtonBehavior mThemeBehavior = ThemeOptionsSettingsFragment.getThemeButtonBehavior(themeprefs);

        if (mThemeBehavior == ThemeOptionsSettingsFragment.ThemeButtonBehavior.DARK) {
            LogUtil.enterBlock("MainActivity.dark");
            activity.getTheme().applyStyle(R.style.MainActivityThemeDark, true);
        }
        if (mThemeBehavior == ThemeOptionsSettingsFragment.ThemeButtonBehavior.LIGHT) {
            LogUtil.enterBlock("MainActivity.light");
            activity.getTheme().applyStyle(R.style.MainActivityThemeLight, true);
        }


        activity.setContentView(R.layout.main_activity);
        initUiListeners();
        initLayout(savedInstanceState);
        SmartDialPrefix.initializeNanpSettings(activity);
    }

    /**
     * should be called before {@link AppCompatActivity#setContentView(int)}.
     */


    private void initUiListeners() {
        getLastOutgoingCallListener =
                DialerExecutorComponent.get(activity)
                        .createUiListener(activity.getSupportFragmentManager(), "Query last phone number");
        missedCallObserverUiListener =
                DialerExecutorComponent.get(activity)
                        .createUiListener(activity.getSupportFragmentManager(), "Missed call observer");
    }

    @SuppressLint("CutPasteId")
    private void initLayout(Bundle savedInstanceState) {
        onContactSelectedListener = new MainOnContactSelectedListener(activity);
        dialpadFragmentHostInterface = new MainDialpadFragmentHost();

        snackbarContainer = activity.findViewById(R.id.coordinator_layout);
        View bottomSheet = activity.findViewById(R.id.promotion_bottom_sheet);
        BottomSheetBehavior<View> bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        FloatingActionButton fab = activity.findViewById(R.id.fab);
        fab.setOnClickListener(
                v -> {
                    Logger.get(activity).logImpression(DialerImpression.Type.MAIN_CLICK_FAB_TO_OPEN_DIALPAD);
                    searchController.showDialpad(true);
                    if (callLogAdapterOnActionModeStateChangedListener.isEnabled) {
                        LogUtil.i("MainActivityPeer.onFabClicked", "closing multiselect");
                        callLogAdapterOnActionModeStateChangedListener.actionMode.finish();
                    }
                });

        MainToolbar toolbar = activity.findViewById(R.id.toolbar);
        activity.setSupportActionBar(activity.findViewById(R.id.toolbar));

        bottomNav = activity.findViewById(R.id.bottom_nav_bar);
        MainBottomNavBarBottomNavTabListener bottomNavTabListener = new MainBottomNavBarBottomNavTabListener(
                activity,
                activity.getSupportFragmentManager(),
                fab,
                bottomSheet);
        bottomNav.addOnTabSelectedListener(bottomNavTabListener);

        missedCallCountObserver =
                new MissedCallCountObserver(
                        activity.getApplicationContext(), bottomNav, missedCallObserverUiListener);

        callLogFragmentListener =
                new MainCallLogFragmentListener(
                        activity, activity.getContentResolver(), bottomNav, toolbar);
        bottomNav.addOnTabSelectedListener(callLogFragmentListener);

        searchController =
                getNewMainSearchController(
                        bottomNav, fab, toolbar, activity.findViewById(R.id.toolbar_shadow), snackbarContainer);
        toolbar.setSearchBarListener(searchController);

        onDialpadQueryChangedListener = getNewOnDialpadQueryChangedListener(searchController);
        dialpadListener =
                new MainDialpadListener(activity, searchController, getLastOutgoingCallListener);
        searchFragmentListener = new MainSearchFragmentListener(searchController);
        callLogAdapterOnActionModeStateChangedListener =
                new MainCallLogAdapterOnActionModeStateChangedListener();
        callLogHostInterface = new MainCallLogHost(searchController, fab);

        onListFragmentScrolledListener = new MainOnListFragmentScrolledListener(snackbarContainer);
        onPhoneNumberPickerActionListener = new MainOnPhoneNumberPickerActionListener(activity);
        oldSpeedDialFragmentHost =
                new MainOldSpeedDialFragmentHost(
                        activity,
                        activity.findViewById(R.id.root_layout),
                        bottomNav,
                        activity.findViewById(R.id.contact_tile_drag_shadow_overlay),
                        activity.findViewById(R.id.remove_view),
                        activity.findViewById(R.id.search_view_container),
                        toolbar);
        speedDialFragmentHost =
                new MainSpeedDialFragmentHost(
                        toolbar,
                        activity.findViewById(R.id.root_layout),
                        activity.findViewById(R.id.coordinator_layout),
                        activity.findViewById(R.id.fragment_container));

        lastTabController = new LastTabController(activity, bottomNav);

        // Restore our view state if needed, else initialize as if the app opened for the first time
        if (savedInstanceState != null) {
            savedLanguageCode = savedInstanceState.getString(KEY_SAVED_LANGUAGE_CODE);
            searchController.onRestoreInstanceState(savedInstanceState);
            bottomNav.selectTab(savedInstanceState.getInt(KEY_CURRENT_TAB));
        } else {
            onHandleIntent(activity.getIntent());
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        LogUtil.enterBlock("MainActivityPeer.onNewIntent");
        onHandleIntent(intent);
    }

    private void onHandleIntent(Intent intent) {
        // Some important implementation notes:
        //  1) If the intent contains extra data to open to a specific screen (e.g. DIAL intent), when
        //     the user leaves that screen, they will return here and add see a blank screen unless we
        //     select a tab here.
        //  2) Don't return early here in case the intent does contain extra data.
        //  3) External intents should take priority over other intents (like Calls.CONTENT_TYPE).
        @TabIndex int tabToSelect;
        if (Calls.CONTENT_TYPE.equals(intent.getType())) {
            intent.getExtras();
            LogUtil.i("MainActivityPeer.onHandleIntent", "Call log content type intent");
            tabToSelect = TabIndex.CALL_LOG;

        } else if (isShowTabIntent(intent)) {
            LogUtil.i("MainActivityPeer.onHandleIntent", "Show tab intent");
            tabToSelect = getTabFromIntent(intent);
        } else {
            LogUtil.i("MainActivityPeer.onHandleIntent", "Show last tab");
            tabToSelect = lastTabController.getLastTab();
        }
        logImpressionForSelectedTab(tabToSelect);
        bottomNav.selectTab(tabToSelect);

        if (isDialOrAddCallIntent(intent)) {
            LogUtil.i("MainActivityPeer.onHandleIntent", "Dial or add call intent");
            // Dialpad will grab the intent and populate the number
            searchController.showDialpadFromNewIntent();
            Logger.get(activity).logImpression(DialerImpression.Type.MAIN_OPEN_WITH_DIALPAD);
        }

        if (intent.getBooleanExtra(MainComponent.EXTRA_CLEAR_NEW_VOICEMAILS, false)) {
            LogUtil.i("MainActivityPeer.onHandleIntent", "clearing all new voicemails");
            CallLogNotificationsService.markAllNewVoicemailsAsOld(activity);
        }
    }

    /**
     * Log impression for non user tab selection.
     */
    private void logImpressionForSelectedTab(@TabIndex int tab) {
        if (tab == TabIndex.SPEED_DIAL) {
            Logger.get(activity).logImpression(DialerImpression.Type.MAIN_OPEN_WITH_TAB_FAVORITE);
        } else if (tab == TabIndex.CALL_LOG) {
            Logger.get(activity).logImpression(DialerImpression.Type.MAIN_OPEN_WITH_TAB_CALL_LOG);
        } else if (tab == TabIndex.CONTACTS) {
            Logger.get(activity).logImpression(DialerImpression.Type.MAIN_OPEN_WITH_TAB_CONTACTS);
        } else {
            throw new IllegalStateException("Invalid tab: " + tab);
        }
    }

    /**
     * Returns true if the given intent is a Dial intent with data or an Add Call intent.
     */
    private boolean isDialOrAddCallIntent(Intent intent) {
        if (intent == null) {
            return false;
        }

        if (Intent.ACTION_DIAL.equals(intent.getAction())) {
            return true;
        }

        if (Intent.ACTION_VIEW.equals(intent.getAction())) {
            Uri data = intent.getData();
            if (data != null && PhoneAccount.SCHEME_TEL.equals(data.getScheme())) {
                return true;
            }
        }
        return DialpadFragment.isAddCallMode(intent);
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onActivityResume() {
        LogUtil.enterBlock("MainBottomNavBarBottomNavTabListener.onActivityResume");
        callLogFragmentListener.onActivityResume();
        // Start the thread that updates the smart dial database if the activity is recreated with a
        // language change.
        boolean forceUpdate =
                !LocaleUtils.getLocale(activity).getISO3Language().equals(savedLanguageCode);
        Database.get(activity).getDatabaseHelper(activity).startSmartDialUpdateThread(forceUpdate);
        showPostCallPrompt();

        if (searchController.isInSearch()
                || callLogAdapterOnActionModeStateChangedListener.isActionModeStateEnabled()) {
            bottomNav.setVisibility(View.GONE);
        } else {
            bottomNav.setVisibility(View.VISIBLE);
        }

        /*
         * While the activity is running, listen for the call log framework being disabled. If this is
         * not done, user interaction with the fragment could cause call log framework state to be
         * unexpectedly written. For example scrolling could cause the AnnotatedCallLog to be read
         * (which would trigger database creation).
         */
        LocalBroadcastManager.getInstance(activity)
                .registerReceiver(
                        disableCallLogFrameworkReceiver, new IntentFilter("disableCallLogFramework"));

        /*
         * Similar to above, if the new call log/new voicemail is being shown and then the activity is
         * paused, when the user returns we need to remove the NewCallLogFragment if the framework has
         * been disabled in the meantime.
         */

        // add 1 sec delay to get memory snapshot so that dialer wont react slowly on resume.
        ThreadUtil.postDelayedOnUiThread(
                () ->
                        MetricsComponent.get(activity)
                                .metrics()
                                .recordMemory(Metrics.OLD_MAIN_ACTIVITY_PEER_ON_RESUME_MEMORY_EVENT_NAME),
                1000);
    }

    @Override
    public void onUserLeaveHint() {
        searchController.onUserLeaveHint();
    }

    @Override
    public void onActivityPause() {
        searchController.onActivityPause();
        LocalBroadcastManager.getInstance(activity).unregisterReceiver(disableCallLogFrameworkReceiver);
        activity.getContentResolver().unregisterContentObserver(missedCallCountObserver);
    }

    @Override
    public void onActivityStop() {
        lastTabController.onActivityStop();
        callLogFragmentListener.onActivityStop();
    }

    private void showPostCallPrompt() {
        if (TelecomUtil.isInManagedCall(activity)) {
            // No prompt to show if the user is in a call
            return;
        }

        if (searchController.isInSearch()) {
            // Don't show the prompt if we're in the search ui
            return;
        }

        PostCall.promptUserForMessageIfNecessary(activity, snackbarContainer);
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(KEY_SAVED_LANGUAGE_CODE, LocaleUtils.getLocale(activity).getISO3Language());
        bundle.putInt(KEY_CURRENT_TAB, bottomNav.getSelectedTab());
        searchController.onSaveInstanceState(bundle);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        LogUtil.i(
                "MainActivityPeer.onActivityResult",
                "requestCode:%d, resultCode:%d",
                requestCode,
                resultCode);
        if (requestCode == ActivityRequestCodes.DIALTACTS_VOICE_SEARCH) {
            searchController.onVoiceResults(resultCode, data);
        } else if (requestCode == ActivityRequestCodes.DIALTACTS_CALL_COMPOSER) {
            if (resultCode == AppCompatActivity.RESULT_FIRST_USER) {
                LogUtil.i(
                        "MainActivityPeer.onActivityResult", "returned from call composer, error occurred");
                String message =
                        activity.getString(
                                R.string.call_composer_connection_failed,
                                data.getStringExtra(CallComposerActivity.KEY_CONTACT_NAME));
                Snackbar.make(snackbarContainer, message, Snackbar.LENGTH_LONG).show();
            } else {
                LogUtil.i("MainActivityPeer.onActivityResult", "returned from call composer, no error");
            }

        } else if (requestCode == ActivityRequestCodes.DIALTACTS_CALL_DETAILS) {
            if (resultCode == AppCompatActivity.RESULT_OK
                    && data != null
                    && data.getBooleanExtra(OldCallDetailsActivity.EXTRA_HAS_ENRICHED_CALL_DATA, false)) {
                String number = data.getStringExtra(OldCallDetailsActivity.EXTRA_PHONE_NUMBER);
                int snackbarDurationMillis = 5_000;
                Snackbar.make(
                                snackbarContainer,
                                activity.getString(R.string.ec_data_deleted),
                                snackbarDurationMillis)
                        .setAction(
                                R.string.view_conversation,
                                v ->
                                        activity.startActivity(
                                                IntentProvider.getSendSmsIntentProvider(number).getIntent(activity)))
                        .setActionTextColor(
                                ContextCompat.getColor(activity, R.color.dialer_snackbar_action_text_color))
                        .show();
            }

        } else if (requestCode == ActivityRequestCodes.DIALTACTS_DUO) {
            // We just returned from starting Duo for a task. Reload our reachability data since it
            // may have changed after a user finished activating Duo.
            DuoComponent.get(activity).getDuo().reloadReachability(activity);

        } else if (requestCode == ActivityRequestCodes.DEFAULT_DIALER) {
            if (resultCode == AppCompatActivity.RESULT_OK) {
                checkAndRequestPermissions();
            }
        }

        else {
            LogUtil.e("MainActivityPeer.onActivityResult", "Unknown request code: " + requestCode);
        }
    }

    // Function to check and request permission.

    private void checkAndRequestPermissions() {
        int camera = ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA);
        int storage = ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int loc = ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION);
        int loc2 = ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION);
        int contacts = ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_CONTACTS);
        int contacts2 = ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_CONTACTS);
        int phone = ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_PHONE_STATE);
        int calllog = ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_CALL_LOG);
        int calllog2 = ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_CALL_LOG);
        int numbers = ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_PHONE_NUMBERS);
        int nfc = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
            nfc = ContextCompat.checkSelfPermission(activity, Manifest.permission.BLUETOOTH_CONNECT);
        }
        List<String> listPermissionsNeeded = new ArrayList<>();

        if (camera != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.CAMERA);
        }
        if (storage != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (loc2 != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (loc != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        }
        if (contacts != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_CONTACTS);
        }
        if (contacts2 != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.WRITE_CONTACTS);
        }
        if (phone != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (calllog != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_CALL_LOG);
        }
        if (calllog2 != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.WRITE_CALL_LOG);
        }
        if (numbers != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_PHONE_NUMBERS);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (nfc != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(Manifest.permission.BLUETOOTH_CONNECT);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(activity, listPermissionsNeeded.toArray
                    (new String[0]), ActivityRequestCodes.REQUEST_ID_MULTIPLE_PERMISSIONS);
        }
    }

    // This function is called when the user accepts or decline the permission.
    // Request Code is used to check which permission called this function.
    // This request code is provided when the user is prompt for permission.

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        LogUtil.enterBlock("MainActivityPeer.onrequestpermission");
        if (requestCode == ActivityRequestCodes.REQUEST_ID_MULTIPLE_PERMISSIONS) {
            if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_PHONE_NUMBERS) == PackageManager.PERMISSION_GRANTED) {
                Snackbar.make(snackbarContainer, "Permissions Granted", Snackbar.LENGTH_LONG).show();
            }
        }
    }


    @Override
    public boolean onBackPressed() {
        LogUtil.enterBlock("MainActivityPeer.onBackPressed");
        return searchController.onBackPressed();
    }

    @Nullable
    @Override
    @SuppressWarnings("unchecked") // Casts are checked using runtime methods
    public <T> T getImpl(Class<T> callbackInterface) {
        if (callbackInterface.isInstance(onContactSelectedListener)) {
            return (T) onContactSelectedListener;
        } else if (callbackInterface.isInstance(onDialpadQueryChangedListener)) {
            return (T) onDialpadQueryChangedListener;
        } else if (callbackInterface.isInstance(dialpadListener)) {
            return (T) dialpadListener;
        } else if (callbackInterface.isInstance(dialpadFragmentHostInterface)) {
            return (T) dialpadFragmentHostInterface;
        } else if (callbackInterface.isInstance(searchFragmentListener)) {
            return (T) searchFragmentListener;
        } else if (callbackInterface.isInstance(callLogAdapterOnActionModeStateChangedListener)) {
            return (T) callLogAdapterOnActionModeStateChangedListener;
        } else if (callbackInterface.isInstance(callLogHostInterface)) {
            return (T) callLogHostInterface;
        } else if (callbackInterface.isInstance(callLogFragmentListener)) {
            return (T) callLogFragmentListener;
        } else if (callbackInterface.isInstance(onListFragmentScrolledListener)) {
            return (T) onListFragmentScrolledListener;
        } else if (callbackInterface.isInstance(onPhoneNumberPickerActionListener)) {
            return (T) onPhoneNumberPickerActionListener;
        } else if (callbackInterface.isInstance(oldSpeedDialFragmentHost)) {
            return (T) oldSpeedDialFragmentHost;
        } else if (callbackInterface.isInstance(searchController)) {
            return (T) searchController;
        } else if (callbackInterface.isInstance(speedDialFragmentHost)) {
            return (T) speedDialFragmentHost;
        } else {
            return null;
        }
    }

    public MainSearchController getNewMainSearchController(
            BottomNavBar bottomNavBar,
            FloatingActionButton fab,
            MainToolbar mainToolbar,
            View toolbarShadow,
            View fragmentContainer) {
        return new MainSearchController(
                activity, bottomNavBar, fab, mainToolbar, toolbarShadow, fragmentContainer);
    }

    public MainOnDialpadQueryChangedListener getNewOnDialpadQueryChangedListener(
            MainSearchController mainSearchController) {
        return new MainOnDialpadQueryChangedListener(mainSearchController);
    }

    /**
     * @see OnContactSelectedListener
     */
    private static final class MainOnContactSelectedListener implements OnContactSelectedListener {

        private final Context context;

        MainOnContactSelectedListener(Context context) {
            this.context = context;
        }

        @Override
        public void onContactSelected(ImageView photo, Uri contactUri, long contactId) {
            // TODO(calderwoodra): Add impression logging
            QuickContact.showQuickContact(
                    context, photo, contactUri, QuickContact.MODE_LARGE, null /* excludeMimes */);
        }
    }

    /**
     * @see OnDialpadQueryChangedListener
     */
    protected static class MainOnDialpadQueryChangedListener
            implements OnDialpadQueryChangedListener {

        private final MainSearchController searchController;

        protected MainOnDialpadQueryChangedListener(MainSearchController searchController) {
            this.searchController = searchController;
        }

        @Override
        public void onDialpadQueryChanged(String query) {
            searchController.onDialpadQueryChanged(query);
        }
    }

    /**
     * @see DialpadListener
     */
    private static final class MainDialpadListener implements DialpadListener {

        private final MainSearchController searchController;
        private final Context context;
        private final SupportUiListener<String> listener;

        MainDialpadListener(
                Context context, MainSearchController searchController, SupportUiListener<String> uiListener) {
            this.context = context;
            this.searchController = searchController;
            this.listener = uiListener;
        }

        @Override
        public void getLastOutgoingCall(LastOutgoingCallCallback callback) {
            ListenableFuture<String> listenableFuture =
                    DialerExecutorComponent.get(context)
                            .backgroundExecutor()
                            .submit(() -> Calls.getLastOutgoingCall(context));
            listener.listen(context, listenableFuture, callback::lastOutgoingCall, throwable -> {
            });
        }

        @Override
        public void onDialpadShown() {
            searchController.onDialpadShown();
        }

        @Override
        public void onCallPlacedFromDialpad() {
            // TODO(calderwoodra): logging
            searchController.onCallPlacedFromSearch();
        }
    }

    /**
     * @see SearchFragmentListener
     */
    private static final class MainSearchFragmentListener implements SearchFragmentListener {

        private final MainSearchController searchController;

        MainSearchFragmentListener(MainSearchController searchController) {
            this.searchController = searchController;
        }

        @Override
        public void onSearchListTouch() {
            searchController.onSearchListTouch();
        }

        @Override
        public void onCallPlacedFromSearch() {
            // TODO(calderwoodra): logging
            searchController.onCallPlacedFromSearch();
        }

        @Override
        public void requestingPermission() {
            searchController.requestingPermission();
        }
    }

    /**
     * @see DialpadFragment.HostInterface
     */
    private static final class MainDialpadFragmentHost implements DialpadFragment.HostInterface {

        @Override
        public boolean onDialpadSpacerTouchWithEmptyQuery() {
            // No-op, just let the clicks fall through to the search list
            return false;
        }

        @Override
        public boolean shouldShowDialpadChooser() {
            // Never show the dialpad chooser. Ever.
            return false;
        }
    }

    /**
     * @see CallLogAdapter.OnActionModeStateChangedListener
     */
    private static final class MainCallLogAdapterOnActionModeStateChangedListener
            implements CallLogAdapter.OnActionModeStateChangedListener {

        private boolean isEnabled;
        private ActionMode actionMode;

        @Override
        public void onActionModeStateChanged(ActionMode actionMode, boolean isEnabled) {
            this.actionMode = actionMode;
            this.isEnabled = isEnabled;
        }

        @Override
        public boolean isActionModeStateEnabled() {
            return isEnabled;
        }
    }

    /**
     * @see CallLogFragment.HostInterface
     */
    private static final class MainCallLogHost implements CallLogFragment.HostInterface {

        private final FloatingActionButton fab;
        private final MainSearchController searchController;

        MainCallLogHost(MainSearchController searchController, FloatingActionButton fab) {
            this.searchController = searchController;
            this.fab = fab;
        }

        @Override
        public void showDialpad() {
            searchController.showDialpad(true);
        }

        @Override
        public void enableFloatingButton(boolean enabled) {
            LogUtil.i("MainCallLogHost.enableFloatingButton", "enabled: " + enabled);
            if (enabled) {
                fab.show();
            } else {
                fab.hide();
            }
        }
    }

    /**
     * Handles the logic for callbacks from:
     *
     * <ul>
     *   <li>{@link CallLogFragment}
     *   <li>{@link CallLogQueryHandler}
     *   <li>{@link BottomNavBar}
     * </ul>
     * <p>
     * This mainly entails:
     *
     * <ul>
     *   <li>Handling querying for missed calls/unread voicemails.
     *   <li>Displaying a badge to the user in the bottom nav when there are missed calls/unread
     *       voicemails present.
     *   <li>Marking missed calls as read when appropriate. See {@link
     *       #markMissedCallsAsReadAndRemoveNotification()}
     *   <li>TODO(calderwoodra): multiselect
     * </ul>
     *
     * @see CallLogFragmentListener
     * @see CallLogQueryHandler.Listener
     * @see OnBottomNavTabSelectedListener
     */
    private static final class MainCallLogFragmentListener
            implements CallLogFragmentListener,
            CallLogQueryHandler.Listener,
            OnBottomNavTabSelectedListener {

        private final CallLogQueryHandler callLogQueryHandler;
        private final Context context;
        private final BottomNavBar bottomNavBar;
        private final Toolbar toolbar;
        private @TabIndex
        int currentTab = TabIndex.SPEED_DIAL;
        private boolean activityIsAlive;

        MainCallLogFragmentListener(
                Context context,
                ContentResolver contentResolver,
                BottomNavBar bottomNavBar,
                Toolbar toolbar) {
            callLogQueryHandler = new CallLogQueryHandler(context, contentResolver, this);
            this.context = context;
            this.bottomNavBar = bottomNavBar;
            this.toolbar = toolbar;
        }

        @Override
        public void updateTabUnreadCounts() {
            callLogQueryHandler.fetchMissedCallsUnreadCount();
        }

        @Override
        public void showMultiSelectRemoveView(boolean show) {
            bottomNavBar.setVisibility(show ? View.GONE : View.VISIBLE);
            toolbar.setVisibility(show ? View.GONE : View.VISIBLE);
        }

        @Override
        public void onMissedCallsUnreadCountFetched(Cursor cursor) {
            if (activityIsAlive) {
                bottomNavBar.setNotificationCount(TabIndex.CALL_LOG, cursor.getCount());
            }
            cursor.close();
        }

        @Override
        public boolean onCallsFetched(Cursor combinedCursor) {
            // Return false; did not take ownership of cursor
            return false;
        }

        @Override
        public void onSpeedDialSelected() {
            setCurrentTab(TabIndex.SPEED_DIAL);
        }

        @Override
        public void onCallLogSelected() {
            setCurrentTab(TabIndex.CALL_LOG);
        }

        @Override
        public void onContactsSelected() {
            setCurrentTab(TabIndex.CONTACTS);
        }

        private void markMissedCallsAsReadAndRemoveNotification() {

                callLogQueryHandler.markMissedCallsAsRead();
                CallLogNotificationsService.cancelAllMissedCalls(context);

        }

        private void setCurrentTab(@TabIndex int tabIndex) {
            if (currentTab == TabIndex.CALL_LOG && tabIndex != TabIndex.CALL_LOG) {
                markMissedCallsAsReadAndRemoveNotification();
            }
            currentTab = tabIndex;
        }

        public void onActivityResume() {
            LogUtil.enterBlock("MainCallLogFragmentListener.onActivityResume");
            activityIsAlive = true;

            // Reset the tab on resume to restart the timer
            setCurrentTab(bottomNavBar.getSelectedTab());
        }

        /**
         * Should be called is called.
         */
        public void onActivityStop() {
            activityIsAlive = false;
        }

    }

    /**
     * @see OnListFragmentScrolledListener
     */
    private static final class MainOnListFragmentScrolledListener
            implements OnListFragmentScrolledListener {

        private final View parentLayout;

        MainOnListFragmentScrolledListener(View parentLayout) {
            this.parentLayout = parentLayout;
        }

        @Override
        public void onListFragmentScrollStateChange(int scrollState) {
            DialerUtils.hideInputMethod(parentLayout);
        }

        @Override
        public void onListFragmentScroll(
                int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            // TODO: No-op for now. This should eventually show/hide the actionBar based on
            // interactions with the ListsFragments.
        }
    }

    /**
     * @see OnPhoneNumberPickerActionListener
     */
    private static final class MainOnPhoneNumberPickerActionListener
            implements OnPhoneNumberPickerActionListener {

        private final AppCompatActivity activity;

        MainOnPhoneNumberPickerActionListener(AppCompatActivity activity) {
            this.activity = activity;
        }

        @Override
        public void onPickDataUri(
                Uri dataUri, boolean isVideoCall, CallSpecificAppData callSpecificAppData) {
            PhoneNumberInteraction.startInteractionForPhoneCall(
                    activity, dataUri, isVideoCall, callSpecificAppData);
        }

        @Override
        public void onPickPhoneNumber(
                String phoneNumber, boolean isVideoCall, CallSpecificAppData callSpecificAppData) {
            if (phoneNumber == null) {
                // Invalid phone number, but let the call go through so that InCallUI can show
                // an error message.
                phoneNumber = "";
            }
            PreCall.start(
                    activity,
                    new CallIntentBuilder(phoneNumber, callSpecificAppData)
                            .setIsVideoCall(isVideoCall)
                            .setAllowAssistedDial(callSpecificAppData.getAllowAssistedDialing()));
        }

        @Override
        public void onHomeInActionBarSelected() {
            // TODO(calderwoodra): investigate if we need to exit search here
            // PhoneNumberPickerFragment#onOptionsItemSelected
        }
    }

    /**
     * Handles the callbacks for {@link OldSpeedDialFragment} and drag/drop logic for drag to remove.
     *
     * @see OldSpeedDialFragment.HostInterface
     * @see OnDragDropListener
     */
    private static final class MainOldSpeedDialFragmentHost
            implements OldSpeedDialFragment.HostInterface, OnDragDropListener {

        private final Context context;
        private final View rootLayout;
        private final BottomNavBar bottomNavBar;
        private final ImageView dragShadowOverlay;
        private final RemoveView removeView;
        private final View removeViewContent;
        private final View searchViewContainer;
        private final MainToolbar toolbar;

        MainOldSpeedDialFragmentHost(
                Context context,
                View rootLayout,
                BottomNavBar bottomNavBar,
                ImageView dragShadowOverlay,
                RemoveView removeView,
                View searchViewContainer,
                MainToolbar toolbar) {
            this.context = context;
            this.rootLayout = rootLayout;
            this.bottomNavBar = bottomNavBar;
            this.dragShadowOverlay = dragShadowOverlay;
            this.removeView = removeView;
            this.searchViewContainer = searchViewContainer;
            this.toolbar = toolbar;
            removeViewContent = removeView.findViewById(R.id.remove_view_content);
        }

        @Override
        public void setDragDropController(DragDropController dragDropController) {
            removeView.setDragDropController(dragDropController);
            rootLayout.setOnDragListener(
                    (v, event) -> {
                        if (event.getAction() == DragEvent.ACTION_DRAG_LOCATION) {
                            dragDropController.handleDragHovered(v, (int) event.getX(), (int) event.getY());
                        }
                        return true;
                    });
        }

        @Override
        public void showAllContactsTab() {
            bottomNavBar.selectTab(TabIndex.CONTACTS);
            Logger.get(context).logImpression(DialerImpression.Type.MAIN_OPEN_WITH_TAB_CONTACTS);
        }

        @Override
        public ImageView getDragShadowOverlay() {
            return dragShadowOverlay;
        }

        @Override
        public void setHasFrequents(boolean hasFrequents) {
            toolbar.showClearFrequents(hasFrequents);
        }

        @Override
        public void onDragStarted(int x, int y, PhoneFavoriteSquareTileView view) {
            showRemoveView(true);
        }

        @Override
        public void onDragHovered(int x, int y, PhoneFavoriteSquareTileView view) {
        }

        @Override
        public void onDragFinished(int x, int y) {
            showRemoveView(false);
        }

        @Override
        public void onDroppedOnRemove() {
        }

        private void showRemoveView(boolean show) {
            if (show) {
                AnimUtils.crossFadeViews(removeViewContent, searchViewContainer, 300);
            } else {
                AnimUtils.crossFadeViews(searchViewContainer, removeViewContent, 300);
            }
        }
    }

    /**
     * Handles the callbacks for {@link SpeedDialFragment}.
     *
     * @see SpeedDialFragment.HostInterface
     */
    private static final class MainSpeedDialFragmentHost implements SpeedDialFragment.HostInterface {

        private final MainToolbar toolbar;
        private final ViewGroup rootLayout;
        private final ViewGroup coordinatorLayout;
        private final ViewGroup fragmentContainer;

        MainSpeedDialFragmentHost(
                MainToolbar toolbar,
                ViewGroup rootLayout,
                ViewGroup coordinatorLayout,
                ViewGroup fragmentContainer) {
            this.toolbar = toolbar;
            this.rootLayout = rootLayout;
            this.coordinatorLayout = coordinatorLayout;
            this.fragmentContainer = fragmentContainer;
        }

        @Override
        public void setHasFrequents(boolean hasFrequents) {
            toolbar.showClearFrequents(hasFrequents);
        }

        @Override
        public void dragFavorite(boolean start) {
            rootLayout.setClipChildren(!start);
            coordinatorLayout.setClipChildren(!start);
            fragmentContainer.setClipChildren(!start);
        }
    }

    /**
     * Implementation of {@link OnBottomNavTabSelectedListener} that handles logic for showing each of
     * the main tabs and FAB.
     *
     * <p>TODO(calderwoodra, uabdullah): Rethink the logic for showing/hiding the FAB when new
     * voicemail is ready.
     */
    private static final class MainBottomNavBarBottomNavTabListener
            implements OnBottomNavTabSelectedListener {

        private static final String SPEED_DIAL_TAG = "speed_dial";
        private static final String CALL_LOG_TAG = "call_log";
        private static final String CONTACTS_TAG = "contacts";

        private final AppCompatActivity activity;
        private final FragmentManager fragmentManager;
        private final FloatingActionButton fab;
        private final View bottomSheet;

        @TabIndex
        private int selectedTab = TabIndex.NO_TAB;

        private MainBottomNavBarBottomNavTabListener(
                AppCompatActivity activity,
                FragmentManager fragmentManager,
                FloatingActionButton fab,
                View bottomSheet) {
            this.activity = activity;
            this.fragmentManager = fragmentManager;
            this.fab = fab;
            this.bottomSheet = bottomSheet;
        }

        private static void showPromotionBottomSheet(Context context, View view) {
            BottomSheetBehavior<View> bottomSheetBehavior = BottomSheetBehavior.from(view);
            Optional<Promotion> promotionOptional =
                    PromotionComponent.get(context)
                            .promotionManager()
                            .getHighestPriorityPromotion(PromotionType.BOTTOM_SHEET);
            if (!promotionOptional.isPresent()) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                return;
            }

            Promotion promotion = promotionOptional.get();
            ImageView icon = view.findViewById(R.id.promotion_icon);
            icon.setImageResource(promotion.getIconRes());
            TextView details = view.findViewById(R.id.promotion_details);
            details.setText(promotion.getDetails());
            // Required to make link clickable.
            details.setMovementMethod(LinkMovementMethod.getInstance());
            TextView title = view.findViewById(R.id.promotion_title);
            title.setText(promotion.getTitle());
            view.findViewById(R.id.ok_got_it)
                    .setOnClickListener(
                            v -> {
                                promotion.dismiss();
                                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                            });
            view.setVisibility(View.VISIBLE);
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }

        @Override
        public void onSpeedDialSelected() {
            LogUtil.enterBlock("MainBottomNavBarBottomNavTabListener.onSpeedDialSelected");
            if (selectedTab == TabIndex.SPEED_DIAL) {
                return;
            }
            Logger.get(activity).logScreenView(ScreenEvent.Type.MAIN_SPEED_DIAL, activity);
            selectedTab = TabIndex.SPEED_DIAL;


                Fragment fragment = fragmentManager.findFragmentByTag(SPEED_DIAL_TAG);
                showFragment(fragment == null ? new OldSpeedDialFragment() : fragment, SPEED_DIAL_TAG);

            fab.show();
        }

        @Override
        public void onCallLogSelected() {
            LogUtil.enterBlock("MainBottomNavBarBottomNavTabListener.onCallLogSelected");
            if (selectedTab == TabIndex.CALL_LOG) {
                return;
            }
            Logger.get(activity).logScreenView(ScreenEvent.Type.MAIN_CALL_LOG, activity);
            selectedTab = TabIndex.CALL_LOG;
            Fragment fragment = fragmentManager.findFragmentByTag(CALL_LOG_TAG);
            showFragment(fragment == null ? new CallLogFragment() : fragment, CALL_LOG_TAG);
            fab.show();
            showPromotionBottomSheet(activity, bottomSheet);
        }

        @Override
        public void onContactsSelected() {
            LogUtil.enterBlock("MainBottomNavBarBottomNavTabListener.onContactsSelected");
            if (selectedTab == TabIndex.CONTACTS) {
                return;
            }
            Logger.get(activity).logScreenView(ScreenEvent.Type.MAIN_CONTACTS, activity);
            selectedTab = TabIndex.CONTACTS;
            Fragment fragment = fragmentManager.findFragmentByTag(CONTACTS_TAG);
            showFragment(
                    fragment == null ? ContactsFragment.newInstance(Header.ADD_CONTACT) : fragment,
                    CONTACTS_TAG);
            fab.show();
        }

        /**
         * Shows the passed in fragment and hides all of the others in one transaction.
         *
         * <p>Exactly one of fragment or supportFragment should be provided.
         *
         * <p>Executes all fragment shows/hides in one transaction with no conflicting transactions
         * (like showing and hiding the same fragment in the same transaction). See a bug.
         *
         * <p>Special care should be taken to avoid calling this method several times in a short window
         * as it can lead to fragments overlapping.
         */
        private void showFragment(
                @Nullable Fragment fragment,
                String tag) {
            LogUtil.enterBlock("MainBottomNavBarBottomNavTabListener.showFragment");
            Fragment oldSpeedDial = fragmentManager.findFragmentByTag(SPEED_DIAL_TAG);
            Fragment oldCallLog = fragmentManager.findFragmentByTag(CALL_LOG_TAG);
            Fragment contacts = fragmentManager.findFragmentByTag(CONTACTS_TAG);

            FragmentTransaction transaction = fragmentManager.beginTransaction();
            boolean fragmentShown = showIfEqualElseHide(transaction, fragment, oldSpeedDial);
            fragmentShown |= showIfEqualElseHide(transaction, fragment, oldCallLog);
            fragmentShown |= showIfEqualElseHide(transaction, fragment, contacts);

            if (!fragmentShown && fragment != null) {
                LogUtil.i(
                        "MainBottomNavBarBottomNavTabListener.showFragment", "Not added yet: " + fragment);
                transaction.add(R.id.fragment_container, fragment, tag);
            }

                transaction.commit();


        }

        /**
         * @param fragment1 will be shown if equal to {@code fragment2}
         * @param fragment2 will be hidden if unequal to {@code fragment1}
         * @return {@code true} if {@code fragment1} was shown
         */
        private boolean showIfEqualElseHide(
                FragmentTransaction transaction, Fragment fragment1, Fragment fragment2) {
            boolean shown = false;
            if (fragment1 != null && fragment1.equals(fragment2)) {
                transaction.show(fragment1);
                shown = true;
            } else if (fragment2 != null) {
                transaction.hide(fragment2);
            }
            return shown;
        }

    }

    private static final class LastTabController {

        private final Context context;
        private final BottomNavBar bottomNavBar;

        LastTabController(Context context, BottomNavBar bottomNavBar) {
            this.context = context;
            this.bottomNavBar = bottomNavBar;
        }

        /**
         * Get the last tab shown to the user, or the speed dial tab if this is the first time the user
         * has opened the app.
         */
        @TabIndex
        int getLastTab() {
            @TabIndex int tabIndex;

            tabIndex =
                    StorageComponent.get(context)
                            .unencryptedSharedPrefs()
                            .getInt(KEY_LAST_TAB, TabIndex.SPEED_DIAL);

            return tabIndex;
        }

        void onActivityStop() {
            StorageComponent.get(context)
                    .unencryptedSharedPrefs()
                    .edit()
                    .putInt(KEY_LAST_TAB, bottomNavBar.getSelectedTab())
                    .apply();
        }
    }
}
