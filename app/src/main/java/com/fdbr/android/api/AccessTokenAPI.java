package com.fdbr.android.api;

import com.fdbr.android.utils.Constant;
import com.fdbr.android.model.AccessToken;
import com.fdbr.android.model.Success;

import retrofit2.Response;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Wandy on 8/18/2016.
 */
public interface AccessTokenAPI {

    @GET(Constant.ACCESS_TOKEN_URL)
    Observable<Response<AccessToken>> getAccessToken();

    @GET(Constant.VERIFY_ACCESS_TOKEN_URL)
    Observable<Response<Success>> verifyAccessToken();
}
