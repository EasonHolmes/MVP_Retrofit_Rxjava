package com.cui.mrr.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cui.mrr.AbstractBaseActivity;
import com.cui.mrr.R;
import com.cui.mrr.presenter.iml.SecondPresenter;
import com.cui.mrr.view.iml.SecondContract;

/**
 * Created by cuiyang on 16/6/20.
 */
public class SecondActivity extends AbstractBaseActivity implements SecondContract.SecondView {
    private ImageView imageView;
    private String url;
    private SecondPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_act);

        url = getIntent().getStringExtra(MainActivity.URL);

        imageView = (ImageView) findViewById(R.id.imageview);

        Glide.with(this).load(url).into(imageView);

        presenter = new SecondPresenter(this);


        imageView.setOnLongClickListener(v -> {
            Toast.makeText(this, "saving....", Toast.LENGTH_SHORT).show();
            presenter.DownLoadImg(url);
            return true;
        });
    }

    @Override
    public void DownLoadSuccesss(boolean isSuccess) {
        if (isSuccess) {
            Toast.makeText(this, "download success", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "download success", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void refreshError(String error) {

    }
}
