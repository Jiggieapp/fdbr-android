package com.fdbr.android.view.interfaces;

import com.fdbr.android.model.ProfileModel;

/**
 * Created by LTE on 8/23/2016.
 */
public class ProfileView {

    public interface DetailProfileView{
        void detailProfile(ProfileModel loginModel);
    }

    public interface EditProfileView{
        void editProfile(ProfileModel loginModel);
    }

}
