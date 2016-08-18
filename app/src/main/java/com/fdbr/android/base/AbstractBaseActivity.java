package com.fdbr.android.base;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.fdbr.android.R;

import butterknife.ButterKnife;

/**
 * Created by Wandy on 8/16/2016.
 */
public abstract class AbstractBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    protected void bindView() {
        ButterKnife.bind(this);
    }

    private SharedPreferences getSharedPreferences()
    {
        return PreferenceManager.getDefaultSharedPreferences(this);
    }

    public void saveToPreference(final String key, final String value)
    {
        getSharedPreferences().edit()
                .putString(key, value)
                .commit();
    }
}
