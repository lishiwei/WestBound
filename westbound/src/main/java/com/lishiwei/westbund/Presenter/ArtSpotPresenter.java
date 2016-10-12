package com.lishiwei.westbund.Presenter;

import android.util.Log;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.lishiwei.core.ArtSpotRemoteDataSource;
import com.lishiwei.core.DataSource;
import com.lishiwei.core.ExhibitionRemoteDataSource;
import com.lishiwei.model.ArtSpot;
import com.lishiwei.model.Exhibition;
import com.lishiwei.westbund.ViewInterface.ArtSpotView;
import com.lishiwei.westbund.ViewInterface.CallenderView;

import java.util.List;

/**
 * Created by lishiwei on 16/5/18.
 */
public class ArtSpotPresenter extends MvpBasePresenter<ArtSpotView> implements IArtSpotPresenter {
    private static final String TAG = ArtSpotPresenter.class.getSimpleName();
    ArtSpotRemoteDataSource artSpotRemoteDataSource;

    @Override
    public void attachView(ArtSpotView view) {
        super.attachView(view);


    }

    @Override
    public void loadArtSpot(int pageSize, int pageNo,boolean pullToRefresh) {
        if (isViewAttached()) {
            getView().showLoading(pullToRefresh);
        }
        if (artSpotRemoteDataSource == null) {
            artSpotRemoteDataSource = new ArtSpotRemoteDataSource();
        }
        artSpotRemoteDataSource.getDatas(pageSize,pageNo,new DataSource.LoadDataCallBack<ArtSpot>() {
            @Override
            public void onSucceed(List<ArtSpot> list) {
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
