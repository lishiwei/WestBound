package com.lishiwei.westbund.Presenter;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.lishiwei.westbund.ViewInterface.GalleryView;

/**
 * Created by lishiwei on 16/5/22.
 */
public interface IGalleryPresenter extends MvpPresenter<GalleryView> {
    public void loadGallery(int pageSize, int pageNo,final boolean pullToRefresh);

}
