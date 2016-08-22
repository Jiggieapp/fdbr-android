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

        public Data(boolean success, String token){
            this.success = success;
            this.token = token;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getToken() {
            return token;
        }
    }
}