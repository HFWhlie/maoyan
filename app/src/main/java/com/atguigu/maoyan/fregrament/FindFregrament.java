package com.atguigu.maoyan.fregrament;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.URL;
import com.atguigu.maoyan.adapter.FindAdapter;
import com.atguigu.maoyan.bean.Findbean;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Request;

/**
 * Created by tao on 2016/6/24.
 * 发现
 */
public class FindFregrament extends BaseFregrament {
    private View view;
    private RecyclerView rl_find;
    private ProgressBar pb;
    private ImageView iv_pb;
    private LinearLayout ll_show;
    //发现的请求地址
    private String findurl;
    private List<Findbean.DataBean.FeedsBean> feeds;
    private FindAdapter adapter;

    public FindFregrament(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        view = View.inflate(context, R.layout.find_fregrament, null);
        findView();
        setlistener();
        return view;
    }

    private void findView() {
        rl_find = (RecyclerView) view.findViewById(R.id.rl_find);
        pb = (ProgressBar) view.findViewById(R.id.pb);
        iv_pb = (ImageView) view.findViewById(R.id.iv_pb);
        ll_show = (LinearLayout) view.findViewById(R.id.ll_show);
    }
    private void setlistener() {
        ll_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFromNetData();
            }
        });
    }

    @Override
    public void initData() {
        findurl = URL.findurl;
        getFromNetData();
    }

    /**
     * 联网请求
     */
    private void getFromNetData() {
        pb.setVisibility(View.VISIBLE);
        iv_pb.setVisibility(View.VISIBLE);
        OkHttpUtils.get().url(findurl).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Log.e("TAG", "发现数据请求失败");
                pb.setVisibility(View.GONE);
                iv_pb.setVisibility(View.GONE);
                ll_show.setVisibility(View.VISIBLE);
            }

            @Override
            public void onResponse(String response) {
                Log.e("TAG", "发现数据请求成功");
                pb.setVisibility(View.GONE);
                iv_pb.setVisibility(View.GONE);
                ll_show.setVisibility(View.GONE);
                pressData(response);
            }
        });
    }

    /**
     * 解析并显示数据
     *
     * @param response
     */
    private void pressData(String response) {
        Findbean findbean = new Gson().fromJson(response, Findbean.class);
        feeds = findbean.getData().getFeeds();
        rl_find.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        adapter = new FindAdapter(context, feeds);
        rl_find.setAdapter(adapter);
    }
}
