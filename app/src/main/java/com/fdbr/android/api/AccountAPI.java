package com.fdbr.android.api;

import com.fdbr.android.model.LoginModel;
import com.fdbr.android.model.PredefinedModel;
import com.fdbr.android.model.RegisterModel;
import com.fdbr.android.utils.Constant;

import java.util.HashMap;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by LTE on 8/15/2016.
 */
public interface AccountAPI {

    @POST
    Observable<Response<RegisterModel>> postRegister(@Url String url, @Body HashMap<String, Object> postRegisterModel);

    @POST
    Observable<Response<LoginModel>> postLogin(@Url String url, @Body HashMap<String, Object> postLoginModel);

    @GET(Constant.URL_PREDEFINED)
    Observable<Response<PredefinedModel>> getPredefined();

}
