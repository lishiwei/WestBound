package com.lishiwei.westbund.Presenter;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.lishiwei.core.DataSource;
import com.lishiwei.core.DayActivityRemoteDataSource;
import com.lishiwei.model.DayActivity;
import com.lishiwei.westbund.ViewInterface.DayActivityView;

import java.util.List;

/**
 * Created by shiwei on 2016/9/17.
 */
public class DayActivityPresenter extends MvpBasePresenter<DayActivityView> implements IDayActivityPresenter {
    DayActivityRemoteDataSource dayActivityRemoteDataSource;

    @Override
    public void loadDayActivity(int pageSize, int pageNo, boolean pullToRefresh) {
        if (dayActivityRemoteDataSource == null) {
            dayActivityRemoteDataSource = new DayActivityRemoteDataSource();
        }
        if (isViewAttached()) {
            getView().showLoading(pullToRefresh);
        }
        dayActivityRemoteDataSource.getDatas(pageSize, pageNo, new DataSource.LoadDataCallBack<DayActivity>() {
            @Override
            public void onSucceed(List<DayActivity> list) {
                if (isViewAttached()) {
                    getView().showContent();
                    getView().setData(list);
                }
            }

            @Override
            public void onError() {
                if (isViewAttached()) {
                    getView().showError(null, false);
                }
            }
        });
    }
}
