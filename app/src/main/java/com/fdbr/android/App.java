package com.fdbr.android;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Wandy on 8/18/2016.
 */
public class App extends Application {

    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
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
