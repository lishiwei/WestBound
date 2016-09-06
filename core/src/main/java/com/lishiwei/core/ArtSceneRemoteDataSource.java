package com.lishiwei.core;

import android.support.annotation.NonNull;

import com.lishiwei.model.ArtScene;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by lishiwei on 16/8/24.
 */
public class ArtSceneRemoteDataSource implements DataSource<ArtScene> {


    @Override
    public void getDatas(int pageSize, int pageNo,final @NonNull LoadDataCallBack<ArtScene> loadDataCallBack) {
        final List<ArtScene> seminarList = new ArrayList<>();
        seminarList.add(new ArtScene("1", "9月9日", "星期二", "未开始"));
        seminarList.add(new ArtScene("2", "9月10日", "星期三", "未开始"));
        seminarList.add(new ArtScene("3", "9月11日", "星期四", "未开始"));
        seminarList.add(new ArtScene("4", "9月12日", "星期五", "未开始"));
        seminarList.add(new ArtScene("5", "9月13日", "星期六", "未开始"));
        Observable.just(seminarList)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .filter(new Func1<List<ArtScene>, Boolean>() {
                    @Override
                    public Boolean call(List<ArtScene> seminars) {
                        return seminars.size() > 0;
                    }
                })
                .delaySubscription(3000, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<List<ArtScene>>() {
                    @Override
                    public void call(List<ArtScene> seminars) {
                        loadDataCallBack.onSucceed(seminarList);
                    }
                });


        Observable.just(1).compose(new Observable.Transformer<Integer, Integer>() {
            @Override
            public Observable<Integer> call(Observable<Integer> integerObservable) {

                return  integerObservable.observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io());
            }
        });


    }
    <T> Observable.Transformer<T, T> applySchedulers() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }



}
