package com.fdbr.android.api;

import com.fdbr.android.model.LoginModel;
import com.fdbr.android.model.RegisterModel;

import java.util.HashMap;

import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by LTE on 8/15/2016.
 */
public interface AccountAPI {

    @POST
    Observable<RegisterModel> postRegister(@Url String url, @Body HashMap<String, Object> registerModel);

    @POST
    Observable<LoginModel> postLogin(@Url String url, @Body HashMap<String, Object> loginModel);

}
