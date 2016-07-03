package com.atguigu.maoyan.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.URL;
import com.atguigu.maoyan.bean.Sousuobean;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Request;

/**
 * Created by tao on 2016/6/29.
 */
public class SousuoActivity extends Activity implements View.OnClickListener {
    private TextView tv_cancel;
    private String sousuourl;
    private LinearLayout ll_sousou;
    private TextView tv_1;
    private TextView tv_2;
    private TextView tv_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sousuo);

        findView();
        initData();
        setListener();
    }

    private void initData() {
        sousuourl = URL.sousuourl;

        getFromNetData();
    }

    private void getFromNetData() {
        OkHttpUtils.get().url(sousuourl).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Log.e("TAG", "搜索框书请求失败");
            }

            @Override
            public void onResponse(String response) {
                Log.e("TAG", "搜索框书请求成功");
                pressData(response);
            }
        });
    }

    private void pressData(String response) {
        Sousuobean sousuobean = new Gson().fromJson(response, Sousuobean.class);
        List<Sousuobean.DataBean> data = sousuobean.getData();
        tv_1.setText(data.get(0).getValue());
        tv_2.setText(data.get(1).getValue());
        tv_3.setText(data.get(2).getValue());

    }

    private void setListener() {
        tv_cancel.setOnClickListener(this);
    }

    private void findView() {
        tv_cancel = (TextView) findViewById(R.id.tv_cancel);
        tv_1 = (TextView) findViewById(R.id.tv_1);
        tv_2 = (TextView) findViewById(R.id.tv_2);
        tv_3 = (TextView) findViewById(R.id.tv_3);
        ll_sousou = (LinearLayout) findViewById(R.id.ll_sousou);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancel:
                finish();
                break;
        }
    }
}
