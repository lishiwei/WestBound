package com.lishiwei.westbund.Activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.lishiwei.model.ArtSpot;
import com.lishiwei.westbund.R;
import com.lishiwei.westbund.databinding.ActivityArtSpotDetailsBinding;

public class ActivityArtSpotDetails extends AppCompatActivity {
ArtSpot artSpot;
    public static String ARTSPOT = "artspot";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityArtSpotDetailsBinding activityArtSpotDetailsBinding = DataBindingUtil.setContentView(this,R.layout.activity_art_spot_details);
        setContentView(activityArtSpotDetailsBinding.getRoot());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_back);
        Intent intent = getIntent();
        artSpot = intent.getParcelableExtra(ARTSPOT);
        activityArtSpotDetailsBinding.setArtSpot(artSpot);
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
            intent.putExtra(Intent.EXTRA_SUBJECT, artSpot.getName());
            intent.putExtra(Intent.EXTRA_TEXT, artSpot.getArtistName());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(Intent.createChooser(intent, "分享"));
        }

        return super.onOptionsItemSelected(item);
    }
}
