package com.fdbr.android.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by LTE on 8/25/2016.
 */
public final class PredefinedModel implements Parcelable {
    public final Meta meta;
    public final Data data;

    public PredefinedModel(Meta meta, Data data){
        this.meta = meta;
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public Data getData() {
        return data;
    }

    public static final class Meta implements Parcelable {
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

        protected Meta(Parcel in) {
            code = in.readLong();
            msg = in.readString();
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeLong(code);
            dest.writeString(msg);
        }

        @SuppressWarnings("unused")
        public static final Parcelable.Creator<Meta> CREATOR = new Parcelable.Creator<Meta>() {
            @Override
            public Meta createFromParcel(Parcel in) {
                return new Meta(in);
            }

            @Override
            public Meta[] newArray(int size) {
                return new Meta[size];
            }
        };
    }

    public static final class Data implements Parcelable {
        public final ArrayList<Skin_type> skin_type;
        public final ArrayList<Skin_tone> skin_tone;
        public final ArrayList<Skin_undertone> skin_undertone;
        public final ArrayList<Hair_type> hair_type;
        public final ArrayList<Hair_texture> hair_texture;
        public final ArrayList<Skin_concern> skin_concerns;
        public final ArrayList<Body_concern> body_concerns;
        public final ArrayList<Hair_concern> hair_concerns;
        public final ArrayList<City> city;

        public Data(ArrayList<Skin_type> skin_type, ArrayList<Skin_tone> skin_tone, ArrayList<Skin_undertone> skin_undertone, ArrayList<Hair_type> hair_type, ArrayList<Hair_texture> hair_texture, ArrayList<Skin_concern> skin_concerns, ArrayList<Body_concern> body_concerns, ArrayList<Hair_concern> hair_concerns, ArrayList<City> city){
            this.skin_type = skin_type;
            this.skin_tone = skin_tone;
            this.skin_undertone = skin_undertone;
            this.hair_type = hair_type;
            this.hair_texture = hair_texture;
            this.skin_concerns = skin_concerns;
            this.body_concerns = body_concerns;
            this.hair_concerns = hair_concerns;
            this.city = city;
        }

        public ArrayList<Skin_type> getSkin_type() {
            return skin_type;
        }

        public ArrayList<Skin_tone> getSkin_tone() {
            return skin_tone;
        }

        public ArrayList<Skin_undertone> getSkin_undertone() {
            return skin_undertone;
        }

        public ArrayList<Hair_type> getHair_type() {
            return hair_type;
        }

        public ArrayList<Hair_texture> getHair_texture() {
            return hair_texture;
        }

        public ArrayList<Skin_concern> getSkin_concerns() {
            return skin_concerns;
        }

        public ArrayList<Body_concern> getBody_concerns() {
            return body_concerns;
        }

        public ArrayList<Hair_concern> getHair_concerns() {
            return hair_concerns;
        }

        public ArrayList<City> getCity() {
            return city;
        }

        public static final class Skin_type implements Parcelable {
            public final long skityp_id;
            public final String skityp_name;
            public final String skityp_desc;
            public final String skityp_img;
            public final String skityp_entryuser;
            public final String skityp_entrydate;
            public final String skityp_changeuser;
            public final String skityp_changedate;

            public Skin_type(long skityp_id, String skityp_name, String skityp_desc, String skityp_img, String skityp_entryuser, String skityp_entrydate, String skityp_changeuser, String skityp_changedate){
                this.skityp_id = skityp_id;
                this.skityp_name = skityp_name;
                this.skityp_desc = skityp_desc;
                this.skityp_img = skityp_img;
                this.skityp_entryuser = skityp_entryuser;
                this.skityp_entrydate = skityp_entrydate;
                this.skityp_changeuser = skityp_changeuser;
                this.skityp_changedate = skityp_changedate;
            }

            public long getSkityp_id() {
                return skityp_id;
            }

            public String getSkityp_name() {
                return skityp_name;
            }

            public String getSkityp_desc() {
                return skityp_desc;
            }

            public String getSkityp_img() {
                return skityp_img;
            }

            public String getSkityp_entryuser() {
                return skityp_entryuser;
            }

            public String getSkityp_entrydate() {
                return skityp_entrydate;
            }

            public String getSkityp_changeuser() {
                return skityp_changeuser;
            }

            public String getSkityp_changedate() {
                return skityp_changedate;
            }

            protected Skin_type(Parcel in) {
                skityp_id = in.readLong();
                skityp_name = in.readString();
                skityp_desc = in.readString();
                skityp_img = in.readString();
                skityp_entryuser = in.readString();
                skityp_entrydate = in.readString();
                skityp_changeuser = in.readString();
                skityp_changedate = in.readString();
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeLong(skityp_id);
                dest.writeString(skityp_name);
                dest.writeString(skityp_desc);
                dest.writeString(skityp_img);
                dest.writeString(skityp_entryuser);
                dest.writeString(skityp_entrydate);
                dest.writeString(skityp_changeuser);
                dest.writeString(skityp_changedate);
            }

            @SuppressWarnings("unused")
            public static final Parcelable.Creator<Skin_type> CREATOR = new Parcelable.Creator<Skin_type>() {
                @Override
                public Skin_type createFromParcel(Parcel in) {
                    return new Skin_type(in);
                }

                @Override
                public Skin_type[] newArray(int size) {
                    return new Skin_type[size];
                }
            };
        }

        public static final class Skin_tone implements Parcelable {
            public final long skiton_id;
            public final String skiton_name;
            public final String skiton_desc;
            public final String skiton_img;
            public final String skiton_entryuser;
            public final String skiton_entrydate;
            public final String skiton_changeuser;
            public final String skiton_changedate;

            public Skin_tone(long skiton_id, String skiton_name, String skiton_desc, String skiton_img, String skiton_entryuser, String skiton_entrydate, String skiton_changeuser, String skiton_changedate){
                this.skiton_id = skiton_id;
                this.skiton_name = skiton_name;
                this.skiton_desc = skiton_desc;
                this.skiton_img = skiton_img;
                this.skiton_entryuser = skiton_entryuser;
                this.skiton_entrydate = skiton_entrydate;
                this.skiton_changeuser = skiton_changeuser;
                this.skiton_changedate = skiton_changedate;
            }

            public long getSkiton_id() {
                return skiton_id;
            }

            public String getSkiton_name() {
                return skiton_name;
            }

            public String getSkiton_desc() {
                return skiton_desc;
            }

            public String getSkiton_img() {
                return skiton_img;
            }

            public String getSkiton_entryuser() {
                return skiton_entryuser;
            }

            public String getSkiton_entrydate() {
                return skiton_entrydate;
            }

            public String getSkiton_changeuser() {
                return skiton_changeuser;
            }

            public String getSkiton_changedate() {
                return skiton_changedate;
            }

            protected Skin_tone(Parcel in) {
                skiton_id = in.readLong();
                skiton_name = in.readString();
                skiton_desc = in.readString();
                skiton_img = in.readString();
                skiton_entryuser = in.readString();
                skiton_entrydate = in.readString();
                skiton_changeuser = in.readString();
                skiton_changedate = in.readString();
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeLong(skiton_id);
                dest.writeString(skiton_name);
                dest.writeString(skiton_desc);
                dest.writeString(skiton_img);
                dest.writeString(skiton_entryuser);
                dest.writeString(skiton_entrydate);
                dest.writeString(skiton_changeuser);
                dest.writeString(skiton_changedate);
            }

            @SuppressWarnings("unused")
            public static final Parcelable.Creator<Skin_tone> CREATOR = new Parcelable.Creator<Skin_tone>() {
                @Override
                public Skin_tone createFromParcel(Parcel in) {
                    return new Skin_tone(in);
                }

                @Override
                public Skin_tone[] newArray(int size) {
                    return new Skin_tone[size];
                }
            };
        }

        public static final class Skin_undertone implements Parcelable {
            public final long skiund_id;
            public final String skiund_name;
            public final String skiund_desc;
            public final String skiund_img;
            public final String skiund_entryuser;
            public final String skiund_entrydate;
            public final String skiund_changeuser;
            public final String skiund_changedate;

            public Skin_undertone(long skiund_id, String skiund_name, String skiund_desc, String skiund_img, String skiund_entryuser, String skiund_entrydate, String skiund_changeuser, String skiund_changedate){
                this.skiund_id = skiund_id;
                this.skiund_name = skiund_name;
                this.skiund_desc = skiund_desc;
                this.skiund_img = skiund_img;
                this.skiund_entryuser = skiund_entryuser;
                this.skiund_entrydate = skiund_entrydate;
                this.skiund_changeuser = skiund_changeuser;
                this.skiund_changedate = skiund_changedate;
            }

            public long getSkiund_id() {
                return skiund_id;
            }

            public String getSkiund_name() {
                return skiund_name;
            }

            public String getSkiund_desc() {
                return skiund_desc;
            }

            public String getSkiund_img() {
                return skiund_img;
            }

            public String getSkiund_entryuser() {
                return skiund_entryuser;
            }

            public String getSkiund_entrydate() {
                return skiund_entrydate;
            }

            public String getSkiund_changeuser() {
                return skiund_changeuser;
            }

            public String getSkiund_changedate() {
                return skiund_changedate;
            }

            protected Skin_undertone(Parcel in) {
                skiund_id = in.readLong();
                skiund_name = in.readString();
                skiund_desc = in.readString();
                skiund_img = in.readString();
                skiund_entryuser = in.readString();
                skiund_entrydate = in.readString();
                skiund_changeuser = in.readString();
                skiund_changedate = in.readString();
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeLong(skiund_id);
                dest.writeString(skiund_name);
                dest.writeString(skiund_desc);
                dest.writeString(skiund_img);
                dest.writeString(skiund_entryuser);
                dest.writeString(skiund_entrydate);
                dest.writeString(skiund_changeuser);
                dest.writeString(skiund_changedate);
            }

            @SuppressWarnings("unused")
            public static final Parcelable.Creator<Skin_undertone> CREATOR = new Parcelable.Creator<Skin_undertone>() {
                @Override
                public Skin_undertone createFromParcel(Parcel in) {
                    return new Skin_undertone(in);
                }

                @Override
                public Skin_undertone[] newArray(int size) {
                    return new Skin_undertone[size];
                }
            };
        }

        public static final class Hair_type implements Parcelable {
            public final long haityp_id;
            public final String haityp_name;
            public final String haityp_desc;
            public final String haityp_img;
            public final String haityp_entryuser;
            public final String haityp_entrydate;
            public final String haityp_changeuser;
            public final String haityp_changedate;

            public Hair_type(long haityp_id, String haityp_name, String haityp_desc, String haityp_img, String haityp_entryuser, String haityp_entrydate, String haityp_changeuser, String haityp_changedate){
                this.haityp_id = haityp_id;
                this.haityp_name = haityp_name;
                this.haityp_desc = haityp_desc;
                this.haityp_img = haityp_img;
                this.haityp_entryuser = haityp_entryuser;
                this.haityp_entrydate = haityp_entrydate;
                this.haityp_changeuser = haityp_changeuser;
                this.haityp_changedate = haityp_changedate;
            }

            public long getHaityp_id() {
                return haityp_id;
            }

            public String getHaityp_name() {
                return haityp_name;
            }

            public String getHaityp_desc() {
                return haityp_desc;
            }

            public String getHaityp_img() {
                return haityp_img;
            }

            public String getHaityp_entryuser() {
                return haityp_entryuser;
            }

            public String getHaityp_entrydate() {
                return haityp_entrydate;
            }

            public String getHaityp_changeuser() {
                return haityp_changeuser;
            }

            public String getHaityp_changedate() {
                return haityp_changedate;
            }

            protected Hair_type(Parcel in) {
                haityp_id = in.readLong();
                haityp_name = in.readString();
                haityp_desc = in.readString();
                haityp_img = in.readString();
                haityp_entryuser = in.readString();
                haityp_entrydate = in.readString();
                haityp_changeuser = in.readString();
                haityp_changedate = in.readString();
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeLong(haityp_id);
                dest.writeString(haityp_name);
                dest.writeString(haityp_desc);
                dest.writeString(haityp_img);
                dest.writeString(haityp_entryuser);
                dest.writeString(haityp_entrydate);
                dest.writeString(haityp_changeuser);
                dest.writeString(haityp_changedate);
            }

            @SuppressWarnings("unused")
            public static final Parcelable.Creator<Hair_type> CREATOR = new Parcelable.Creator<Hair_type>() {
                @Override
                public Hair_type createFromParcel(Parcel in) {
                    return new Hair_type(in);
                }

                @Override
                public Hair_type[] newArray(int size) {
                    return new Hair_type[size];
                }
            };
        }

        public static final class Hair_texture implements Parcelable {
            public final long haitex_id;
            public final String haitex_name;
            public final String haitex_desc;
            public final String haitex_img;
            public final String haitex_entryuser;
            public final String haitex_entrydate;
            public final String haitex_changeuser;
            public final String haitex_changedate;

            public Hair_texture(long haitex_id, String haitex_name, String haitex_desc, String haitex_img, String haitex_entryuser, String haitex_entrydate, String haitex_changeuser, String haitex_changedate){
                this.haitex_id = haitex_id;
                this.haitex_name = haitex_name;
                this.haitex_desc = haitex_desc;
                this.haitex_img = haitex_img;
                this.haitex_entryuser = haitex_entryuser;
                this.haitex_entrydate = haitex_entrydate;
                this.haitex_changeuser = haitex_changeuser;
                this.haitex_changedate = haitex_changedate;
            }

            public long getHaitex_id() {
                return haitex_id;
            }

            public String getHaitex_name() {
                return haitex_name;
            }

            public String getHaitex_desc() {
                return haitex_desc;
            }

            public String getHaitex_img() {
                return haitex_img;
            }

            public String getHaitex_entryuser() {
                return haitex_entryuser;
            }

            public String getHaitex_entrydate() {
                return haitex_entrydate;
            }

            public String getHaitex_changeuser() {
                return haitex_changeuser;
            }

            public String getHaitex_changedate() {
                return haitex_changedate;
            }

            protected Hair_texture(Parcel in) {
                haitex_id = in.readLong();
                haitex_name = in.readString();
                haitex_desc = in.readString();
                haitex_img = in.readString();
                haitex_entryuser = in.readString();
                haitex_entrydate = in.readString();
                haitex_changeuser = in.readString();
                haitex_changedate = in.readString();
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeLong(haitex_id);
                dest.writeString(haitex_name);
                dest.writeString(haitex_desc);
                dest.writeString(haitex_img);
                dest.writeString(haitex_entryuser);
                dest.writeString(haitex_entrydate);
                dest.writeString(haitex_changeuser);
                dest.writeString(haitex_changedate);
            }

            @SuppressWarnings("unused")
            public static final Parcelable.Creator<Hair_texture> CREATOR = new Parcelable.Creator<Hair_texture>() {
                @Override
                public Hair_texture createFromParcel(Parcel in) {
                    return new Hair_texture(in);
                }

                @Override
                public Hair_texture[] newArray(int size) {
                    return new Hair_texture[size];
                }
            };
        }

        public static final class Skin_concern implements Parcelable {
            public final long skicon_id;
            public final String skicon_name;
            public final String skicon_desc;
            public final String skicon_entryuser;
            public final String skicon_entrydate;
            public final String skicon_changeuser;
            public final String skicon_changedate;

            public Skin_concern(long skicon_id, String skicon_name, String skicon_desc, String skicon_entryuser, String skicon_entrydate, String skicon_changeuser, String skicon_changedate){
                this.skicon_id = skicon_id;
                this.skicon_name = skicon_name;
                this.skicon_desc = skicon_desc;
                this.skicon_entryuser = skicon_entryuser;
                this.skicon_entrydate = skicon_entrydate;
                this.skicon_changeuser = skicon_changeuser;
                this.skicon_changedate = skicon_changedate;
            }

            public long getSkicon_id() {
                return skicon_id;
            }

            public String getSkicon_name() {
                return skicon_name;
            }

            public String getSkicon_desc() {
                return skicon_desc;
            }

            public String getSkicon_entryuser() {
                return skicon_entryuser;
            }

            public String getSkicon_entrydate() {
                return skicon_entrydate;
            }

            public String getSkicon_changeuser() {
                return skicon_changeuser;
            }

            public String getSkicon_changedate() {
                return skicon_changedate;
            }

            protected Skin_concern(Parcel in) {
                skicon_id = in.readLong();
                skicon_name = in.readString();
                skicon_desc = in.readString();
                skicon_entryuser = in.readString();
                skicon_entrydate = in.readString();
                skicon_changeuser = in.readString();
                skicon_changedate = in.readString();
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeLong(skicon_id);
                dest.writeString(skicon_name);
                dest.writeString(skicon_desc);
                dest.writeString(skicon_entryuser);
                dest.writeString(skicon_entrydate);
                dest.writeString(skicon_changeuser);
                dest.writeString(skicon_changedate);
            }

            @SuppressWarnings("unused")
            public static final Parcelable.Creator<Skin_concern> CREATOR = new Parcelable.Creator<Skin_concern>() {
                @Override
                public Skin_concern createFromParcel(Parcel in) {
                    return new Skin_concern(in);
                }

                @Override
                public Skin_concern[] newArray(int size) {
                    return new Skin_concern[size];
                }
            };
        }

        public static final class Body_concern implements Parcelable {
            public final long bodcon_id;
            public final String bodcon_name;
            public final String bodcon_desc;
            public final String bodcon_entryuser;
            public final String bodcon_entrydate;
            public final String bodcon_changeuser;
            public final String bodcon_changedate;

            public Body_concern(long bodcon_id, String bodcon_name, String bodcon_desc, String bodcon_entryuser, String bodcon_entrydate, String bodcon_changeuser, String bodcon_changedate){
                this.bodcon_id = bodcon_id;
                this.bodcon_name = bodcon_name;
                this.bodcon_desc = bodcon_desc;
                this.bodcon_entryuser = bodcon_entryuser;
                this.bodcon_entrydate = bodcon_entrydate;
                this.bodcon_changeuser = bodcon_changeuser;
                this.bodcon_changedate = bodcon_changedate;
            }

            public long getBodcon_id() {
                return bodcon_id;
            }

            public String getBodcon_name() {
                return bodcon_name;
            }

            public String getBodcon_desc() {
                return bodcon_desc;
            }

            public String getBodcon_entryuser() {
                return bodcon_entryuser;
            }

            public String getBodcon_entrydate() {
                return bodcon_entrydate;
            }

            public String getBodcon_changeuser() {
                return bodcon_changeuser;
            }

            public String getBodcon_changedate() {
                return bodcon_changedate;
            }

            protected Body_concern(Parcel in) {
                bodcon_id = in.readLong();
                bodcon_name = in.readString();
                bodcon_desc = in.readString();
                bodcon_entryuser = in.readString();
                bodcon_entrydate = in.readString();
                bodcon_changeuser = in.readString();
                bodcon_changedate = in.readString();
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeLong(bodcon_id);
                dest.writeString(bodcon_name);
                dest.writeString(bodcon_desc);
                dest.writeString(bodcon_entryuser);
                dest.writeString(bodcon_entrydate);
                dest.writeString(bodcon_changeuser);
                dest.writeString(bodcon_changedate);
            }

            @SuppressWarnings("unused")
            public static final Parcelable.Creator<Body_concern> CREATOR = new Parcelable.Creator<Body_concern>() {
                @Override
                public Body_concern createFromParcel(Parcel in) {
                    return new Body_concern(in);
                }

                @Override
                public Body_concern[] newArray(int size) {
                    return new Body_concern[size];
                }
            };
        }

        public static final class Hair_concern implements Parcelable {
            public final long haicon_id;
            public final String haicon_name;
            public final String haicon_desc;
            public final String haicon_entryuser;
            public final String haicon_entrydate;
            public final String haicon_changeuser;
            public final String haicon_changedate;

            public Hair_concern(long haicon_id, String haicon_name, String haicon_desc, String haicon_entryuser, String haicon_entrydate, String haicon_changeuser, String haicon_changedate){
                this.haicon_id = haicon_id;
                this.haicon_name = haicon_name;
                this.haicon_desc = haicon_desc;
                this.haicon_entryuser = haicon_entryuser;
                this.haicon_entrydate = haicon_entrydate;
                this.haicon_changeuser = haicon_changeuser;
                this.haicon_changedate = haicon_changedate;
            }

            public long getHaicon_id() {
                return haicon_id;
            }

            public String getHaicon_name() {
                return haicon_name;
            }

            public String getHaicon_desc() {
                return haicon_desc;
            }

            public String getHaicon_entryuser() {
                return haicon_entryuser;
            }

            public String getHaicon_entrydate() {
                return haicon_entrydate;
            }

            public String getHaicon_changeuser() {
                return haicon_changeuser;
            }

            public String getHaicon_changedate() {
                return haicon_changedate;
            }

            protected Hair_concern(Parcel in) {
                haicon_id = in.readLong();
                haicon_name = in.readString();
                haicon_desc = in.readString();
                haicon_entryuser = in.readString();
                haicon_entrydate = in.readString();
                haicon_changeuser = in.readString();
                haicon_changedate = in.readString();
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeLong(haicon_id);
                dest.writeString(haicon_name);
                dest.writeString(haicon_desc);
                dest.writeString(haicon_entryuser);
                dest.writeString(haicon_entrydate);
                dest.writeString(haicon_changeuser);
                dest.writeString(haicon_changedate);
            }

            @SuppressWarnings("unused")
            public static final Parcelable.Creator<Hair_concern> CREATOR = new Parcelable.Creator<Hair_concern>() {
                @Override
                public Hair_concern createFromParcel(Parcel in) {
                    return new Hair_concern(in);
                }

                @Override
                public Hair_concern[] newArray(int size) {
                    return new Hair_concern[size];
                }
            };
        }

        public static final class City implements Parcelable {
            public final long id;
            public final String name;

            public City(long id, String name){
                this.id = id;
                this.name = name;
            }

            public long getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            protected City(Parcel in) {
                id = in.readLong();
                name = in.readString();
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeLong(id);
                dest.writeString(name);
            }

            @SuppressWarnings("unused")
            public static final Parcelable.Creator<City> CREATOR = new Parcelable.Creator<City>() {
                @Override
                public City createFromParcel(Parcel in) {
                    return new City(in);
                }

                @Override
                public City[] newArray(int size) {
                    return new City[size];
                }
            };
        }

        protected Data(Parcel in) {
            if (in.readByte() == 0x01) {
                skin_type = new ArrayList<Skin_type>();
                in.readList(skin_type, Skin_type.class.getClassLoader());
            } else {
                skin_type = null;
            }
            if (in.readByte() == 0x01) {
                skin_tone = new ArrayList<Skin_tone>();
                in.readList(skin_tone, Skin_tone.class.getClassLoader());
            } else {
                skin_tone = null;
            }
            if (in.readByte() == 0x01) {
                skin_undertone = new ArrayList<Skin_undertone>();
                in.readList(skin_undertone, Skin_undertone.class.getClassLoader());
            } else {
                skin_undertone = null;
            }
            if (in.readByte() == 0x01) {
                hair_type = new ArrayList<Hair_type>();
                in.readList(hair_type, Hair_type.class.getClassLoader());
            } else {
                hair_type = null;
            }
            if (in.readByte() == 0x01) {
                hair_texture = new ArrayList<Hair_texture>();
                in.readList(hair_texture, Hair_texture.class.getClassLoader());
            } else {
                hair_texture = null;
            }
            if (in.readByte() == 0x01) {
                skin_concerns = new ArrayList<Skin_concern>();
                in.readList(skin_concerns, Skin_concern.class.getClassLoader());
            } else {
                skin_concerns = null;
            }
            if (in.readByte() == 0x01) {
                body_concerns = new ArrayList<Body_concern>();
                in.readList(body_concerns, Body_concern.class.getClassLoader());
            } else {
                body_concerns = null;
            }
            if (in.readByte() == 0x01) {
                hair_concerns = new ArrayList<Hair_concern>();
                in.readList(hair_concerns, Hair_concern.class.getClassLoader());
            } else {
                hair_concerns = null;
            }
            if (in.readByte() == 0x01) {
                city = new ArrayList<City>();
                in.readList(city, City.class.getClassLoader());
            } else {
                city = null;
            }
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            if (skin_type == null) {
                dest.writeByte((byte) (0x00));
            } else {
                dest.writeByte((byte) (0x01));
                dest.writeList(skin_type);
            }
            if (skin_tone == null) {
                dest.writeByte((byte) (0x00));
            } else {
                dest.writeByte((byte) (0x01));
                dest.writeList(skin_tone);
            }
            if (skin_undertone == null) {
                dest.writeByte((byte) (0x00));
            } else {
                dest.writeByte((byte) (0x01));
                dest.writeList(skin_undertone);
            }
            if (hair_type == null) {
                dest.writeByte((byte) (0x00));
            } else {
                dest.writeByte((byte) (0x01));
                dest.writeList(hair_type);
            }
            if (hair_texture == null) {
                dest.writeByte((byte) (0x00));
            } else {
                dest.writeByte((byte) (0x01));
                dest.writeList(hair_texture);
            }
            if (skin_concerns == null) {
                dest.writeByte((byte) (0x00));
            } else {
                dest.writeByte((byte) (0x01));
                dest.writeList(skin_concerns);
            }
            if (body_concerns == null) {
                dest.writeByte((byte) (0x00));
            } else {
                dest.writeByte((byte) (0x01));
                dest.writeList(body_concerns);
            }
            if (hair_concerns == null) {
                dest.writeByte((byte) (0x00));
            } else {
                dest.writeByte((byte) (0x01));
                dest.writeList(hair_concerns);
            }
            if (city == null) {
                dest.writeByte((byte) (0x00));
            } else {
                dest.writeByte((byte) (0x01));
                dest.writeList(city);
            }
        }

        @SuppressWarnings("unused")
        public static final Parcelable.Creator<Data> CREATOR = new Parcelable.Creator<Data>() {
            @Override
            public Data createFromParcel(Parcel in) {
                return new Data(in);
            }

            @Override
            public Data[] newArray(int size) {
                return new Data[size];
            }
        };
    }

    protected PredefinedModel(Parcel in) {
        meta = (Meta) in.readValue(Meta.class.getClassLoader());
        data = (Data) in.readValue(Data.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(meta);
        dest.writeValue(data);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<PredefinedModel> CREATOR = new Parcelable.Creator<PredefinedModel>() {
        @Override
        public PredefinedModel createFromParcel(Parcel in) {
            return new PredefinedModel(in);
        }

        @Override
        public PredefinedModel[] newArray(int size) {
            return new PredefinedModel[size];
        }
    };
}