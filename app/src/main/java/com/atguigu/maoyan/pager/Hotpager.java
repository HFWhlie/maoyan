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
import com.atguigu.maoyan.adapter.HotAdapter;
import com.atguigu.maoyan.bean.Hotbean;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
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
    private RecyclerView rl_refresh;
    private HotAdapter adapter;
    //热映数据集合和地址
    private String hoturl;
    public List<Hotbean.DataBean.MoviesBean> list;
    private ProgressBar pb;
    private ImageView iv_pb;
    private LinearLayout ll_show;
    private MaterialRefreshLayout refresh;

    private Handler handler = new Handler();

    public Hotpager(Context context) {
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
        //热映页面请求地址
        hoturl = URL.hoturl;
        getFromNetData();
    }

    /**
     * list 联网请求
     */
    private void getFromNetData() {
        pb.setVisibility(View.VISIBLE);
        iv_pb.setVisibility(View.VISIBLE);
        ll_show.setVisibility(View.GONE);
        OkHttpUtils.get().url(hoturl).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Log.e("TAG", "联网失败");
                pb.setVisibility(View.GONE);
                iv_pb.setVisibility(View.GONE);
                ll_show.setVisibility(View.VISIBLE);
            }

            @Override
            public void onResponse(final String response) {
                Log.e("TAG", "联网成功list");
                pb.setVisibility(View.GONE);
                iv_pb.setVisibility(View.GONE);
                ll_show.setVisibility(View.GONE);
                //解析并显示数据
                processData(response);
            }
        });
    }

    /**
     * 解析并显示数据
     *
     * @param response
     */
    private void processData(String response) {
        Hotbean hotbean = new Gson().fromJson(response, Hotbean.class);
        //listview的集合
        list = hotbean.getData().getMovies();
        rl_refresh.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        adapter = new HotAdapter(context, list);
        rl_refresh.setAdapter(adapter);

        //跳转到H5
        adapter.setOnClickitemListeren(new HotAdapter.OnClickitemListeren() {
            @Override
            public void onclickListener(Hotbean.DataBean.MoviesBean bean) {
                Intent intent = new Intent(context, HotHfive.class);
                String nm = bean.getNm();
                intent.putExtra("key",nm);
                intent.setFlags(1);
                context.startActivity(intent);
            }
        });
    }
}
