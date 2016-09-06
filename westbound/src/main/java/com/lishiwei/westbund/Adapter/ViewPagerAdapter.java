package com.lishiwei.westbund.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by lishiwei on 16/5/19.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList;
    Context context;
    List<String> stringList;

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragmentList, Context context, List<String> stringList) {
        super(fm);
        this.fragmentList = fragmentList;
        this.context = context;
        this.stringList = stringList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return stringList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
