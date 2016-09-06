package com.lishiwei.westbund.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lishiwei.westbund.Adapter.ViewPagerAdapter;
import com.lishiwei.westbund.Fragment.FragmentGalleryPkg.FragmentGallery;
import com.lishiwei.westbund.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentGalleries#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentGalleries extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @Bind(R.id.tab_Gallery)
    TabLayout tabGallery;
    @Bind(R.id.vp_Gallery)
    ViewPager vpGallery;
    List<String> titleString = new ArrayList<>();
    List<Fragment> fragmentList = new ArrayList<>();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public FragmentGalleries() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentGalleries.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentGalleries newInstance(String param1, String param2) {
        FragmentGalleries fragment = new FragmentGalleries();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onPause() {
        super.onPause();

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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fragmentList.add(FragmentGallery.newInstance("1", ""));
        fragmentList.add(FragmentHomePage.newInstance("1", ""));
        titleString.add("画廊");
        titleString.add("艺术现场");
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), fragmentList, getActivity(), titleString);
        tabGallery.setTabGravity(TabLayout.GRAVITY_FILL);
        tabGallery.setTabMode(TabLayout.MODE_FIXED);
        vpGallery.setAdapter(viewPagerAdapter);
        vpGallery.setOffscreenPageLimit(3);
        tabGallery.setupWithViewPager(vpGallery);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_galleries, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
