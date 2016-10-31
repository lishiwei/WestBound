package com.lishiwei.core;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;

import com.lishiwei.core.Retrofit.WestBoundRetrofit;
import com.lishiwei.model.BaseResponseBody;
import com.lishiwei.model.News;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by lishiwei on 16/5/17.
 */
public class NewsRemoteDataSource implements DataSource<News> {

    private static final String TAG = NewsRemoteDataSource.class.getSimpleName();
    Context context;

    public NewsRemoteDataSource(Context context) {
        this.context = context;
    }

    @Override
    public void getDatas(int pageSize,int pageNo,final @NonNull DataSource.LoadDataCallBack<News> loadNewsCallBack) {
        final List<News> list = new ArrayList<>();
        WestBoundRetrofit.getRetrofitService(context).getNews(JsonUtils.getPageInfoBody(pageSize,pageNo))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .map(new Func1<BaseResponseBody<News>, List<News>>() {
                    @Override
                    public List<News> call(BaseResponseBody<News> newsBaseResponseBody) {
                        Log.d(TAG, "call: "+newsBaseResponseBody.getPage().toString());
                        Log.d(TAG, "call: "+newsBaseResponseBody.getDataList());
                        return newsBaseResponseBody.getDataList();
                    }
                }).subscribe(new Subscriber<List<News>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: "+e.toString());
                loadNewsCallBack.onSucceed(list);
                //loadNewsCallBack.onError(e);

            }

            @Override
            public void onNext(List<News> newsList) {
                Log.d(TAG, "onNext: "+newsList.toString());
                if (newsList.size() > 0) {
                    loadNewsCallBack.onSucceed(newsList);

                } else {
loadNewsCallBack.onError();                }
            }
        });

    }


}

