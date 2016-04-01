package com.adaptercontroller.test;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.ViewGroup;
import com.adaptercontroller.BaseViewHolder;
import com.adaptercontroller.ControllerAdapter;
import com.adaptercontroller.RecyclerViewHolder;

import java.util.List;

/**
 * Created by kingwu on 2016/4/1.
 */
public class ControllerTestAdapter extends ControllerAdapter<String> {

    public ControllerTestAdapter(Context context, List<String> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void BaseController(BaseViewHolder holder,final String item,final int position, ViewGroup parent) {
        super.BaseController(holder, item, position, parent);
        holder.setText(R.id.tv,item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, item + "---" + position, Snackbar.LENGTH_SHORT).show();
            }
        });
        holder.setImageResource(R.id.iv, R.mipmap.ic_launcher);
        holder.setText(R.id.et, item);
    }

    @Override
    public void RecyclerController(RecyclerViewHolder holder,final String item,final int position) {
        super.RecyclerController(holder, item, position);
        holder.setText(R.id.tv,item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, item + "---" + position, Snackbar.LENGTH_SHORT).show();
            }
        });
        holder.setImageResource(R.id.iv, R.mipmap.ic_launcher);
        holder.setText(R.id.et, item);
    }
}
