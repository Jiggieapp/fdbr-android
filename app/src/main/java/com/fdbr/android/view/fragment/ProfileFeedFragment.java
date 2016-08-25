package com.fdbr.android.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fdbr.android.R;
import com.fdbr.android.model.FeedProfileModel;
import com.fdbr.android.presenter.implementation.ProfilePresenterImplementation;
import com.fdbr.android.view.interfaces.ProfileView;

import java.util.HashMap;

/**
 * Created by LTE on 8/23/2016.
 */
public class ProfileFeedFragment extends Fragment implements ProfileView.FeedProfileView {

    private final String TAG = TriedFragment.class.getSimpleName();
    private ProfilePresenterImplementation.FeedProfilePresenterImplementation feedProfilePresenterImplementation;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tried, null);

        feedProfilePresenterImplementation = new ProfilePresenterImplementation.FeedProfilePresenterImplementation();
        feedProfilePresenterImplementation.onAttachView(this);
        feedProfilePresenterImplementation.feedProfile("", new HashMap<String, Object>());

        return v;
    }

    @Override
    public void getFeedProfile(FeedProfileModel feedProfileModel) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        feedProfilePresenterImplementation.onUnattachView();
    }
}
