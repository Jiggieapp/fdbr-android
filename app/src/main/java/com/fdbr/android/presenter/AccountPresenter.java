package com.fdbr.android.presenter;

import com.fdbr.android.view.interfaces.AccountView;

import java.util.HashMap;

/**
 * Created by LTE on 8/23/2016.
 */
public class AccountPresenter  {

    public interface LoginPresenter extends BasePresenter<AccountView.LoginView>{
        void login(String url, HashMap<String, Object> postLoginModel);
    }

    public interface RegisterPresenter extends BasePresenter<AccountView.RegisterView>{
        void register(String url, HashMap<String, Object> postRegisterModel);
    }

    public interface PredefinedPresenter extends BasePresenter<AccountView.PredefinedView>{
        void predefined();
    }

}
