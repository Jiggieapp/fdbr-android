package com.fdbr.android.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Wandy on 8/16/2016.
 */
public abstract class BaseActivity extends AbstractBaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        super.bindView();
        onCreate();
    }

    abstract void onCreate();
    abstract int getContentView();
}
