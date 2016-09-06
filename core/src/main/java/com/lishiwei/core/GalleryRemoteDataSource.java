package com.lishiwei.core;

import android.os.Handler;
import android.support.annotation.NonNull;

import com.lishiwei.model.Gallery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lishiwei on 16/5/21.
 */
public class GalleryRemoteDataSource implements DataSource<Gallery> {
    @Override
    public void getDatas(int pageSize, int pageNo,final @NonNull LoadDataCallBack<Gallery> loadDataCallBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<Gallery> list = new ArrayList<>();
                list.add(new Gallery("1","艾可画廊", "Aike-Dellarco", "上海"));
                list.add(new Gallery("2","北京现代画廊", "Beijing Art Now Gallery", "上海"));
                list.add(new Gallery("3","站台中国", "PlatFormChina", "上海"));
                list.add(new Gallery("4","阿拉里奥画廊", "Arario Gallery", "上海"));
                list.add(new Gallery("5","博而励画廊", "Boers-Li", "上海"));
                list.add(new Gallery("6","萨迪科尔斯", "Sadie Coles HQ", "上海"));
                list.add(new Gallery("7","格莱斯顿画廊", "Gladstone Gallery", "上海"));
                list.add(new Gallery("8","豪瑟沃斯画廊", "Hauser & Wirth", "上海"));
                list.add(new Gallery("9","长征空间", "Long March Space", "上海"));

                if (list.size() > 0) {
                    loadDataCallBack.onSucceed(list);
                } else {
                    loadDataCallBack.onError();
                }
            }
        },2000);

    }
}
