package com.fdbr.android.api;

import com.fdbr.android.model.BrandModel;
import com.fdbr.android.utils.Constant;

import retrofit2.Response;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by LTE on 8/15/2016.
 */
public interface ProductAPI {

    @GET(Constant.URL_BRAND)
    Observable<Response<BrandModel>> getBrandList();

}
