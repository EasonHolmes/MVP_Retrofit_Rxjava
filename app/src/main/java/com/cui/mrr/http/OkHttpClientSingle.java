package com.cui.mrr.http;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;

/**
 * Created by cuiyang on 15/12/22.
 */
public class OkHttpClientSingle {


    private static OkHttpClient.Builder okHttpBuilder;

    private OkHttpClientSingle() {
        okHttpBuilder = new OkHttpClient.Builder();
//        okHttpBuilder.retryOnConnectionFailure(true);//设置出现错误是否进行重新连接。
//        okHttpBuilder.readTimeout(30, TimeUnit.SECONDS);
//        okHttpBuilder.writeTimeout(30, TimeUnit.SECONDS);
        okHttpBuilder.connectTimeout(30, TimeUnit.SECONDS);
//        okHttpBuilder.interceptors().add(new Interceptor() {
//            @Override
//            public okhttp3.Response intercept(Chain chain) throws IOException {
//                Request request = chain.request();
//                /**
//                 *制作固定的键值对 每次请求都会在最后面加上
//                 */
//                Request.Builder requestBuilder = request.newBuilder();

//                FormBody.Builder formBodyBuilder = new FormBody.Builder();
        //制作固定键值对
//                formBodyBuilder.add("token", "your token");
//                formBodyBuilder.add("deviceType", "your type");
//                formBodyBuilder.add("....", "....");

//                RequestBody formBody = formBodyBuilder.build();

//                String postBodyString = bodyToString(request.body());

//                postBodyString += ((postBodyString.length() > 0) ? "&" : "") + bodyToString(formBody);

//                requestBuilder.post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=UTF-8"), postBodyString));//发送的编码格式

//                request = requestBuilder.build();

//                return chain.proceed(request);
//            }
//        });
        okHttpBuilder.interceptors().add(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
    }

    private static String bodyToString(final RequestBody request) {
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if (copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }

    public static OkHttpClient getInstance() {
        if (okHttpBuilder == null) {
            synchronized (OkHttpClient.class) {
                if (okHttpBuilder == null) {
                    new OkHttpClientSingle();
                }
            }
        }
        return okHttpBuilder.build();
    }
}
