package com.atguigu.maoyan.pager;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.URL;
import com.atguigu.maoyan.adapter.OverseasAdapter;
import com.atguigu.maoyan.bean.Nationbean;
import com.atguigu.maoyan.fregrament.BaseFregrament;
import com.atguigu.maoyan.pager.OverseasFregrament.HanFregrament;
import com.atguigu.maoyan.pager.OverseasFregrament.MeiFregrament;
import com.atguigu.maoyan.pager.OverseasFregrament.RiFregrament;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

/**
 * Created by tao on 2016/6/24.
 */
public class Overseaspager extends Basepager {
    private TabLayout tb;
    private ViewPager vp;
    private View view;
    //页面集合
    private List<BaseFregrament> list;
    private OverseasAdapter adapter;
    private static int currentPostion = 0;
    //标题的请求地址
    private String overseastitleurl;
    //国家的集合
    private List<Nationbean.DataBean.AreasBean> areas;

    public Overseaspager(Context context) {
        super(context);
    }

    @Override
    public View initview() {
        view = View.inflate(context, R.layout.overseas_pager, null);
        findview();
        return view;
    }

    private void findview() {
        tb = (TabLayout) view.findViewById(R.id.tb);
        vp = (ViewPager) view.findViewById(R.id.vp);


    }

    @Override
    public void initData() {
        isInitData = true;

        //准备数据
        list = new ArrayList();
        list.add(new MeiFregrament(context));
        list.add(new HanFregrament(context));
        list.add(new RiFregrament(context));
        //获取头部数据
        getTitleData();



    }

    /**
     * 获取头部数据
     */
    private void getTitleData() {
        overseastitleurl = URL.overseastitleurl;
        getFromNetData();
    }

    private void getFromNetData() {
        OkHttpUtils.get().url(overseastitleurl).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Log.e("TAG", "获取标题数据失败");
            }

            @Override
            public void onResponse(String response) {
                Log.e("TAG", "获取标题数据成功");
                pressData(response);
            }
        });
    }

    /**
     * 解析并显示数据
     * @param response
     */
    private void pressData(String response) {
        Nationbean nationbean = new Gson().fromJson(response, Nationbean.class);
        areas = nationbean.getData().getAreas();
        //设置title
        for (int i = 0;i<areas.size();i++){
            tb.addTab(tb.newTab().setText(areas.get(i).getName()));
        }
        tb.setTabTextColors(Color.GRAY, Color.RED);

        //设置适配器
        adapter = new OverseasAdapter(list, areas);
        vp.setAdapter(adapter);
        //TabLayout与ViewPager关联
        tb.setupWithViewPager(vp);

        //设置页面改变的监听
        vp.addOnPageChangeListener(new OnPageChangeListener());

        //默认选中第一项
        list.get(0).initData();
        vp.setCurrentItem(0);
    }


    private class OnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            //当选中这个页面时，加载数据
            list.get(position).initData();
            currentPostion = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
