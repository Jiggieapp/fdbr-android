package com.fdbr.android.view.activity;

import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.fdbr.android.R;
import com.fdbr.android.base.BaseActivity;
import com.fdbr.android.model.FBModel;
import com.fdbr.android.model.LoginModel;
import com.fdbr.android.presenter.implementation.AccountPresenterImplementation;
import com.fdbr.android.utils.Constant;
import com.fdbr.android.utils.Utils;
import com.fdbr.android.view.interfaces.AccountView;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by LTE on 8/31/2016.
 */
public class SignupDetailActivity extends BaseActivity implements AccountView.LoginView {

    @BindView(R.id.img_profile)
    ImageView imgProfile;
    @BindView(R.id.edt_name)
    MaterialEditText edtName;
    @BindView(R.id.edt_dob)
    MaterialEditText edtDob;
    @BindView(R.id.auto_location)
    AutoCompleteTextView autoLocation;
    @BindView(R.id.edt_bio)
    MaterialEditText edtBio;
    @BindView(R.id.rel_next)
    RelativeLayout relNext;

    FBModel fbModel;

    AccountPresenterImplementation.LoginPresenterImplementation loginPresenterImplementation;
    boolean IS_FACEBOOK = false;

    @Override
    protected void onCreate() {
        initView();

        Intent a = getIntent();
        IS_FACEBOOK = a.getBooleanExtra(Constant.IS_FACEBOOK, false);
        if (IS_FACEBOOK) {
            fbModel = a.getParcelableExtra(FBModel.class.getName());
            edtName.setText(fbModel.getFirst_name() + " " + fbModel.getLast_name());

            loginPresenterImplementation = new AccountPresenterImplementation.LoginPresenterImplementation();
            loginPresenterImplementation.onAttachView(this);
        }

        int layoutItemId = android.R.layout.simple_dropdown_item_1line;
        String[] dogArr = getResources().getStringArray(R.array.dogs_list);
        List<String> dogList = Arrays.asList(dogArr);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, layoutItemId, dogList);

        autoLocation.setAdapter(adapter);
    }

    private void initView() {
        getSupportActionBar().setTitle(Utils.getStringResource(this, R.string.sgup));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_signup_detail;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        loginPresenterImplementation.onUnattachView();
    }

    @Override
    public void login(LoginModel loginModel) {
        saveToPreference(Constant.ACCESS_TOKEN_PREF, loginModel.getData().getToken());
        saveToPreference(Constant.USER_ID, String.valueOf(loginModel.getData().getRows().getId()));

        startActivity(new Intent(SignupDetailActivity.this, SetupBeautyProfileActivity.class));
    }

    @OnClick(R.id.rel_next)
    public void onClick() {

        if(IS_FACEBOOK){
            HashMap<String, Object> postLoginModel = new HashMap<>();
            postLoginModel.put("username", Constant.BLANK);
            postLoginModel.put("password", Constant.BLANK);
            postLoginModel.put("is_fb", true);
            postLoginModel.put("fb_id", Constant.BLANK);
            postLoginModel.put("first_name", Constant.BLANK);
            postLoginModel.put("last_name", Constant.BLANK);
            postLoginModel.put("email", Constant.BLANK);
            postLoginModel.put("gender", Constant.BLANK);

            loginPresenterImplementation.login(Constant.URL_LOGIN, postLoginModel);
        }else{

        }

    }
}
