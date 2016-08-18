package com.fdbr.android.api;

import com.fdbr.android.Constant;
import com.fdbr.android.api.response.AccessToken;
import com.fdbr.android.api.response.Success;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Wandy on 8/18/2016.
 */
public interface AccessTokenAPI {

    @GET(Constant.ACCESS_TOKEN_URL)
    Observable<AccessToken> getAccessToken();

    @GET(Constant.VERIFY_ACCESS_TOKEN_URL)
    Observable<Success> verifyAccessToken();
}
