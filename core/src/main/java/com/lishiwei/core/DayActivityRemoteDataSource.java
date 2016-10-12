package com.lishiwei.core;

import android.support.annotation.NonNull;
import android.util.Log;

import com.lishiwei.core.Retrofit.WestBoundRetrofit;
import com.lishiwei.model.BaseResponseBody;
import com.lishiwei.model.DayActivity;
import com.lishiwei.model.Exhibition;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by shiwei on 2016/9/17.
 */
public class DayActivityRemoteDataSource implements DataSource<DayActivity> {
    private static final String TAG = DayActivityRemoteDataSource.class.getSimpleName();

    @Override
    public void getDatas(int pageSize, int pageNo,final  @NonNull LoadDataCallBack<DayActivity> loadDataCallBack) {
        final List<DayActivity> list = new ArrayList<>();
        WestBoundRetrofit.getRetrofitService().getActivities(JsonUtils.getPageInfo(pageSize,pageNo))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .map(new Func1<BaseResponseBody<DayActivity>, List<DayActivity>>() {
                    @Override
                    public List<DayActivity> call(BaseResponseBody<DayActivity> newsBaseResponseBody) {
                        Log.d(TAG, "call: "+newsBaseResponseBody.getPage().toString());
                        Log.d(TAG, "call: "+newsBaseResponseBody.getDataList());
                        return newsBaseResponseBody.getDataList();
                    }
                }).subscribe(new Subscriber<List<DayActivity>>() {
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
            public void onNext(List<DayActivity> newsList) {
                Log.d(TAG, "onNext: "+newsList.toString());
                if (newsList.size() > 0) {
                    loadDataCallBack.onSucceed(newsList);

                } else {
                    //loadNewsCallBack.onError(null);
                }
            }
        });
    }
}
