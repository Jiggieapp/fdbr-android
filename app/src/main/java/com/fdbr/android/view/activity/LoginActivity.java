package com.fdbr.android.view.activity;

import android.preference.PreferenceManager;

import com.fdbr.android.Constant;
import com.fdbr.android.R;
import com.fdbr.android.base.BaseActivity;
import com.fdbr.android.manager.AccessTokenPresenterImplementation;
import com.fdbr.android.model.AccessToken;
import com.fdbr.android.utils.Utils;
import com.fdbr.android.view.AccessTokenView;

/**
 * Created by LTE on 8/15/2016.
 */
public class LoginActivity extends BaseActivity implements AccessTokenView{

    private AccessTokenPresenterImplementation implementation;
    private final String TAG = LoginActivity.class.getSimpleName();

    @Override
    public void getAccessToken(AccessToken accessToken) {
        //getSharedPreferences().edit().putString(Constant.ANDROID_KEY, accessToken.token).commit();
        saveToPreference(Constant.ACCESS_TOKEN_PREF, accessToken.token);
        implementation.verifyToken();
    }

    @Override
    protected void onCreate() {
        implementation = new AccessTokenPresenterImplementation();
        implementation.onAttachView(this);
        implementation.getAccessToken();
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
}
