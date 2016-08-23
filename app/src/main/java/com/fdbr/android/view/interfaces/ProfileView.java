package com.fdbr.android.view.interfaces;

import com.fdbr.android.model.ProfileModel;

/**
 * Created by LTE on 8/23/2016.
 */
public class ProfileView {

    public interface DetailProfileView{
        void detailProfile(ProfileModel loginModel);
    }

    public interface FollowingView{
        void getFollowing();
    }

    public interface FollowersView{
        void getFollowers();
    }

    public interface ReviewsView{
        void getReviews();
    }

    //jaga-jaga klo nanti data-nya dipisah dengan detailprofile-----
    public interface FeedView{
        void getFeed();
    }

    public interface ProfileProfileView{
        void getProfileProfile();
    }

    public interface WishlistView{
        void getWishlist();
    }

    public interface TriedView{
        void getTried();
    }
    //------------------------

}
