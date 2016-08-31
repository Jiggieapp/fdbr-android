package com.fdbr.android.api;

import com.fdbr.android.utils.Constant;
import com.fdbr.android.utils.Utils;

import retrofit2.Response;
import rx.Subscriber;

/**
 * Created by Wandy on 8/26/2016.
 */
public abstract class BaseResponse<T> extends Subscriber<Response<T>> {

    private final String TAG = BaseResponse.class.getSimpleName();

    @Override
    public void onError(Throwable e) {
        Utils.d(TAG, "error " + e.toString());
        onError();
    }

    @Override
    public void onNext(Response<T> response) {
        Utils.d("profilefrag", "response code " + response.code());
        if (response.code() == Constant.CODE_EMPTY) {

        } else if (response.code() == Constant.CODE_OK) {
            doOnNext(response.body());
        } else if (response.code() == Constant.CODE_TOKEN_EXPIRED) {
            //doRestart();
        }
    }

    /*@Override
    public void onNext(Response<T> response) {
        if (response.code() == Constant.CODE_EMPTY) {

        } else if (response.code() == Constant.CODE_OK) {
            doOnNext(response);
        } else if (response.code() == Constant.CODE_TOKEN_EXPIRED) {
            doRestart();
        }
    }*/



    //public abstract void doRestart();
    public abstract void onError();
    public abstract void doOnNext(T t);
}
