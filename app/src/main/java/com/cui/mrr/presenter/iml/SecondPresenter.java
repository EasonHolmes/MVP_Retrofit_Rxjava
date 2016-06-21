package com.cui.mrr.presenter.iml;

import com.cui.mrr.ui.SecondActivity;
import com.cui.mrr.view.iml.SecondContract;

/**
 * Created by cuiyang on 16/6/21.
 */
public class SecondPresenter extends SavePresenter implements SecondContract.SecondPresenterIml {

    private SecondActivity activity;
    private SecondContract.SecondView mView;

    public SecondPresenter(SecondActivity activity) {
        this.activity = activity;
        this.mView = activity;
    }

    @Override
    public void DownLoadImg(String url) {
        subscription = super.savePicture(url, mView);
    }
}
