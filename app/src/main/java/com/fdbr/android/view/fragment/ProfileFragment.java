package com.fdbr.android.view.fragment;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.fdbr.android.R;
import com.fdbr.android.base.BaseActivity;
import com.fdbr.android.model.ProfileModel;
import com.fdbr.android.presenter.implementation.ProfilePresenterImplementation;
import com.fdbr.android.utils.Utils;
import com.fdbr.android.view.adapter.ProfileFeedAdapter;
import com.fdbr.android.view.interfaces.ProfileView;
import com.fdbr.android.view.widget.RevealBackgroundView;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by LTE on 8/15/2016.
 */
public class ProfileFragment extends BaseActivity implements ProfileView.DetailProfileView, RevealBackgroundView.OnStateChangeListener {

    private final String TAG = ProfileFragment.class.getSimpleName();
    @BindView(R.id.vRevealBackground)
    RevealBackgroundView vRevealBackground;
    @BindView(R.id.rvUserProfile)
    RecyclerView rvUserProfile;
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

    private ProfilePresenterImplementation.DetailProfilePresenterImplementation detailProfilePresenterImplementation;
    private static final int USER_OPTIONS_ANIMATION_DELAY = 300;
    private static final Interpolator INTERPOLATOR = new DecelerateInterpolator();

    ProfileFeedAdapter profileFeedAdapter;

    /*@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, null);

        detailProfilePresenterImplementation = new ProfilePresenterImplementation.DetailProfilePresenterImplementation();
        detailProfilePresenterImplementation.onAttachView(this);

        detailProfilePresenterImplementation.detailProfile("43417");

        ButterKnife.bind(this, v);

        setupTabs();
        setupUserProfileGrid();
        setupRevealBackground(savedInstanceState, v);

        return v;
    }*/

    @Override
    protected void onCreate() {
        setupTabs();
        setupUserProfileGrid();
        setupRevealBackground(null, content);
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_profile;
    }

    @Override
    public void detailProfile(ProfileModel profileModel) {
        String sd = String.valueOf(new Gson().toJson(profileModel));
        Log.d("sd", "sd");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //detailProfilePresenterImplementation.onUnattachView();
    }

    private void setupTabs() {
        tlUserProfileTabs.addTab(tlUserProfileTabs.newTab().setText(Utils.getStringResource(ProfileFragment.this, R.string.feed)));
        tlUserProfileTabs.addTab(tlUserProfileTabs.newTab().setText(Utils.getStringResource(ProfileFragment.this, R.string.bio)));
        tlUserProfileTabs.addTab(tlUserProfileTabs.newTab().setText(Utils.getStringResource(ProfileFragment.this, R.string.wishlist)));
        tlUserProfileTabs.addTab(tlUserProfileTabs.newTab().setText(Utils.getStringResource(ProfileFragment.this, R.string.tried)));
    }

    private void setupUserProfileGrid() {
        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvUserProfile.setLayoutManager(layoutManager);
        rvUserProfile.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                profileFeedAdapter.setLockedAnimations(true);
            }
        });
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
            profileFeedAdapter.setLockedAnimations(true);
        }
    }

    @Override
    public void onStateChange(int state) {
        if (RevealBackgroundView.STATE_FINISHED == state) {
            rvUserProfile.setVisibility(View.VISIBLE);
            tlUserProfileTabs.setVisibility(View.VISIBLE);
            vUserProfileRoot.setVisibility(View.VISIBLE);
            profileFeedAdapter = new ProfileFeedAdapter(this);
            rvUserProfile.setAdapter(profileFeedAdapter);
            animateUserProfileOptions();
            animateUserProfileHeader();
        } else {
            tlUserProfileTabs.setVisibility(View.INVISIBLE);
            rvUserProfile.setVisibility(View.INVISIBLE);
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
}
