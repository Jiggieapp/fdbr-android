package com.fdbr.android;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

/**
 * Created by Wandy on 8/18/2016.
 */
public class App extends Application {

    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        //Fabric.with(this, new Crashlytics());
        instance = this;
    }

    private static SharedPreferences getSharedPreferences()
    {
        return PreferenceManager.getDefaultSharedPreferences(instance);
    }

    public static String getFromPreference(final String key)
    {
        return getSharedPreferences().getString(key, "");
    }

    public static App getInstance()
    {
        return instance;
    }
}
