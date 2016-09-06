package com.lishiwei.core;

import android.support.annotation.NonNull;

import com.lishiwei.model.Seminar;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by lishiwei on 16/8/18.
 */
public class SeminarRemoteDataSource implements DataSource<Seminar> {
    @Override
    public void getDatas(int pageSize, int pageNo,@NonNull final LoadDataCallBack<Seminar> loadDataCallBack) {
        final List<Seminar> seminarList = new ArrayList<>();
        seminarList.add(new Seminar("1", "9月9日", "星期二", "未开始", "http://cn.aikedellarco.com/images/exhi/201501/103_EG_1422395724710.jpg", "一位藏家的策展时间以及他的录像艺术收藏指南", "嘉宾: 增文泉(策划人,收藏夹)", "1：30pm - 3:00pm"));
        seminarList.add(new Seminar("2", "9月10日", "星期三", "未开始", "http://cn.aikedellarco.com/images/exhi/201501/103_EG_1422395724710.jpg", "2015-2022", "多向度的线路图以及作为策展人的艺术家", "1：30pm - 3:00pm"));
        seminarList.add(new Seminar("3", "9月11日", "星期四", "未开始", "http://cn.aikedellarco.com/images/exhi/201501/103_EG_1422395724710.jpg", "抽象的艺术", "嘉宾: 曾根裕(艺术家)", "1：30pm - 3:00pm"));
        seminarList.add(new Seminar("4", "9月12日", "星期五", "未开始", "http://cn.aikedellarco.com/images/exhi/201501/103_EG_1422395724710.jpg", "当代艺术的影响", "嘉宾: 曾根裕(艺术家)", "1：30pm - 3:00pm"));
        seminarList.add(new Seminar("5", "9月13日", "星期六", "未开始", "http://cn.aikedellarco.com/images/exhi/201501/103_EG_1422395724710.jpg", "收藏当代艺术的影响", "嘉宾: 曾根裕(艺术家)", "1：30pm - 3:00pm"));
        Observable.just(seminarList)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .filter(new Func1<List<Seminar>, Boolean>() {
                    @Override
                    public Boolean call(List<Seminar> seminars) {
                        return seminars.size() > 0;
                    }
                })
                .delaySubscription(3000, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<List<Seminar>>() {
            @Override
            public void call(List<Seminar> seminars) {
                loadDataCallBack.onSucceed(seminarList);
            }
        });


    }
}
