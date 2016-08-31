package com.fdbr.android.view.activity;

import com.fdbr.android.R;
import com.fdbr.android.base.BaseActivity;
import com.fdbr.android.utils.Utils;
import com.rengwuxian.materialedittext.MaterialEditText;

import butterknife.BindView;

/**
 * Created by LTE on 8/31/2016.
 */
public class ChangePassActivity extends BaseActivity {

    @BindView(R.id.edt_currpass)
    MaterialEditText edtCurrpass;
    @BindView(R.id.edt_newpass)
    MaterialEditText edtNewpass;
    @BindView(R.id.edt_confpass)
    MaterialEditText edtConfpass;

    @Override
    protected void onCreate() {

        initView();

    }

    private void initView(){
        getSupportActionBar().setTitle(Utils.getStringResource(this, R.string.st_chpass));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_changepass;
    }
}
