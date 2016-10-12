package com.lishiwei.westbund.Adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lishiwei.model.ArtSpot;
import com.lishiwei.model.Exhibition;
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
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemArtspotRecyclerviewBinding itemArtspotRecyclerviewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_artspot_recyclerview, parent, true);
        ViewHolder viewHolder = new ViewHolder(itemArtspotRecyclerviewBinding.getRoot());
        viewHolder.setItemOtherexhibitionRecyclerviewBinding(itemArtspotRecyclerviewBinding);
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
