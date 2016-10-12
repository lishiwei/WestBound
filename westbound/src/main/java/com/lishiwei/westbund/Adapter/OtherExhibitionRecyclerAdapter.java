package com.lishiwei.westbund.Adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lishiwei.model.Exhibition;
import com.lishiwei.westbund.R;
import com.lishiwei.westbund.databinding.ItemOtherexhibitionRecyclerviewBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lishiwei on 16/8/19.
 */
public class OtherExhibitionRecyclerAdapter extends RecyclerView.Adapter<OtherExhibitionRecyclerAdapter.ViewHolder> {

    private static final String TAG = OtherExhibitionRecyclerAdapter.class.getSimpleName();


    public List<Exhibition> getExhibitionList() {
        return exhibitionList;
    }

    public void setExhibitionList(List<Exhibition> exhibitionList) {
        this.exhibitionList = exhibitionList;
    }

    List<Exhibition> exhibitionList = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemOtherexhibitionRecyclerviewBinding itemOtherexhibitionRecyclerviewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_otherexhibition_recyclerview, parent, true);
        ViewHolder viewHolder = new ViewHolder(itemOtherexhibitionRecyclerviewBinding.getRoot());
        viewHolder.setItemOtherexhibitionRecyclerviewBinding(itemOtherexhibitionRecyclerviewBinding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        holder.itemOtherexhibitionRecyclerviewBinding.setExhibition(exhibitionList.get(position));
    }

    @Override
    public int getItemCount() {
        return exhibitionList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemOtherexhibitionRecyclerviewBinding itemOtherexhibitionRecyclerviewBinding;

        public ItemOtherexhibitionRecyclerviewBinding getItemOtherexhibitionRecyclerviewBinding() {
            return itemOtherexhibitionRecyclerviewBinding;
        }

        public void setItemOtherexhibitionRecyclerviewBinding(ItemOtherexhibitionRecyclerviewBinding itemOtherexhibitionRecyclerviewBinding) {
            this.itemOtherexhibitionRecyclerviewBinding = itemOtherexhibitionRecyclerviewBinding;
        }

        public ViewHolder(View itemView) {

            super(itemView);
        }
    }
}
