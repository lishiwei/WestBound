package com.lishiwei.westbund.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.lishiwei.westbund.Activity.ActivityAbout;
import com.lishiwei.westbund.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentAbout#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentAbout extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    @Bind(R.id.ln_About_MyCollections)
    LinearLayout lnAboutMyCollections;
    @Bind(R.id.ln_About_PictureBooks)
    LinearLayout lnAboutPictureBooks;
    @Bind(R.id.ln_About_About)
    LinearLayout lnAboutAbout;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public FragmentAbout() {
        // Required empty public constructor
    }


    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return null;
    }


    public MvpPresenter createPresenter() {
        return null;
    }

    public void setData(Object data) {

    }

    public void loadData(boolean pullToRefresh) {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentAbout.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentAbout newInstance(String param1, String param2) {
        FragmentAbout fragment = new FragmentAbout();
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
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.ln_About_MyCollections, R.id.ln_About_PictureBooks, R.id.ln_About_About})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ln_About_MyCollections:
                break;
            case R.id.ln_About_PictureBooks:
                break;
            case R.id.ln_About_About:
                startActivity(new Intent(getActivity(), ActivityAbout.class));
                break;
        }
    }
}
