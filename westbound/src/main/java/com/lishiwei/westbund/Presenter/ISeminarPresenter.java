package com.lishiwei.westbund.Presenter;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.lishiwei.westbund.ViewInterface.SeminarView;

/**
 * Created by lishiwei on 16/8/18.
 */
public interface ISeminarPresenter extends MvpPresenter<SeminarView> {
    public void loadData(int pageSize, int pageNo,final boolean pullToRefresh);
}
