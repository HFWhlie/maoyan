package com.atguigu.maoyan.pager;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.URL;
import com.atguigu.maoyan.adapter.StdyAdapter;
import com.atguigu.maoyan.bean.Stdybean;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Request;

/**
 * Created by tao on 2016/6/24.
 * 待映
 */
public class Stdypager extends Basepager {

    private View view;

    private SwipeRefreshLayout sf_refresh;
    private RecyclerView rl_refresh;

    //待映请求地址
    private String stdyPagerurl;
    private List<Stdybean.DataBean.ComingBean> cominglist;
    private StdyAdapter adapter;

    public Stdypager(Context context) {
        super(context);
    }

    @Override
    public View initview() {
        view = View.inflate(context, R.layout.hot_pager,null);

        findView();
        return view;

    }

    private void findView() {
        sf_refresh = (SwipeRefreshLayout) view.findViewById(R.id.sf_refresh);
        rl_refresh = (RecyclerView) view.findViewById(R.id.rl_refresh);
    }

    @Override
    public void initData() {
        isInitData = true;

        stdyPagerurl = URL.stdyPagerurl;

        getFromNetData();
    }

    /**
     * 联网请求
     */
    private void getFromNetData() {
        OkHttpUtils.get().url(stdyPagerurl).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Log.e("TAG", "待映请求失败");
            }

            @Override
            public void onResponse(String response) {
                Log.e("TAG", "待映请求成功");
                pressData(response);
            }
        });
    }
    //解析并显示数据
    private void pressData(String response) {
        Stdybean stdybean = new Gson().fromJson(response, Stdybean.class);
        cominglist = stdybean.getData().getComing();
        //设置布局管理器
        rl_refresh.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        adapter = new StdyAdapter(context, cominglist);
        rl_refresh.setAdapter(adapter);

    }
}
