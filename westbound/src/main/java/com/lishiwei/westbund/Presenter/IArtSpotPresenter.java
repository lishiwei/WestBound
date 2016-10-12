package com.lishiwei.westbund.Presenter;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.lishiwei.westbund.ViewInterface.ArtSpotView;
import com.lishiwei.westbund.ViewInterface.CallenderView;

/**
 * Created by lishiwei on 16/5/18.
 */
public interface IArtSpotPresenter extends MvpPresenter<ArtSpotView> {
    public void loadArtSpot(int pageSize, int pageNo, final boolean pullToRefresh);
}
