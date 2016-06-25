package com.atguigu.maoyan.pager;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.URL;
import com.atguigu.maoyan.adapter.HotAdapter;
import com.atguigu.maoyan.bean.HotPagerbean;
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
    //热映数据集合
    private List<Hotbean.DataBean.MoviesBean> movielist;
    private String hoturl;
    //热映pager路径
    private String hotpagerurl;
    //热映pager集合
    private List<HotPagerbean.DataBean> data;

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
        sf_refresh = (SwipeRefreshLayout) view.findViewById(R.id.sf_refresh);
        rl_refresh = (RecyclerView) view.findViewById(R.id.rl_refresh);
    }

    @Override
    public void initData() {

        //设置布局管理器
        LinearLayoutManager manager = new LinearLayoutManager(context);
        rl_refresh.setLayoutManager(manager);
        //设置适配器
        adapter = new HotAdapter(context);
        rl_refresh.setAdapter(adapter);


        //热映的地址
        hoturl = URL.hoturl;
        getFromNetData();
        //热映pager地址
        hotpagerurl = URL.hotPagerurl;
        getFrompagerNetData();

    }

    /**
     * 热映pager联网请求
     */
    private void getFrompagerNetData() {
        OkHttpUtils
                .get()
                .url(hotpagerurl)
                .build()
                .execute(new StringCallback() {
                    /**
                     * 请求失败
                     * @param request
                     * @param e
                     */
                    @Override
                    public void onError(Request request, Exception e) {
                        Log.e("TAG", "dataonError----------------");
                    }

                    /**
                     * 请求成功
                     * @param response
                     */
                    @Override
                    public void onResponse(String response) {
                        Log.e("TAG", "dataonResponse--------------");
                        //解析数据
                        processepagerData(response);
                    }
                });
    }

    /**
     * 热映pager解析数据
     * @param response
     */
    private void processepagerData(String response) {
        HotPagerbean hotPagerbean = new Gson().fromJson(response, HotPagerbean.class);
        data = hotPagerbean.getData();

        if(data!=null) {
            adapter.setviewData(data);
            adapter.notifyItemRangeChanged(0,1);
        }

    }

    /**
     * 热映联网请求
     *
     * @param
     */
    private void getFromNetData() {
        OkHttpUtils
                .get()
                .url(hoturl)
                .build()
                .execute(new StringCallback() {
                    /**
                     * 请求失败
                     * @param request
                     * @param e
                     */
                    @Override
                    public void onError(Request request, Exception e) {
                        Log.e("TAG", "listonError----------------");
                    }

                    /**
                     * 请求成功
                     * @param response
                     */
                    @Override
                    public void onResponse(String response) {
                        Log.e("TAG", "listonResponse--------------");
                        //解析数据
                        processeData(response);
                    }
                });
    }

    /**
     * 解析热映数据
     * @param response
     */
    private void processeData(String response) {
        Hotbean hotbean = new Gson().fromJson(response, Hotbean.class);
        movielist = hotbean.getData().getMovies();

        adapter.setviewlist(movielist);
        adapter.notifyItemRangeChanged(0, movielist.size());
    }
}
