package com.atguigu.maoyan.pager.OverseasFregrament;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.URL;
import com.atguigu.maoyan.activity.SystemActivity;
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
    private ProgressBar pb;
    private ImageView iv_pb;
    private LinearLayout ll_show;
    //韩国的请求地址
    private String hanurl;
    private HanguoAdapter adapter;
    private List<Hanbean.DataBean.HotBean> hot;

    public HanFregrament(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        view = View.inflate(context, R.layout.han_fregrament, null);
        findView();
        setlistener();
        return view;
    }


    private void findView() {
        rl_han = (RecyclerView) view.findViewById(R.id.rl_han);
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
        hanurl = URL.hanurl;
        getFromNetData();
    }

    /**
     * 联网请求
     */
    private void getFromNetData() {
        pb.setVisibility(View.VISIBLE);
        iv_pb.setVisibility(View.VISIBLE);
        ll_show.setVisibility(View.GONE);
        OkHttpUtils.get().url(hanurl).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Log.e("TAG", "韩国数据请求失败");
                pb.setVisibility(View.GONE);
                iv_pb.setVisibility(View.GONE);
                ll_show.setVisibility(View.VISIBLE);
            }

            @Override
            public void onResponse(String response) {
                Log.e("TAG", "韩国数据请求成功");
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
        Hanbean hanbean = new Gson().fromJson(response, Hanbean.class);
        hot = hanbean.getData().getHot();
        rl_han.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        adapter = new HanguoAdapter(context, hot);
        rl_han.setAdapter(adapter);

        adapter.setOnClickHanitemlistener(new HanguoAdapter.OnClickHanitemlistener() {
            @Override
            public void onClickHanitemlistener(View v, int layoutPosition) {
                String videourl = hot.get(layoutPosition).getVideourl();
                Intent intent = new Intent(context, SystemActivity.class);
                intent.setDataAndType(Uri.parse(videourl), "video/*");
                context.startActivity(intent);
            }
        });
    }
}
