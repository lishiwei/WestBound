package com.lishiwei.core;

import android.support.annotation.NonNull;
import android.util.Log;

import com.lishiwei.core.Retrofit.WestBoundRetrofit;
import com.lishiwei.model.ArtSpot;
import com.lishiwei.model.BaseResponseBody;
import com.lishiwei.model.ArtSpot;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by shiwei on 2016/9/11.
 */
public class ArtSpotRemoteDataSource implements DataSource<ArtSpot> {
    private static final String TAG = ArtSpotRemoteDataSource.class.getSimpleName();

    @Override
    public void getDatas(int pageSize, int pageNo, @NonNull final LoadDataCallBack<ArtSpot> loadDataCallBack) {
        final List<ArtSpot> list = new ArrayList<>();
        WestBoundRetrofit.getRetrofitService().getArtSpot(JsonUtils.getPageInfo(pageSize,pageNo))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .map(new Func1<BaseResponseBody<ArtSpot>, List<ArtSpot>>() {
                    @Override
                    public List<ArtSpot> call(BaseResponseBody<ArtSpot> newsBaseResponseBody) {
                        Log.d(TAG, "call: "+newsBaseResponseBody.toString());
                        Log.d(TAG, "call: "+newsBaseResponseBody.getDataList());
                        return newsBaseResponseBody.getDataList();
                    }
                }).subscribe(new Subscriber<List<ArtSpot>>() {
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
            public void onNext(List<ArtSpot> newsList) {
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
