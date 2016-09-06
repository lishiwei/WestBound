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
import com.lishiwei.westbund.Fragment.FragmentMapPkg.FragmentMapFloor;
import com.lishiwei.westbund.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentMap#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentMap extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @Bind(R.id.tab_Map)
    TabLayout tabMap;
    @Bind(R.id.vp_Map)
    ViewPager vpMap;
    List<Fragment> fragmentList = new ArrayList<>();
    List<String> titleString= new ArrayList<>();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public FragmentMap() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentMap.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentMap newInstance(String param1, String param2) {
        FragmentMap fragment = new FragmentMap();
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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fragmentList.add(FragmentMapFloor.newInstance("1", ""));
        fragmentList.add(FragmentMapFloor.newInstance("2", ""));
        fragmentList.add(FragmentMapFloor.newInstance("3", ""));
        fragmentList.add(FragmentMapFloor.newInstance("4", ""));
        titleString.add("主场馆");
        titleString.add("新馆");
        titleString.add("示范区");
        titleString.add("西岸地区");
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), fragmentList, getActivity(), titleString);
        tabMap.setTabGravity(TabLayout.GRAVITY_FILL);
        tabMap.setTabMode(TabLayout.MODE_FIXED);
        vpMap.setAdapter(viewPagerAdapter);
        vpMap.setOffscreenPageLimit(3);
        tabMap.setupWithViewPager(vpMap);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
