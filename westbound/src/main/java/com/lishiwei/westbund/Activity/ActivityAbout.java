package com.lishiwei.westbund.Activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.lishiwei.westbund.R;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import butterknife.Bind;

public class ActivityAbout extends BaseActivity {

    @Bind(R.id.webview_Activity_About)
    WebView webviewActivityAbout;
    

    @Override
    public void initViews(Bundle savedInstanceState) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_back);

        webviewActivityAbout.getSettings().setJavaScriptEnabled(true);
        webviewActivityAbout.getSettings().setLoadWithOverviewMode(true);
        webviewActivityAbout.getSettings().setSupportZoom(true);
        webviewActivityAbout.setWebViewClient(new WebViewClient());
        webviewActivityAbout.getSettings().setBuiltInZoomControls(true);
        webviewActivityAbout.getSettings().setUseWideViewPort(true);
        webviewActivityAbout.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webviewActivityAbout.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webviewActivityAbout.getSettings().setDomStorageEnabled(true);
        webviewActivityAbout.getSettings().setBlockNetworkImage(false);
        webviewActivityAbout.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE); // 设置 缓存模式
        webviewActivityAbout.loadUrl("https://mp.weixin.qq.com/s?__biz=MjM5MTE0NDE3MQ==&mid=206889923&idx=1&sn=9bedba9f10b7257324a1aaaa5a26c896&scene=1&srcid=0614D1m3quwLgwQe9uCMP60Y&key=c982d415b75b17eabe774aa054cd004356894746aa49362ef3494cbc2f29b118802c57e83cb66e7866e49a75329896a3&ascene=0&uin=MTMxNzk3MzEyMA%3D%3D&devicetype=iMac+MacBookPro11%2C1+OSX+OSX+10.11.5+build(15F34)&version=11020201&pass_ticket=LfPsXdW02E7I%2Fp3lADxDEzQ%2B4J2PYtj9kzO9GMzWH68pbBoD4JUVxEaLq4jRjTD1");
    }

    @Override
    public void loadData() {

    }

    @Override
    public View getContentLayoutId() {
        return View.inflate(ActivityAbout.this, R.layout.activity_about, null);
    }

}
