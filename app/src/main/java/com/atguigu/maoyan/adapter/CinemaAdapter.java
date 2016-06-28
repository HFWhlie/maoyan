package com.atguigu.maoyan.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.URL;
import com.atguigu.maoyan.bean.CinemaPagerbean;
import com.atguigu.maoyan.bean.Citybean;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Request;

/**
 * Created by tao on 2016/6/28.
 */
public class CinemaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int ONE = 0;
    private static final int TWO = 1;
    private Context context;
    private Citybean.DataBean data;

    public CinemaAdapter(Context context, Citybean.DataBean data) {
        this.context =context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == ONE){
            View view = View.inflate(context, R.layout.cinema_pager, null);
            return new CinemapagerHolder(view);
        }
        if(viewType == TWO) {
            return null;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof CinemapagerHolder) {
            ((CinemapagerHolder)holder).setData();
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return ONE;
        }
        return TWO;
    }

    /**
     * viewpager的holder
     */
    private class CinemapagerHolder extends RecyclerView.ViewHolder {
        private ViewPager vp_cinema;
        private TextView tv_login;
        private String cinemaPagerurl;
        private CinemapagerAdapter adapter;
        private List<CinemaPagerbean.DataBean> data;

        public CinemapagerHolder(View view) {
            super(view);
            tv_login = (TextView) view.findViewById(R.id.tv_login);
            vp_cinema = (ViewPager) view.findViewById(R.id.vp_cinema);
        }

        public void setData() {
            cinemaPagerurl = URL.cinemaPagerurl;
            getFromNetData();
        }

        private void getFromNetData() {
            OkHttpUtils.get().url(cinemaPagerurl).build().execute(new StringCallback() {
                @Override
                public void onError(Request request, Exception e) {
                    Log.e("TAG", "影院viewpager数据请求失败");
                }

                @Override
                public void onResponse(String response) {
                    Log.e("TAG", "影院viewpager数据请求成功");
                    pressData(response);
                }
            });
        }

        private void pressData(String response) {
            CinemaPagerbean cinemaPagerbean = new Gson().fromJson(response, CinemaPagerbean.class);
            data = cinemaPagerbean.getData();
            adapter = new CinemapagerAdapter(context,data);
            vp_cinema.setAdapter(adapter);

            //轮播图
            //定位到中间
            vp_cinema.setCurrentItem(50);
            //首先移除所有消息

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

                vp_cinema.setCurrentItem((vp_cinema.getCurrentItem()+1));
                //再次发消息
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
