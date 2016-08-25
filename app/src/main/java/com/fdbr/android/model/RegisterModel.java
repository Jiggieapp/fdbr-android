package com.fdbr.android.model;

/**
 * Created by LTE on 8/22/2016.
 */
public final class RegisterModel {
    public final Meta meta;
    public final Data data;

    public RegisterModel(Meta meta, Data data){
        this.meta = meta;
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public Data getData() {
        return data;
    }

    public static final class Meta {
        public final long code;
        public final String msg;

        public Meta(long code, String msg){
            this.code = code;
            this.msg = msg;
        }

        public long getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    public static final class Data {
        public final boolean success;
        public final String token;
        public final long userid;

        public Data(boolean success, String token, long userid){
            this.success = success;
            this.token = token;
            this.userid = userid;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getToken() {
            return token;
        }

        public long getUserid() {
            return userid;
        }
    }
}