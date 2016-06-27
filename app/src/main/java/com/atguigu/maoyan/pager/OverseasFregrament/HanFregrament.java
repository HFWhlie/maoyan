package com.atguigu.maoyan.pager.OverseasFregrament;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.URL;
import com.atguigu.maoyan.adapter.HanguoAdapter;
import com.atguigu.maoyan.bean.Hanbean;
import com.atguigu.maoyan.fregrament.BaseFregrament;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Request;

/**
 * Created by tao on 2016/6/25.
 */
public class HanFregrament extends BaseFregrament {
    private View view;
    private RecyclerView rl_han;
    //韩国的请求地址
    private String hanurl;
    private HanguoAdapter adapter;

    public HanFregrament(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        view = View.inflate(context, R.layout.han_fregrament, null);
        findView();
        return view;
    }

    private void findView() {
        rl_han = (RecyclerView) view.findViewById(R.id.rl_han);
    }

    @Override
    public void initData() {
        hanurl = URL.hanurl;
        getFromNetData();
    }

    private void getFromNetData() {
        OkHttpUtils.get().url(hanurl).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Log.e("TAG", "美国数据请求失败");
            }

            @Override
            public void onResponse(String response) {
                Log.e("TAG", "美国数据请求成功");

                pressData(response);
            }
        });
    }

    private void pressData(String response) {
        Hanbean hanbean = new Gson().fromJson(response, Hanbean.class);
        List<Hanbean.DataBean.HotBean> hot = hanbean.getData().getHot();
        rl_han.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        adapter = new HanguoAdapter(context, hot);
        rl_han.setAdapter(adapter);
    }
}
