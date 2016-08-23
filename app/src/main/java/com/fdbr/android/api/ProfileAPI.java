package com.fdbr.android.api;

import com.fdbr.android.utils.Constant;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by LTE on 8/23/2016.
 */
public interface ProfileAPI {

    @GET(Constant.URL_PROFILE)
    Observable<Response<ProfileAPI>> getProfile(@Path("id") String id);

}
