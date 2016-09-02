package com.fdbr.android.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.fdbr.android.R;
import com.fdbr.android.base.BaseActivity;

import butterknife.BindView;

public class PostTakePhotoActivity extends BaseActivity {

    @BindView(R.id.img_posted)
    ImageView imgPosted;

    @Override
    protected void onCreate() {
        final String imagePath = getIntent().getExtras().getString("imagePath");
        Glide.with(this).load(imagePath).asBitmap().into(imgPosted);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_post_take_photo;
    }
}
