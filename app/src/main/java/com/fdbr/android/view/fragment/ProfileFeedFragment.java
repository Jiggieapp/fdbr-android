package com.fdbr.android.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fdbr.android.R;
import com.fdbr.android.model.FeedProfileModel;
import com.fdbr.android.presenter.implementation.ProfilePresenterImplementation;
import com.fdbr.android.view.adapter.ProfileFeedAdapter;
import com.fdbr.android.view.interfaces.ProfileView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LTE on 8/23/2016.
 */
public class ProfileFeedFragment extends Fragment implements ProfileView.FeedProfileView {

    private final String TAG = TriedFragment.class.getSimpleName();
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private ProfilePresenterImplementation.FeedProfilePresenterImplementation feedProfilePresenterImplementation;

    ProfileFeedAdapter profileFeedAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile_feed, null);

        /*feedProfilePresenterImplementation = new ProfilePresenterImplementation.FeedProfilePresenterImplementation();
        feedProfilePresenterImplementation.onAttachView(this);
        feedProfilePresenterImplementation.feedProfile("", new HashMap<String, Object>());*/

        ButterKnife.bind(this, v);

        setupUserProfileGrid();
        profileFeedAdapter = new ProfileFeedAdapter(getActivity());
            recyclerView.setAdapter(profileFeedAdapter);

        return v;
    }

    @Override
    public void getFeedProfile(FeedProfileModel feedProfileModel) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //feedProfilePresenterImplementation.onUnattachView();
    }

    private void setupUserProfileGrid() {
        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                profileFeedAdapter.setLockedAnimations(true);
            }
        });
    }
}
