package com.cui.mrr.view.iml;

import com.cui.mrr.view.BaseContract;

/**
 * Created by cuiyang on 16/6/21.
 */
public interface SecondContract {
    interface SecondView extends BaseContract.BaseView {
        void DownLoadSuccesss(boolean isSuccess);

    }

    interface SecondPresenterIml extends BaseContract.BasePresenter {
        void DownLoadImg(String url);

    }
}
