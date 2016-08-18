package com.fdbr.android.manager;

import com.fdbr.android.api.AccessTokenAPI;
import com.fdbr.android.api.response.AccessToken;
import com.fdbr.android.api.response.Success;
import com.fdbr.android.base.BaseNetworkManager;
import com.fdbr.android.manager.basepresenter.AccessTokenPresenter;
import com.fdbr.android.utils.Utils;
import com.fdbr.android.view.AccessTokenView;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Wandy on 8/18/2016.
 */
public class AccessTokenPresenterImplementation extends BaseNetworkManager implements AccessTokenPresenter {

    private AccessTokenView accessTokenView;
    private Subscription subscription;
    private static AccessTokenAPI accessTokenAPI;
    private final String TAG = AccessTokenPresenterImplementation.class.getSimpleName();

    @Override
    public void getAccessToken() {
        subscription = getInstanceForToken()
                .getAccessToken()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<AccessToken>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Utils.d(TAG, e.toString());
                    }

                    @Override
                    public void onNext(AccessToken accessToken) {
                        accessTokenView.getAccessToken(accessToken);
                    }
                });
    }

    @Override
    public void verifyToken() {
        subscription = getInstance().verifyAccessToken()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Success>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(Success success) {
                    }
                });
    }

    @Override
    public void onAttachView(AccessTokenView view) {
        this.accessTokenView = view;
    }

    @Override
    public void onUnattachView() {
        accessTokenAPI = null;
        subscription.unsubscribe();
    }

    private static AccessTokenAPI getInstanceForToken()
    {
        return getRetrofitForToken().create(AccessTokenAPI.class);
    }

    private static AccessTokenAPI getInstance()
    {
        if(accessTokenAPI == null)
            accessTokenAPI = getRetrofit().create(AccessTokenAPI.class);
        return accessTokenAPI;
    }
}
