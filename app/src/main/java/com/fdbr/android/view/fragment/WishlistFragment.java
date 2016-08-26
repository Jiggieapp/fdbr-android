package com.fdbr.android.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fdbr.android.R;
import com.fdbr.android.model.WishlistModel;
import com.fdbr.android.presenter.implementation.ProfilePresenterImplementation;
import com.fdbr.android.view.interfaces.ProfileView;

import java.util.HashMap;

/**
 * Created by LTE on 8/23/2016.
 */
public class WishlistFragment extends Fragment implements ProfileView.WishlistView {

    private final String TAG = WishlistFragment.class.getSimpleName();
    private ProfilePresenterImplementation.WishlistPresenterImplementation wishlistPresenterImplementation;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_wishlist, null);

        wishlistPresenterImplementation = new ProfilePresenterImplementation.WishlistPresenterImplementation();
        wishlistPresenterImplementation.onAttachView(this);
        wishlistPresenterImplementation.wishlist("", new HashMap<String, Object>());

        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        wishlistPresenterImplementation.onUnattachView();
    }

    @Override
    public void getWishlist(WishlistModel wishlistModel) {

    }
}
