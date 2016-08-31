package com.fdbr.android.view.activity;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.fdbr.android.R;
import com.fdbr.android.base.BaseActivity;
import com.fdbr.android.model.AccessToken;
import com.fdbr.android.model.LoginModel;
import com.fdbr.android.presenter.implementation.AccessTokenPresenterImplementation;
import com.fdbr.android.presenter.implementation.AccountPresenterImplementation;
import com.fdbr.android.utils.Constant;
import com.fdbr.android.utils.Utils;
import com.fdbr.android.view.interfaces.AccessTokenView;
import com.fdbr.android.view.interfaces.AccountView;
import com.google.gson.Gson;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by LTE on 8/15/2016.
 */
public class LoginActivity extends BaseActivity implements AccessTokenView, AccountView.LoginView {


    @BindView(R.id.edt_username)
    MaterialEditText edtUsername;
    @BindView(R.id.edt_password)
    MaterialEditText edtPassword;
    @BindView(R.id.rel_signin)
    RelativeLayout relSignin;
    private AccessTokenPresenterImplementation implementation;
    private final String TAG = LoginActivity.class.getSimpleName();

    private AccountPresenterImplementation.LoginPresenterImplementation loginImplementation;

    public void getAccessToken(AccessToken accessToken) {
        //getSharedPreferences().edit().putString(Constant.ANDROID_KEY, accessToken.token).commit();
        saveToPreference(Constant.ACCESS_TOKEN_PREF, accessToken.token);
        implementation.verifyToken();
    }

    @Override
    protected void onCreate() {
        initView();

        implementation = new AccessTokenPresenterImplementation();
        implementation.onAttachView(this);
        //implementation.getAccessToken();

        loginImplementation = new AccountPresenterImplementation.LoginPresenterImplementation();
        loginImplementation.onAttachView(this);

    }

    private void initView(){
        getSupportActionBar().setTitle(Utils.getStringResource(this, R.string.sgin));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.rel_signin)
    public void onLoginClick() {

        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();

        boolean isPasswordValid = Utils.validasiInput(Constant.TYPE_PASSWORD, username);

        if (!isPasswordValid) {
            Utils.showToast(LoginActivity.this, Utils.getStringResource(LoginActivity.this, R.string.inval_password));
        } else {
            HashMap<String, Object> postLoginModel = new HashMap<>();
            postLoginModel.put("username", username);
            postLoginModel.put("password", password);

            String sd = String.valueOf(new Gson().toJson(postLoginModel));
            Log.d("sd", "sd");

            loginImplementation.login(Constant.URL_LOGIN, postLoginModel);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        implementation.onUnattachView();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    public void login(LoginModel loginModel) {

        String sd = String.valueOf(new Gson().toJson(loginModel));
        Log.d("sd", "sd");

        /*saveToPreference(Constant.ACCESS_TOKEN_PREF, loginModel.getData().getToken());
        implementation.verifyToken();*/
    }


}
