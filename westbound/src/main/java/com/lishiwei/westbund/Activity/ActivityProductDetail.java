package com.lishiwei.westbund.Activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lishiwei.core.ImageLoad;
import com.lishiwei.model.Product;
import com.lishiwei.westbund.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ActivityProductDetail extends BaseActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tv_ProductDetails_Title)
    TextView tvProductDetailsTitle;
    @Bind(R.id.tv_ProductDetails_Artist)
    TextView tvProductDetailsArtist;
    @Bind(R.id.tv_ProductDetails_size)
    TextView tvProductDetailsSize;
    @Bind(R.id.tv_ProductDetails_technique)
    TextView tvProductDetailsTechnique;
    @Bind(R.id.tv_ProductDetails_Materail)
    TextView tvProductDetailsMaterail;
    @Bind(R.id.iv_ProductDetails_Image)
    ImageView ivProductDetailsImage;
    Product product;

    @Override
    public void initViews(Bundle savedInstanceState) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_back);

    }

    @Override
    public void loadData() {
        product = getIntent().getParcelableExtra("product");
        tvProductDetailsArtist.setText(product.getArtist());
        tvProductDetailsMaterail.setText(product.getMaterial());
        tvProductDetailsSize.setText(product.getSize());
        tvProductDetailsTechnique.setText(product.getTechnique());
        tvProductDetailsTitle.setText(product.getTitle());
        ImageLoad.displayLocalImageView(ActivityProductDetail.this,(product.getImageUrl()),ivProductDetailsImage);
    }

    @Override
    public View getContentLayoutId() {
        return View.inflate(this, R.layout.activity_product_detail, null);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
