package com.lishiwei.core;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;

import com.lishiwei.core.Retrofit.WestBoundRetrofit;
import com.lishiwei.model.BaseResponseBody;
import com.lishiwei.model.Gallery;
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
 * Created by lishiwei on 16/5/21.
 */
public class GalleryRemoteDataSource implements DataSource<Gallery> {
    private static final String TAG = GalleryRemoteDataSource.class.getSimpleName();

    @Override
    public void getDatas(int pageSize, int pageNo,final @NonNull LoadDataCallBack<Gallery> loadDataCallBack) {

        final List<Gallery> list = new ArrayList<>();
        Log.d(TAG, "getDatas: "+pageNo);
        WestBoundRetrofit.getRetrofitService().getGallery(JsonUtils.getPageInfo(pageSize,pageNo))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .map(new Func1<BaseResponseBody<Gallery>, List<Gallery>>() {
                    @Override
                    public List<Gallery> call(BaseResponseBody<Gallery> newsBaseResponseBody) {
                        Log.d(TAG, "call: "+newsBaseResponseBody.getPage().toString());
                        return newsBaseResponseBody.getDataList();
                    }
                }).subscribe(new Subscriber<List<Gallery>>() {
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
            public void onNext(List<Gallery> newsList) {
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
