package com.fdbr.android.view.interfaces;

import com.fdbr.android.model.FeedProfileModel;
import com.fdbr.android.model.ProfileModel;
import com.fdbr.android.model.TriedModel;
import com.fdbr.android.model.WishlistModel;

/**
 * Created by LTE on 8/23/2016.
 */
public class ProfileView {

    public interface DetailProfileView{
        void detailProfile(ProfileModel profileModel);
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
    public interface FeedProfileView{
        void getFeedProfile(FeedProfileModel feedProfileModel);
    }

    public interface ProfileProfileView{
        void getProfileProfile();
    }

    public interface WishlistView{
        void getWishlist(WishlistModel wishlistModel);
    }

    public interface TriedView{
        void getTried(TriedModel triedModel);
    }

    public interface PredefinedView{
        void preDefined();
    }
    //------------------------

    public interface OnFollow
    {
        void follow();
    }

}
