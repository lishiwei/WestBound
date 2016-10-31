package com.lishiwei.westbund.Presenter;

import android.content.Context;
import android.util.Log;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.lishiwei.core.DataSource;
import com.lishiwei.core.ExhibitionRemoteDataSource;
import com.lishiwei.model.Exhibition;
import com.lishiwei.westbund.ViewInterface.CallenderView;

import java.util.List;

/**
 * Created by lishiwei on 16/5/18.
 */
public class CallenderPresenter extends MvpBasePresenter<CallenderView> implements ICallendarPresenter {
    private static final String TAG = CallenderPresenter.class.getSimpleName();
    ExhibitionRemoteDataSource exhibitionRemoteDataSource;
Context context;
    @Override
    public void attachView(CallenderView view) {
        super.attachView(view);


    }

    public CallenderPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void loadExihibition(int pageSize, int pageNo,boolean pullToRefresh) {
        if (isViewAttached()) {
            getView().showLoading(pullToRefresh);
        }
        if (exhibitionRemoteDataSource == null) {
            exhibitionRemoteDataSource = new ExhibitionRemoteDataSource(context);
        }
        exhibitionRemoteDataSource.getDatas(pageSize,pageNo,new DataSource.LoadDataCallBack<Exhibition>() {
            @Override
            public void onSucceed(List<Exhibition> list) {
                Log.d(TAG, "onSucceed: " + list.toString());
                getView().showContent();
                getView().setData(list);
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
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
    }
}
