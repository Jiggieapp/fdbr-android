package com.fdbr.android.model;

import java.util.ArrayList;

/**
 * Created by LTE on 8/25/2016.
 */
public final class BrandModel {
    public final Meta meta;
    public final ArrayList<Data> data;

    public BrandModel(Meta meta, ArrayList<Data> data){
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
        public final long brands_id;
        public final String brands_item;
        public final String brands_slug;
        public final String brands_desc;
        public final long brands_braori_id;
        public final long brands_total_product;
        public final long brands_total_review_num;
        public final double brands_rating;
        public final long brands_price;
        public final String brands_frontend;
        public final String brands_sort_frontend;
        public final long brands_view;
        public final long brands_prod_view;
        public final String brands_create_date;
        public final String brands_status;
        public final String brands_top;

        public Data(long brands_id, String brands_item, String brands_slug, String brands_desc, long brands_braori_id, long brands_total_product, long brands_total_review_num, double brands_rating, long brands_price, String brands_frontend, String brands_sort_frontend, long brands_view, long brands_prod_view, String brands_create_date, String brands_status, String brands_top){
            this.brands_id = brands_id;
            this.brands_item = brands_item;
            this.brands_slug = brands_slug;
            this.brands_desc = brands_desc;
            this.brands_braori_id = brands_braori_id;
            this.brands_total_product = brands_total_product;
            this.brands_total_review_num = brands_total_review_num;
            this.brands_rating = brands_rating;
            this.brands_price = brands_price;
            this.brands_frontend = brands_frontend;
            this.brands_sort_frontend = brands_sort_frontend;
            this.brands_view = brands_view;
            this.brands_prod_view = brands_prod_view;
            this.brands_create_date = brands_create_date;
            this.brands_status = brands_status;
            this.brands_top = brands_top;
        }

        public long getBrands_id() {
            return brands_id;
        }

        public String getBrands_item() {
            return brands_item;
        }

        public String getBrands_slug() {
            return brands_slug;
        }

        public String getBrands_desc() {
            return brands_desc;
        }

        public long getBrands_braori_id() {
            return brands_braori_id;
        }

        public long getBrands_total_product() {
            return brands_total_product;
        }

        public long getBrands_total_review_num() {
            return brands_total_review_num;
        }

        public double getBrands_rating() {
            return brands_rating;
        }

        public long getBrands_price() {
            return brands_price;
        }

        public String getBrands_frontend() {
            return brands_frontend;
        }

        public String getBrands_sort_frontend() {
            return brands_sort_frontend;
        }

        public long getBrands_view() {
            return brands_view;
        }

        public long getBrands_prod_view() {
            return brands_prod_view;
        }

        public String getBrands_create_date() {
            return brands_create_date;
        }

        public String getBrands_status() {
            return brands_status;
        }

        public String getBrands_top() {
            return brands_top;
        }
    }
}
