package com.fdbr.android.model;

import java.util.ArrayList;

/**
 * Created by LTE on 9/1/2016.
 */
public final class ProductListModel {
    public final Meta meta;
    public final ArrayList<Data> data;

    public ProductListModel(Meta meta, ArrayList<Data> data){
        this.meta = meta;
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public ArrayList<Data> getData() {
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
        public final String review_id;
        public final String review_cat_id;
        public final String review_brand_id;
        public final String review_prod_id;
        public final String review_date;
        public final String review_last_update;
        public final String review_rating_avg;
        public final String review_num;
        public final String review_prodprice_ori;
        public final String review_prodprice_update;
        public final String prod_id;
        public final String prod_item;
        public final String prod_desc;
        public final String prod_type;
        public final String prod_image;
        public final double sort_point;
        public final String brands_name;

        public Data(String review_id, String review_cat_id, String review_brand_id, String review_prod_id, String review_date, String review_last_update, String review_rating_avg, String review_num, String review_prodprice_ori, String review_prodprice_update, String prod_id, String prod_item, String prod_desc, String prod_type, String prod_image, double sort_point, String brands_name){
            this.review_id = review_id;
            this.review_cat_id = review_cat_id;
            this.review_brand_id = review_brand_id;
            this.review_prod_id = review_prod_id;
            this.review_date = review_date;
            this.review_last_update = review_last_update;
            this.review_rating_avg = review_rating_avg;
            this.review_num = review_num;
            this.review_prodprice_ori = review_prodprice_ori;
            this.review_prodprice_update = review_prodprice_update;
            this.prod_id = prod_id;
            this.prod_item = prod_item;
            this.prod_desc = prod_desc;
            this.prod_type = prod_type;
            this.prod_image = prod_image;
            this.sort_point = sort_point;
            this.brands_name = brands_name;
        }

        public String getReview_id() {
            return review_id;
        }

        public String getReview_cat_id() {
            return review_cat_id;
        }

        public String getReview_brand_id() {
            return review_brand_id;
        }

        public String getReview_prod_id() {
            return review_prod_id;
        }

        public String getReview_date() {
            return review_date;
        }

        public String getReview_last_update() {
            return review_last_update;
        }

        public String getReview_rating_avg() {
            return review_rating_avg;
        }

        public String getReview_num() {
            return review_num;
        }

        public String getReview_prodprice_ori() {
            return review_prodprice_ori;
        }

        public String getReview_prodprice_update() {
            return review_prodprice_update;
        }

        public String getProd_id() {
            return prod_id;
        }

        public String getProd_item() {
            return prod_item;
        }

        public String getProd_desc() {
            return prod_desc;
        }

        public String getProd_type() {
            return prod_type;
        }

        public String getProd_image() {
            return prod_image;
        }

        public double getSort_point() {
            return sort_point;
        }

        public String getBrands_name() {
            return brands_name;
        }
    }
}
