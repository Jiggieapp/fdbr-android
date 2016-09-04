package com.fdbr.android.view.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.webkit.WebView;

import com.fdbr.android.R;
import com.fdbr.android.base.BaseActivity;
import com.fdbr.android.model.PredefinedModel;
import com.fdbr.android.presenter.implementation.AccountPresenterImplementation;
import com.fdbr.android.utils.Constant;
import com.fdbr.android.utils.Utils;
import com.fdbr.android.view.interfaces.AccountView;
import com.google.gson.Gson;

import butterknife.BindView;

/**
 * Created by LTE on 8/15/2016.
 */
public class SplashScreenActivity extends BaseActivity implements AccountView.PredefinedView{

    @BindView(R.id.webview)
    WebView webview;

    AccountPresenterImplementation.PredefinedPresenterImplementation predefinedPresenterImplementation;
    private final String TAG = SplashScreenActivity.class.getSimpleName();

    @Override
    protected void onCreate() {
        //https://www.instagram.com/oauth/authorize/?client_id=b7c32efe0a9f4a4a8b5b2338dc6d5bf3&redirect_uri=http://api-dev.femaledaily.net/test_insta&response_type=code
        final String clientId = /*"b7c32efe0a9f4a4a8b5b2338dc6d5bf3"*/ "d810cbab41514cfcbf272e7d1142a58c";
        final String url = "https://api.instagram.com/oauth/authorize/?client_id=" + clientId + "&redirect_uri=http://api-dev.femaledaily.net/test_insta&response_type=code";
        //webview.loadUrl(url);
        webview.setVisibility(View.GONE);

        predefinedPresenterImplementation = new AccountPresenterImplementation.PredefinedPresenterImplementation();
        predefinedPresenterImplementation.onAttachView(this);

        Utils.showMyProgressDialog(SplashScreenActivity.this);
        predefinedPresenterImplementation.predefined();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_splashscreen;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        predefinedPresenterImplementation.onUnattachView();
    }

    @Override
    public void predefined(PredefinedModel predefinedModel) {

        String sd = String.valueOf(new Gson().toJson(predefinedModel));
        Utils.d(TAG, "sd " + sd);

        String model = new Gson().toJson(predefinedModel);
        saveToPreference(Constant.PREDEFINED, model);

        Utils.dismissMyProgressDialog(SplashScreenActivity.this);

        startActivity(new Intent(SplashScreenActivity.this, WelcomeActivity.class));

    }
}
