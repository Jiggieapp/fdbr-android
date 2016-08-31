package com.fdbr.android.model;

import java.util.ArrayList;

/**
 * Created by LTE on 8/23/2016.
 */
public final class ProfileModel {
    public final Meta meta;
    private final Data data;

    public ProfileModel(Meta meta, Data data){
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
        private final String fullname;
        private final String username;
        private final String email;
        private final String birthday;
        private final String join_date;
        private final String about;
        private final long follower_count;
        private final long following_count;
        private final long total_point;
        private final long total_badge;
        private final long total_review;
        private final String bio;
        private final String facebook;
        private final String twitter;
        private final String instagram;
        private final String youtube;
        private final String blog;
        private final Picture picture;
        private final Beauty_profile beauty_profile;
        private final Beauty_concern beauty_concern;
        private final ArrayList<Brand> brands;

        public Data(String fullname, String username, String email, String birthday, String join_date, String about, long follower_count, long following_count, long total_point, long total_badge, long total_review, String bio, String facebook, String twitter, String instagram, String youtube, String blog, Picture picture, Beauty_profile beauty_profile, Beauty_concern beauty_concern, ArrayList<Brand> brands){
            this.fullname = fullname;
            this.username = username;
            this.email = email;
            this.birthday = birthday;
            this.join_date = join_date;
            this.about = about;
            this.follower_count = follower_count;
            this.following_count = following_count;
            this.total_point = total_point;
            this.total_badge = total_badge;
            this.total_review = total_review;
            this.bio = bio;
            this.facebook = facebook;
            this.twitter = twitter;
            this.instagram = instagram;
            this.youtube = youtube;
            this.blog = blog;
            this.picture = picture;
            this.beauty_profile = beauty_profile;
            this.beauty_concern = beauty_concern;
            this.brands = brands;
        }

        public String getFullname() {
            return fullname;
        }

        public String getUsername() {
            return username;
        }

        public String getEmail() {
            return email;
        }

        public String getBirthday() {
            return birthday;
        }

        public String getJoin_date() {
            return join_date;
        }

        public String getAbout() {
            return about;
        }

        public long getFollower_count() {
            return follower_count;
        }

        public long getFollowing_count() {
            return following_count;
        }

        public long getTotal_point() {
            return total_point;
        }

        public long getTotal_badge() {
            return total_badge;
        }

        public long getTotal_review() {
            return total_review;
        }

        public String getBio() {
            return bio;
        }

        public String getFacebook() {
            return facebook;
        }

        public String getTwitter() {
            return twitter;
        }

        public String getInstagram() {
            return instagram;
        }

        public String getYoutube() {
            return youtube;
        }

        public String getBlog() {
            return blog;
        }

        public Picture getPicture() {
            return picture;
        }

        public Beauty_profile getBeauty_profile() {
            return beauty_profile;
        }

        public Beauty_concern getBeauty_concern() {
            return beauty_concern;
        }

        public ArrayList<Brand> getBrands() {
            return brands;
        }

        public static final class Picture {
            public final String xtra_small;
            public final String small;
            public final String medium;
            public final String large;

            public Picture(String xtra_small, String small, String medium, String large){
                this.xtra_small = xtra_small;
                this.small = small;
                this.medium = medium;
                this.large = large;
            }

            public String getXtra_small() {
                return xtra_small;
            }

            public String getSmall() {
                return small;
            }

            public String getMedium() {
                return medium;
            }

            public String getLarge() {
                return large;
            }
        }

        public static final class Beauty_profile {
            public final long skin_type_id;
            public final String skin_type_name;
            public final long skin_tone_id;
            public final String skin_tone_name;
            public final long skin_undertone_id;
            public final String skin_undertone_name;
            public final Skin_hairtype_id skin_hairtype_id;
            public final String skin_hairtype_name;
            public final Hair_texture_id hair_texture_id;
            public final String hair_texture_name;

            public Beauty_profile(long skin_type_id, String skin_type_name, long skin_tone_id, String skin_tone_name, long skin_undertone_id, String skin_undertone_name, Skin_hairtype_id skin_hairtype_id, String skin_hairtype_name, Hair_texture_id hair_texture_id, String hair_texture_name){
                this.skin_type_id = skin_type_id;
                this.skin_type_name = skin_type_name;
                this.skin_tone_id = skin_tone_id;
                this.skin_tone_name = skin_tone_name;
                this.skin_undertone_id = skin_undertone_id;
                this.skin_undertone_name = skin_undertone_name;
                this.skin_hairtype_id = skin_hairtype_id;
                this.skin_hairtype_name = skin_hairtype_name;
                this.hair_texture_id = hair_texture_id;
                this.hair_texture_name = hair_texture_name;
            }

            public long getSkin_type_id() {
                return skin_type_id;
            }

            public String getSkin_type_name() {
                return skin_type_name;
            }

            public long getSkin_tone_id() {
                return skin_tone_id;
            }

            public String getSkin_tone_name() {
                return skin_tone_name;
            }

            public long getSkin_undertone_id() {
                return skin_undertone_id;
            }

            public String getSkin_undertone_name() {
                return skin_undertone_name;
            }

            public Skin_hairtype_id getSkin_hairtype_id() {
                return skin_hairtype_id;
            }

            public String getSkin_hairtype_name() {
                return skin_hairtype_name;
            }

            public Hair_texture_id getHair_texture_id() {
                return hair_texture_id;
            }

            public String getHair_texture_name() {
                return hair_texture_name;
            }

            public static final class Skin_hairtype_id {

                public Skin_hairtype_id(){
                }
            }

            public static final class Hair_texture_id {

                public Hair_texture_id(){
                }
            }
        }

        public static final class Beauty_concern {
            public final ArrayList<Skin> skin;
            public final ArrayList<Body> body;
            public final ArrayList<Hair> hair;

            public Beauty_concern(ArrayList<Skin> skin, ArrayList<Body> body, ArrayList<Hair> hair){
                this.skin = skin;
                this.body = body;
                this.hair = hair;
            }

            public ArrayList<Skin> getSkin() {
                return skin;
            }

            public ArrayList<Body> getBody() {
                return body;
            }

            public ArrayList<Hair> getHair() {
                return hair;
            }

            public static final class Skin {

                public Skin(){
                }
            }

            public static final class Body {

                public Body(){
                }
            }

            public static final class Hair {

                public Hair(){
                }
            }
        }

        public static final class Brand {

            public Brand(){
            }
        }
    }
}
