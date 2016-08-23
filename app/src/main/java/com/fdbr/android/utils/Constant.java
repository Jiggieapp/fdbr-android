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

    //pref
    public static final String ACCESS_TOKEN_PREF = "access_token";
}
