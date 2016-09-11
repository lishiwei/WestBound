package com.lishiwei.core;

import android.support.annotation.NonNull;
import java.util.List;

/**
 * Created by lishiwei on 16/5/17.
 */
public interface DataSource < T > {

    interface LoadDataCallBack< T > {
        void onSucceed(List< T > list);

        void onError( );
    }

    void getDatas(int pageSize,int pageNo,@NonNull final LoadDataCallBack<T> loadDataCallBack);
}
