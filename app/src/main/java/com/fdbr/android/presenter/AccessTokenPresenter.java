package com.fdbr.android.presenter;

import com.fdbr.android.view.interfaces.AccessTokenView;

/**
 * Created by Wandy on 8/18/2016.
 */
public interface AccessTokenPresenter extends BasePresenter<AccessTokenView> {

    void getAccessToken();
    void verifyToken();
}
