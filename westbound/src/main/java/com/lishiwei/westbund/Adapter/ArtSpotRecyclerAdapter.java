package com.lishiwei.westbund.Adapter;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lishiwei.model.ArtSpot;
import com.lishiwei.model.Exhibition;
import com.lishiwei.westbund.Activity.ActivityArtSpotDetails;
import com.lishiwei.westbund.R;
import com.lishiwei.westbund.databinding.ItemArtspotRecyclerviewBinding;
import com.lishiwei.westbund.databinding.ItemOtherexhibitionRecyclerviewBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lishiwei on 16/8/19.
 */
public class ArtSpotRecyclerAdapter extends RecyclerView.Adapter<ArtSpotRecyclerAdapter.ViewHolder> {

    private static final String TAG = ArtSpotRecyclerAdapter.class.getSimpleName();



    List<ArtSpot> artSpotList = new ArrayList<>();

    public void setArtSpotList(List<ArtSpot> artSpotList) {
        this.artSpotList = artSpotList;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        ItemArtspotRecyclerviewBinding itemArtspotRecyclerviewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_artspot_recyclerview, parent, true);
        final ViewHolder viewHolder = new ViewHolder(itemArtspotRecyclerviewBinding.getRoot());
        viewHolder.setItemOtherexhibitionRecyclerviewBinding(itemArtspotRecyclerviewBinding);
        viewHolder.itemOtherexhibitionRecyclerviewBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(parent.getContext(),ActivityArtSpotDetails.class);
                intent.putExtra(ActivityArtSpotDetails.ARTSPOT,artSpotList.get(viewHolder.getLayoutPosition()));
                parent.getContext().startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        holder.itemOtherexhibitionRecyclerviewBinding.setArtSpot(artSpotList.get(position));
    }

    @Override
    public int getItemCount() {
        return artSpotList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemArtspotRecyclerviewBinding itemOtherexhibitionRecyclerviewBinding;


        public void setItemOtherexhibitionRecyclerviewBinding(ItemArtspotRecyclerviewBinding itemArtspotRecyclerviewBinding) {
            this.itemOtherexhibitionRecyclerviewBinding = itemArtspotRecyclerviewBinding;
        }

        public ViewHolder(View itemView) {

            super(itemView);
        }
    }
}
