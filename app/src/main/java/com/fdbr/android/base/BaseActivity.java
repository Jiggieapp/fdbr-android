package com.fdbr.android.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return false;
    }


    protected abstract void onCreate();
    public abstract int getContentView();
}
