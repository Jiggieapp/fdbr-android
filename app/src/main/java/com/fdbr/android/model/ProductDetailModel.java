package com.fdbr.android.model;

import java.util.ArrayList;

/**
 * Created by LTE on 9/1/2016.
 */
public final class ProductDetailModel {
    public final Meta meta;
    public final Data data;

    public ProductDetailModel(Meta meta, Data data){
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
        public final String prodimg;
        public final String prod_item;
        public final String brands_item;
        public final String review_prodprice_update;
        public final String review_cur_update;
        public final String review_rating_avg;
        public final String review_packaging_avg;
        public final String prod_desc;
        public final String average_age;
        public final String most_skin;
        public final ArrayList<Feed_reviews_column> feed_reviews_column;

        public Data(String prodimg, String prod_item, String brands_item, String review_prodprice_update, String review_cur_update, String review_rating_avg, String review_packaging_avg, String prod_desc, String average_age, String most_skin, ArrayList<Feed_reviews_column> feed_reviews_column){
            this.prodimg = prodimg;
            this.prod_item = prod_item;
            this.brands_item = brands_item;
            this.review_prodprice_update = review_prodprice_update;
            this.review_cur_update = review_cur_update;
            this.review_rating_avg = review_rating_avg;
            this.review_packaging_avg = review_packaging_avg;
            this.prod_desc = prod_desc;
            this.average_age = average_age;
            this.most_skin = most_skin;
            this.feed_reviews_column = feed_reviews_column;
        }

        public String getProdimg() {
            return prodimg;
        }

        public String getProd_item() {
            return prod_item;
        }

        public String getBrands_item() {
            return brands_item;
        }

        public String getReview_prodprice_update() {
            return review_prodprice_update;
        }

        public String getReview_cur_update() {
            return review_cur_update;
        }

        public String getReview_rating_avg() {
            return review_rating_avg;
        }

        public String getReview_packaging_avg() {
            return review_packaging_avg;
        }

        public String getProd_desc() {
            return prod_desc;
        }

        public String getAverage_age() {
            return average_age;
        }

        public String getMost_skin() {
            return most_skin;
        }

        public ArrayList<Feed_reviews_column> getFeed_reviews_column() {
            return feed_reviews_column;
        }

        public static final class Feed_reviews_column {
            public final long rvwr_id;
            public final long rvwr_review_id;
            public final long rvwr_user_id;
            public final String rvwr_post_date;
            public final String rvwr_update_date;
            public final long rvwr_review_rating;
            public final String rvwr_review_think;
            public final String rvwr_review_buy;
            public final long rvwr_review_package;
            public final long rvwr_user_agerange;
            public final long rvwr_user_skin_type;
            public final long rvwr_user_skin_tone;
            public final long rvwr_user_skin_untone;
            public final long rvwr_numusers_flag;
            public final long rvwr_numusers_wishlist;
            public final long rvwr_numusers_helpful;
            public final String rvwr_review_txt;
            public final String rvwr_review_hashtag;
            public final String rvwr_pro;
            public final String rvwr_cons;
            public final String rvwr_delete;
            public final String image;
            public final String fullname;
            public final String username;
            public final String age;
            public final String dob;

            public Feed_reviews_column(long rvwr_id, long rvwr_review_id, long rvwr_user_id, String rvwr_post_date, String rvwr_update_date, long rvwr_review_rating, String rvwr_review_think, String rvwr_review_buy, long rvwr_review_package, long rvwr_user_agerange, long rvwr_user_skin_type, long rvwr_user_skin_tone, long rvwr_user_skin_untone, long rvwr_numusers_flag, long rvwr_numusers_wishlist, long rvwr_numusers_helpful, String rvwr_review_txt, String rvwr_review_hashtag, String rvwr_pro, String rvwr_cons, String rvwr_delete, String image, String fullname, String username, String age, String dob){
                this.rvwr_id = rvwr_id;
                this.rvwr_review_id = rvwr_review_id;
                this.rvwr_user_id = rvwr_user_id;
                this.rvwr_post_date = rvwr_post_date;
                this.rvwr_update_date = rvwr_update_date;
                this.rvwr_review_rating = rvwr_review_rating;
                this.rvwr_review_think = rvwr_review_think;
                this.rvwr_review_buy = rvwr_review_buy;
                this.rvwr_review_package = rvwr_review_package;
                this.rvwr_user_agerange = rvwr_user_agerange;
                this.rvwr_user_skin_type = rvwr_user_skin_type;
                this.rvwr_user_skin_tone = rvwr_user_skin_tone;
                this.rvwr_user_skin_untone = rvwr_user_skin_untone;
                this.rvwr_numusers_flag = rvwr_numusers_flag;
                this.rvwr_numusers_wishlist = rvwr_numusers_wishlist;
                this.rvwr_numusers_helpful = rvwr_numusers_helpful;
                this.rvwr_review_txt = rvwr_review_txt;
                this.rvwr_review_hashtag = rvwr_review_hashtag;
                this.rvwr_pro = rvwr_pro;
                this.rvwr_cons = rvwr_cons;
                this.rvwr_delete = rvwr_delete;
                this.image = image;
                this.fullname = fullname;
                this.username = username;
                this.age = age;
                this.dob = dob;
            }

            public long getRvwr_id() {
                return rvwr_id;
            }

            public long getRvwr_review_id() {
                return rvwr_review_id;
            }

            public long getRvwr_user_id() {
                return rvwr_user_id;
            }

            public String getRvwr_post_date() {
                return rvwr_post_date;
            }

            public String getRvwr_update_date() {
                return rvwr_update_date;
            }

            public long getRvwr_review_rating() {
                return rvwr_review_rating;
            }

            public String getRvwr_review_think() {
                return rvwr_review_think;
            }

            public String getRvwr_review_buy() {
                return rvwr_review_buy;
            }

            public long getRvwr_review_package() {
                return rvwr_review_package;
            }

            public long getRvwr_user_agerange() {
                return rvwr_user_agerange;
            }

            public long getRvwr_user_skin_type() {
                return rvwr_user_skin_type;
            }

            public long getRvwr_user_skin_tone() {
                return rvwr_user_skin_tone;
            }

            public long getRvwr_user_skin_untone() {
                return rvwr_user_skin_untone;
            }

            public long getRvwr_numusers_flag() {
                return rvwr_numusers_flag;
            }

            public long getRvwr_numusers_wishlist() {
                return rvwr_numusers_wishlist;
            }

            public long getRvwr_numusers_helpful() {
                return rvwr_numusers_helpful;
            }

            public String getRvwr_review_txt() {
                return rvwr_review_txt;
            }

            public String getRvwr_review_hashtag() {
                return rvwr_review_hashtag;
            }

            public String getRvwr_pro() {
                return rvwr_pro;
            }

            public String getRvwr_cons() {
                return rvwr_cons;
            }

            public String getRvwr_delete() {
                return rvwr_delete;
            }

            public String getImage() {
                return image;
            }

            public String getFullname() {
                return fullname;
            }

            public String getUsername() {
                return username;
            }

            public String getAge() {
                return age;
            }

            public String getDob() {
                return dob;
            }
        }
    }
}