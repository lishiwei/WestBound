package com.lishiwei.core.Retrofit;


import android.support.annotation.NonNull;
import android.util.Log;

import com.lishiwei.core.DataSource;
import com.lishiwei.model.BaseResponseBody;
import com.lishiwei.model.News;
import com.squareup.okhttp.OkHttpClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
import retrofit.RxJavaCallAdapterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by lishiwei on 15/12/31.
 */
public class WestBoundRetrofit {
public static String BaseUrl = "http://115.159.76.141:8080/westbund/";
    private static final String TAG = WestBoundRetrofit.class.getSimpleName();
    static RetrofitService RetrofitService;

    public static RetrofitService getRetrofitService() {

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(30, TimeUnit.SECONDS);
        okHttpClient.setWriteTimeout(30, TimeUnit.SECONDS);
        okHttpClient.setConnectTimeout(30, TimeUnit.SECONDS);
        retrofit.Retrofit retrofit = new retrofit.Retrofit.Builder().client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BaseUrl)
                .build();
        RetrofitService = retrofit.create(RetrofitService.class);

        return RetrofitService;

    }
}