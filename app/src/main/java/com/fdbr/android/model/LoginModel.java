package com.fdbr.android.model;

import java.util.ArrayList;

/**
 * Created by LTE on 8/22/2016.
 */
public final class LoginModel {
    public final Meta meta;
    public final Data data;

    public LoginModel(Meta meta, Data data){
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
        public final ArrayList<Row> rows;
        public final Vb vb;
        public final String token;

        public Data(ArrayList<Row> rows, Vb vb, String token){
            this.rows = rows;
            this.vb = vb;
            this.token = token;
        }

        public ArrayList<Row> getRows() {
            return rows;
        }

        public Vb getVb() {
            return vb;
        }

        public String getToken() {
            return token;
        }

        public static final class Row {
            public final long usrapo_id;
            public final long user_id;
            public final String fullname;
            public final String username;
            public final String password;
            public final String dob;
            public final String email;
            public final String userabout;
            public final long userdata_completion;
            public final long userage_range;
            public final String userabout_set;
            public final String joindate;
            public final String lastvisit;
            public final String lastactivity;
            public final String lastreview;
            public final long lastreputation;
            public final long wishlistnum;
            public final long ownitnum;
            public final long reviewnum;
            public final long productsubmitnum;
            public final String user_banned;
            public final String user_gender;
            public final String user_occupation;
            public final long user_usrlvl_id;
            public final long user_total_point;
            public final long user_total_badge;
            public final String user_blog;
            public final String user_facebook;
            public final String user_instagram;
            public final String user_instagram_auth;
            public final String user_youtube;
            public final String user_twitter;
            public final String user_v_brand;
            public final String user_v_scent;
            public final String user_v_salon;
            public final long user_agree_term;
            public final long user_subscribe_newsletter;
            public final String user_beauty_panelist;
            public final String user_connect_fb;

            public Row(long usrapo_id, long user_id, String fullname, String username, String password, String dob, String email, String userabout, long userdata_completion, long userage_range, String userabout_set, String joindate, String lastvisit, String lastactivity, String lastreview, long lastreputation, long wishlistnum, long ownitnum, long reviewnum, long productsubmitnum, String user_banned, String user_gender, String user_occupation, long user_usrlvl_id, long user_total_point, long user_total_badge, String user_blog, String user_facebook, String user_instagram, String user_instagram_auth, String user_youtube, String user_twitter, String user_v_brand, String user_v_scent, String user_v_salon, long user_agree_term, long user_subscribe_newsletter, String user_beauty_panelist, String user_connect_fb){
                this.usrapo_id = usrapo_id;
                this.user_id = user_id;
                this.fullname = fullname;
                this.username = username;
                this.password = password;
                this.dob = dob;
                this.email = email;
                this.userabout = userabout;
                this.userdata_completion = userdata_completion;
                this.userage_range = userage_range;
                this.userabout_set = userabout_set;
                this.joindate = joindate;
                this.lastvisit = lastvisit;
                this.lastactivity = lastactivity;
                this.lastreview = lastreview;
                this.lastreputation = lastreputation;
                this.wishlistnum = wishlistnum;
                this.ownitnum = ownitnum;
                this.reviewnum = reviewnum;
                this.productsubmitnum = productsubmitnum;
                this.user_banned = user_banned;
                this.user_gender = user_gender;
                this.user_occupation = user_occupation;
                this.user_usrlvl_id = user_usrlvl_id;
                this.user_total_point = user_total_point;
                this.user_total_badge = user_total_badge;
                this.user_blog = user_blog;
                this.user_facebook = user_facebook;
                this.user_instagram = user_instagram;
                this.user_instagram_auth = user_instagram_auth;
                this.user_youtube = user_youtube;
                this.user_twitter = user_twitter;
                this.user_v_brand = user_v_brand;
                this.user_v_scent = user_v_scent;
                this.user_v_salon = user_v_salon;
                this.user_agree_term = user_agree_term;
                this.user_subscribe_newsletter = user_subscribe_newsletter;
                this.user_beauty_panelist = user_beauty_panelist;
                this.user_connect_fb = user_connect_fb;
            }

            public long getUsrapo_id() {
                return usrapo_id;
            }

            public long getUser_id() {
                return user_id;
            }

            public String getFullname() {
                return fullname;
            }

            public String getUsername() {
                return username;
            }

            public String getPassword() {
                return password;
            }

            public String getDob() {
                return dob;
            }

            public String getEmail() {
                return email;
            }

            public String getUserabout() {
                return userabout;
            }

            public long getUserdata_completion() {
                return userdata_completion;
            }

            public long getUserage_range() {
                return userage_range;
            }

            public String getUserabout_set() {
                return userabout_set;
            }

            public String getJoindate() {
                return joindate;
            }

            public String getLastvisit() {
                return lastvisit;
            }

            public String getLastactivity() {
                return lastactivity;
            }

            public String getLastreview() {
                return lastreview;
            }

            public long getLastreputation() {
                return lastreputation;
            }

            public long getWishlistnum() {
                return wishlistnum;
            }

            public long getOwnitnum() {
                return ownitnum;
            }

            public long getReviewnum() {
                return reviewnum;
            }

            public long getProductsubmitnum() {
                return productsubmitnum;
            }

            public String getUser_banned() {
                return user_banned;
            }

            public String getUser_gender() {
                return user_gender;
            }

            public String getUser_occupation() {
                return user_occupation;
            }

            public long getUser_usrlvl_id() {
                return user_usrlvl_id;
            }

            public long getUser_total_point() {
                return user_total_point;
            }

            public long getUser_total_badge() {
                return user_total_badge;
            }

            public String getUser_blog() {
                return user_blog;
            }

            public String getUser_facebook() {
                return user_facebook;
            }

            public String getUser_instagram() {
                return user_instagram;
            }

            public String getUser_instagram_auth() {
                return user_instagram_auth;
            }

            public String getUser_youtube() {
                return user_youtube;
            }

            public String getUser_twitter() {
                return user_twitter;
            }

            public String getUser_v_brand() {
                return user_v_brand;
            }

            public String getUser_v_scent() {
                return user_v_scent;
            }

            public String getUser_v_salon() {
                return user_v_salon;
            }

            public long getUser_agree_term() {
                return user_agree_term;
            }

            public long getUser_subscribe_newsletter() {
                return user_subscribe_newsletter;
            }

            public String getUser_beauty_panelist() {
                return user_beauty_panelist;
            }

            public String getUser_connect_fb() {
                return user_connect_fb;
            }
        }

        public static final class Vb {
            public final boolean login_success;
            public final Error error;
            public final Result result;

            public Vb(boolean login_success, Error error, Result result){
                this.login_success = login_success;
                this.error = error;
                this.result = result;
            }

            public boolean isLogin_success() {
                return login_success;
            }

            public Error getError() {
                return error;
            }

            public Result getResult() {
                return result;
            }

            public static final class Error {
                public final String message;

                public Error(String message){
                    this.message = message;
                }

                public String getMessage() {
                    return message;
                }
            }

            public static final class Result {
                public final User_info user_info;

                public User_info getUser_info() {
                    return user_info;
                }

                public Result(User_info user_info){
                    this.user_info = user_info;
                }

                public static final class User_info {
                    public final String userid;
                    public final String username;
                    public final String joindate;

                    public User_info(String userid, String username, String joindate){
                        this.userid = userid;
                        this.username = username;
                        this.joindate = joindate;
                    }

                    public String getUserid() {
                        return userid;
                    }

                    public String getUsername() {
                        return username;
                    }

                    public String getJoindate() {
                        return joindate;
                    }
                }
            }
        }
    }
}
