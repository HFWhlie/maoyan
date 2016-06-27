package com.atguigu.maoyan.pager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.URL;
import com.atguigu.maoyan.adapter.HotAdapter;
import com.atguigu.maoyan.bean.Hotbean;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Request;

/**
 * Created by tao on 2016/6/24.
 */
public class Hotpager extends Basepager {
    private View view;
    private SwipeRefreshLayout sf_refresh;
    private RecyclerView rl_refresh;
    private HotAdapter adapter;
    //热映数据集合和地址
    private String hoturl;
    public List<Hotbean.DataBean.MoviesBean> list;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    getFromNetData();
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    };

    public Hotpager(Context context) {
        super(context);
    }

    @Override
    public View initview() {
        view = View.inflate(context, R.layout.hot_pager, null);
        findView();
        return view;
    }

    private void findView() {
        rl_refresh = (RecyclerView) view.findViewById(R.id.rl_refresh);
        sf_refresh = (SwipeRefreshLayout) view.findViewById(R.id.sf_refresh);

        sf_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessageDelayed(0,2000);
                    }
                }).start();
            }
        });

    }

    @Override
    public void initData() {
        isInitData = true;
        //listview
        hoturl = URL.hoturl;
        getFromNetData();
    }

    /**
     * list
     */

    private void getFromNetData() {
        OkHttpUtils.get().url(hoturl).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Log.e("TAG", "联网失败");

            }

            @Override
            public void onResponse(final String response) {
                Log.e("TAG", "联网成功list");
                //解析并显示数据
                processData(response);
            }
        });
    }

    private void processData(String response) {
        Hotbean hotbean = new Gson().fromJson(response, Hotbean.class);
        //listview的集合
        list = hotbean.getData().getMovies();
        rl_refresh.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        adapter = new HotAdapter(context, list);
        rl_refresh.setAdapter(adapter);
    }
}
