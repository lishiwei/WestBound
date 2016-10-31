package com.lishiwei.westbund.Adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lishiwei.core.ImageLoad;
import com.lishiwei.core.Retrofit.WestBoundRetrofit;
import com.lishiwei.model.Gallery;
import com.lishiwei.westbund.R;
import com.lishiwei.westbund.Utils.DensityUtil;

/**
 * Created by lishiwei on 16/5/22.
 */
public class GalleryExListViewAdapter implements ExpandableListAdapter {
    private static final String TAG = GalleryExListViewAdapter.class.getSimpleName();
    Context context;

    public String[] getArmTypes() {
        return armTypes;
    }

    Gallery gallery;

    public void setArmTypes(String[] armTypes) {
        this.armTypes = armTypes;
    }

    private String[] armTypes ;

    private String[][] arms;

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getGroupCount() {
        return armTypes.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return arms[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return armTypes[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return arms[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        LinearLayout ll = new LinearLayout(context);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        TextView textView = getGroupTextView();
        textView.setText(getGroup(groupPosition).toString());
        textView.setPadding(DensityUtil.dip2px(12), DensityUtil.dip2px(12), 0, DensityUtil.dip2px(12));
        View view = new View(context);
        view.setLayoutParams(new LinearLayout.LayoutParams(0, 0, 1));
        ImageView imageView = new ImageView(context);


        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DensityUtil.dip2px(20), DensityUtil.dip2px(20));
        layoutParams.topMargin = DensityUtil.dip2px(10);
        layoutParams.rightMargin = DensityUtil.dip2px(10);
        imageView.setLayoutParams(layoutParams);
        if (isExpanded) {
            imageView.setImageResource(R.drawable.reduce);
        } else {
            imageView.setImageResource(R.drawable.plus);
        }
        if (groupPosition == armTypes.length - 1) {
//            if (convertView != null) {
//                convertView.setClickable(true);
//            }

        }

        ll.addView(textView);
        ll.addView(view);
        ll.addView(imageView);
        return ll;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (groupPosition < armTypes.length - 1) {
            TextView textView = getChildTextView();
            textView.setText(getChild(groupPosition, childPosition).toString());
            return textView;
        } else if (groupPosition == armTypes.length - 1) {
            ImageView imageView = new ImageView(context);
            AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DensityUtil.dip2px(200));

            imageView.setLayoutParams(lp);
            ImageLoad.displayImageView(context, WestBoundRetrofit.BaseUrl+gallery.getGalleryImgUrl(),imageView);
            return imageView;
        }
        return null;

//
// } else if (groupPosition == armTypes.length - 1) {
//            RecyclerView recyclerView = new RecyclerView(context);
//
//            final List<Product> productList = new ArrayList<>();
//            if (id == 1) {
//                productList.add(new Product("" + R.drawable.pic1, "吕振光", "山水第D三零零二号", "麻布", "塑胶彩与混合媒介", "150*200"));
//                productList.add(new Product("" + R.drawable.pic21, "王晓曲,", "模仿生活 ", "布画油画", "塑胶彩与混合媒介", "100*120"));
//                productList.add(new Product("" + R.drawable.pic3, "蒋鹏奕", "不被注册的城市", "", "收藏级艺术微喷", "150*209"));
//                productList.add(new Product("" + R.drawable.pic4, "陈杰", "2012", "布画油画", "暂未知", "150*200"));
//            }
//            if (id == 2) {
//                productList.add(new Product("" + R.drawable.pic11, "洪绍裴", "精灵 我许愿我不是个王子", "暂未知", "丙烯燃料", "200*120"));
//                productList.add(new Product("" + R.drawable.pic12, "王劲松,", "无题 7号", "麻布", "塑胶彩与混合媒介", "150*200"));
//                productList.add(new Product("" + R.drawable.pic13, "郑维", "弹琴的人之一 草地上的巴勒斯", "麻布", "综合材料", "230*230"));
//
//            }
//            if (id == 3) {
//                productList.add(new Product("" + R.drawable.pic20, "付经岩", "需要的平衡", "麻布", "纸本丙烯", "216*250"));
//                productList.add(new Product("" + R.drawable.pic23, "汤大尧", "正午", "布画油画", "纸上丙烯", "200*300"));
//                productList.add(new Product("" + R.drawable.pic24, "黄亮", "桃不桃", "布画油画", "塑胶彩与混合媒介", "54*65"));
//                productList.add(new Product("" + R.drawable.pic25, "毕建业", "沙滩", "麻布", "布画油画", "75*80"));
//            }
//            recyclerView.setAdapter(new CommonRcvAdapter<Product>(productList) {
//                @NonNull
//                @Override
//                public AdapterItem createItem(Object type) {
//
//                    return new ExhibitionProductItem();
//                }
//            });
//            recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
//            ((CommonRcvAdapter<Product>) (recyclerView.getAdapter())).setOnItemClickListener(new OnItemClickListener() {
//                @Override
//                public void OnItemClick(View view, int position) {
//                    Intent intent = new Intent(context, ActivityProductDetail.class);
//                    intent.putExtra("product", productList.get(position));
//                    context.startActivity(intent);
//                }
//
//                @Override
//                public void OnItemLongClick(View view, int position) {
//
//                }
//            });
//            recyclerView.setEnabled(false);
//            recyclerView.setFocusable(false);
//            int raw = 0;
//            if (productList.size() == 0) {
//                raw = 0;
//            } else if (productList.size() < 3) {
//                raw = 1;
//            } else if (productList.size() % 2 == 1) {
//                raw = productList.size() / 2 + 1;
//            }
//            recyclerView.setVerticalScrollBarEnabled(false);
//            recyclerView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, DensityUtil.dip2px(248) * (raw)));
//            return recyclerView;
//        }

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {

    }

    @Override
    public void onGroupCollapsed(int groupPosition) {

    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return 0;
    }

    public GalleryExListViewAdapter(Context context, Gallery gallery) {
        this.context = context;
        this.gallery = gallery;

            arms = new String[][]{
                    {gallery.getDetail()},
                    {gallery.getDirector()},
                    {gallery.getLocation()},
                    {gallery.getArtists()},
                    {gallery.getGalleryImgUrl()}

        };
        armTypes = new String[]{
                context.getString(R.string.gallery_detail), context.getString(R.string.contact), context.getString(R.string.city),context.getString(R.string.artist), context.getString(R.string.gallery_photo)};
    }

    private TextView getGroupTextView() {
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView textView = new TextView(context);
        textView.setLayoutParams(lp);
        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);

        textView.setPadding(DensityUtil.dip2px(12), DensityUtil.dip2px(12), DensityUtil.dip2px(12), DensityUtil.dip2px(12));
        textView.setTextSize(14);
        textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        return textView;
    }

    private TextView getChildTextView() {
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView textView = new TextView(context);
        textView.setLayoutParams(lp);
        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        textView.setPadding(DensityUtil.dip2px(12), DensityUtil.dip2px(12), DensityUtil.dip2px(12), DensityUtil.dip2px(12));
        textView.setLineSpacing(8, 1.2f);
        textView.setTextSize(14);
        return textView;
    }
}
