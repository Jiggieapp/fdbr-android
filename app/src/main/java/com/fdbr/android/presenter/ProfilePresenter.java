package com.fdbr.android.presenter;

import com.fdbr.android.view.interfaces.ProfileView;

/**
 * Created by LTE on 8/23/2016.
 */
public class ProfilePresenter {

    public interface DetailProfilePresenter extends BasePresenter<ProfileView.DetailProfileView>{
        void detailProfile(String id);
    }

}
