package com.fdbr.android.presenter;

/**
 * Created by Wandy on 8/18/2016.
 */
public interface BasePresenter<V> {

    void onAttachView(V view);
    void onUnattachView();
}
