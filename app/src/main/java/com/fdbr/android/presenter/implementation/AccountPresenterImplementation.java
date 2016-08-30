package com.fdbr.android.presenter.implementation;

import com.fdbr.android.api.AccountAPI;
import com.fdbr.android.api.BaseResponse;
import com.fdbr.android.base.BaseNetworkManager;
import com.fdbr.android.model.LoginModel;
import com.fdbr.android.model.RegisterModel;
import com.fdbr.android.presenter.AccountPresenter;
import com.fdbr.android.utils.Utils;
import com.fdbr.android.view.interfaces.AccountView;

import java.util.HashMap;

import retrofit2.Response;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by LTE on 8/23/2016.
 */
public class AccountPresenterImplementation  {

    //LOGIN PART=======================
    public static class LoginPresenterImplementation extends BaseNetworkManager implements AccountPresenter.LoginPresenter{
        private AccountView.LoginView loginView;
        private Subscription subscription;
        private static AccountAPI accountAPI;
        private final String TAG = AccountPresenterImplementation.LoginPresenterImplementation.class.getSimpleName();

        @Override
        public void onAttachView(AccountView.LoginView view) {
            this.loginView = view;
        }

        @Override
        public void onUnattachView() {
            accountAPI = null;
            subscription.unsubscribe();
        }

        @Override
        public void login(String url, HashMap<String, Object> postLoginModel) {
            subscription = getInstanceForToken()
                    .postLogin(url, postLoginModel)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    /*.subscribe(new Subscriber<Response<LoginModel>>() {
                        @Override
                        public void onCompleted() {
                            Utils.d(TAG, "");
                        }

                        @Override
                        public void onError(Throwable e) {
                            Utils.d(TAG, e.toString());
                        }

                        @Override
                        public void onNext(Response<LoginModel> response) {
                            int code = response.code();
                            Utils.d(TAG, String.valueOf(code));
                            if(code==204){
                                //content empty
                            }else{
                                loginView.login(response.body());
                            }
                        }
                    })*/
            .subscribe(new BaseResponse<LoginModel>() {
                @Override
                public void onError() {

                }

                @Override
                public void doOnNext(LoginModel loginModel) {
                    Utils.d(TAG, "loginmodel " + loginModel.getData().getToken());
                    loginView.login(loginModel);
                }

                @Override
                public void onCompleted() {

                }
            });
        }

        private static AccountAPI getInstanceForToken()
        {
            return getRetrofitForToken().create(AccountAPI.class);
        }

        private static AccountAPI getInstance()
        {
            if(accountAPI == null)
                accountAPI = getRetrofit().create(AccountAPI.class);
            return accountAPI;
        }
    }
    //END OF LOGIN PART=======================

    //REGISTER PART===========================
    public static class RegisterPresenterImplementation extends BaseNetworkManager implements AccountPresenter.RegisterPresenter{
        private AccountView.RegisterView registerView;
        private Subscription subscription;
        private static AccountAPI accountAPI;
        private final String TAG = AccountPresenterImplementation./*RegisterPresenterImplementation.*/class.getSimpleName();

        @Override
        public void onAttachView(AccountView.RegisterView view) {
            this.registerView = view;
        }

        @Override
        public void onUnattachView() {
            accountAPI = null;
            subscription.unsubscribe();
        }

        @Override
        public void register(String url, final HashMap<String, Object> postRegisterModel) {
            subscription = getInstanceForToken()
                    .postRegister(url, postRegisterModel)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Subscriber<Response<RegisterModel>>() {
                        @Override
                        public void onCompleted() {
                            Utils.d(TAG, "complete");
                        }

                        @Override
                        public void onError(Throwable e) {
                            Utils.d(TAG, e.toString());
                        }

                        @Override
                        public void onNext(Response<RegisterModel> response) {
                            int code = response.code();
                            Utils.d(TAG, String.valueOf(code));
                            if(code==204){
                                //content empty
                            }else{
                                registerView.register(response.body());
                            }
                        }
                    });
        }

        private static AccountAPI getInstanceForToken()
        {
            return getRetrofitForToken().create(AccountAPI.class);
        }

        private static AccountAPI getInstance()
        {
            if(accountAPI == null)
                accountAPI = getRetrofit().create(AccountAPI.class);
            return accountAPI;
        }
    }
    //END OF REGISTER PART=========================

}
