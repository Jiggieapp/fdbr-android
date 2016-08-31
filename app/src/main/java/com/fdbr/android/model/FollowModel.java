package com.fdbr.android.model;

/**
 * Created by Wandy on 8/29/2016.
 */
public final class FollowModel {
    public final Meta meta;
    public final Data data;

    public FollowModel(Meta meta, Data data){
        this.meta = meta;
        this.data = data;
    }

    public static final class Meta {
        public final long code;
        public final String msg;

        public Meta(long code, String msg){
            this.code = code;
            this.msg = msg;
        }
    }

    public static final class Data {
        public final boolean success;

        public Data(boolean success){
            this.success = success;
        }
    }
}
