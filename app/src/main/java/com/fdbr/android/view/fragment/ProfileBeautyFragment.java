package com.fdbr.android.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fdbr.android.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LTE on 8/23/2016.
 */
public class ProfileBeautyFragment extends Fragment {

    @BindView(R.id.txt_bp)
    TextView txtBp;
    @BindView(R.id.txt_bp1)
    TextView txtBp1;
    @BindView(R.id.txt_in_bp1)
    TextView txtInBp1;
    @BindView(R.id.txt_bp2)
    TextView txtBp2;
    @BindView(R.id.txt_in_bp2)
    TextView txtInBp2;
    @BindView(R.id.txt_bp3)
    TextView txtBp3;
    @BindView(R.id.txt_in_bp3)
    TextView txtInBp3;
    @BindView(R.id.lin_b_profile)
    LinearLayout linBProfile;
    @BindView(R.id.txt_bp4)
    TextView txtBp4;
    @BindView(R.id.txt_in_bp4)
    TextView txtInBp4;
    @BindView(R.id.txt_bp5)
    TextView txtBp5;
    @BindView(R.id.txt_in_bp5)
    TextView txtInBp5;
    @BindView(R.id.txt_bc)
    TextView txtBc;
    @BindView(R.id.txt_bc1)
    TextView txtBc1;
    @BindView(R.id.txt_in_bc1)
    TextView txtInBc1;
    @BindView(R.id.txt_bc2)
    TextView txtBc2;
    @BindView(R.id.txt_in_bc2)
    TextView txtInBc2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile_beauty, null);


        ButterKnife.bind(this, v);


        return v;
    }
}
