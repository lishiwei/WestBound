package com.lishiwei.westbund.Adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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

    int id;

    public void setArmTypes(String[] armTypes) {
        this.armTypes = armTypes;
    }

    private String[] armTypes = new String[]{
            "详情", "艺术总监", "展览历史", "艺术家", "画廊"};
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
            imageView.setBackgroundResource(R.drawable.gallery);
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

    public GalleryExListViewAdapter(Context context, int id) {
        this.context = context;
        this.id = id;
        Log.d(TAG, "GalleryExListViewAdapter: " + id);
        if (id == 1) {

            arms = new String[][]{
                    {"艾可画廊位于意大利的帕勒莫，成立于2005年，主要展出意大利和世界范围内新兴艺术家的作品。" +
                            "在成立之初，艾可画廊就十分关注中国当代艺术。2008年 艾可画廊进驻上海著名的艺术园区莫干山路50号（M50），" +
                            "旨在促进中国艺术家和全世界的对话和交流。目前艾可画廊每年在上海和帕勒莫分别举办4次展览"},
                    {"吕振光"},
                    {"山水第D三零零二号", "模仿生活", "不被注册的城市", "2012” "},
                    {"吕振光", "王晓曲", "蒋鹏奕", "陈杰",},
                    {"还是这群人"}
            };

        }
        if (id == 2) {
            arms = new String[][]{
                    {"北京现在画廊是一家经营中国当代前卫艺术的国际化专业艺术机构，于2004年成立于北京。画廊坐落于草场地艺术区，总面积达800多平方米，" +
                            "共有两层展示空间，设有独立的影像厅和资料库。为进一步实施实验性和国际性的展览计划、" +
                            "积极推介新锐艺术家及优秀作品创造了完美的空间。"},
                    {"洪绍裴"},
                    {"精灵 我许愿我不是个王子", "无题 7号", "弹琴的人之一 草地上的巴勒斯"},
                    {"洪绍裴", "王劲松", "郑维"},
                    {"还是这群人"}
            };

        }
        if (id == 3) {
            arms = new String[][]{
                    {"站台中国的新画廊空间地处798艺术区中心区域，总面积超过700余平方米，分为展厅及研讨室。展览空间空旷高挑，适合展出各种媒介的艺术作品。同时设有“橱窗”项目空间，力图通过艺术跨界合作、以实验及探索的语言方式不定期的组织特定的现场装置和艺术项目，展现更为新锐实验的艺术创作。\n"
                    },
                    {"付经岩"},
                    {"需要的平衡", "正午", "桃不桃", "沙滩"},
                    {"付经岩", "汤大尧", "黄亮", "毕建业"},
                    {"还是这群人"}
            };
        }
    }

    private TextView getGroupTextView() {
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView textView = new TextView(context);
        textView.setLayoutParams(lp);
        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);

        textView.setPadding(DensityUtil.dip2px(12), DensityUtil.dip2px(12), DensityUtil.dip2px(12), DensityUtil.dip2px(12));
        textView.setTextSize(14);
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
