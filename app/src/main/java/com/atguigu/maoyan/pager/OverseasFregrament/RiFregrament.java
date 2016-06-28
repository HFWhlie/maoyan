package com.atguigu.maoyan.pager.OverseasFregrament;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.URL;
import com.atguigu.maoyan.adapter.RibenAdapter;
import com.atguigu.maoyan.bean.Ribean;
import com.atguigu.maoyan.fregrament.BaseFregrament;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Request;

/**
 * Created by tao on 2016/6/25.
 */
public class RiFregrament extends BaseFregrament {


    private View view;
    private RecyclerView rl_ri;
    //日本请求地址
    private String riurl;
    private RibenAdapter adapter;

    public RiFregrament(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        view = View.inflate(context, R.layout.ri_fregrament, null);
        findView();
        return view;
    }

    private void findView() {
        rl_ri = (RecyclerView) view.findViewById(R.id.rl_ri);
    }

    @Override
    public void initData() {
        riurl = URL.riurl;
        getFromNetData();
    }

    private void getFromNetData() {
        OkHttpUtils.get().url(riurl).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Log.e("TAG", "日本数据请求失败");
            }

            @Override
            public void onResponse(String response) {
                Log.e("TAG", "日本数据请求成功");

                pressData(response);
            }
        });
    }

    private void pressData(String response) {
        Ribean ribean = new Gson().fromJson(response, Ribean.class);
        List<Ribean.DataBean.HotBean> hotlist = ribean.getData().getHot();
        rl_ri.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        adapter = new RibenAdapter(context, hotlist);
        rl_ri.setAdapter(adapter);
    }
}
