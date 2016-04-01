package com.adaptercontroller.test;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.adaptercontroller.BaseControllerAdapter;
import com.adaptercontroller.BaseViewHolder;

import java.util.List;

/**
 * Created by 273 on 2016/3/22.
 */
public class ListViewSimpleAdapter extends BaseControllerAdapter<String>{
    public ListViewSimpleAdapter(Context context, List<String> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void convert(BaseViewHolder holder, final String item, final int position, ViewGroup parent) {
        holder.setText(R.id.tv,item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, item + "---" + position, Snackbar.LENGTH_SHORT).show();
            }
        });
        ImageView iv = holder.getView(R.id.iv);
        //Picasso.with(mContext).load("http://img.my.csdn.net/uploads/201309/01/1378037235_3453.jpg").into(iv);
        holder.setImageResource(R.id.iv, R.mipmap.ic_launcher);
        holder.setText(R.id.et, item);
    }
}
