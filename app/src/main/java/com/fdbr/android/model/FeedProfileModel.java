package com.fdbr.android.model;

import java.util.ArrayList;

/**
 * Created by LTE on 8/25/2016.
 */
public final class FeedProfileModel {
    public final Meta meta;
    public final ArrayList<Data> data;
    public final Pagination pagination;

    public FeedProfileModel(Meta meta, ArrayList<Data> data, Pagination pagination){
        this.meta = meta;
        this.data = data;
        this.pagination = pagination;
    }

    public Meta getMeta() {
        return meta;
    }

    public ArrayList<Data> getData() {
        return data;
    }

    public Pagination getPagination() {
        return pagination;
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
        public final long id;
        public final String created_at;
        public final String updated_at;
        public final Product product;
        public final Brand brand;
        public final ArrayList<Tag> tags;

        public Data(long id, String created_at, String updated_at, Product product, Brand brand, ArrayList<Tag> tags){
            this.id = id;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.product = product;
            this.brand = brand;
            this.tags = tags;
        }

        public long getId() {
            return id;
        }

        public String getCreated_at() {
            return created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public Product getProduct() {
            return product;
        }

        public Brand getBrand() {
            return brand;
        }

        public ArrayList<Tag> getTags() {
            return tags;
        }

        public static final class Product {
            public final long id;
            public final String name;
            public final String slug;
            public final String desc;
            public final Image image;

            public Product(long id, String name, String slug, String desc, Image image){
                this.id = id;
                this.name = name;
                this.slug = slug;
                this.desc = desc;
                this.image = image;
            }

            public long getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            public String getSlug() {
                return slug;
            }

            public String getDesc() {
                return desc;
            }

            public Image getImage() {
                return image;
            }

            public static final class Image {
                public final String xtra_small;
                public final String small;
                public final String medium;
                public final String large;

                public Image(String xtra_small, String small, String medium, String large){
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
        }

        public static final class Brand {
            public final long id;
            public final String name;
            public final String slug;
            public final String desc;

            public Brand(long id, String name, String slug, String desc){
                this.id = id;
                this.name = name;
                this.slug = slug;
                this.desc = desc;
            }

            public long getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            public String getSlug() {
                return slug;
            }

            public String getDesc() {
                return desc;
            }
        }

        public static final class Tag {
            public final long id;
            public final String name;
            public final String slug;

            public Tag(long id, String name, String slug){
                this.id = id;
                this.name = name;
                this.slug = slug;
            }

            public String getSlug() {
                return slug;
            }

            public long getId() {
                return id;
            }

            public String getName() {
                return name;
            }
        }
    }

    public static final class Pagination {
        public final long limit;
        public final long next_id;

        public Pagination(long limit, long next_id){
            this.limit = limit;
            this.next_id = next_id;
        }

        public long getLimit() {
            return limit;
        }

        public long getNext_id() {
            return next_id;
        }
    }
}
