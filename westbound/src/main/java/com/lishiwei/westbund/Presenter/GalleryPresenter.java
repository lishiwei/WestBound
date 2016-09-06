package com.lishiwei.westbund.Presenter;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.lishiwei.core.DataSource;
import com.lishiwei.core.GalleryRemoteDataSource;
import com.lishiwei.model.Gallery;
import com.lishiwei.westbund.ViewInterface.GalleryView;

import java.util.List;

/**
 * Created by lishiwei on 16/5/22.
 */
public class GalleryPresenter extends MvpBasePresenter<GalleryView> implements IGalleryPresenter {
    GalleryRemoteDataSource galleryRemoteDataSource ;
    @Override
    public void loadGallery(int pageSize, int pageNo,final boolean pullToRefresh) {
        if (galleryRemoteDataSource==null)
        {
            galleryRemoteDataSource = new GalleryRemoteDataSource();
        }
        if (isViewAttached())
        {
            getView().showLoading(pullToRefresh);
        }
        galleryRemoteDataSource.getDatas(pageSize,pageNo,new DataSource.LoadDataCallBack<Gallery>() {
            @Override
            public void onSucceed(List<Gallery> list) {
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
    public void attachView(GalleryView view) {
        super.attachView(view);
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
    }
}
