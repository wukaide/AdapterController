package com.adaptercontroller;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by kingwu on 2016/3/21.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder{

    private SparseArray<View> mViews;
    private View itemView;
    public RecyclerViewHolder(View itemView) {
        super(itemView);
        this.mViews = new SparseArray<>();
        this.itemView = itemView;
    }

    /**
     * 通过viewId获取控件
     * @param viewId
     * @return
     */
    public <T extends View>T getView(int viewId){
        View view = mViews.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T)view;
    }

    /**
     * 设置TextView的值
     * @param viewId
     * @param text
     * @return
     */
    public TextView setText(int viewId,String text){
        TextView tv = getView(viewId);
        if (tv instanceof TextView){
            tv.setText(text);
        }
        return tv;
    }

    /**
     * 设置ImageView背景
     * @param viewId
     * @param reId
     * @return
     */
    public ImageView setImageResource(int viewId,int reId){
        ImageView view = getView(viewId);
        view.setImageResource(reId);
        return view;
    }


}
