package com.adaptercontroller.test;

import android.content.Context;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ImageView;

import com.adaptercontroller.RecyclerControllerAdapter;
import com.adaptercontroller.RecyclerViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 273 on 2016/3/22.
 */
public class ReSimpleAdapter extends RecyclerControllerAdapter<String> {

    public ReSimpleAdapter(Context context, List<String> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void Controller(RecyclerViewHolder holder, final String item,final int position) {
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
