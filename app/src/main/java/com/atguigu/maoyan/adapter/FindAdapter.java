package com.atguigu.maoyan.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.URL;
import com.atguigu.maoyan.bean.FindPagerbean;
import com.atguigu.maoyan.bean.Findbean;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Request;

/**
 * Created by tao on 2016/6/28.
 */
public class FindAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int ONE = 0;
    private static final int TWO = 1;
    private Context context;
    private List<Findbean.DataBean.FeedsBean> feedslist;

    public FindAdapter(Context context, List<Findbean.DataBean.FeedsBean> feeds) {
        this.context = context;
        this.feedslist = feeds;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType == ONE){
            View view = View.inflate(context, R.layout.find_pager, null);
            return new FindPagerHolder(view);
        }
        if(viewType == TWO){

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof FindPagerHolder){
            if(position == 0){
                ((FindPagerHolder)holder).setData();
            }
        }

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0) {
            return ONE;
        }
        return TWO;
    }

    private class FindPagerHolder extends RecyclerView.ViewHolder {
        private ViewPager vp_find;
        private String findPagerurl;
        private FindpagerAdapter adapter;

        public FindPagerHolder(View view) {
            super(view);
            vp_find = (ViewPager) view.findViewById(R.id.vp_find);
        }

        public void setData() {
            findPagerurl = URL.findPagerurl;
            getFromNetData();
        }

        private void getFromNetData() {
            OkHttpUtils.get().url(findPagerurl).build().execute(new StringCallback() {
                @Override
                public void onError(Request request, Exception e) {
                    Log.e("TAG", "发现Viewpager数据请求失败");
                }

                @Override
                public void onResponse(String response) {
                    Log.e("TAG", "发现Viewpager数据请求成功");
                    pressData(response);
                }
            });
        }

        private void pressData(String response) {
            FindPagerbean findPagerbean = new Gson().fromJson(response, FindPagerbean.class);
            List<FindPagerbean.DataBean> data = findPagerbean.getData();
            adapter = new FindpagerAdapter(context,data);
            vp_find.setAdapter(adapter);

            vp_find.setCurrentItem(50);

            if(initHandler == null){
                initHandler = new InitHandler();
            }
            initHandler.removeCallbacksAndMessages(null);
            initHandler.postDelayed(new Myrunnable(),2000);

        }

        private InitHandler initHandler;
        private class InitHandler extends Handler{
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                vp_find.setCurrentItem(vp_find.getCurrentItem() + 1);
                initHandler.postDelayed(new Myrunnable(),2000);
            }
        }

        private class Myrunnable implements Runnable {
            @Override
            public void run() {
                initHandler.sendEmptyMessage(0);
            }
        }
    }
}
