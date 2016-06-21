package com.cui.mrr.presenter.iml;

import android.util.Log;

import com.cui.mrr.http.ApiClient;
import com.cui.mrr.presenter.AbstractBasePresenter;
import com.cui.mrr.util.Utils;
import com.cui.mrr.view.BaseContract;
import com.cui.mrr.view.iml.MainContract;
import com.cui.mrr.view.iml.SecondContract;


import okhttp3.ResponseBody;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by cuiyang on 16/6/20.
 */
public class SavePresenter extends AbstractBasePresenter {

    protected Subscription savePicture(String url, BaseContract.BaseView mView) {
        subscription = ApiClient.getApiService()
                .downloadFile(url)
                .subscribeOn(Schedulers.io())
                .map((Func1<ResponseBody, Object>) Utils::writeResponseBodyToDisk)//PS使用@Streaming所以不能在主线程否则会抛出android.os.NetworkOnMainThreadException异常
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(o -> {
                            if (mView instanceof MainContract.MainView) {
                                ((MainContract.MainView) mView).DownLoadSuccesss((Boolean) o);
                            } else if (mView instanceof SecondContract.SecondView) {
                                ((SecondContract.SecondView) mView).DownLoadSuccesss((Boolean) o);
                            }
                        }
                        , throwable -> {
                            Log.e("cui", throwable.toString());
                        });
        return subscription;
    }
}
