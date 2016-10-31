package com.lishiwei.westbund.Utils;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshRecyclerView;
import com.lishiwei.core.ImageLoad;
import com.lishiwei.core.Retrofit.WestBoundRetrofit;
import com.lishiwei.westbund.Adapter.OtherExhibitionRecyclerAdapter;
import com.lishiwei.westbund.WestBundApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lishiwei on 16/8/26.
 */
@BindingMethods(
        {
                @BindingMethod(type = android.support.design.widget.TabLayout.class, attribute = "viewPager", method = "setupWithViewPager"),
        }
)
public class DataBindingUtils {

    private static final String TAG = DataBindingUtils.class.getSimpleName();
    static private DataBindingUtils dataBindingUtils = null;
    public PullToRefreshBase.Mode pullFromEnd = PullToRefreshBase.Mode.PULL_FROM_END;
    public PullToRefreshBase.Mode Pull_From_Start = PullToRefreshBase.Mode.PULL_FROM_START;
    public PullToRefreshBase.Mode Pull_Disable = PullToRefreshBase.Mode.DISABLED;
    public RecyclerView.LayoutManager LinearLayoutManager ;

    private DataBindingUtils() {
        if (LinearLayoutManager == null)
        {
            LinearLayoutManager = new LinearLayoutManager(WestBundApplication.getInstance());
        }
    }

    static public DataBindingUtils newInstance() {
        if (dataBindingUtils == null) {
            synchronized (DataBindingUtils.class) {
                if (dataBindingUtils == null) {
                    dataBindingUtils = new DataBindingUtils();
                }
            }
        }
        return dataBindingUtils;
    }

    public static String getCorrectImageUrl(String imageUrl) {
        Log.d(TAG, "getCorrectImageUrl: " + WestBoundRetrofit.BaseUrl + imageUrl);
        return WestBoundRetrofit.BaseUrl + imageUrl;
    }

    public static String getCorrectStatus(String status) {
        if (status.equals("1")) {
            return "西岸论坛";
        } else {
            return "现代传播论坛";
        }

    }

    public static String getCorrectSeminarLocation(String location) {
        return "地址:  " + location;

    }

    public static String getCorrectSeminarTime(String time) {
        return "时间:  " + time;

    }

    public static String getCorrectActivityStatus(String status) {
        if (status.equals("进行中") || status.equals("ONGOING")) {
            return "1";
        } else {
            return "0";
        }

    }

    public static String getCorrectTime(String startTime, String endTime) {
        return startTime + "     --     " + endTime;
    }

    public static String getCorrectTime(String time) {
        Date date = new Date(Long.valueOf(time));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static String getCorrectActivityTime(String startTime, String openTime, String time) {

        return startTime + "/" + openTime + time;
    }

    @BindingAdapter({"bind:image"})
    public static void imageLoader(ImageView imageView, String url) {
        ImageLoad.displaySenimarImageView(WestBundApplication.getInstance(), url, imageView);
    }

    @BindingConversion
    public static String convertDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }


    @BindingAdapter("bind:Adapter")
    public static void setAdapter(PullToRefreshRecyclerView pullToRefreshRecyclerView, OtherExhibitionRecyclerAdapter adapter) {
        if (pullToRefreshRecyclerView.getRefreshableView().getAdapter() != null) {
            pullToRefreshRecyclerView.getRefreshableView().setAdapter(null);
        }
        pullToRefreshRecyclerView.getRefreshableView().setAdapter(adapter);
    }

    @BindingAdapter("bind:LayoutManager")
    public static void setOnLayoutManager(PullToRefreshRecyclerView pullToRefreshRecyclerView, RecyclerView.LayoutManager layoutManager) {
        if (pullToRefreshRecyclerView.getRefreshableView().getLayoutManager() != null) {
            pullToRefreshRecyclerView.getRefreshableView().setLayoutManager(null);
        }
        pullToRefreshRecyclerView.getRefreshableView().setLayoutManager(layoutManager);
    }

    @BindingAdapter("bind:Completefreshing")
    public static void setOnCompletefreshing(PullToRefreshRecyclerView pullToRefreshRecyclerView, boolean isRefreshing) {
        if (!isRefreshing) {
            if (pullToRefreshRecyclerView.isRefreshing()) {
                Log.d(TAG, "setOnCompletefreshing: ");
                pullToRefreshRecyclerView.onRefreshComplete();
            }

        }

    }


}
