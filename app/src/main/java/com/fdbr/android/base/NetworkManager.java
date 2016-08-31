package com.fdbr.android.base;

/**
 * Created by Wandy on 8/29/2016.
 */
public abstract class NetworkManager<T> extends BaseNetworkManager {

    T api;

    public T getInstance()
    {
        if(api == null)
            return getRetrofit().create((Class<? extends T>) getClass());
        return api;
    }

    //public abstract T getAnu();
}
