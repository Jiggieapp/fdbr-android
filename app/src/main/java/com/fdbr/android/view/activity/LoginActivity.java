package com.fdbr.android.view.activity;

import android.util.Log;
import android.widget.Button;

import com.fdbr.android.R;
import com.fdbr.android.base.BaseActivity;
import com.fdbr.android.model.AccessToken;
import com.fdbr.android.model.LoginModel;
import com.fdbr.android.model.RegisterModel;
import com.fdbr.android.presenter.implementation.AccessTokenPresenterImplementation;
import com.fdbr.android.presenter.implementation.AccountPresenterImplementation;
import com.fdbr.android.utils.Constant;
import com.fdbr.android.view.interfaces.AccessTokenView;
import com.fdbr.android.view.interfaces.AccountView;
import com.google.gson.Gson;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by LTE on 8/15/2016.
 */
public class LoginActivity extends BaseActivity implements AccessTokenView, AccountView.LoginView, AccountView.RegisterView {

    @BindView(R.id.btnLogin)
    Button btnLogin;

    private AccessTokenPresenterImplementation implementation;
    private final String TAG = LoginActivity.class.getSimpleName();

    private AccountPresenterImplementation.LoginPresenterImplementation loginImplementation;
    private AccountPresenterImplementation.RegisterPresenterImplementation registerImplementation;

    public void getAccessToken(AccessToken accessToken) {
        //getSharedPreferences().edit().putString(Constant.ANDROID_KEY, accessToken.token).commit();
        saveToPreference(Constant.ACCESS_TOKEN_PREF, accessToken.token);
        implementation.verifyToken();
    }

    @Override
    protected void onCreate() {
        implementation = new AccessTokenPresenterImplementation();
        implementation.onAttachView(this);
        //implementation.getAccessToken();

        loginImplementation = new AccountPresenterImplementation.LoginPresenterImplementation();
        loginImplementation.onAttachView(this);

        registerImplementation = new AccountPresenterImplementation.RegisterPresenterImplementation();
        registerImplementation.onAttachView(this);

    }

    @OnClick(R.id.btnLogin)
    public void onLoginClick() {
        /*HashMap<String, Object> postLoginModel = new HashMap<>();
        postLoginModel.put("username", "jjjsss1212123456");
        postLoginModel.put("password", "Admin123!");

        String sd = String.valueOf(new Gson().toJson(postLoginModel));
        Log.d("sd","sd");

        loginImplementation.login(Constant.URL_LOGIN, postLoginModel);*/

        HashMap<String, Object> postRegisterModel = new HashMap<>();
        postRegisterModel.put("username", "kukukurata");
        postRegisterModel.put("password", "kukukurata");
        postRegisterModel.put("email", "torontoojan@gmail.com!");

        String sd = String.valueOf(new Gson().toJson(postRegisterModel));
        Log.d("sd","sd");

        registerImplementation.register(Constant.URL_REGISTER, postRegisterModel);
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
        Log.d("sd","sd");

        saveToPreference(Constant.ACCESS_TOKEN_PREF, loginModel.getData().getToken());
        implementation.verifyToken();
    }

    @Override
    public void register(RegisterModel registerModel) {
        String sd = String.valueOf(new Gson().toJson(registerModel));
        Log.d("sd","sd");
    }
}
