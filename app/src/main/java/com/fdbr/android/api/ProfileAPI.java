package com.fdbr.android.api;

import com.fdbr.android.model.FeedProfileModel;
import com.fdbr.android.model.FollowModel;
import com.fdbr.android.model.ProfileModel;
import com.fdbr.android.model.TriedModel;
import com.fdbr.android.model.WishlistModel;
import com.fdbr.android.utils.Constant;

import java.util.HashMap;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by LTE on 8/23/2016.
 */
public interface ProfileAPI {

    @GET(Constant.URL_PROFILE)
    Observable<Response<ProfileModel>> getDetailProfile(@Path("user_id") String id);

    @GET(Constant.URL_WISHLIST)
    Observable<Response<WishlistModel>> getWishlist(@Path("user_id") String id, @QueryMap HashMap<String, Object> query);

    @GET(Constant.URL_TRIED)
    Observable<Response<TriedModel>> getTried(@Path("user_id") String id, @QueryMap HashMap<String, Object> query);

    @GET(Constant.URL_FEED_PROFILE)
    Observable<Response<FeedProfileModel>> getFeedProfile(@Path("user_id") String id, @QueryMap HashMap<String, Object> query);

    @POST(Constant.URL_FOLLOW)
    Observable<Response<FollowModel>> follow(@Body HashMap<String, String> rateModel);

}
