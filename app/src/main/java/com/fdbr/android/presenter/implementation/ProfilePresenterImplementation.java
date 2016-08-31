package com.fdbr.android.presenter.implementation;

import com.fdbr.android.api.BaseResponse;
import com.fdbr.android.api.ProfileAPI;
import com.fdbr.android.base.BaseNetworkManager;
import com.fdbr.android.model.FeedProfileModel;
import com.fdbr.android.model.FollowModel;
import com.fdbr.android.model.ProfileModel;
import com.fdbr.android.model.TriedModel;
import com.fdbr.android.model.WishlistModel;
import com.fdbr.android.presenter.ProfilePresenter;
import com.fdbr.android.utils.Utils;
import com.fdbr.android.view.interfaces.ProfileView;

import java.util.HashMap;

import retrofit2.Response;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by LTE on 8/23/2016.
 */
public class ProfilePresenterImplementation /*implements ProfilePresenter.OnFollowListener<ProfileView.OnFollow>*/{

    /*@Override
    public void follow(String userId, String userToFollowId) {

    }

    @Override
    public void onAttachView(ProfileView.OnFollow view) {

    }

    @Override
    public void onUnattachView() {

    }*/

    public static class DetailProfilePresenterImplementation extends BaseNetworkManager
            implements ProfilePresenter.DetailProfilePresenter{

        private ProfileView.DetailProfileView detailProfileView;
        private Subscription subscription;
        private static ProfileAPI profileAPI;
        private final String TAG = ProfilePresenterImplementation.DetailProfilePresenterImplementation.class.getSimpleName();

        @Override
        public void onAttachView(ProfileView.DetailProfileView view) {
            this.detailProfileView = view;
        }

        @Override
        public void onUnattachView() {
            profileAPI = null;
            if(subscription!=null&&!subscription.isUnsubscribed()){
                subscription.unsubscribe();
            }

        }

        @Override
        public void detailProfile(String id) {
            subscription = getInstance()
                    .getDetailProfile(id)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new BaseResponse<ProfileModel>() {
                        @Override
                        public void onError() {

                        }

                        @Override
                        public void doOnNext(ProfileModel profileModel) {
                            detailProfileView.detailProfile(profileModel);
                        }

                        @Override
                        public void onCompleted() {

                        }
                    })
                    /*.subscribe(new Subscriber<Response<ProfileModel>>() {
                        @Override
                        public void onCompleted() {
                            Utils.d(TAG, "");
                        }

                        @Override
                        public void onError(Throwable e) {
                            Utils.d(TAG, e.toString());
                        }

                        @Override
                        public void onNext(Response<ProfileModel> response) {
                            int code = response.code();
                            Utils.d(TAG, String.valueOf(code));
                            if(code==204){
                                //content empty
                            }else{
                                detailProfileView.detailProfile(response.body());
                            }


                        }
                    })*/;
        }

        private static ProfileAPI getInstance()
        {
            if(profileAPI == null)
                profileAPI = getRetrofit().create(ProfileAPI.class);
            return profileAPI;
        }
    }

    public static class WishlistPresenterImplementation extends BaseNetworkManager implements ProfilePresenter.WishlistPresenter{

        private ProfileView.WishlistView wishlistView;
        private Subscription subscription;
        private static ProfileAPI profileAPI;
        private final String TAG = ProfilePresenterImplementation.WishlistPresenterImplementation.class.getSimpleName();

        @Override
        public void onAttachView(ProfileView.WishlistView view) {
            this.wishlistView = view;
        }

        @Override
        public void onUnattachView() {
            profileAPI = null;
            subscription.unsubscribe();
        }

        @Override
        public void wishlist(String userId, HashMap<String, Object> query) {
            subscription = getInstance()
                    .getWishlist(userId, query)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Subscriber<Response<WishlistModel>>() {
                        @Override
                        public void onCompleted() {
                            Utils.d(TAG, "");
                        }

                        @Override
                        public void onError(Throwable e) {
                            Utils.d(TAG, e.toString());
                        }

                        @Override
                        public void onNext(Response<WishlistModel> response) {
                            int code = response.code();
                            Utils.d(TAG, String.valueOf(code));
                            if(code==204){
                                //content empty
                            }else{
                                wishlistView.getWishlist(response.body());
                            }


                        }
                    });
        }

        private static ProfileAPI getInstance()
        {
            if(profileAPI == null)
                profileAPI = getRetrofit().create(ProfileAPI.class);
            return profileAPI;
        }
    }

    public static class TriedPresenterImplementation extends BaseNetworkManager implements ProfilePresenter.TriedPresenter{

        private ProfileView.TriedView triedView;
        private Subscription subscription;
        private static ProfileAPI profileAPI;
        private final String TAG = ProfilePresenterImplementation.TriedPresenterImplementation.class.getSimpleName();

        @Override
        public void onAttachView(ProfileView.TriedView view) {
            this.triedView = view;
        }

        @Override
        public void onUnattachView() {
            profileAPI = null;
            subscription.unsubscribe();
        }

        @Override
        public void tried(String userId, HashMap<String, Object> query) {
            subscription = getInstance()
                    .getTried(userId, query)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Subscriber<Response<TriedModel>>() {
                        @Override
                        public void onCompleted() {
                            Utils.d(TAG, "");
                        }

                        @Override
                        public void onError(Throwable e) {
                            Utils.d(TAG, e.toString());
                        }

                        @Override
                        public void onNext(Response<TriedModel> response) {
                            int code = response.code();
                            Utils.d(TAG, String.valueOf(code));
                            if(code==204){
                                //content empty
                            }else{
                                triedView.getTried(response.body());
                            }
                        }
                    });
        }

        private static ProfileAPI getInstance()
        {
            if(profileAPI == null)
                profileAPI = getRetrofit().create(ProfileAPI.class);
            return profileAPI;
        }
    }

    public static class FeedProfilePresenterImplementation extends BaseNetworkManager
            implements ProfilePresenter.FeedProfilePresenter{

        private ProfileView.FeedProfileView feedProfileView;
        private Subscription subscription;
        private static ProfileAPI profileAPI;
        private final String TAG = ProfilePresenterImplementation.FeedProfilePresenterImplementation.class.getSimpleName();

        @Override
        public void onAttachView(ProfileView.FeedProfileView view) {
            this.feedProfileView = view;
        }

        @Override
        public void onUnattachView() {
            profileAPI = null;
            subscription.unsubscribe();
        }

        @Override
        public void feedProfile(String userId, HashMap<String, Object> query) {
            subscription = getInstance()
                    .getFeedProfile(userId, query)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Subscriber<Response<FeedProfileModel>>() {
                        @Override
                        public void onCompleted() {
                            Utils.d(TAG, "");
                        }

                        @Override
                        public void onError(Throwable e) {
                            Utils.d(TAG, e.toString());
                        }

                        @Override
                        public void onNext(Response<FeedProfileModel> response) {
                            int code = response.code();
                            Utils.d(TAG, String.valueOf(code));
                            if(code==204){
                                //content empty
                            }else{
                                feedProfileView.getFeedProfile(response.body());
                            }
                        }
                    });
        }

        private static ProfileAPI getInstance()
        {
            if(profileAPI == null)
                profileAPI = getRetrofit().create(ProfileAPI.class);
            return profileAPI;
        }
    }

    public static final class FollowPresenterImplementation extends BaseNetworkManager
            implements ProfilePresenter.OnFollowListener
    {
        private ProfileView.OnFollow view;
        private Subscription subscription;
        private ProfileAPI profileAPI;

        public void follow(String userId, String userToFollowId) {
            HashMap<String, String> hashmap = new HashMap<>();
            hashmap.put("user_id", "43409");
            hashmap.put("follow_user_id", "43412");
            subscription = getInstance()
                    .follow(hashmap)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new BaseResponse<FollowModel>() {
                        @Override
                        public void onError() {
                        }

                        @Override
                        public void doOnNext(FollowModel followModel) {
                        }

                        @Override
                        public void onCompleted() {
                        }
                    });
        }

        @Override
        public void onAttachView(ProfileView.OnFollow view) {
            this.view = view;
        }

        private ProfileAPI getInstance()
        {
            if(profileAPI == null)
                profileAPI = getRetrofit().create(ProfileAPI.class);
            return profileAPI;
        }

        @Override
        public void onUnattachView() {
            this.view = null;
            subscription.unsubscribe();
            subscription = null;
        }

    }
}
