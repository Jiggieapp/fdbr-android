package com.fdbr.android.api.response;

/**
 * Created by Wandy on 8/18/2016.
 */
public final class AccessToken {
    public final boolean success;
    public final String token;

    public AccessToken(boolean success, String token){
        this.success = success;
        this.token = token;
    }
}
