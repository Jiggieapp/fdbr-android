package com.fdbr.android.view.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.fdbr.android.R;
import com.fdbr.android.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LTE on 8/31/2016.
 */
public class ProfileFeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int PHOTO_ANIMATION_DELAY = 600;
    private static final Interpolator INTERPOLATOR = new DecelerateInterpolator();

    private Activity a;

    //private final List<String> photos;
    private final int cellSize;

    private boolean lockedAnimations = false;
    private int lastAnimatedItem = -1;

    public ProfileFeedAdapter(Activity a) {
        this.a = a;
        this.cellSize = Utils.getScreenWidth(a) / 2;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ProfileFeedViewHolder viewHolder = (ProfileFeedViewHolder) holder;

        //viewHolder.ivPhoto.setImageResource(R.drawable.img_feed_center_1);

        Glide.with(a)
                .load("http://scontent-a-fra.cdninstagram.com/hphotos-xpf1/t51.2885-15/s306x306/e15/10665483_429615813855717_1490926670_n.jpg")
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(new SimpleTarget<GlideDrawable>(cellSize, cellSize){
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {

                        animatePhoto(viewHolder);
                        viewHolder.ivPhoto.setImageDrawable(resource);
                    }
                });



        if (lastAnimatedItem < position) lastAnimatedItem = position;
    }

    @Override
    public int getItemCount() {
        return 22;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(a).inflate(R.layout.item_feed_profile, parent, false);

        StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
        layoutParams.height = cellSize;
        layoutParams.width = cellSize;
        layoutParams.setFullSpan(false);
        view.setLayoutParams(layoutParams);
        return new ProfileFeedViewHolder(view);
    }


    private void animatePhoto(ProfileFeedViewHolder viewHolder) {
        if (!lockedAnimations) {
            if (lastAnimatedItem == viewHolder.getPosition()) {
                setLockedAnimations(true);
            }

            long animationDelay = PHOTO_ANIMATION_DELAY + viewHolder.getPosition() * 30;

            viewHolder.flRoot.setScaleY(0);
            viewHolder.flRoot.setScaleX(0);

            viewHolder.flRoot.animate()
                    .scaleY(1)
                    .scaleX(1)
                    .setDuration(200)
                    .setInterpolator(INTERPOLATOR)
                    .setStartDelay(animationDelay)
                    .start();
        }
    }

    static class ProfileFeedViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivPhoto)
        ImageView ivPhoto;
        @BindView(R.id.flRoot)
        FrameLayout flRoot;

        public ProfileFeedViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void setLockedAnimations(boolean lockedAnimations) {
        this.lockedAnimations = lockedAnimations;
    }
}
