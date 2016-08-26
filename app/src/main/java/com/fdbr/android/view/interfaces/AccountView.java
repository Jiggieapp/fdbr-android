package com.fdbr.android.view.interfaces;

import com.fdbr.android.model.LoginModel;
import com.fdbr.android.model.RegisterModel;

/**
 * Created by LTE on 8/23/2016.
 */
public class AccountView {

    public interface LoginView{
        void login(LoginModel loginModel);
    }

    public interface RegisterView{
        void register(RegisterModel registerModel);
    }


}
