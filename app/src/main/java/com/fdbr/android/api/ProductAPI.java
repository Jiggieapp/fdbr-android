package com.fdbr.android.api;

import com.fdbr.android.model.BrandModel;
import com.fdbr.android.model.ProductDetailModel;
import com.fdbr.android.model.ProductListModel;
import com.fdbr.android.utils.Constant;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by LTE on 8/15/2016.
 */
public interface ProductAPI {

    @GET(Constant.URL_BRAND)
    Observable<Response<BrandModel>> getBrandList();

    @GET(Constant.URL_PRODUCT_LIST)
    Observable<Response<ProductListModel>> getProductList();

    @GET(Constant.URL_PRODUCT_DETAIL)
    Observable<Response<ProductDetailModel>> getProductDetail(@Path("product_id") String product_id);

}
