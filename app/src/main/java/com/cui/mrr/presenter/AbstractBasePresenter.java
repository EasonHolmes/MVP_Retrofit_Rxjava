package com.cui.mrr.presenter;

import com.cui.mrr.AbstractBaseActivity;
import com.cui.mrr.view.BaseContract;

import rx.Subscription;

/**
 * Created by cuiyang on 16/6/20.
 */
public class AbstractBasePresenter {
    /**
     * 保存subscription用来在界面销毁的时候释放用
     */
    public Subscription subscription;

}
