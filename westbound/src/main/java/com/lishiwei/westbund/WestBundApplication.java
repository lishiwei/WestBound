package com.lishiwei.westbund;

import android.app.Application;

/**
 * Created by lishiwei on 16/5/17.
 */
public class WestBundApplication extends Application {
    private static WestBundApplication westBundApplication = null;


    @Override
    public void onCreate() {
        super.onCreate();
        westBundApplication = this;

    }

    public static WestBundApplication getInstance() {
        return westBundApplication;
    }


}
