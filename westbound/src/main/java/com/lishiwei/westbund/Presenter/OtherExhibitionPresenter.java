package com.lishiwei.westbund.Presenter;

import android.content.Context;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.lishiwei.core.DataSource;
import com.lishiwei.core.OtherExhibitionRemoteDataSource;
import com.lishiwei.model.Exhibition;
import com.lishiwei.westbund.ViewInterface.OtherExhibitionView;

import java.util.List;

/**
 * Created by lishiwei on 16/8/19.
 */
public class OtherExhibitionPresenter extends MvpBasePresenter<OtherExhibitionView>implements IOtherExhibitionPresenter {
    OtherExhibitionRemoteDataSource exhibitionRemoteDataSource ;
    Context context;

    public OtherExhibitionPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void loadData(int pageSize, int pageNo,final boolean pullToRefresh) {
        if (exhibitionRemoteDataSource==null)
        {
            exhibitionRemoteDataSource = new OtherExhibitionRemoteDataSource(context);
        }
        if (isViewAttached())
        {
            getView().showLoading(pullToRefresh);
        }
        exhibitionRemoteDataSource.getDatas(pageSize,pageNo,new DataSource.LoadDataCallBack<Exhibition>() {
            @Override
            public void onSucceed(List<Exhibition> list) {
                if (isViewAttached())
                {
                    getView().showContent();
                    getView().setData(list);
                }
            }

            @Override
            public void onError() {
                getView().showError(null,pullToRefresh);
            }
        });

    }

    @Override
    public void attachView(OtherExhibitionView view) {
        super.attachView(view);
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
    }

}
