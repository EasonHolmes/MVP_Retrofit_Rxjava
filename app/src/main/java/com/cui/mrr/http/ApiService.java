package com.cui.mrr.http;


import com.cui.mrr.entity.ListEntity;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by cuiyang on 16/6/1.
 */
public interface ApiService {


    @GET("search/query/listview/category/%E7%A6%8F%E5%88%A9/count/50/page/1")
    Observable<ListEntity> getMainList();

    @Streaming //使用Streaming将不把文件读进内存
    @GET
    Observable<ResponseBody> downloadFile(@Url String url);
}
