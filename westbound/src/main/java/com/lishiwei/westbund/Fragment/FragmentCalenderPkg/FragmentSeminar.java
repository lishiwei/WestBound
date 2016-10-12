package com.lishiwei.westbund.Fragment.FragmentCalenderPkg;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshRecyclerView;
import com.lishiwei.model.Seminar;
import com.lishiwei.westbund.Adapter.SeminarRecyclerAdapter;
import com.lishiwei.westbund.Fragment.BaseMvpLceFragment;
import com.lishiwei.westbund.Presenter.ISeminarPresenter;
import com.lishiwei.westbund.Presenter.SeminarPresenter;
import com.lishiwei.westbund.R;
import com.lishiwei.westbund.ViewInterface.SeminarView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentSeminar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentSeminar extends BaseMvpLceFragment<SwipeRefreshLayout, List<Seminar>, SeminarView, ISeminarPresenter> implements SeminarView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = FragmentSeminar.class.getSimpleName();

    @Bind(R.id.ptr_Seminar)
    PullToRefreshRecyclerView ptrSeminar;
    @Bind(R.id.contentView)
    SwipeRefreshLayout contentView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    SeminarRecyclerAdapter seminarRecyclerAdapter;
    List<Seminar> seminarList = new ArrayList<>();

    public FragmentSeminar() {
        // Required empty public constructor
    }

    @Override
    public ISeminarPresenter createPresenter() {
        return new SeminarPresenter();
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
     * @return A new instance of fragment FragmentSeminar.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentSeminar newInstance(String param1, String param2) {
        FragmentSeminar fragment = new FragmentSeminar();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_seminar, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public void initViews(Bundle savedInstanceState) {
        seminarRecyclerAdapter = new SeminarRecyclerAdapter();
        ptrSeminar.getRefreshableView().setLayoutManager(new LinearLayoutManager(getActivity()));
        ptrSeminar.getRefreshableView().setAdapter(seminarRecyclerAdapter);

        ptrSeminar.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        ptrSeminar.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<RecyclerView>() {
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
        contentView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                currentPageNumber = 1;
                isLoadMore = false;
                loadData(true);
            }
        });
    }


    @Override
    public void setData(List<Seminar> data) {
        if (isLoadMore) {
            seminarList.addAll(data);

        } else {
            seminarList = data;
        }
        seminarRecyclerAdapter.setSeminarList(seminarList);
        seminarRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void showContent() {
        super.showContent();
        contentView.setRefreshing(false);
        ptrSeminar.onRefreshComplete();
    }

    @Override
    public void showError(Throwable e, boolean pullToRefresh) {
        super.showError(e, pullToRefresh);
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        presenter.loadData(10,currentPageNumber, pullToRefresh);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
