package com.lishiwei.westbund.Adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lishiwei.model.DayActivity;
import com.lishiwei.westbund.R;
import com.lishiwei.westbund.databinding.ItemDayactivityRecyclerviewBinding;

import java.util.List;

/**
 * Created by shiwei on 2016/9/17.
 */
public class DayActivityRecyclerAdapter extends RecyclerView.Adapter<DayActivityRecyclerAdapter.ViewHolder> {
    List<DayActivity> dayActivityList;
    public void setDayActivityList(List<DayActivity> dayActivityList) {
        this.dayActivityList = dayActivityList;
    }

    public List<DayActivity> getDayActivityList() {
        return dayActivityList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemDayactivityRecyclerviewBinding itemDayactivityRecyclerviewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_dayactivity_recyclerview, parent, false
        );
        ViewHolder viewHolder = new ViewHolder(itemDayactivityRecyclerviewBinding.getRoot());
       viewHolder.setViewDataBinding(itemDayactivityRecyclerviewBinding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getViewDataBinding().setDayActivity(dayActivityList.get(position));

    }



    @Override
    public int getItemCount() {
        return dayActivityList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemDayactivityRecyclerviewBinding viewDataBinding;

        public ItemDayactivityRecyclerviewBinding getViewDataBinding() {
            return viewDataBinding;
        }

        public void setViewDataBinding(ItemDayactivityRecyclerviewBinding viewDataBinding) {
            this.viewDataBinding = viewDataBinding;
        }

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
