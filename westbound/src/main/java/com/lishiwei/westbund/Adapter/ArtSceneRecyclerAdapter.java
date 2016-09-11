package com.lishiwei.westbund.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lishiwei.core.ImageLoad;
import com.lishiwei.core.Retrofit.WestBoundRetrofit;
import com.lishiwei.model.News;
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
public class ArtSceneRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = ArtSceneRecyclerAdapter.class.getSimpleName();
    private List<News> newsList;
    private Context context;
    DateFormat df3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;

    }

    @Override
    public int getItemCount() {
        return   getContentItemCount();
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            final ViewHolder viewHolder = new ViewHolder(View.inflate(context, R.layout.item_news_recyclerview, null));

        return viewHolder;
    }

    public int getContentItemCount() {
        return newsList.size();
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

//            ((ViewHolder) holder).tvNewsRecyclerTime.setText(df3.format(new Date(Long.valueOf(newsList.get(position - mHeaderCount).getCreateTime()))));
            ((ViewHolder) holder).tvNewsRecyclerTime.setText(DataBindingUtils.getCorrectTime(newsList.get(position).getCreateTime()));
            ((ViewHolder) holder).tvNewsRecyclerMainTitle.setText(newsList.get(position ).getMainTitle());
            ((ViewHolder) holder).tvNewsRecyclerSubTitle.setText(newsList.get(position).getSubTitle());
            ((ViewHolder) holder).tvNewsRecyclerFrom.setText(newsList.get(position ).getSource());
            ((ViewHolder) holder).tvNewsRecyclerContent.setText(newsList.get(position ).getContent());

                ImageLoad.displayImageView(context, WestBoundRetrofit.BaseUrl+newsList.get(position ).getNewsImgUrl(), ((ViewHolder) holder).ivNewsRecyclerImageView);

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

    public ArtSceneRecyclerAdapter(Context context) {
        this.context = context;
    }
}
