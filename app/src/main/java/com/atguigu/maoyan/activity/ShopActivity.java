package com.atguigu.maoyan.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.URL;
import com.atguigu.maoyan.adapter.ShopAdapter;
import com.atguigu.maoyan.bean.Shoppagerbean;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Request;

public class ShopActivity extends Activity implements View.OnClickListener {
    private Context context;
    private ImageView iv_back;
    private ImageView iv_seach;
    private RecyclerView recycler;
    //商城最上面的viewpager接口
    private String shopurl;
    private ShopAdapter adapter;
    private RelativeLayout rl_show;
    private float lastY;
    private float lastX;
    private boolean isUpSlide;
    //是否显示
    private boolean isToolshide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        context = this;
        findView();
        initData();
        setlistener();
    }

    private void setlistener() {
        iv_back.setOnClickListener(this);
        iv_seach.setOnClickListener(this);

        recycler.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        lastY = event.getY();
                        lastX = event.getX();
                        break;
                    case MotionEvent.ACTION_MOVE:

                        float disY = event.getY() - lastY;
                        float disX = event.getY() - lastX;

                        //垂直方向滑动
                        if (Math.abs(disY) > Math.abs(disX)) {
                            //是否向上滑动
                            isUpSlide = disY < 0;
                            if (isUpSlide) {
                                if (!isToolshide) {
                                    if (Math.abs(disY) > rl_show.getHeight()) {
                                        rl_show.setVisibility(View.VISIBLE);
                                        isToolshide = true;
                                    } else {
                                        rl_show.setVisibility(View.GONE);
                                        isToolshide = false;
                                    }
                                } else {
                                    rl_show.setVisibility(View.VISIBLE);
                                    isToolshide = true;
                                }
                            } else {
                                if (!isToolshide) {
                                    if (Math.abs(disY) > rl_show.getHeight()) {
                                        rl_show.setVisibility(View.VISIBLE);
                                        isToolshide = true;
                                    } else {
                                        rl_show.setVisibility(View.GONE);
                                        isToolshide = false;
                                    }
                                    rl_show.setVisibility(View.VISIBLE);
                                    isToolshide = true;
                                } else {
                                    rl_show.setVisibility(View.GONE);
                                    isToolshide = false;
                                }
                            }
                        }
                        break;
                }
                return false;
            }
        });
    }

    private void initData() {
        shopurl = URL.shopurl;
        getFromNetData();
    }

    private void getFromNetData() {
        OkHttpUtils.get().url(shopurl).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Log.e("TAG", "商城Viewpager请求失败");
            }

            @Override
            public void onResponse(String response) {
                Log.e("TAG", "商城Viewpager请求成功");

                pressData(response);
            }
        });
    }

    private void pressData(String response) {
        Shoppagerbean shoppagerbean = new Gson().fromJson(response, Shoppagerbean.class);
        List<Shoppagerbean.DataBean> data = shoppagerbean.getData();
        recycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        adapter = new ShopAdapter(context, data);
        recycler.setAdapter(adapter);
    }

    private void findView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_seach = (ImageView) findViewById(R.id.iv_seach);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        rl_show = (RelativeLayout) findViewById(R.id.rl_show);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_seach:

                break;
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
