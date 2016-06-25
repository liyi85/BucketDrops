package com.example.andrearodriguez.bucketdrops.adapters;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.andrearodriguez.bucketdrops.R;

/**
 * Created by andrearodriguez on 6/24/16.
 */
public class Divider extends RecyclerView.ItemDecoration {
    private Drawable mDivider;
    private int mOrientatio;

    public Divider(Context context, int orientatio) {
        mDivider = ContextCompat.getDrawable(context, R.drawable.divider);
        if(orientatio!= LinearLayoutManager.VERTICAL){
            throw new IllegalArgumentException("This Item Decoration can be used only with a RecyclerView that uses a Linealayoutanager with vertical orientatio");
        }
        mOrientatio = orientatio;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if(mOrientatio == LinearLayoutManager.VERTICAL){
            drawHorizontalDivider(c, parent, state);
        }
    }

    private void drawHorizontalDivider(Canvas c, RecyclerView parent, RecyclerView.State state) {
    int left, top, right, botton;
        left=parent.getPaddingLeft();
        right = parent.getWidth() - parent.getPaddingRight();
        int count = parent.getChildCount();

        for(int i = 0; i< count; i++){
            View current = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) current.getLayoutParams();
            top = current.getTop() - params.topMargin;
            botton = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, botton);
            mDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
    }
}
