package com.fdbr.android;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.fdbr.android.base.BaseActivity;
import com.fdbr.android.view.fragment.DiscoverFragment;
import com.fdbr.android.view.fragment.EmptyFragment;
import com.fdbr.android.view.fragment.FeedFragment;
import com.fdbr.android.view.fragment.ProductFragment;
import com.fdbr.android.view.fragment.ProfileFragment;
import com.fdbr.android.view.fragment.ProfileFragment2;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    MainPageAdapter adapter;
    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate() {
        adapter = new MainPageAdapter
                (getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(adapter.getCount());
        tab.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    private void setupTabIcons() {
        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.tab_custom, null);
        tabOne.setText(getResources().getString(R.string.discover));
        //tabOne.setCompoundDrawablesWithIntrinsicBounds(0, getResources().getDrawable(R.drawable.ic_tag_faces_black_24px), 0, 0);
        tab.getTabAt(0).setIcon(getResources().getDrawable(R.drawable.ic_tag_faces_black_24px));

        TextView tabTwo = (TextView)  LayoutInflater.from(this)
                .inflate(R.layout.tab_custom, null);
        tabTwo.setText(getResources().getString(R.string.feed));
        //tabTwoTitle.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_chat_white_24dp, 0, 0);
        //tabTwoTitle.setCompoundDrawablesWithIntrinsicBounds(0, adapter.getIcon(1), 0, 0);
        //TextView tabTwoBadge = (TextView) tabTwo.findViewById(R.id.tab_badge);
        //tabTwoBadge.setText("99");
        tab.getTabAt(1).setIcon(getResources().getDrawable(R.drawable.ic_tag_faces_black_24px));

        TextView tabThree = (TextView) LayoutInflater.from(this)
                .inflate(R.layout.tab_custom, null);
        tabThree.setText(getResources().getString(R.string.add));
        tab.getTabAt(2).setIcon(getResources().getDrawable(R.drawable.ic_tag_faces_black_24px));

        TextView tabFour = (TextView) LayoutInflater.from(this).inflate(R.layout.tab_custom, null);
        tabFour.setText(getResources().getString(R.string.products));
        tab.getTabAt(3).setIcon(getResources().getDrawable(R.drawable.ic_tag_faces_black_24px));

        TextView tabFive = (TextView) LayoutInflater.from(this).inflate(R.layout.tab_custom, null);
        tabFour.setText(getResources().getString(R.string.products));
        tab.getTabAt(4).setIcon(getResources().getDrawable(R.drawable.ic_tag_faces_black_24px));
    }

    protected class MainPageAdapter extends FragmentPagerAdapter
    {
        private Fragment[] fragments;
        public MainPageAdapter(FragmentManager fm) {
            super(fm);
            this.fragments = new Fragment[]{
                    new FeedFragment(),
                    new DiscoverFragment(),
                    new EmptyFragment(),
                    new ProductFragment(),
                    new ProfileFragment(),
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
