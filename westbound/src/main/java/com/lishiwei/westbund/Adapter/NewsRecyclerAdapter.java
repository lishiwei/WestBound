package com.lishiwei.westbund.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lishiwei.core.ImageLoad;
import com.lishiwei.core.Retrofit.WestBoundRetrofit;
import com.lishiwei.model.News;
import com.lishiwei.westbund.Activity.ActivityNewsDetail;
import com.lishiwei.westbund.R;
import com.lishiwei.westbund.Utils.DataBindingUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lishiwei on 16/5/18.
 */
public class NewsRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = NewsRecyclerAdapter.class.getSimpleName();
    private List<News> newsList;
    private Context context;
    private int mHeaderCount = 1;//头部View个数
    //item类型
    public static final int ITEM_TYPE_HEADER = 0;
    public static final int ITEM_TYPE_CONTENT = 1;
    DateFormat df3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;

    }

    @Override
    public int getItemCount() {
        return mHeaderCount + getContentItemCount();
    }

    public boolean isHeaderView(int position) {
        return mHeaderCount != 0 && position < mHeaderCount;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE_HEADER) {
            return new HeaderViewHolder(View.inflate(context, R.layout.news_recyclerview_header, null));
        } else if (viewType == mHeaderCount) {
            final ViewHolder viewHolder = new ViewHolder(View.inflate(context, R.layout.item_news_recyclerview, null));
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ActivityNewsDetail.class);
                    intent.putExtra("news",newsList.get(viewHolder.getLayoutPosition()-1));
                    context.startActivity(intent);
                }
            });

            return viewHolder;
        }
        return null;
    }

    public int getContentItemCount() {
        return newsList.size();
    }

    //判断当前item类型
    @Override
    public int getItemViewType(int position) {
        int dataItemCount = getContentItemCount();
        if (mHeaderCount != 0 && position < mHeaderCount) {
            //头部View
            return ITEM_TYPE_HEADER;
        } else {
            //内容View
            return ITEM_TYPE_CONTENT;
        }
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {

        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder) {

        } else if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).tvNewsRecyclerTime.setText(DataBindingUtils.getCorrectTime(newsList.get(position - mHeaderCount).getCreateTime()));
            ((ViewHolder) holder).tvNewsRecyclerMainTitle.setText(newsList.get(position - mHeaderCount).getMainTitle());
            ((ViewHolder) holder).tvNewsRecyclerSubTitle.setText(newsList.get(position - mHeaderCount).getSubTitle());
            ((ViewHolder) holder).tvNewsRecyclerFrom.setText(newsList.get(position - mHeaderCount).getSource());
            ((ViewHolder) holder).tvNewsRecyclerContent.setText(newsList.get(position - mHeaderCount).getContent());

            ImageLoad.displayImageView(context, WestBoundRetrofit.BaseUrl+newsList.get(position - mHeaderCount).getNewsImgUrl(), ((ViewHolder) holder).ivNewsRecyclerImageView);
        }

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_NewsRecycler_From)
        TextView tvNewsRecyclerFrom;
        @Bind(R.id.tv_NewsRecycler_Time)
        TextView tvNewsRecyclerTime;
        @Bind(R.id.tv_NewsRecycler_MainTitle)
        TextView tvNewsRecyclerMainTitle;
        @Bind(R.id.tv_NewsRecycler_SubTitle)
        TextView tvNewsRecyclerSubTitle;
        @Bind(R.id.iv_NewsRecycler_ImageView)
        ImageView ivNewsRecyclerImageView;
        @Bind(R.id.tv_NewsRecycler_Content)
        TextView tvNewsRecyclerContent;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    public NewsRecyclerAdapter(Context context) {
        this.context = context;
    }
}
