package com.lishiwei.westbund.Presenter;

import android.content.Context;
import android.util.Log;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.lishiwei.core.DataSource;
import com.lishiwei.core.SeminarRemoteDataSource;
import com.lishiwei.model.Seminar;
import com.lishiwei.westbund.ViewInterface.SeminarView;

import java.util.List;

/**
 * Created by lishiwei on 16/8/18.
 */
public class SeminarPresenter extends MvpBasePresenter<SeminarView> implements ISeminarPresenter {
    private static final String TAG = SeminarPresenter.class.getSimpleName();
    SeminarRemoteDataSource seminarRemoteDataSource;
Context context;

    public SeminarPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void loadData(int pageSize, int pageNo,boolean pullToRefresh) {
        if (isViewAttached()) {
            getView().showLoading(pullToRefresh);
        }
        if (seminarRemoteDataSource == null) {
            seminarRemoteDataSource = new SeminarRemoteDataSource(context);
        }
        seminarRemoteDataSource.getDatas(pageSize,pageNo,new DataSource.LoadDataCallBack<Seminar>() {
            @Override
            public void onSucceed(List<Seminar> list) {
                Log.d(TAG, "onSucceed: "+list.toString());
                if (isViewAttached()) {
                    Log.d(TAG, "isViewAttached: ");
                    getView().showContent();
                    Log.d(TAG, "showContent: ");
                    getView().setData(list);
                    Log.d(TAG, "setDataaaaaaaaa: ");

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

    @Override
    public void attachView(SeminarView view) {
super.attachView(view);
    }

    @Override
    public void detachView(boolean retainInstance) {
super.detachView(retainInstance);
    }
}
