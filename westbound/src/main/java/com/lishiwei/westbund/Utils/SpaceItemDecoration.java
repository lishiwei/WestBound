package com.lishiwei.westbund.Utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by lishiwei on 16/5/18.
 */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration
{
    private  int space;

    public SpaceItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if(parent.getChildPosition(view) != 0)
            outRect.top = space;
    }
}
