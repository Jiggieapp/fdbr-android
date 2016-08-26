package com.fdbr.android.presenter;

import com.fdbr.android.view.interfaces.ProfileView;

import java.util.HashMap;

/**
 * Created by LTE on 8/23/2016.
 */
public class ProfilePresenter {

    public interface DetailProfilePresenter extends BasePresenter<ProfileView.DetailProfileView>{
        void detailProfile(String userId);
    }

    public interface WishlistPresenter extends BasePresenter<ProfileView.WishlistView>{
        void wishlist(String userId, HashMap<String, Object> query);
    }

    public interface TriedPresenter extends BasePresenter<ProfileView.TriedView>{
        void tried(String userId, HashMap<String, Object> query);
    }

    public interface FeedProfilePresenter extends BasePresenter<ProfileView.FeedProfileView>{
        void feedProfile(String userId, HashMap<String, Object> query);
    }

}
