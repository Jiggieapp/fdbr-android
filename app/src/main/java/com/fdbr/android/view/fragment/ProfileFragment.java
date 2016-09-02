package com.fdbr.android.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fdbr.android.App;
import com.fdbr.android.R;
import com.fdbr.android.model.ProfileModel;
import com.fdbr.android.presenter.implementation.ProfilePresenterImplementation;
import com.fdbr.android.utils.Constant;
import com.fdbr.android.utils.Utils;
import com.fdbr.android.view.interfaces.ProfileView;
import com.fdbr.android.view.widget.RevealBackgroundView;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by LTE on 8/15/2016.
 */
public class ProfileFragment extends Fragment implements ProfileView.DetailProfileView, RevealBackgroundView.OnStateChangeListener {

    private final String TAG = ProfileFragment.class.getSimpleName();
    @BindView(R.id.vRevealBackground)
    RevealBackgroundView vRevealBackground;
    /*@BindView(R.id.rvUserProfile)
    RecyclerView rvUserProfile;*/
    @BindView(R.id.ivUserProfilePhoto)
    ImageView ivUserProfilePhoto;
    @BindView(R.id.vUserDetails)
    LinearLayout vUserDetails;
    @BindView(R.id.vUserStats)
    LinearLayout vUserStats;
    @BindView(R.id.vUserProfileRoot)
    LinearLayout vUserProfileRoot;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.tlUserProfileTabs)
    TabLayout tlUserProfileTabs;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.content)
    CoordinatorLayout content;
    @BindView(R.id.rel_editprofile)
    RelativeLayout relEditprofile;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.txt_reviews)
    TextView txtReviews;
    @BindView(R.id.txt_followers)
    TextView txtFollowers;
    @BindView(R.id.txt_following)
    TextView txtFollowing;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.txt_location)
    TextView txtLocation;
    @BindView(R.id.txt_desc)
    TextView txtDesc;
    @BindView(R.id.txt_username)
    TextView txtUsername;

    private ProfilePresenterImplementation.DetailProfilePresenterImplementation detailProfilePresenterImplementation;
    private static final int USER_OPTIONS_ANIMATION_DELAY = 300;
    private static final Interpolator INTERPOLATOR = new DecelerateInterpolator();

    //ProfileFeedAdapter profileFeedAdapter;

    ProfilePageAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, null);
        ButterKnife.bind(this, v);


        adapter = new ProfilePageAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(adapter.getCount());
        tlUserProfileTabs.setupWithViewPager(viewPager);

        setupTabs();
        setupRevealBackground(savedInstanceState, v);

        detailProfilePresenterImplementation = new ProfilePresenterImplementation.DetailProfilePresenterImplementation();
        detailProfilePresenterImplementation.onAttachView(this);

        detailProfilePresenterImplementation.detailProfile(App.getFromPreference(Constant.USER_ID));

        return v;
    }

    @Override
    public void detailProfile(ProfileModel profileModel) {
        String sd = String.valueOf(new Gson().toJson(profileModel));
        Log.d("sd", "sd");

        ProfileModel.Data data = profileModel.getData();

        txtUsername.setText(data.getUsername());
        txtName.setText(data.getFullname());
        txtReviews.setText(String.valueOf(data.getTotal_review()));
        txtFollowers.setText(String.valueOf(data.getFollower_count()));
        txtFollowing.setText(String.valueOf(data.getFollowing_count()));
        //txtLocation.setText("");
        txtDesc.setText(data.getBio());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        detailProfilePresenterImplementation.onUnattachView();
    }

    private void setupTabs() {
        tlUserProfileTabs.getTabAt(0).setText(Utils.getStringResource(getActivity(), R.string.feed));
        tlUserProfileTabs.getTabAt(1).setText(Utils.getStringResource(getActivity(), R.string.pf_beautyid));
        /*tlUserProfileTabs.getTabAt(2).setText(Utils.getStringResource(getActivity(), R.string.wishlist));
        tlUserProfileTabs.getTabAt(3).setText(Utils.getStringResource(getActivity(), R.string.tried));*/
    }

    private void setupRevealBackground(Bundle savedInstanceState, View v) {
        vRevealBackground.setOnStateChangeListener(this);
        if (savedInstanceState == null) {
            //final int[] startingLocation = getActivity().getIntent().getIntArrayExtra(ARG_REVEAL_START_LOCATION);

            final int[] startingLocation = new int[2];
            //v.getLocationOnScreen(startingLocation);
            startingLocation[0] += v.getWidth();

            vRevealBackground.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    vRevealBackground.getViewTreeObserver().removeOnPreDrawListener(this);
                    vRevealBackground.startFromLocation(startingLocation);
                    return true;
                }
            });
        } else {
            vRevealBackground.setToFinishedFrame();
        }
    }

    @Override
    public void onStateChange(int state) {
        if (RevealBackgroundView.STATE_FINISHED == state) {
            viewPager.setVisibility(View.VISIBLE);
            tlUserProfileTabs.setVisibility(View.VISIBLE);
            vUserProfileRoot.setVisibility(View.VISIBLE);

            animateUserProfileOptions();
            animateUserProfileHeader();
        } else {
            tlUserProfileTabs.setVisibility(View.INVISIBLE);
            viewPager.setVisibility(View.INVISIBLE);
            vUserProfileRoot.setVisibility(View.INVISIBLE);
        }
    }

    private void animateUserProfileOptions() {
        tlUserProfileTabs.setTranslationY(-tlUserProfileTabs.getHeight());
        tlUserProfileTabs.animate().translationY(0).setDuration(300).setStartDelay(USER_OPTIONS_ANIMATION_DELAY).setInterpolator(INTERPOLATOR);
    }

    private void animateUserProfileHeader() {
        vUserProfileRoot.setTranslationY(-vUserProfileRoot.getHeight());
        ivUserProfilePhoto.setTranslationY(-ivUserProfilePhoto.getHeight());
        vUserDetails.setTranslationY(-vUserDetails.getHeight());
        vUserStats.setAlpha(0);

        vUserProfileRoot.animate().translationY(0).setDuration(300).setInterpolator(INTERPOLATOR);
        ivUserProfilePhoto.animate().translationY(0).setDuration(300).setStartDelay(100).setInterpolator(INTERPOLATOR);
        vUserDetails.animate().translationY(0).setDuration(300).setStartDelay(200).setInterpolator(INTERPOLATOR);
        vUserStats.animate().alpha(1).setDuration(200).setStartDelay(400).setInterpolator(INTERPOLATOR).start();
    }

    @OnClick(R.id.rel_editprofile)
    public void onClick() {
    }

    protected class ProfilePageAdapter extends FragmentPagerAdapter {
        private Fragment[] fragments;

        public ProfilePageAdapter(FragmentManager fm) {
            super(fm);
            this.fragments = new Fragment[]{
                    new ProfileFeedFragment(),
                    new ProfileBeautyFragment()
                    /*new WishlistFragment(),
                    new TriedFragment(),*/
            };
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public int getCount() {
            return fragments.length;
        }
    }
}
