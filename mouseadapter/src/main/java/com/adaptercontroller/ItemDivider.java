package com.adaptercontroller;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by kingwu on 2016/3/22.
 */
public class ItemDivider extends RecyclerView.ItemDecoration{
    private Drawable mDrawable;
    private int mOritation;

    public ItemDivider(Context context,int resId,int oritation){
        mDrawable = context.getResources().getDrawable(resId);
        this.mOritation = oritation;
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent) {
        if (mOritation == LinearLayoutManager.VERTICAL) {
            final int left = parent.getPaddingLeft();
            final int right = parent.getWidth() - parent.getPaddingRight();

            final int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                final View child = parent.getChildAt(i);
                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                        .getLayoutParams();

                final int top = child.getBottom() + params.bottomMargin;
                final int bottom = top + mDrawable.getIntrinsicHeight();
                mDrawable.setBounds(left, top, right, bottom);
                mDrawable.draw(c);
            }
        } else if (mOritation == LinearLayoutManager.HORIZONTAL) {

            final int top = parent.getPaddingTop();

            final int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                final View child = parent.getChildAt(i);
                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                        .getLayoutParams();
                final int left = child.getRight() + params.rightMargin;
                final int right = left + mDrawable.getIntrinsicHeight();

                final int bottom = child.getBottom();
                mDrawable.setBounds(left, top, right, bottom);
                mDrawable.draw(c);
            }
        }

    }

    @Override
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
        if (mOritation == LinearLayoutManager.VERTICAL) {
            outRect.set(0, 0, 0, mDrawable.getIntrinsicWidth());
            // outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
        } else if (mOritation == LinearLayoutManager.HORIZONTAL) {
            // outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
            outRect.set(0, 0, 0, mDrawable.getIntrinsicHeight());
        }

    }
}
