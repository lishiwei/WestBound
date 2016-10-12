package com.lishiwei.westbund.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshRecyclerView;
import com.lishiwei.model.News;
import com.lishiwei.westbund.Adapter.ArtSceneRecyclerAdapter;
import com.lishiwei.westbund.Adapter.NewsRecyclerAdapter;
import com.lishiwei.westbund.Presenter.HomePagePresenter;
import com.lishiwei.westbund.Presenter.IHomePagePresenter;
import com.lishiwei.westbund.R;
import com.lishiwei.westbund.Utils.DensityUtil;
import com.lishiwei.westbund.Utils.SpaceItemDecoration;
import com.lishiwei.westbund.ViewInterface.HomePageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentHomePage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentHomePage extends BaseMvpLceFragment<SwipeRefreshLayout, List<News>, HomePageView, IHomePagePresenter> implements HomePageView, PullToRefreshBase.OnRefreshListener2 {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = FragmentHomePage.class.getSimpleName();
    @Bind(R.id.Ptr_News)
    PullToRefreshRecyclerView ptr_news;
    NewsRecyclerAdapter newsRecyclerAdapter;
    ArtSceneRecyclerAdapter artSceneRecyclerAdapter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    List<News> newsList = new ArrayList<>();
public static String NEWS="news";
public static String ARTSCENE="artscene";

    public FragmentHomePage() {
        // Required empty public constructor
    }

    @Override
    public IHomePagePresenter createPresenter() {
        HomePagePresenter homePagePresenter = new HomePagePresenter();
        if (getArguments().get(ARG_PARAM1).equals(ARTSCENE)) {
            homePagePresenter.setFrom(ARTSCENE);
        }

        return homePagePresenter;
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return null;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentHomePage.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentHomePage newInstance(String param1, String param2) {
        FragmentHomePage fragment = new FragmentHomePage();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    public void initViews(Bundle savedInstanceState) {
        contentView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isLoadMore = false;
                currentPageNumber = 1;
                loadData(true);
            }
        });
        contentView.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        ptr_news.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        ptr_news.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<RecyclerView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<RecyclerView> refreshView) {

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
currentPageNumber++;
                isLoadMore = true;
                loadData(true);
            }
        });

        ptr_news.getRefreshableView().setLayoutManager(new LinearLayoutManager(getActivity()));
        ptr_news.getRefreshableView().clearFocus();
        ptr_news.getRefreshableView().addItemDecoration(new SpaceItemDecoration(DensityUtil.dip2px(16)));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void setData(List<News> list) {
        if (isLoadMore) {
            newsList.addAll(list);
        } else {
            newsList = list;
        }
        if (getArguments().get(ARG_PARAM1).equals(NEWS)) {
            if (newsRecyclerAdapter==null)
            {
                newsRecyclerAdapter = new NewsRecyclerAdapter(getActivity(),newsList);
                ptr_news.getRefreshableView().setAdapter(newsRecyclerAdapter);
            }
            newsRecyclerAdapter.notifyDataSetChanged();
        } else if (getArguments().get(ARG_PARAM1).equals(ARTSCENE)) {
            if (artSceneRecyclerAdapter==null)
            {
                artSceneRecyclerAdapter = new ArtSceneRecyclerAdapter(getActivity(),newsList);
                ptr_news.getRefreshableView().setAdapter(artSceneRecyclerAdapter);
            }

            artSceneRecyclerAdapter.notifyDataSetChanged();
        }

        Log.d(TAG, "setData:+ notifyDataSetChanged");
    }

    @Override
    public void showContent() {
        super.showContent();
        contentView.setRefreshing(false);
        ptr_news.onRefreshComplete();
    }

    @Override
    public void showError(Throwable e, boolean pullToRefresh) {
        super.showError(e, pullToRefresh);
        contentView.setRefreshing(false);
        ptr_news.onRefreshComplete();
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        presenter.loadNews(10,currentPageNumber,pullToRefresh);
    }


    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        Log.d(TAG, "onPullDownToRefresh: ");
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
