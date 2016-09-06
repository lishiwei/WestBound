package com.lishiwei.westbund.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
setContentView(getContentLayoutId());
        ButterKnife.bind(this);
        initViews(savedInstanceState);
        loadData();
    }

    public abstract void initViews(Bundle savedInstanceState);

    public abstract void loadData();
    public abstract View getContentLayoutId();

}
