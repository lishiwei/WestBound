package com.lishiwei.westbund.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lishiwei.core.ImageLoad;
import com.lishiwei.model.Exhibition;
import com.lishiwei.westbund.R;

import butterknife.Bind;

public class ActivityExhibitionDetail extends BaseActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tv_ExhibitionDetail_ExpoName)
    TextView tvExhibitionDetailExpoName;
    @Bind(R.id.tv_ExhibitionDetail_Status)
    TextView tvExhibitionDetailStatus;
    @Bind(R.id.tv_ExhibitionDetail_Title)
    TextView tvExhibitionDetailTitle;
    @Bind(R.id.iv_ExhibitionDetail_ImageView)
    ImageView ivExhibitionDetailImageView;
    @Bind(R.id.tv_ExhibitionDetail_Date)
    TextView tvExhibitionDetailDate;
    @Bind(R.id.tv_ExhibitionDetail_Time)
    TextView tvExhibitionDetailTime;
    @Bind(R.id.tv_ExhibitionDetail_Curator)
    TextView tvExhibitionDetailCurator;
    @Bind(R.id.tv_ExhibitionDetail_Location)
    TextView tvExhibitionDetailLocation;
    Exhibition exhibition;
    @Bind(R.id.tv_ExhibitionDetail_Content)
    TextView tvExhibitionDetailContent;
    @Bind(R.id.iv_ExhibitionDetail_Map)
    ImageView ivExhibitionDetailMap;

    @Override
    public void initViews(Bundle savedInstanceState) {
        toolbar.setTitle("展览详情");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_back);

        if (getIntent() != null) {
            exhibition = getIntent().getParcelableExtra("exhibition");
        }
        tvExhibitionDetailCurator.setText(exhibition.getCurator());
        tvExhibitionDetailDate.setText(exhibition.getDate());
        tvExhibitionDetailExpoName.setText(exhibition.getExpoName());
        tvExhibitionDetailLocation.setText(exhibition.getLocation());
        tvExhibitionDetailStatus.setText(exhibition.getStatus());
        tvExhibitionDetailTime.setText(exhibition.getTimeStr());
        tvExhibitionDetailTitle.setText(exhibition.getShowName());
        tvExhibitionDetailContent.setText(exhibition.getContent());
        ImageLoad.displayImageView(this, exhibition.getExhibitionImgUrl(), ivExhibitionDetailImageView);
        ivExhibitionDetailMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Uri mUri = Uri.parse("geo:121.468534,31.174508");
//                Intent mIntent = new Intent(Intent.ACTION_VIEW,mUri);
//                startActivity(mIntent);
                navigation(121.468534,31.174508,18,"西岸艺术中心");
            }
        });
    }

    @Override
    public void loadData() {

    }
    private void navigation(double latitude, double longitude, int zoom,
                            String addr) {
        StringBuffer sb = new StringBuffer();
        sb.append("geo:").append(latitude).append(",").append(longitude)
                .append("?").append("z=").append(zoom).append("?").append("q=")
                .append(addr);
        Uri mUri = Uri.parse(sb.toString());
        Intent mIntent = new Intent(Intent.ACTION_VIEW, mUri);
        startActivity(mIntent);}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.exhibitiondetail, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public View getContentLayoutId() {
        return View.inflate(this, R.layout.activity_exhibition_detail, null);
    }
}
