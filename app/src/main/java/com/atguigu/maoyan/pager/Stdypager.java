package com.atguigu.maoyan.pager;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.URL;
import com.atguigu.maoyan.activity.HotHfive;
import com.atguigu.maoyan.adapter.StdyAdapter;
import com.atguigu.maoyan.bean.Stdybean;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
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
    private MaterialRefreshLayout refresh;
    private RecyclerView rl_refresh;
    private ProgressBar pb;
    private ImageView iv_pb;
    private LinearLayout ll_show;
    //待映请求地址
    private String stdyPagerurl;
    private List<Stdybean.DataBean.ComingBean> cominglist;
    private StdyAdapter adapter;
    private Handler handler = new Handler();

    public Stdypager(Context context) {
        super(context);
    }

    @Override
    public View initview() {
        view = View.inflate(context, R.layout.hot_pager, null);
        findView();
        setlistener();
        return view;

    }


    private void findView() {
        rl_refresh = (RecyclerView) view.findViewById(R.id.rl_refresh);
        pb = (ProgressBar) view.findViewById(R.id.pb);
        iv_pb = (ImageView) view.findViewById(R.id.iv_pb);
        ll_show = (LinearLayout) view.findViewById(R.id.ll_show);
        refresh = (MaterialRefreshLayout) view.findViewById(R.id.refresh);
    }

    private void setlistener() {
        refresh.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getFromNetData();
                        adapter.notifyDataSetChanged();
                        refresh.finishRefresh();
                    }
                }, 2000);
            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getFromNetData();
                        adapter.notifyDataSetChanged();
                        refresh.finishRefreshLoadMore();
                    }
                }, 2000);
            }
        });

        ll_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFromNetData();
            }
        });

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
        pb.setVisibility(View.VISIBLE);
        iv_pb.setVisibility(View.VISIBLE);
        ll_show.setVisibility(View.GONE);
        OkHttpUtils.get().url(stdyPagerurl).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Log.e("TAG", "待映请求失败");
                pb.setVisibility(View.GONE);
                iv_pb.setVisibility(View.GONE);
                ll_show.setVisibility(View.VISIBLE);
            }

            @Override
            public void onResponse(String response) {
                Log.e("TAG", "待映请求成功");
                pb.setVisibility(View.GONE);
                iv_pb.setVisibility(View.GONE);
                ll_show.setVisibility(View.GONE);
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

        //点击某个item的监听
        adapter.setOnStdylistener(new StdyAdapter.OnStdylistener() {
            @Override
            public void onstdyonclicklistener(View v, int layoutPosition) {
                Intent intent = new Intent(context, HotHfive.class);
                String nm = cominglist.get(layoutPosition-1).getNm();
                intent.putExtra("stdy", nm);
                intent.setFlags(2);
                context.startActivity(intent);
            }
        });
    }
}
