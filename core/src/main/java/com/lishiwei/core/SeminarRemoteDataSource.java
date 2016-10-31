package com.lishiwei.core;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.lishiwei.core.Retrofit.WestBoundRetrofit;
import com.lishiwei.model.BaseResponseBody;
import com.lishiwei.model.Seminar;
import com.lishiwei.model.Seminar;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by lishiwei on 16/8/18.
 */
public class SeminarRemoteDataSource implements DataSource<Seminar> {
    private static final String TAG = SeminarRemoteDataSource.class.getSimpleName();
Context context;

    public SeminarRemoteDataSource(Context context) {
        this.context = context;
    }

    @Override
    public void getDatas(int pageSize, int pageNo,@NonNull final LoadDataCallBack<Seminar> loadDataCallBack) {
        final List<Seminar> seminarList = new ArrayList<>();
        final List<Seminar> list = new ArrayList<>();
        WestBoundRetrofit.getRetrofitService(context).getSeminar(JsonUtils.getPageInfoBody(pageSize,pageNo))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .map(new Func1<BaseResponseBody<Seminar>, List<Seminar>>() {
                    @Override
                    public List<Seminar> call(BaseResponseBody<Seminar> newsBaseResponseBody) {
                        Log.d(TAG, "call: "+newsBaseResponseBody.toString());
                        Log.d(TAG, "call: "+newsBaseResponseBody.getDataList());
                        return newsBaseResponseBody.getDataList();
                    }
                }).
                subscribe(new Subscriber<List<Seminar>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: "+e.toString());
                loadDataCallBack.onSucceed(list);
                //loadNewsCallBack.onError(e);

            }

            @Override
            public void onNext(List<Seminar> newsList) {
                Log.d(TAG, "onNext: "+newsList.toString());
                if (newsList.size() > 0) {
                    loadDataCallBack.onSucceed(newsList);

                } else {
loadDataCallBack.onError();                }
            }
        });

    }
}
