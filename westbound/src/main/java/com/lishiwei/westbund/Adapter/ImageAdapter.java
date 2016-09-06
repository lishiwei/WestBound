package com.lishiwei.westbund.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lishiwei.model.Gallery;
import com.lishiwei.westbund.R;
import com.lishiwei.westbund.Utils.OnItemClickListener;


/**
 * Created by lishiwei on 16/5/22.
 */
public class ImageAdapter extends PagerAdapter {
    Context context;
    OnItemClickListener onItemClickListener;

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public ImageAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        //设置成最大，使用户看不到边界
        return 3;
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

        Gallery gallery = null;
        if (position == 0) {
            gallery = new Gallery("", "艾可画廊", "Aike-Dellarco", "" + R.drawable.pic1);
        }
        if (position == 1) {
            gallery = new Gallery("", "北京现在画廊", "Beijing Art Now Gallery", "" + R.drawable.pic11);
        }
        if (position == 2) {
            gallery = new Gallery("", "站台中国", "PlatFormChina", "" + R.drawable.pic21);
        }


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
        imageView.setBackgroundResource(Integer.valueOf(gallery.getLocation()));
        TextView title = (TextView) view.findViewById(R.id.tv_title);
//        SubjectsInfo subjectsInfo = subjectsInfos.get(position);
        title.setText(gallery.getChineseName());
// ImageLoad.displayImageView(container.getContext(), imageView, subjectsInfo.getImages().getLarge(), context.getResources().getDrawable(R.mipmap.ic_loading));
        container.addView(view);

        return view;
    }
}
