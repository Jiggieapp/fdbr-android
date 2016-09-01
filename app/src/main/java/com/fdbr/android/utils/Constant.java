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
    public static final String URL_PROFILE = BASE_URL + "user/profile/{user_id}";
    public static final String URL_WISHLIST = BASE_URL + "user/wishlist/{user_id}";
    public static final String URL_TRIED = BASE_URL + "user/tried/{user_id}";
    public static final String URL_FEED_PROFILE = BASE_URL + "user/feed/{user_id}";
    public static final String URL_BRAND = BASE_URL + "user/brand";
    public static final String URL_FOLLOW = BASE_URL + "follow";
    public static final String URL_PREDEFINED = BASE_URL + "user/predefined";
    public static final String URL_PRODUCT_LIST = BASE_URL + "product_list";
    public static final String URL_PRODUCT_DETAIL = BASE_URL + "product/detail/{product_id}";

    //pref
    public static final String ACCESS_TOKEN_PREF = "access_token";
    public static final String USER_ID = "user_id";

    //status code

    public static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";
    public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$";

    //
    //^[A-Za-z][A-Za-z0-9]*([._-]?[A-Za-z0-9]+)@[A-Za-z].[A-Za-z]{0,3}?.[A-Za-z]{0,2}$

    public static final int TYPE_USERNAME = 1;
    public static final int TYPE_PASSWORD = 2;
    public static final int TYPE_EMAIL = 3;

    public static String BLANK = "";

    /*200 => OK
    401 => Token Mismatch
    410 => Token Expired
    400 => Bad Request
    422 => Entity Exist
    403 => Error in Server, please Tell me(Jannes,, heheheheh)*/
    public static final int CODE_OK = 200;
    public static final int CODE_EMPTY = 204;
    public static final int CODE_BAD_REQUEST = 400;
    public static final int CODE_TOKEN_MISMATCH = 401;
    public static final int CODE_ERROR_SERVIER = 403;
    public static final int CODE_TOKEN_EXPIRED = 410;
    public static final int CODE_ENTITY_EXIST = 422;
}
