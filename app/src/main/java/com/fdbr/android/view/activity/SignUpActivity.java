package com.fdbr.android.view.activity;

import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fdbr.android.R;
import com.fdbr.android.base.BaseActivity;
import com.fdbr.android.model.RegisterModel;
import com.fdbr.android.presenter.implementation.AccountPresenterImplementation;
import com.fdbr.android.utils.Constant;
import com.fdbr.android.utils.Utils;
import com.fdbr.android.view.interfaces.AccountView;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by LTE on 8/25/2016.
 */
public class SignUpActivity extends BaseActivity implements AccountView.RegisterView {

    @BindView(R.id.edt_email)
    EditText edtEmail;
    @BindView(R.id.edt_username)
    EditText edtUsername;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.btn_register)
    Button btnRegister;
    @BindView(R.id.txt_term)
    TextView txtTerm;
    @BindView(R.id.txt_policy)
    TextView txtPolicy;
    @BindView(R.id.rel_term)
    RelativeLayout relTerm;
    @BindView(R.id.txt_agree)
    TextView txtAgree;

    private final String TAG = SignUpActivity.class.getSimpleName();

    private AccountPresenterImplementation.RegisterPresenterImplementation registerImplementation;

    @Override
    protected void onCreate() {
        registerImplementation = new AccountPresenterImplementation.RegisterPresenterImplementation();
        registerImplementation.onAttachView(this);
    }

    @OnClick(R.id.btn_register)
    public void onRegisterClick() {

        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();
        String email = edtEmail.getText().toString();

        boolean isUsernameValid = Utils.validasiInput(Constant.TYPE_USERNAME, username);
        boolean isPasswordValid = Utils.validasiInput(Constant.TYPE_PASSWORD, password);
        boolean isEmailValid = Utils.validasiInput(Constant.TYPE_EMAIL, email);

        if(!isUsernameValid){
            Utils.showToast(SignUpActivity.this, Utils.getStringResource(SignUpActivity.this, R.string.inval_username));
        }else if(!isPasswordValid){
            Utils.showToast(SignUpActivity.this, Utils.getStringResource(SignUpActivity.this, R.string.inval_password));
        }
        /*else if(!isEmailValid){
            Utils.showToast(SignUpActivity.this, Utils.getStringResource(SignUpActivity.this, R.string.inval_email));
        }*/
        else{
            HashMap<String, Object> postRegisterModel = new HashMap<>();
            postRegisterModel.put("username", username);
            postRegisterModel.put("password", password);
            postRegisterModel.put("email", email);

            String sd = String.valueOf(new Gson().toJson(postRegisterModel));
            Log.d("sd","sd");

            registerImplementation.register(Constant.URL_REGISTER, postRegisterModel);
        }

    }

    @Override
    public int getContentView() {
        return R.layout.activity_signup;
    }

    @Override
    public void register(RegisterModel registerModel) {
        String sd = String.valueOf(new Gson().toJson(registerModel));
        Log.d("sd","sd");

        saveToPreference(Constant.ACCESS_TOKEN_PREF, registerModel.getData().getToken());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        registerImplementation.onUnattachView();
    }
}
