package com.adaptercontroller;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kingwu on 2016/3/22.
 */
public class BaseViewHolder {
    private SparseArray<View> mViews;
    private View mConvertView;

    public BaseViewHolder (Context context,ViewGroup parent,int layoutId,int position){
        this.mViews = new SparseArray<>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent,false);
        mConvertView.setTag(this);
    }

    public static BaseViewHolder get(Context context,View convertView,ViewGroup parent,int layoutId,int position){
        if (convertView == null) {
            return new BaseViewHolder(context, parent, layoutId, position);
        }else {
            BaseViewHolder holder = (BaseViewHolder) convertView.getTag();
            return holder;
        }
    }
    /**
     * 通过viewId获取控件
     * @param viewId
     * @return
     */
    public <T extends View>T getView(int viewId){
        View view = mViews.get(viewId);

        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T)view;
    }

    public View getConvertView(){
        return mConvertView;
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
    public BaseViewHolder setImageResource(int viewId,int reId){
        ImageView view = getView(viewId);
        view.setImageResource(reId);
        return this;
    }

    public BaseViewHolder setImageBitmap(int viewId,Bitmap bitmap){
        ImageView view = getView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }

    public BaseViewHolder setImageUrl(int viewId,String url){
        ImageView view = getView(viewId);
        //view.setImageBitmap(bitmap);
        //Imageloader.getInstance().loadImg(view,url);
        return this;
    }
}
