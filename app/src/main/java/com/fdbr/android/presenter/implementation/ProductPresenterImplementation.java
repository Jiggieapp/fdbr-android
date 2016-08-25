package com.fdbr.android.presenter.implementation;

import com.fdbr.android.api.ProductAPI;
import com.fdbr.android.base.BaseNetworkManager;
import com.fdbr.android.model.BrandModel;
import com.fdbr.android.presenter.ProductPresenter;
import com.fdbr.android.utils.Utils;
import com.fdbr.android.view.interfaces.ProductView;

import retrofit2.Response;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by LTE on 8/25/2016.
 */
public class ProductPresenterImplementation {

    public static class BrandPresenterImplementation extends BaseNetworkManager implements ProductPresenter.BrandPresenter{

        private ProductView.BrandView brandView;
        private Subscription subscription;
        private static ProductAPI productAPI;
        private final String TAG = ProfilePresenterImplementation.DetailProfilePresenterImplementation.class.getSimpleName();

        @Override
        public void onAttachView(ProductView.BrandView view) {
            this.brandView = view;
        }

        @Override
        public void onUnattachView() {
            productAPI = null;
            subscription.unsubscribe();
        }

        @Override
        public void brandList() {
            subscription = getInstance()
                    .getBrandList()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Subscriber<Response<BrandModel>>() {
                        @Override
                        public void onCompleted() {
                            Utils.d(TAG, "");
                        }

                        @Override
                        public void onError(Throwable e) {
                            Utils.d(TAG, e.toString());
                        }

                        @Override
                        public void onNext(Response<BrandModel> response) {
                            int code = response.code();
                            Utils.d(TAG, String.valueOf(code));
                            if(code==204){
                                //content empty
                            }else{
                                brandView.getBrandList(response.body());
                            }


                        }
                    });
        }

        private static ProductAPI getInstance()
        {
            if(productAPI == null)
                productAPI = getRetrofit().create(ProductAPI.class);
            return productAPI;
        }
    }

}
