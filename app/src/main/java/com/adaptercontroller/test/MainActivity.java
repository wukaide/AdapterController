package com.adaptercontroller.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ClickRecyclerSimple(View v){
        Intent intent = new Intent(this,RecyclerSimpleActivity.class);
        startActivity(intent);
    }

    public void ClickListViewSimple(View v){
        Intent intent = new Intent(this,ListViewSimpleActivity.class);
        startActivity(intent);
    }

    public void ClickRecycModelSimple(View v){
        Intent intent = new Intent(this,RecyclerModelActivity.class);
        startActivity(intent);
    }

    public void ClickGetHtml(View v){

    }
}
