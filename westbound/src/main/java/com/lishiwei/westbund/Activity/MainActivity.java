package com.lishiwei.westbund.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.lishiwei.westbund.CustomViews.FragmentIndicator;
import com.lishiwei.westbund.Fragment.FragmentAbout;
import com.lishiwei.westbund.Fragment.FragmentCalender;
import com.lishiwei.westbund.Fragment.FragmentGalleries;
import com.lishiwei.westbund.Fragment.FragmentHomePage;
import com.lishiwei.westbund.Fragment.FragmentMap;
import com.lishiwei.westbund.R;

import butterknife.Bind;

public class MainActivity extends BaseActivity {
    @Bind(R.id.FragmentIndicator)
    FragmentIndicator fragmentIndicator;
    FragmentHomePage fragmentHomePage;
    FragmentCalender fragmentCalender;
    FragmentGalleries fragmentGalleries;
    FragmentMap fragmentMap;
    FragmentAbout fragmentAbout;
    FragmentIndicatorClicklistener fragmentIndicatorClicklistener;
    private static String ABOUT = "ABOUT";
    private static String CALENDAR = "CALENDAR";
    private static String GALLERIES = "GALLERIES";
    private static String MAP = "MAP";
    private static String HOMEPAGE = "HOMEPAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.findFragmentByTag(HOMEPAGE) == null) {
            fragmentHomePage = FragmentHomePage.newInstance("", "");
            fragmentTransaction.add(R.id.fragmentContainer, fragmentHomePage, HOMEPAGE);
        } else {
            fragmentHomePage = (FragmentHomePage) fragmentManager.findFragmentByTag(HOMEPAGE);
        }
        if (fragmentManager.findFragmentByTag(CALENDAR) == null) {
            fragmentCalender = FragmentCalender.newInstance("", "");
            fragmentTransaction.add(R.id.fragmentContainer, fragmentCalender, CALENDAR).hide(fragmentCalender);
        } else {
            fragmentCalender = (FragmentCalender) fragmentManager.findFragmentByTag(CALENDAR);
        }
        if (fragmentManager.findFragmentByTag(GALLERIES) == null) {
            fragmentGalleries = FragmentGalleries.newInstance("", "");
            fragmentTransaction.add(R.id.fragmentContainer, fragmentGalleries, GALLERIES).hide(fragmentGalleries);
        } else {
            fragmentGalleries = (FragmentGalleries) fragmentManager.findFragmentByTag(GALLERIES);
        }
        if (fragmentManager.findFragmentByTag(MAP) == null) {
            fragmentMap = FragmentMap.newInstance("", "");
            fragmentTransaction.add(R.id.fragmentContainer, fragmentMap, MAP).hide(fragmentMap);
        } else {
            fragmentMap = (FragmentMap) fragmentManager.findFragmentByTag(MAP);
        }
        if (fragmentManager.findFragmentByTag(ABOUT) == null) {
            fragmentAbout = FragmentAbout.newInstance("", "");
            fragmentTransaction.add(R.id.fragmentContainer, fragmentAbout, ABOUT).hide(fragmentAbout);
        } else {
            fragmentAbout = (FragmentAbout) fragmentManager.findFragmentByTag(ABOUT);
        }
        if (fragmentIndicator != null && fragmentIndicatorClicklistener != null) {
            fragmentIndicator.setOnIndicateListener(fragmentIndicatorClicklistener);
        }
        if (fragmentTransaction != null) {
            fragmentTransaction.commitAllowingStateLoss();
        }
    }

    private class FragmentIndicatorClicklistener implements FragmentIndicator.OnIndicateListener {

        @Override
        public void onIndicate(View v, int which) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            switch (which) {
                case 0:
                    fragmentTransaction.hide(fragmentCalender).hide(fragmentGalleries).hide(fragmentMap).hide(fragmentAbout).show(fragmentHomePage);
                    break;
                case 1:
                    fragmentTransaction.hide(fragmentHomePage).hide(fragmentCalender).hide(fragmentMap).hide(fragmentAbout).show(fragmentGalleries);
                    break;
                case 2:
                    fragmentTransaction.hide(fragmentHomePage).hide(fragmentGalleries).hide(fragmentMap).hide(fragmentAbout).show(fragmentCalender);


                    break;
                case 3:
                    fragmentTransaction.hide(fragmentCalender).hide(fragmentGalleries).hide(fragmentHomePage).hide(fragmentAbout).show(fragmentMap);

                    break;
                case 4:
                    fragmentTransaction.hide(fragmentCalender).hide(fragmentGalleries).hide(fragmentMap).hide(fragmentHomePage).show(fragmentAbout);

                    break;
            }
            fragmentTransaction.commitAllowingStateLoss();

        }
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        fragmentIndicator.setIndicator(0);
        fragmentIndicatorClicklistener = new FragmentIndicatorClicklistener();

    }

    @Override
    public void loadData() {

    }

    @Override
    public View getContentLayoutId() {
        return View.inflate(getBaseContext(), R.layout.activity_main, null);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);


    }



    @Override
    public Object getLastCustomNonConfigurationInstance() {
        return super.getLastCustomNonConfigurationInstance();
    }
}
