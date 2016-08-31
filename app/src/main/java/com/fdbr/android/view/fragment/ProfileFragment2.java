package com.fdbr.android.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fdbr.android.R;
import com.fdbr.android.model.ProfileModel;
import com.fdbr.android.presenter.implementation.ProfilePresenterImplementation;
import com.fdbr.android.utils.Utils;
import com.fdbr.android.view.interfaces.ProfileView;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by LTE on 8/15/2016.
 */
public class ProfileFragment2 extends Fragment implements ProfileView.DetailProfileView {

    /*@BindView(R.id.lbl_count_reviews) TextView lblCountRevies;
    @BindView(R.id.lbl_count_followers) TextView lblCountFollowers;
    @BindView(R.id.lbl_count_following) TextView lblCountFollowing;
    @BindView(R.id.lbl_user_name) TextView lblUserName;
    @BindView(R.id.lbl_user_description) TextView lblUserDescription;
    @BindView(R.id.profile_image) CircleImageView profileImage;*/

    private final String TAG = ProfileFragment2.class.getSimpleName();
    private ProfilePresenterImplementation.DetailProfilePresenterImplementation detailProfilePresenterImplementation;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, null);
        //profileImage = (CircleImageView) v.findViewById(R.id.profile_image);
        ButterKnife.bind(this, v);
        detailProfilePresenterImplementation = new ProfilePresenterImplementation.DetailProfilePresenterImplementation();
        detailProfilePresenterImplementation.onAttachView(this);
        detailProfilePresenterImplementation.detailProfile("43417");
        return v;
    }

    @Override
    public void detailProfile(ProfileModel profileModel) {
        String sd = String.valueOf(new Gson().toJson(profileModel));
        Utils.d(TAG, sd);

        /*Glide.with(this)
                .load("https://s3-ap-southeast-1.amazonaws.com/picup-stage/uploads/243/IMG_20160823_141834.jpg")
                .asBitmap()
                .into(profileImage);

        ProfileModel.Data data = profileModel.getData();
        lblCountFollowers.setText(data.getFollower_count() + "");
        lblCountFollowing.setText(data.getFollowing_count() + "");
        lblCountRevies.setText(data.getTotal_review() + "");

        lblUserName.setText(data.getFullname());
        lblUserDescription.setText(data.getBio());*/
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        detailProfilePresenterImplementation.onUnattachView();
    }
}
