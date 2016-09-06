package com.lishiwei.westbund.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lishiwei.core.ImageLoad;
import com.lishiwei.model.Exhibition;
import com.lishiwei.westbund.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lishiwei on 16/5/18.
 */
public class ExhibitionRecyclerAdapter extends RecyclerView.Adapter<ExhibitionRecyclerAdapter.ViewHolder> {

    private static final String TAG = ExhibitionRecyclerAdapter.class.getSimpleName();

    public List<Exhibition> getExhibitionList() {
        return exhibitionList;
    }

    public void setExhibitionList(List<Exhibition> exhibitionList) {
        this.exhibitionList = exhibitionList;
        notifyDataSetChanged();
    }

    private List<Exhibition> exhibitionList;
    private Context context;


    @Override
    public int getItemCount() {
        return exhibitionList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final ViewHolder viewHolder = new ViewHolder(View.inflate(context, R.layout.item_exhibition_recyclerview, null));
//        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, ActivityExhibitionDetail.class);
//                intent.putExtra("exhibition", exhibitionList.get(viewHolder.getLayoutPosition()));
//                context.startActivity(intent);
//            }
//        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvExhibitionRecyclerExpoName.setText(exhibitionList.get(position).getExpoName());
        holder.tvExhibitionRecyclerStatus.setText(exhibitionList.get(position).getStatus());
        holder.tvExhibitionRecyclerTitle.setText(exhibitionList.get(position).getShowName());
        holder.tvExhibitionRecyclerDate.setText(exhibitionList.get(position).getDate());
        holder.tvExhibitionRecyclerTime.setText(exhibitionList.get(position).getTime());
        holder.tvExhibitionRecyclerLocation.setText(exhibitionList.get(position).getLocation());
        ImageLoad.displayImageView(context, exhibitionList.get(position).getImageURL(), holder.ivExhibitionRecyclerImageView);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_ExhibitionRecycler_ExpoName)
        TextView tvExhibitionRecyclerExpoName;
        @Bind(R.id.tv_ExhibitionRecycler_Title)
        TextView tvExhibitionRecyclerTitle;
        @Bind(R.id.tv_ExhibitionRecycler_Status)
        TextView tvExhibitionRecyclerStatus;
        @Bind(R.id.iv_ExhibitionRecycler_ImageView)
        ImageView ivExhibitionRecyclerImageView;
        @Bind(R.id.tv_ExhibitionRecycler_Date)
        TextView tvExhibitionRecyclerDate;
        @Bind(R.id.tv_ExhibitionRecycler_Time)
        TextView tvExhibitionRecyclerTime;
        @Bind(R.id.tv_ExhibitionRecycler_Curator)
        TextView tvExhibitionRecyclerCurator;
        @Bind(R.id.tv_ExhibitionRecycler_Location)
        TextView tvExhibitionRecyclerLocation;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    public ExhibitionRecyclerAdapter(List<Exhibition> exhibitionList, Context context) {
        this.exhibitionList = exhibitionList;
        this.context = context;
    }

    public ExhibitionRecyclerAdapter(Context context) {

        this.context = context;
    }
}
