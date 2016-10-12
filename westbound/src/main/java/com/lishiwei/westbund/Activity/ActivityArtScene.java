package com.lishiwei.westbund.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshRecyclerView;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceActivity;
import com.lishiwei.model.News;
import com.lishiwei.westbund.Adapter.NewsRecyclerAdapter;
import com.lishiwei.westbund.Presenter.HomePagePresenter;
import com.lishiwei.westbund.Presenter.IHomePagePresenter;
import com.lishiwei.westbund.R;
import com.lishiwei.westbund.ViewInterface.HomePageView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ActivityArtScene extends MvpLceActivity<SwipeRefreshLayout, List<News>, HomePageView, IHomePagePresenter> implements HomePageView{

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.ptr_ArtScene)
    PullToRefreshRecyclerView ptrArtScene;
    NewsRecyclerAdapter newsRecyclerAdapter;
    @Bind(R.id.contentView)
    SwipeRefreshLayout contentView;
    int pageSize = 1;
    int pageNo = 6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_art_scene);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ptrArtScene.getRefreshableView().setLayoutManager(new LinearLayoutManager(getBaseContext()));

        contentView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pageSize=1;
                loadData(true);
            }
        });
        ptrArtScene.getRefreshableView().setAdapter(newsRecyclerAdapter);
        ptrArtScene.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        ptrArtScene.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<RecyclerView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<RecyclerView> refreshView) {

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                pageSize++;
presenter.loadNews(pageSize,pageNo,false);            }
        });
        loadData(false);
    }

    @NonNull
    @Override
    public IHomePagePresenter createPresenter() {
        return new HomePagePresenter();
    }

    @Override
    public void showLoading(boolean pullToRefresh) {
        super.showLoading(pullToRefresh);

    }

    @Override
    public void showContent() {
        super.showContent();
        ptrArtScene.onRefreshComplete();
        contentView.setRefreshing(false);
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return null;
    }

    @Override
    public void setData(List<News> data) {
        if (newsRecyclerAdapter==null)
        {
            newsRecyclerAdapter = new NewsRecyclerAdapter(getBaseContext(),data);
        }

        newsRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        presenter.loadNews(1,10,pullToRefresh);
    }
}
