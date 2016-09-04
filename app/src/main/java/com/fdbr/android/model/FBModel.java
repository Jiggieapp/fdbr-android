package com.fdbr.android.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by LTE on 9/4/2016.
 */
public final class FBModel implements Parcelable {

    public final String fb_id;
    public final String first_name;
    public final String last_name;
    public final String email;
    public final String gender;

    public FBModel(String fb_id, String first_name, String last_name, String email, String gender){
        this.fb_id = fb_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
    }

    public String getFb_id() {
        return fb_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    protected FBModel(Parcel in) {
        fb_id = in.readString();
        first_name = in.readString();
        last_name = in.readString();
        email = in.readString();
        gender = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fb_id);
        dest.writeString(first_name);
        dest.writeString(last_name);
        dest.writeString(email);
        dest.writeString(gender);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<FBModel> CREATOR = new Parcelable.Creator<FBModel>() {
        @Override
        public FBModel createFromParcel(Parcel in) {
            return new FBModel(in);
        }

        @Override
        public FBModel[] newArray(int size) {
            return new FBModel[size];
        }
    };
}
