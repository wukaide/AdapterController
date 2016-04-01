package com.adaptercontroller;

import android.content.Context;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by kingwu on 2016/4/1.
 */
public abstract class ControllerAdapter<T> implements ControllerInterface {

    private BaseControllerAdapter baseAdapter;

    private RecyclerControllerAdapter recyclerAdapter;

    protected Context mContext;
    protected int layoutId;
    protected List<T> mDatas;
    public ControllerAdapter(Context context,List<T> datas,int layoutId){
        this.mContext = context;
        this.mDatas = datas;
        this.layoutId = layoutId;
    }

    @Override
    public BaseControllerAdapter reBaseAdapter() {
        baseAdapter = new BaseControllerAdapter(mContext,mDatas,layoutId) {
            @Override
            public void convert(BaseViewHolder holder, Object item, int position, ViewGroup parent) {
                BaseController(holder, (T)item, position, parent);
            }
        };
        return baseAdapter;
    }

    @Override
    public RecyclerControllerAdapter reRecyclerAdapter() {
        recyclerAdapter = new RecyclerControllerAdapter(mContext,mDatas,layoutId) {
            @Override
            public void Controller(RecyclerViewHolder holder, Object item, int position) {
                RecyclerController(holder, (T) item, position);
            }
        };
        return recyclerAdapter;
    }

    public void BaseController(BaseViewHolder holder,final T item,final int position, ViewGroup parent){
        reBaseAdapter();
    }
    public void RecyclerController(RecyclerViewHolder holder,final T item,final int position){
        reRecyclerAdapter();
    }
}
