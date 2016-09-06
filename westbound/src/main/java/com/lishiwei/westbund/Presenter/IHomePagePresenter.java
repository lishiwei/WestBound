package com.lishiwei.westbund.Presenter;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.lishiwei.westbund.ViewInterface.HomePageView;

/**
 * Created by lishiwei on 16/5/17.
 */
public interface IHomePagePresenter extends MvpPresenter<HomePageView> {
    public void loadNews(int pageSize, int pageNo,final boolean pullToRefresh);
}
