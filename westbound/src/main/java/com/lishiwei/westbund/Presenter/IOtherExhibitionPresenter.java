package com.lishiwei.westbund.Presenter;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.lishiwei.westbund.ViewInterface.OtherExhibitionView;

/**
 * Created by lishiwei on 16/8/19.
 */
public interface IOtherExhibitionPresenter extends MvpPresenter<OtherExhibitionView> {
    public void loadData(int pageSize, int pageNo,final boolean pullToRefresh);}
