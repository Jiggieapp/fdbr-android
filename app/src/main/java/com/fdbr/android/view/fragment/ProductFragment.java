package com.fdbr.android.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fdbr.android.R;
import com.fdbr.android.model.ProductDetailModel;
import com.fdbr.android.model.ProductListModel;
import com.fdbr.android.presenter.implementation.ProductPresenterImplementation;
import com.fdbr.android.view.interfaces.ProductView;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LTE on 8/23/2016.
 */
public class ProductFragment extends Fragment implements ProductView.ProductListView, ProductView.ProductDetailView {

    private final String TAG = ProductFragment.class.getSimpleName();
    ProductPresenterImplementation.ProductListPresenterImplementation productListPresenterImplementation;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    ProductPresenterImplementation.ProductDetailPresenterImplementation productDetailPresenterImplementation;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_product, null);
        ButterKnife.bind(this, v);

        /*productListPresenterImplementation = new ProductPresenterImplementation.ProductListPresenterImplementation();
        productListPresenterImplementation.onAttachView(this);
        productListPresenterImplementation.productList();*/

        productDetailPresenterImplementation = new ProductPresenterImplementation.ProductDetailPresenterImplementation();
        productDetailPresenterImplementation.onAttachView(this);
        productDetailPresenterImplementation.productDetail("16454");

        return v;
    }

    @Override
    public void getProductList(ProductListModel productListModel) {
        String sd = String.valueOf(new Gson().toJson(productListModel));
        Log.d("sd", "sd");
    }

    @Override
    public void getProductDetail(ProductDetailModel productDetailModel) {
        String sd = String.valueOf(new Gson().toJson(productDetailModel));
        Log.d("sd", "sd");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //productListPresenterImplementation.onUnattachView();
        productDetailPresenterImplementation.onUnattachView();
    }
}
