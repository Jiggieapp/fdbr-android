package com.fdbr.android.view.interfaces;

import com.fdbr.android.model.BrandModel;

/**
 * Created by LTE on 8/25/2016.
 */
public class ProductView {

    public interface BrandView{
        void getBrandList(BrandModel brandModel);
    }

}
