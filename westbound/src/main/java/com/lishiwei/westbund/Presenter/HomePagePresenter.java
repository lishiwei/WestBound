package com.lishiwei.westbund.Presenter;

import android.util.Log;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.lishiwei.core.DataSource;
import com.lishiwei.core.NewsRemoteDataSource;
import com.lishiwei.model.News;
import com.lishiwei.westbund.Fragment.FragmentHomePage;
import com.lishiwei.westbund.ViewInterface.HomePageView;

import java.util.List;

/**
 * Created by lishiwei on 16/5/17.
 */
public class HomePagePresenter extends MvpBasePresenter<HomePageView> implements IHomePagePresenter {
    NewsRemoteDataSource newsRemoteDataSource;
    String from;

    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public void loadNews(int pageSize,int pageNo,boolean pullToRefresh) {
        if (isViewAttached()) {
            getView().showLoading(pullToRefresh);
        }

        if (newsRemoteDataSource == null) {
            newsRemoteDataSource = new NewsRemoteDataSource();
            if (from!=null)
            {
                newsRemoteDataSource.setFrom(FragmentHomePage.ARTSCENE);
            }

        }
        newsRemoteDataSource.getDatas(pageSize,pageNo,new DataSource.LoadDataCallBack<News>(){
            @Override
            public void onSucceed(List<News> newsList) {
                Log.d("aaaaa", "onSucceed: " + newsList.toString());
                if (isViewAttached()) {
                    getView().showContent();
                    getView().setData(newsList);
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
    public void attachView(HomePageView view) {
        super.attachView(view);

    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
    }
}
