package com.fdbr.android.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;

/**
 * Created by Wandy on 8/16/2016.
 */
public abstract class BaseActivity extends AbstractBaseActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        super.bindView();
        onCreate();
    }


    protected abstract void onCreate();
    public abstract int getContentView();
}
