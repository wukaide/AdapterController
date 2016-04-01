package com.adaptercontroller.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by 273 on 2016/3/22.
 */
public class ListViewSimpleActivity extends AppCompatActivity{
    private ListView mListView;
    private ArrayList<String> datas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_simple);
        initData();
        mListView = (ListView)findViewById(R.id.listview);
        mListView.setAdapter(new ControllerTestAdapter(this,datas,R.layout.simple_item).reBaseAdapter());
        //mListView.setAdapter(new ListViewSimpleAdapter(this,datas,R.layout.simple_item));
    }

    private void initData(){
        datas = new ArrayList<>();
        for (int i=0;i < 200;i++){
            datas.add("Simple" + i);
        }
    }
}
