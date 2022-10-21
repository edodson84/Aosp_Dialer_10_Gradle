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

package com.fissy.dialer.main.impl;

import android.Manifest;
import android.app.Activity;
import android.app.role.RoleManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.fissy.dialer.blockreportspam.ShowBlockReportSpamDialogReceiver;
import com.fissy.dialer.common.Assert;
import com.fissy.dialer.common.LogUtil;
import com.fissy.dialer.constants.ActivityRequestCodes;
import com.fissy.dialer.interactions.PhoneNumberInteraction.DisambigDialogDismissedListener;
import com.fissy.dialer.interactions.PhoneNumberInteraction.InteractionErrorCode;
import com.fissy.dialer.interactions.PhoneNumberInteraction.InteractionErrorListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This is the main activity for dialer. It hosts favorites, call log, search, dialpad, etc...
 */
// TODO(calderwoodra): Do not extend TransactionSafeActivity after new SpeedDial is launched
public class MainActivity extends AppCompatActivity
        implements com.fissy.dialer.main.MainActivityPeer.PeerSupplier,
        // TODO(calderwoodra): remove these 2 interfaces when we migrate to new speed dial fragment
        InteractionErrorListener,
        DisambigDialogDismissedListener {



    private com.fissy.dialer.main.MainActivityPeer activePeer;
    /**
     * {@link android.content.BroadcastReceiver} that shows a dialog to block a number and/or report
     * it as spam when notified.
     */
    private ShowBlockReportSpamDialogReceiver showBlockReportSpamDialogReceiver;

    /**
     * Returns intent that will open MainActivity to the specified tab.
     * <p>
     * <p>
     * /**
     *
     * @param context Context of the application package implementing MainActivity class.
     * @return intent for MainActivity.class
     */
    public static Intent getIntent(Context context) {
        return new Intent(context, MainActivity.class)
                .setAction(Intent.ACTION_VIEW)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }

    public static Activity main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main = this;
        LogUtil.enterBlock("MainActivity.onCreate");
        // If peer was set by the super, don't reset it.
        activePeer = getNewPeer();
        activePeer.onActivityCreate(savedInstanceState);

        showBlockReportSpamDialogReceiver =
                new ShowBlockReportSpamDialogReceiver(getSupportFragmentManager());
        setdialer();
    }
// function to set default dialer
    private void setdialer(){
        TelecomManager manager = (TelecomManager) getSystemService(Context.TELECOM_SERVICE);
        if(Objects.equals(manager.getDefaultDialerPackage(), getPackageName())){
            LogUtil.enterBlock("App Already Default Dialer");
        }
        else{
            launchSetDefaultDialerIntent();
        }
    }

    private void launchSetDefaultDialerIntent() {
        RoleManager roleManager;
        roleManager = (RoleManager) getSystemService(Context.ROLE_SERVICE);
        Intent intent = roleManager.createRequestRoleIntent(RoleManager.ROLE_DIALER);
        startActivityForResult(intent, ActivityRequestCodes.DEFAULT_DIALER);
    }


    protected com.fissy.dialer.main.MainActivityPeer getNewPeer() {
        return new MainActivityPeer(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        activePeer.onNewIntent(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        activePeer.onActivityResume();

        LocalBroadcastManager.getInstance(this)
                .registerReceiver(
                        showBlockReportSpamDialogReceiver, ShowBlockReportSpamDialogReceiver.getIntentFilter());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        activePeer.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        activePeer.onUserLeaveHint();
    }

    @Override
    protected void onPause() {
        super.onPause();
        activePeer.onActivityPause();

        LocalBroadcastManager.getInstance(this).unregisterReceiver(showBlockReportSpamDialogReceiver);
    }

    @Override
    protected void onStop() {
        super.onStop();
        activePeer.onActivityStop();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        activePeer.onSaveInstanceState(bundle);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            activePeer.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        if (activePeer.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void interactionError(@InteractionErrorCode int interactionErrorCode) {
        switch (interactionErrorCode) {
            case InteractionErrorCode.USER_LEAVING_ACTIVITY:
                // This is expected to happen if the user exits the activity before the interaction occurs.
                return;
            case InteractionErrorCode.CONTACT_NOT_FOUND:
            case InteractionErrorCode.CONTACT_HAS_NO_NUMBER:
            case InteractionErrorCode.OTHER_ERROR:
            default:
                // All other error codes are unexpected. For example, it should be impossible to start an
                // interaction with an invalid contact from this activity.
                throw Assert.createIllegalStateFailException(
                        "PhoneNumberInteraction error: " + interactionErrorCode);
        }
    }

    @Override
    public void onDisambigDialogDismissed() {
        // Don't do anything; the app will remain open with favorites tiles displayed.
    }

    @Override
    public com.fissy.dialer.main.MainActivityPeer getPeer() {
        return activePeer;
    }

}
