package com.fdbr.android.base;

import android.os.Bundle;
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

    protected void bindView() {
        ButterKnife.bind(this);
    }
}
