package com.cui.mrr;

import android.support.v7.app.AppCompatActivity;

import rx.Subscription;

/**
 * Created by cuiyang on 16/6/20.
 */
public class AbstractBaseActivity extends AppCompatActivity {
    protected Subscription subscription;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unsubscribe();
    }

    protected void unsubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
