package com.fdbr.android.presenter.implementation;

import com.fdbr.android.api.ProfileAPI;
import com.fdbr.android.base.BaseNetworkManager;
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
public class ProfilePresenterImplementation {

    public static class DetailProfilePresenterImplementation extends BaseNetworkManager implements ProfilePresenter.DetailProfilePresenter{

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
            subscription.unsubscribe();
        }

        @Override
        public void detailProfile(String id) {
            subscription = getInstance()
                    .getDetailProfile(id)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Subscriber<Response<ProfileModel>>() {
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
                    });
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

}
