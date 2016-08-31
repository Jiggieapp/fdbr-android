package com.fdbr.android.view.activity;

import com.fdbr.android.R;
import com.fdbr.android.base.BaseActivity;
import com.fdbr.android.utils.Utils;

/**
 * Created by LTE on 8/31/2016.
 */
public class SignupDetailActivity extends BaseActivity {

    @Override
    protected void onCreate() {
        initView();
    }

    private void initView(){
        getSupportActionBar().setTitle(Utils.getStringResource(this, R.string.sgup));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_signup_detail;
    }
}
