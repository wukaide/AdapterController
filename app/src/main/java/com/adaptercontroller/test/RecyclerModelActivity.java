package com.adaptercontroller.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.adaptercontroller.ItemDivider;

import java.util.ArrayList;

/**
 * Created by 273 on 2016/3/22.
 */
public class RecyclerModelActivity extends AppCompatActivity{
    private RecyclerView recycler;

    private ArrayList<RecyclerModel> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_simple);
        initData();
        recycler = (RecyclerView)findViewById(R.id.recycler);
        recycler.addItemDecoration(new ItemDivider(this,R.drawable.itemdivider,LinearLayoutManager.VERTICAL));
        recycler.setLayoutManager(new LinearLayoutManager(this));

        recycler.setAdapter(new RecyclerModelAdapter(this,datas,R.layout.simple_item));
    }

    private void initData(){
        String[] urls = getResources().getStringArray(R.array.url);
        datas = new ArrayList<>();
        for (int i = 0;i < urls.length;i++){
            RecyclerModel model = new RecyclerModel(urls[i],"Simple" + i);
            datas.add(model);
        }
    }
}
