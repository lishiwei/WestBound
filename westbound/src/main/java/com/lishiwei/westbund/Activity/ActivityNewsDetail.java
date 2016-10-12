package com.lishiwei.westbund.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.lishiwei.core.ImageLoad;
import com.lishiwei.core.Retrofit.WestBoundRetrofit;
import com.lishiwei.model.News;
import com.lishiwei.westbund.R;
import com.lishiwei.westbund.Utils.DataBindingUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ActivityNewsDetail extends AppCompatActivity {

    @Bind(R.id.tv_News_Detail_From)
    TextView tvNewsDetailFrom;
    @Bind(R.id.tv_News_Detail_Time)
    TextView tvNewsDetailTime;
    @Bind(R.id.tv_News_Detail_MainTitle)
    TextView tvNewsDetailMainTitle;
    @Bind(R.id.tv_News_Detail_SubTitle)
    TextView tvNewsDetailSubTitle;
    @Bind(R.id.iv_News_Detail_ImageView)
    ImageView ivNewsDetailImageView;
    @Bind(R.id.tv_News_Detail_Content)
    TextView tvNewsDetailContent;
    DateFormat df3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    News news;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("新闻详情");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_back);
        toolbar.setTitle("新闻详情");
        Intent intent = getIntent();
         news = intent.getParcelableExtra("news");
        if (news!=null)
        {
            tvNewsDetailFrom.setText(news.getSource());
            tvNewsDetailContent.setText(news.getContent());
            tvNewsDetailMainTitle.setText(news.getMainTitle());
            tvNewsDetailSubTitle.setText(news.getSubTitle());
//            tvNewsDetailTime.setText(df3.format(new Date(Long.valueOf(news.getCreateTime()))));
            tvNewsDetailTime.setText(DataBindingUtils.getCorrectTime(news.getCreateTime()));
            ImageLoad.displayImageView(ActivityNewsDetail.this, WestBoundRetrofit.BaseUrl+news.getNewsImgUrl(),ivNewsDetailImageView);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.share)
        {
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, news.getMainTitle());
            intent.putExtra(Intent.EXTRA_TEXT, news.getNewsImgUrl());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(Intent.createChooser(intent, "分享"));
        }

        return super.onOptionsItemSelected(item);
    }
}
