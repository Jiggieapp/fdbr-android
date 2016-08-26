package com.fdbr.android.presenter;

import com.fdbr.android.view.interfaces.ProductView;

/**
 * Created by LTE on 8/25/2016.
 */
public class ProductPresenter {

    public interface BrandPresenter extends BasePresenter<ProductView.BrandView>{
        void brandList();
    }

}
