package com.fdbr.android.manager.basepresenter;

import com.fdbr.android.view.AccessTokenView;

/**
 * Created by Wandy on 8/18/2016.
 */
public interface AccessTokenPresenter extends BasePresenter<AccessTokenView> {

    void getAccessToken();
    void verifyToken();
}
