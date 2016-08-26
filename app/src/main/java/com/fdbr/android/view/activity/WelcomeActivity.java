package com.fdbr.android.view.activity;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import com.fdbr.android.R;
import com.fdbr.android.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by LTE on 8/24/2016.
 */
public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.txt_login)
    TextView txtLogin;
    @BindView(R.id.btn_signup)
    Button btnSignup;

    @Override
    protected void onCreate() {

    }

    @OnClick(R.id.btn_signup)
    public void onSignupClick() {
        startActivity(new Intent(WelcomeActivity.this, SignUpActivity.class));
    }

    @OnClick(R.id.txt_login)
    public void onLoginClick() {
        startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
    }

    @Override
    public int getContentView() {
        return R.layout.activity_welcome;
    }
}
