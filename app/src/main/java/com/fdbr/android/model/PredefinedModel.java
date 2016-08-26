package com.fdbr.android.model;

import java.util.ArrayList;

/**
 * Created by LTE on 8/25/2016.
 */
public final class PredefinedModel {
    public final Meta meta;
    public final Data data;

    public PredefinedModel(Meta meta, Data data){
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

        public long getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    public static final class Data {
        public final ArrayList<Skin_type> skin_type;
        public final ArrayList<Skin_tone> skin_tone;
        public final ArrayList<Skin_undertone> skin_undertone;
        public final ArrayList<Hair_type> hair_type;
        public final ArrayList<Hair_texture> hair_texture;
        public final ArrayList<Skin_concern> skin_concerns;
        public final ArrayList<Body_concern> body_concerns;
        public final ArrayList<Hair_concern> hair_concerns;

        public Data(ArrayList<Skin_type> skin_type, ArrayList<Skin_tone> skin_tone, ArrayList<Skin_undertone> skin_undertone, ArrayList<Hair_type> hair_type, ArrayList<Hair_texture> hair_texture, ArrayList<Skin_concern> skin_concerns, ArrayList<Body_concern> body_concerns, ArrayList<Hair_concern> hair_concerns){
            this.skin_type = skin_type;
            this.skin_tone = skin_tone;
            this.skin_undertone = skin_undertone;
            this.hair_type = hair_type;
            this.hair_texture = hair_texture;
            this.skin_concerns = skin_concerns;
            this.body_concerns = body_concerns;
            this.hair_concerns = hair_concerns;
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

        public static final class Skin_type {
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
        }

        public static final class Skin_tone {
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
        }

        public static final class Skin_undertone {
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
        }

        public static final class Hair_type {
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
        }

        public static final class Hair_texture {
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
        }

        public static final class Skin_concern {
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
        }

        public static final class Body_concern {
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
        }

        public static final class Hair_concern {
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
        }
    }
}