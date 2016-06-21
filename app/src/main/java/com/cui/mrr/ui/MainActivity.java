package com.cui.mrr.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.cui.mrr.AbstractBaseActivity;
import com.cui.mrr.R;
import com.cui.mrr.adapter.MainListAdapter;
import com.cui.mrr.entity.ListEntity;
import com.cui.mrr.presenter.iml.MainPreseneter;
import com.cui.mrr.view.iml.MainContract;

import java.util.List;

public class MainActivity extends AbstractBaseActivity implements MainContract.MainView, MainListAdapter.ClickListener {
    private RecyclerView mRecyclerView;
    private MainListAdapter adapter;
    private MainPreseneter preseneter;
    public static final String URL = "url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerview);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new MainListAdapter();
        adapter.setOnItemClickListener(this);
        adapter.setOnLongClickListener(this);
        mRecyclerView.setAdapter(adapter);

        preseneter = new MainPreseneter(this);
        subscription = preseneter.getMainListData();

    }


    @Override
    public void refreshError(String error) {
        //处理错误
        Log.e(getClass().getName(), error);
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
    public void getListData(ListEntity entity) {
        if (entity == null)
            return;
        adapter.setNewData(entity.getResults());
    }

    @Override
    public void onItemClick(int position, View v) {
        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra(URL, adapter.getData().get(position).getUrl());
        startActivity(i);
    }

    @Override
    public void onLongClick(int position, View v) {
        Toast.makeText(this, "saving....", Toast.LENGTH_SHORT).show();
        preseneter.downLoadFile(adapter.getData().get(position).getUrl());
    }
}
