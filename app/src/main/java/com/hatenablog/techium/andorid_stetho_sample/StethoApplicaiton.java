package com.hatenablog.techium.andorid_stetho_sample;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.DumperPluginsProvider;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.dumpapp.DumperPlugin;

public class StethoApplicaiton extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initialize(Stetho.newInitializerBuilder(this).enableDumpapp(new CustomDebugDumperPluginsProvider(this)).build());
    }

    private static class CustomDebugDumperPluginsProvider implements DumperPluginsProvider {
        private final Context mContext;

        public CustomDebugDumperPluginsProvider(Context context) {
            mContext = context;
        }

        @Override
        public Iterable<DumperPlugin> get() {
            return new Stetho.DefaultDumperPluginsBuilder(mContext)
                    .provide(new TimeMeasurementDumperPlugin())
                    .finish();
        }
    }
}
