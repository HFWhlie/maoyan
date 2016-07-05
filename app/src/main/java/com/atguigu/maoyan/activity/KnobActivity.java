package com.atguigu.maoyan.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.adapter.KnobAdapter;
import com.atguigu.maoyan.bean.Classify;

import java.util.List;

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
        setlistener();

    }

    private void setlistener() {
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setData() {
        List<Classify.DataBean> key = (List<Classify.DataBean>) getIntent().getSerializableExtra("key");
        Log.e("TAG", "key-------------------" + key);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        //设置布局管理器
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new KnobAdapter(context, key);
        recyclerView.setAdapter(adapter);
    }

    private void findView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }
}
