package com.fdbr.android.view.activity;

import android.webkit.WebView;

import com.fdbr.android.R;
import com.fdbr.android.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by LTE on 8/15/2016.
 */
public class SplashScreenActivity extends BaseActivity{

    @BindView(R.id.webview)
    WebView webview;

    @Override
    protected void onCreate() {
        //https://www.instagram.com/oauth/authorize/?client_id=b7c32efe0a9f4a4a8b5b2338dc6d5bf3&redirect_uri=http://api-dev.femaledaily.net/test_insta&response_type=code
        final String clientId = /*"b7c32efe0a9f4a4a8b5b2338dc6d5bf3"*/ "d810cbab41514cfcbf272e7d1142a58c";
        final String url = "https://api.instagram.com/oauth/authorize/?client_id=" + clientId + "&redirect_uri=http://api-dev.femaledaily.net/test_insta&response_type=code";
        webview.loadUrl(url);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_splashscreen;
    }
}
