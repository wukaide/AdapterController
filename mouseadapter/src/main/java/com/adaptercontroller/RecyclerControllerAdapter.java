package com.adaptercontroller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by kingwu on 2016/3/21.
 */
public abstract class RecyclerControllerAdapter<T> extends RecyclerView.Adapter<RecyclerViewHolder>{
    protected Context mContext;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;
    protected int layoutId;
    public RecyclerControllerAdapter(Context context, List<T> datas, int layoutId){
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mDatas = datas;
        this.layoutId = layoutId;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerViewHolder holder = new RecyclerViewHolder(mInflater.inflate(layoutId,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Controller(holder,getItem(position),position);
    }

    public abstract void Controller(RecyclerViewHolder holder,T item,int position);


    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public T getItem(int position){
        return mDatas.get(position);
    }
}
