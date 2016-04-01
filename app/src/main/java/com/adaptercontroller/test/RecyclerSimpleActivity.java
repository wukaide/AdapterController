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
public class RecyclerSimpleActivity extends AppCompatActivity{
    private RecyclerView recycler;
    private ArrayList<String> datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_simple);
        initData();
        recycler = (RecyclerView)findViewById(R.id.recycler);
        recycler.addItemDecoration(new ItemDivider(this,R.drawable.itemdivider,LinearLayoutManager.VERTICAL));
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(new ControllerTestAdapter(this,datas,R.layout.simple_item).reRecyclerAdapter());
    }

    private void initData(){
        datas = new ArrayList<>();
        for (int i=0;i < 100;i++){
            datas.add("Simple" + i);
        }
    }
}
