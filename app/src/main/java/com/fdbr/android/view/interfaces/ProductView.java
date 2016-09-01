package com.fdbr.android.view.interfaces;

import com.fdbr.android.model.BrandModel;
import com.fdbr.android.model.ProductDetailModel;
import com.fdbr.android.model.ProductListModel;

/**
 * Created by LTE on 8/25/2016.
 */
public class ProductView {

    public interface BrandView{
        void getBrandList(BrandModel brandModel);
    }

    public interface ProductListView{
        void getProductList(ProductListModel productListModel);
    }

    public interface ProductDetailView{
        void getProductDetail(ProductDetailModel productDetailModel);
    }

}
