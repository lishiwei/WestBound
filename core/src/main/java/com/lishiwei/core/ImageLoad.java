package com.lishiwei.core;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
/**
 * Created by lishiwei on 16/5/18.
 */
public class ImageLoad {

    public interface PiccasoCallBack {
        public void onSuccess();

        public void onError();
    }

//    public static void displayImageView(Context context, String imageURL, final ImageView imageView) {
//        imageView.setBackgroundColor(Color.parseColor("#cecece"));
//        Picasso.with(context).load(imageURL).placeholder(context.getResources().getDrawable(R.drawable.loadingcore)).centerCrop().fit().error(R.drawable.ic_cloud_off).into(imageView, new Callback() {
//            @Override
//            public void onSuccess() {
//                imageView.setBackgroundColor(Color.parseColor("#00000000"));
//            }
//
//            @Override
//            public void onError() {
//                imageView.setBackgroundColor(Color.parseColor("#00000000"));
//            }
//        });
//    }

    public static void displayImageView(Context context, String imageURL, final ImageView imageView) {

        imageView.setBackgroundColor(Color.parseColor("#cecece"));
        Picasso.with(context).load(imageURL).placeholder(context.getResources().getDrawable(R.drawable.loadingcore)).centerInside().fit().error(R.drawable.logo_icon).into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                imageView.setBackgroundColor(Color.parseColor("#00000000"));
            }

            @Override
            public void onError() {
                imageView.setBackgroundColor(Color.parseColor("#00000000"));
            }
        });
    }
    public static void displayLocalImageView(Context context, String imageURL, final ImageView imageView) {

        imageView.setBackgroundColor(Color.parseColor("#cecece"));
        Picasso.with(context).load(Integer.valueOf(imageURL)).placeholder(context.getResources().getDrawable(R.drawable.loadingcore)).error(R.drawable.ic_cloud_off).into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                imageView.setBackgroundColor(Color.parseColor("#00000000"));
            }

            @Override
            public void onError() {
                imageView.setBackgroundColor(Color.parseColor("#00000000"));
            }
        });
    }

    public static void displaySenimarImageView(Context context, String imageURL, final ImageView imageView) {
        imageView.setBackgroundColor(Color.parseColor("#cecece"));
        Picasso.with(context).load(imageURL).placeholder(context.getResources().getDrawable(R.drawable.loadingcore)).error(R.drawable.logo_icon).into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                imageView.setBackgroundColor(Color.parseColor("#00000000"));

            }

            @Override
            public void onError() {
                imageView.setBackgroundColor(Color.parseColor("#00000000"));

            }
        });
    }
    public static void displayMapImageView(Context context, String imageURL, final ImageView imageView, final PiccasoCallBack piccasoCallBack) {
        imageView.setBackgroundColor(Color.parseColor("#cecece"));
        Picasso.with(context).load(Integer.valueOf(imageURL)).resize(DensityUtil.dip2px(500),DensityUtil.dip2px(830)).centerInside().placeholder(context.getResources().getDrawable(R.drawable.loadingcore)).error(R.drawable.ic_cloud_off).into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                imageView.setBackgroundColor(Color.parseColor("#00000000"));
                piccasoCallBack.onSuccess();
            }

            @Override
            public void onError() {
                imageView.setBackgroundColor(Color.parseColor("#00000000"));
                piccasoCallBack.onError();
            }
        });
    }
}
