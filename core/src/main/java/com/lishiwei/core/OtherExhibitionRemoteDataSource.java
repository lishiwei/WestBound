package com.lishiwei.core;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;

import com.lishiwei.core.Retrofit.WestBoundRetrofit;
import com.lishiwei.model.BaseResponseBody;
import com.lishiwei.model.Exhibition;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by lishiwei on 16/5/18.
 */
public class OtherExhibitionRemoteDataSource implements DataSource<Exhibition> {
    private static final String TAG = OtherExhibitionRemoteDataSource.class.getSimpleName();

    @Override
    public void getDatas(int pageSize, int pageNo,@NonNull final LoadDataCallBack<Exhibition> loadDataCallBack) {
        final List<Exhibition> list = new ArrayList<>();
        WestBoundRetrofit.getRetrofitService().getExhibition(JsonUtils.getPageInfo(pageSize,pageNo))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .map(new Func1<BaseResponseBody<Exhibition>, List<Exhibition>>() {
                    @Override
                    public List<Exhibition> call(BaseResponseBody<Exhibition> newsBaseResponseBody) {
                        Log.d(TAG, "call: "+newsBaseResponseBody.toString());
                        Log.d(TAG, "call: "+newsBaseResponseBody.getDataList());
                        return newsBaseResponseBody.getDataList();
                    }
                }).subscribe(new Subscriber<List<Exhibition>>() {
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
            public void onNext(List<Exhibition> newsList) {
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
