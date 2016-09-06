package com.lishiwei.core.Retrofit;


import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by lishiwei on 15/12/31.
 */
public class WestBoundRetrofit {

    static RetrofitService RetrofitService;

    public static RetrofitService getRetrofitService() {

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(30, TimeUnit.SECONDS);
        okHttpClient.setWriteTimeout(30, TimeUnit.SECONDS);
        okHttpClient.setConnectTimeout(30, TimeUnit.SECONDS);

        retrofit.Retrofit retrofit = new retrofit.Retrofit.Builder().client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl("http://115.159.76.141:8080/westbund/")
                .build();
        RetrofitService = retrofit.create(RetrofitService.class);
        return RetrofitService;
    }
}