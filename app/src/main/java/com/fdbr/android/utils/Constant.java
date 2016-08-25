package com.fdbr.android.utils;

import com.fdbr.android.BuildConfig;

/**
 * Created by Wandy on 8/16/2016.
 */
public class Constant {
    public static final String BASE_URL = BuildConfig.BASE_URL;
    public static final String ACCESS_TOKEN_URL = BASE_URL + "access_token";
    public static final String VERIFY_ACCESS_TOKEN_URL = BASE_URL + "test_verify";
    public static final String API_VERSION = "1.0";
    public static final String DEVICE_TYPE = "2";
    public static final String ANDROID_KEY = "client02-Ibnnjsadbou28948188bAGwjfksdhibvjoowefobvhcj7FDBbhhjdsf89283847718hhfHIDHFKHSFKShh";

    public static final String URL_REGISTER = BASE_URL + "register";
    public static final String URL_LOGIN = BASE_URL + "login";
    public static final String URL_PROFILE = BASE_URL + "user/profile/{id}";

    //pref
    public static final String ACCESS_TOKEN_PREF = "access_token";

    //status code

    public static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";
    public static final String EMAIL_PATTERN = "^[A-Za-z][A-Za-z0-9]*([._-]?[A-Za-z0-9]+)@[A-Za-z].[A-Za-z]{0,3}?.[A-Za-z]{0,2}$";

    public static final int TYPE_USERNAME = 1;
    public static final int TYPE_PASSWORD = 2;
    public static final int TYPE_EMAIL = 3;
}
