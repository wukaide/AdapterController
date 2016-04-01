package com.adaptercontroller.test;

import android.content.Context;
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
public class RecyclerModelAdapter extends RecyclerControllerAdapter<RecyclerModel>{

    public RecyclerModelAdapter(Context context, List<RecyclerModel> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void Controller(RecyclerViewHolder holder, final RecyclerModel item, final int position) {
        holder.setText(R.id.tv,item.getText()).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, item .getText()+ "---" + position, Snackbar.LENGTH_SHORT).show();
            }
        });
        ImageView iv = holder.getView(R.id.iv);
        Picasso.with(mContext).load(item.getUrl()).placeholder(R.mipmap.loading).resize(280, 200).centerCrop().into(iv);
        //holder.setImageResource(R.id.iv, R.mipmap.ic_launcher);
        holder.setText(R.id.et, item.getText());
    }
}
