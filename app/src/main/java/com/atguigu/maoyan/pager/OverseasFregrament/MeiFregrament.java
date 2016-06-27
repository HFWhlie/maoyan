package com.atguigu.maoyan.pager.OverseasFregrament;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.URL;
import com.atguigu.maoyan.adapter.MeiguoAdapter;
import com.atguigu.maoyan.bean.Meibean;
import com.atguigu.maoyan.fregrament.BaseFregrament;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Request;

/**
 * Created by tao on 2016/6/25.
 */
public class MeiFregrament extends BaseFregrament {

    private View view;
    private RecyclerView rl_mei;
    //美国的请求地址
    private String meiurl;
    private MeiguoAdapter adapter;

    public MeiFregrament(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        view = View.inflate(context, R.layout.mei_fregrament,null);
        findView();
        return view;
    }

    private void findView() {
        rl_mei = (RecyclerView) view.findViewById(R.id.rl_mei);
    }

    @Override
    public void initData() {

        meiurl = URL.meiurl;
        getFromNetData();

    }

    /**
     * 联网请求
     */
    private void getFromNetData() {
        OkHttpUtils.get().url(meiurl).build().execute(new StringCallback() {
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
        Meibean meibean = new Gson().fromJson(response, Meibean.class);
        List<Meibean.DataBean.ComingBean> coming = meibean.getData().getComing();

        rl_mei.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        adapter = new MeiguoAdapter(context,coming);
        rl_mei.setAdapter(adapter);

    }
}
