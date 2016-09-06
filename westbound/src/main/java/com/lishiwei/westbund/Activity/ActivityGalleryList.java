package com.lishiwei.westbund.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lishiwei.model.Gallery;
import com.lishiwei.westbund.Adapter.GalleryExListViewAdapter;
import com.lishiwei.westbund.Adapter.ImageAdapter;
import com.lishiwei.westbund.R;
import com.lishiwei.westbund.Utils.DensityUtil;
import com.lishiwei.westbund.Utils.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ActivityGalleryList extends AppCompatActivity {


    @Bind(R.id.container)
    ViewPager container;
    @Bind(R.id.iv_gallery_indicator)
    ImageView ivGalleryIndicator;
    @Bind(R.id.ln_Gallery)
    LinearLayout lnGallery;
    @Bind(R.id.vp_gallery)
    ViewPager vpGallery;
    /**
     * The {@link PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    ImageAdapter imageAdapter;
    /**
     * The {@link ViewPager} that will host the section contents.
     */

    Gallery gallery;
    int prevIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_list);

        ButterKnife.bind(this);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        initFragmentadapter();
        initImageadapter();
        lnGallery.setVisibility(View.INVISIBLE);
        vpGallery.setVisibility(View.INVISIBLE);

        ivGalleryIndicator.setOnClickListener(new View.OnClickListener() {

            int i = 0;

            @Override
            public void onClick(View v) {
                i++;
                if (i % 2 == 0) {
                    ivGalleryIndicator.setBackgroundResource(R.drawable.indicator_gallery_normal);
                    lnGallery.setVisibility(View.INVISIBLE);
                    vpGallery.setVisibility(View.INVISIBLE);
                    container.setVisibility(View.VISIBLE);
                } else {
                    ivGalleryIndicator.setBackgroundResource(R.drawable.indicator_gallery_selector);
                    lnGallery.setVisibility(View.VISIBLE);
                    vpGallery.setVisibility(View.VISIBLE);
                    container.setVisibility(View.INVISIBLE);
                }
            }
        });

    }

    private void initFragmentadapter() {

        if (mSectionsPagerAdapter == null) {
            mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        }
        if (container.getAdapter() != null) {
            container.setAdapter(null);
        }
        container.setOffscreenPageLimit(mSectionsPagerAdapter.getCount());
        container.setAdapter(mSectionsPagerAdapter);
        container.setPageMargin(DensityUtil.dip2px(-18));

    }

    public void initImageadapter() {
        List<ImageView> list = new ArrayList<>();
        ImageView imageView = new ImageView(ActivityGalleryList.this);
        imageView.setBackgroundResource(R.drawable.gallery);
        list.add(imageView);
        list.add(imageView);
        list.add(imageView);
        list.add(imageView);
        list.add(imageView);
        list.add(imageView);
        list.add(imageView);
        vpGallery.setPageMargin(DensityUtil.dip2px(30));
        if (imageAdapter == null) {
            imageAdapter = new ImageAdapter(getBaseContext());
            imageAdapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void OnItemClick(View view, int position) {
                    ivGalleryIndicator.setBackgroundResource(R.drawable.indicator_gallery_normal);
                    lnGallery.setVisibility(View.INVISIBLE);
                    vpGallery.setVisibility(View.INVISIBLE);
                    container.setVisibility(View.VISIBLE);
                    container.setCurrentItem(position);
                }

                @Override
                public void OnItemLongClick(View view, int position) {

                }
            });
        }
        if (vpGallery.getAdapter() != null) {
            vpGallery.setAdapter(null);
        }
        vpGallery.setAdapter(imageAdapter);
        vpGallery.setCurrentItem(0);
        vpGallery.setOffscreenPageLimit(6);
        lnGallery.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return vpGallery.dispatchTouchEvent(event);
            }
        });

        vpGallery.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                lnGallery.invalidate();
            }

            @Override
            public void onPageSelected(int position) {


// Set the layout params of the newly selected page to be the large width and height

                View v = vpGallery.getChildAt(position);
                v.setScaleX(1.2f);
                v.setScaleY(1.2f);
//                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
//                        newWidth, newHeight);
//
//                v.setLayoutParams(params);
//
//// Don't forget to set the past view to the old layout params.
//
                View oldV = vpGallery.getChildAt(prevIndex);
                oldV.setScaleX(1);
                oldV.setScaleY(1);
//                RelativeLayout.LayoutParams oldParams = new RelativeLayout.LayoutParams(
//                        oldWidth, oldHeight);
//
//                oldV.setLayoutParams(oldParams);
//
                prevIndex = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_gallery_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private static final String TAG = PlaceholderFragment.class.getSimpleName();
        @Bind(R.id.ExListView_Gallery_List)
        ExpandableListView ExListViewGalleryList;
        TextView tvHeadViewExGalleryListChineseName;
        TextView tvHeadViewExGalleryListEnglishName;
        ImageView ivHeadViewExGalleryListTitle;
        TextView tvHeadViewExGalleryListLocaion;

        public PlaceholderFragment() {

        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {

            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            Log.d(TAG, "newInstance: " + sectionNumber);

            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            Gallery gallery = null;
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
                gallery = new Gallery("", "艾可画廊", "Aike-Dellarco", "");
            }
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 2) {
                gallery = new Gallery("", "北京现在画廊", "Beijing Art Now Gallery", "");
            }
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 3) {
                gallery = new Gallery("", "站台中国", "PlatFormChina", "");
            }

            View view = View.inflate(getActivity(), R.layout.headview_exlistview_gallery_list, null);
            tvHeadViewExGalleryListChineseName = (TextView) view.findViewById(R.id.tv_HeadView_ExGalleryList_ChineseName);
            tvHeadViewExGalleryListChineseName.setText(gallery.getChineseName());
            tvHeadViewExGalleryListEnglishName = (TextView) view.findViewById(R.id.tv_HeadView_ExGalleryList_EnglishName);
            tvHeadViewExGalleryListEnglishName.setText(gallery.getEnglishName());
            tvHeadViewExGalleryListLocaion = (TextView) view.findViewById(R.id.tv_HeadView_ExGalleryList_Locaion);
            tvHeadViewExGalleryListLocaion.setText("");
            ivHeadViewExGalleryListTitle = (ImageView) view.findViewById(R.id.tv_HeadView_ExGalleryList_title);


            ExListViewGalleryList.addHeaderView(view);

            GalleryExListViewAdapter galleryExListViewAdapter = new GalleryExListViewAdapter(getActivity(), getArguments().getInt(ARG_SECTION_NUMBER));
            ExListViewGalleryList.setAdapter(galleryExListViewAdapter);
            ExListViewGalleryList.expandGroup(galleryExListViewAdapter.getArmTypes().length - 1);

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_activity_gallery_list, container, false);

            ButterKnife.bind(this, rootView);
            return rootView;
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            ButterKnife.unbind(this);
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public float getPageWidth(int position) {
            return super.getPageWidth(position);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
