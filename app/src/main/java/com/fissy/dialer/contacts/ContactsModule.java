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

package com.fissy.dialer.contacts;

import android.content.Context;
import android.os.UserManager;
import com.fissy.dialer.contacts.displaypreference.ContactDisplayPreferences;
import com.fissy.dialer.contacts.displaypreference.ContactDisplayPreferencesImpl;
import com.fissy.dialer.contacts.displaypreference.ContactDisplayPreferencesStub;
import com.fissy.dialer.contacts.hiresphoto.HighResolutionPhotoRequester;
import com.fissy.dialer.contacts.hiresphoto.HighResolutionPhotoRequesterImpl;
import com.fissy.dialer.inject.ApplicationContext;
import com.fissy.dialer.inject.DialerVariant;
import com.fissy.dialer.inject.InstallIn;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;

/** Module for standard {@link ContactsComponent} */
@InstallIn(variants = {DialerVariant.DIALER_TEST})
@Module
public abstract class ContactsModule {
  @Provides
  public static ContactDisplayPreferences provideContactDisplayPreferences(
      @ApplicationContext Context appContext,
      Lazy<ContactDisplayPreferencesImpl> impl,
      ContactDisplayPreferencesStub stub) {
    if (appContext.getSystemService(UserManager.class).isUserUnlocked()) {
      return impl.get();
    }
    return stub;
  }

  @Binds
  public abstract HighResolutionPhotoRequester toHighResolutionPhotoRequesterImpl(
      HighResolutionPhotoRequesterImpl impl);
}
