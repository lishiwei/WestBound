package com.lishiwei.westbund.Fragment;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lishiwei.westbund.Adapter.ViewPagerAdapter;
import com.lishiwei.westbund.Fragment.FragmentCalenderPkg.FragmentActivity;
import com.lishiwei.westbund.Fragment.FragmentCalenderPkg.FragmentOtherExhibition;
import com.lishiwei.westbund.Fragment.FragmentCalenderPkg.FragmentSeminar;
import com.lishiwei.westbund.R;
import com.lishiwei.westbund.databinding.FragmentCalenderBinding;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FragmentCalender extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @Bind(R.id.vp_Calender)
  public   ViewPager vpCalender;
    public ViewPagerAdapter viewPagerAdapter;
    List<String> stringList = new ArrayList<>();
    List<Fragment> fragmentList = new ArrayList<>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public FragmentCalender() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentCalender.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentCalender newInstance(String param1, String param2) {
        FragmentCalender fragment = new FragmentCalender();
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



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        fragmentList.add(FragmentSeminar.newInstance("", ""));
        fragmentList.add(FragmentActivity.newInstance("", ""));
        fragmentList.add(FragmentOtherExhibition.newInstance("", ""));
        stringList.add(getContext().getString(R.string.senimar));
        stringList.add(getContext().getString(R.string.daily_activity));
        stringList.add(getContext().getString(R.string.exhibition_same_period));

        FragmentCalenderBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_calender, container, false);
        binding.setContainer(this);

        ButterKnife.bind(this, binding.getRoot());
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), fragmentList, getActivity(), stringList);
        vpCalender.setAdapter(viewPagerAdapter);
        vpCalender.setOffscreenPageLimit(3);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
