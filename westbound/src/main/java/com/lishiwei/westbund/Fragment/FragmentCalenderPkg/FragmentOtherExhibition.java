package com.lishiwei.westbund.Fragment.FragmentCalenderPkg;


import android.databinding.DataBindingUtil;
import android.databinding.ObservableBoolean;
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
import com.lishiwei.model.Exhibition;
import com.lishiwei.westbund.Adapter.OtherExhibitionRecyclerAdapter;
import com.lishiwei.westbund.Fragment.BaseMvpLceFragment;
import com.lishiwei.westbund.Presenter.IOtherExhibitionPresenter;
import com.lishiwei.westbund.Presenter.OtherExhibitionPresenter;
import com.lishiwei.westbund.R;
import com.lishiwei.westbund.Utils.DataBindingUtils;
import com.lishiwei.westbund.ViewInterface.OtherExhibitionView;
import com.lishiwei.westbund.WestBundApplication;
import com.lishiwei.westbund.databinding.FragmentOtherExhibitionBinding;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentOtherExhibition#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentOtherExhibition extends BaseMvpLceFragment<SwipeRefreshLayout, List<Exhibition>, OtherExhibitionView, IOtherExhibitionPresenter> implements OtherExhibitionView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = FragmentOtherExhibition.class.getSimpleName();
    public ObservableBoolean isRefreshing = new ObservableBoolean(false);
    @Bind(R.id.contentView)
    SwipeRefreshLayout contentView;
    public OtherExhibitionRecyclerAdapter otherExhibitionRecyclerAdapter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    List<Exhibition> exhibitionList = new ArrayList<>();
    public RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
    public SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            isLoadMore = false;
            currentPageNumber = 1;
            isRefreshing.set(true);
            loadData(true);
        }
    };
    public PullToRefreshBase.Mode mode = PullToRefreshBase.Mode.PULL_FROM_END;
    public PullToRefreshBase.OnRefreshListener2 onRefreshListener2 = new PullToRefreshBase.OnRefreshListener2() {
        @Override
        public void onPullDownToRefresh(PullToRefreshBase refreshView) {

        }

        @Override
        public void onPullUpToRefresh(PullToRefreshBase refreshView) {
            isRefreshing.set(true);
            currentPageNumber++;
            isLoadMore = true;
            loadData(true);
        }
    };

    public FragmentOtherExhibition() {
        // Required empty public constructor
    }

    @Override
    public IOtherExhibitionPresenter createPresenter() {
        return new OtherExhibitionPresenter(WestBundApplication.getInstance());
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
     * @return A new instance of fragment FragmentOtherExhibition.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentOtherExhibition newInstance(String param1, String param2) {
        FragmentOtherExhibition fragment = new FragmentOtherExhibition();
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


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        otherExhibitionRecyclerAdapter = new OtherExhibitionRecyclerAdapter();
        FragmentOtherExhibitionBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_other_exhibition, container, true);
        binding.setListener(this);
        binding.ptrOtherExhibition.getRefreshableView().setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.setDataBindingUtil(DataBindingUtils.newInstance());

        ButterKnife.bind(this, binding.getRoot());
        return binding.getRoot();
    }

    @Override
    public void showContent() {
        super.showContent();
        if (contentView.isRefreshing()) {
            contentView.setRefreshing(false);
        }
        isRefreshing.set(false);

    }

    @Override
    public void showLoading(boolean pullToRefresh) {
        super.showLoading(pullToRefresh);

    }

    @Override
    public void setData(List<Exhibition> data) {
        if (isLoadMore) {
            exhibitionList.addAll(data);
        } else {
            exhibitionList = data;
        }
        otherExhibitionRecyclerAdapter.setExhibitionList(exhibitionList);
        otherExhibitionRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(Throwable e, boolean pullToRefresh) {
        contentView.setRefreshing(false);
        isRefreshing.set(false);
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
