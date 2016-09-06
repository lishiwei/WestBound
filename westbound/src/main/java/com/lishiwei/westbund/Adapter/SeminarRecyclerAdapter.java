package com.lishiwei.westbund.Adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lishiwei.model.Seminar;
import com.lishiwei.westbund.R;
import com.lishiwei.westbund.databinding.ItemSeminarRecyclerviewBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lishiwei on 16/8/17.
 */
public class SeminarRecyclerAdapter extends RecyclerView.Adapter<SeminarRecyclerAdapter.ViewHolder> {
    private static final String TAG = SeminarRecyclerAdapter.class.getSimpleName();

    public void setSeminarList(List<Seminar> seminarList) {
        this.seminarList = seminarList;
    }

    List<Seminar> seminarList = new ArrayList<>();

    public SeminarRecyclerAdapter() {
    }

    @Override
    public SeminarRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemSeminarRecyclerviewBinding itemSeminarRecyclerviewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_seminar_recyclerview, parent, true);
        ViewHolder viewHolder = new ViewHolder(itemSeminarRecyclerviewBinding.getRoot());
        viewHolder.setItemSeminarRecyclerviewBinding(itemSeminarRecyclerviewBinding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SeminarRecyclerAdapter.ViewHolder holder, int position) {
        holder.getItemSeminarRecyclerviewBinding().setSenimar(seminarList.get(position));
    }

    @Override
    public int getItemCount() {

        return seminarList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ItemSeminarRecyclerviewBinding itemSeminarRecyclerviewBinding;
        public ItemSeminarRecyclerviewBinding getItemSeminarRecyclerviewBinding() {
            return itemSeminarRecyclerviewBinding;
        }

        public void setItemSeminarRecyclerviewBinding(ItemSeminarRecyclerviewBinding itemSeminarRecyclerviewBinding) {
            this.itemSeminarRecyclerviewBinding = itemSeminarRecyclerviewBinding;
        }

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
