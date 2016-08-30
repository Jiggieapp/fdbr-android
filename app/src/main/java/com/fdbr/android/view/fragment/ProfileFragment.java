package com.fdbr.android.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fdbr.android.R;
import com.fdbr.android.model.ProfileModel;
import com.fdbr.android.presenter.implementation.ProfilePresenterImplementation;
import com.fdbr.android.utils.Utils;
import com.fdbr.android.view.interfaces.ProfileView;
import com.google.gson.Gson;

/**
 * Created by LTE on 8/15/2016.
 */
public class ProfileFragment extends Fragment implements ProfileView.DetailProfileView {

    private final String TAG = ProfileFragment.class.getSimpleName();
    private ProfilePresenterImplementation.DetailProfilePresenterImplementation detailProfilePresenterImplementation;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, null);

        detailProfilePresenterImplementation = new ProfilePresenterImplementation.DetailProfilePresenterImplementation();
        detailProfilePresenterImplementation.onAttachView(this);

        detailProfilePresenterImplementation.detailProfile("43417");

        return v;
    }

    @Override
    public void detailProfile(ProfileModel profileModel) {
        String sd = String.valueOf(new Gson().toJson(profileModel));
        Utils.d("sd","sd");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        detailProfilePresenterImplementation.onUnattachView();
    }
}
