package com.atguigu.maoyan.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.adapter.KnobAdapter;
import com.atguigu.maoyan.bean.Classify;

public class KnobActivity extends Activity {
    private Context context;

    private ImageView iv_back;
    private RecyclerView recyclerView;
    private KnobAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knob);
        context = this;
        findView();
        setData();

    }

    private void setData() {
        Classify list = (Classify) getIntent().getSerializableExtra("list");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,2);
        //设置布局管理器
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new KnobAdapter(context,list);
        recyclerView.setAdapter(adapter);
    }

    private void findView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }
}
