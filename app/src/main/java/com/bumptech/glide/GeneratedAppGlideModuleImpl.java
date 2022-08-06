package com.bumptech.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import android.util.Log;

import com.fissy.dialer.glide.DialerGlideModule;

import java.util.Collections;
import java.util.Set;

@SuppressWarnings("deprecation")
final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {
    private final DialerGlideModule appGlideModule;

    GeneratedAppGlideModuleImpl() {
        appGlideModule = new DialerGlideModule();
        if (Log.isLoggable("Glide", Log.DEBUG)) {
            Log.d("Glide", "Discovered AppGlideModule from annotation: com.fissy.dialer.glide.DialerGlideModule");
        }
    }

    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        appGlideModule.applyOptions(context, builder);
    }

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide,
                                   @NonNull Registry registry) {
        appGlideModule.registerComponents(context, glide, registry);
    }

    @Override
    public boolean isManifestParsingEnabled() {
        return appGlideModule.isManifestParsingEnabled();
    }

    @Override
    @NonNull
    public Set<Class<?>> getExcludedModuleClasses() {
        return Collections.emptySet();
    }

    @Override
    @NonNull
    GeneratedRequestManagerFactory getRequestManagerFactory() {
        return new GeneratedRequestManagerFactory();
    }
}
