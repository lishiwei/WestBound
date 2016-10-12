package com.lishiwei.westbund.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lishiwei.core.ImageLoad;
import com.lishiwei.core.Retrofit.WestBoundRetrofit;
import com.lishiwei.model.Gallery;
import com.lishiwei.westbund.R;
import com.lishiwei.westbund.Utils.OnItemClickListener;

import java.util.List;


/**
 * Created by lishiwei on 16/5/22.
 */
public class ImageAdapter extends PagerAdapter {
    Context context;
    OnItemClickListener onItemClickListener;
List<Gallery> galleryList;
    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public ImageAdapter(Context context,List<Gallery>galleryList) {
        this.context = context;
        this.galleryList = galleryList;
    }


    @Override
    public int getCount() {
        //设置成最大，使用户看不到边界
        return galleryList.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position,
                            Object object) {
        View view = (View) object;
        container.removeView(view);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {



        //对ViewPager页号求模取出View列表中要显示的项
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_galleryview_list, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.iv_movie);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.OnItemClick(v, position);
                }
            }
        });

        TextView title = (TextView) view.findViewById(R.id.tv_title);
        title.setText(galleryList.get(position).getChineseName());
 ImageLoad.displayImageView(container.getContext(), WestBoundRetrofit.BaseUrl+galleryList.get(position).getGalleryImgUrl(),imageView);
        container.addView(view);

        return view;
    }
}
