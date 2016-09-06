package com.lishiwei.westbund.Fragment.FragmentCalenderPkg;


import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.lishiwei.model.Exhibition;
import com.lishiwei.westbund.Adapter.ExhibitionRecyclerAdapter;
import com.lishiwei.westbund.Fragment.BaseMvpLceFragment;
import com.lishiwei.westbund.Presenter.CallenderPresenter;
import com.lishiwei.westbund.R;
import com.lishiwei.westbund.Utils.DensityUtil;
import com.lishiwei.westbund.Utils.SpaceItemDecoration;
import com.lishiwei.westbund.ViewInterface.CallenderView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentActivity#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentActivity extends BaseMvpLceFragment<SwipeRefreshLayout, List<Exhibition>, CallenderView, CallenderPresenter> implements CallenderView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = FragmentActivity.class.getSimpleName();
    @Bind(R.id.ptr_Exhibition)
    PullToRefreshRecyclerView ptrExhibition;
    ExhibitionRecyclerAdapter exhibitionRecyclerAdapter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public FragmentActivity() {
        // Required empty public constructor
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
     * @return A new instance of fragment .
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentActivity newInstance(String param1, String param2) {
        FragmentActivity fragment = new FragmentActivity();
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
        ptrExhibition.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        ptrExhibition.getRefreshableView().setLayoutManager(new LinearLayoutManager(getActivity()));
        contentView.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        contentView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData(true);
            }
        });

        ptrExhibition.getRefreshableView().addItemDecoration(new SpaceItemDecoration(DensityUtil.dip2px(30)));
        ptrExhibition.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<RecyclerView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<RecyclerView> refreshView) {

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                loadData(true);
            }
        });
    }

    @NonNull
    @Override
    public CallenderPresenter createPresenter() {
        return new CallenderPresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void showContent() {
        super.showContent();
        contentView.setRefreshing(false);
        ptrExhibition.onRefreshComplete();
    }


    @Override
    public void showError(Throwable e, boolean pullToRefresh) {
        super.showError(e, pullToRefresh);
        contentView.setRefreshing(false);
        ptrExhibition.onRefreshComplete();
    }


    @Override
    public void setData(List<Exhibition> data) {
        Log.d(TAG, "setData: ");
        if (exhibitionRecyclerAdapter == null) {
            exhibitionRecyclerAdapter = new ExhibitionRecyclerAdapter(getActivity());
            ptrExhibition.getRefreshableView().setAdapter(exhibitionRecyclerAdapter);
        }
        exhibitionRecyclerAdapter.setExhibitionList(data);
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        Log.d(TAG, "loadData: ");
        presenter.loadExihibition(1,10,pullToRefresh);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}