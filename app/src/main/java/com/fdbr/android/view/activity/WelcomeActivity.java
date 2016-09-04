package com.fdbr.android.view.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.fdbr.android.MainActivity;
import com.fdbr.android.R;
import com.fdbr.android.base.BaseActivity;
import com.fdbr.android.model.FBModel;
import com.fdbr.android.model.LoginModel;
import com.fdbr.android.presenter.implementation.AccountPresenterImplementation;
import com.fdbr.android.utils.Constant;
import com.fdbr.android.utils.Utils;
import com.fdbr.android.view.interfaces.AccountView;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by LTE on 8/24/2016.
 */
public class WelcomeActivity extends BaseActivity implements AccountView.LoginView{

    @BindView(R.id.txt_login)
    TextView txtLogin;
    @BindView(R.id.rel_signup)
    RelativeLayout relSignup;
    @BindView(R.id.rel_fb)
    RelativeLayout relFb;

    private AccountPresenterImplementation.LoginPresenterImplementation loginImplementation;

    private static final String[] FACEBOOK_PERMISSIONS = new String[]{
            "public_profile", "email", "user_about_me", "user_birthday", "user_photos", "user_location",
            "user_friends"
    };

    FBModel fbModel;

    CallbackManager callbackManager;

    @Override
    protected void onCreate() {

        loginImplementation = new AccountPresenterImplementation.LoginPresenterImplementation();
        loginImplementation.onAttachView(this);

        LoginManager.getInstance().registerCallback(this.callbackManager = CallbackManager.Factory.create(), this.facebookCallback);

    }

    @OnClick(R.id.rel_signup)
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

    @OnClick(R.id.rel_fb)
    public void onClick() {
        LoginManager.getInstance().logInWithReadPermissions(WelcomeActivity.this
                , Arrays.asList(FACEBOOK_PERMISSIONS));
    }

    private FacebookCallback<LoginResult> facebookCallback = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {

            for (String perm : loginResult.getRecentlyDeniedPermissions()) {
                if (Utils.contains(FACEBOOK_PERMISSIONS, perm, true)) {
                    /*Toast.makeText(getContext(), getString(R.string.facebook_permission_required), Toast.LENGTH_LONG).show();
                    btnSignIn.setEnabled(true);
                    progressDialog.dismiss();*/
                    Log.d("sd", "sd");
                    return;
                }
            }
            getProfileFacebook();
        }

        @Override
        public void onCancel() {

        }

        @Override
        public void onError(FacebookException error) {

        }
    };

    private GraphRequest.GraphJSONObjectCallback profileCallback = new GraphRequest.GraphJSONObjectCallback() {
        @Override
        public void onCompleted(JSONObject object, GraphResponse response) {
            String sd = object.toString();
            Log.d("sd", sd);

            String fb_id = object.optString("id");
            String first_name = object.optString("first_name");
            String last_name = object.optString("last_name");
            String email = object.optString("email");
            String gender = object.optString("gender");

            fbModel = new FBModel(fb_id, first_name, last_name, email, gender);

            HashMap<String, Object> postLoginModel = new HashMap<>();
            postLoginModel.put("username", Constant.BLANK);
            postLoginModel.put("password", Constant.BLANK);
            postLoginModel.put("is_fb", true);
            postLoginModel.put("fb_id", fb_id);
            postLoginModel.put("first_name", Constant.BLANK);
            postLoginModel.put("last_name", Constant.BLANK);
            postLoginModel.put("email", Constant.BLANK);
            postLoginModel.put("gender", Constant.BLANK);

            loginImplementation.login(Constant.URL_LOGIN, postLoginModel);

        }
    };

    private void getProfileFacebook() {
        final AccessToken token = AccessToken.getCurrentAccessToken();
        final Bundle parameters = new Bundle();
        final GraphRequest request = GraphRequest.newMeRequest(token, profileCallback);
        parameters.putString("fields", "id, email, gender, birthday, bio, first_name" +
                ", last_name, location, friends, picture");
        request.setParameters(parameters);
        request.executeAsync();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        this.callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void login(LoginModel loginModel) {

        saveToPreference(Constant.ACCESS_TOKEN_PREF, loginModel.getData().getToken());

        if(loginModel.getData().is_exist()){
            Intent i = new Intent(new Intent(WelcomeActivity.this, MainActivity.class));
            startActivity(i);
        }else{
            Intent i = new Intent(new Intent(WelcomeActivity.this, SignupDetailActivity.class));
            i.putExtra(Constant.IS_FACEBOOK, true);
            i.putExtra(fbModel.getClass().getName(), fbModel);
            startActivity(i);
        }
    }
}
