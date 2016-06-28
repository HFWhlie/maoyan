package com.atguigu.maoyan.fregrament;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.URL;
import com.atguigu.maoyan.adapter.CinemaAdapter;
import com.atguigu.maoyan.bean.Citybean;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Request;

/**
 * Created by tao on 2016/6/24.
 * 影院
 */
public class CinemaFregrament extends BaseFregrament {

    private View view;
    private RecyclerView rl_cinema;
    //影院接口
    private String cinemaurl;
    private CinemaAdapter adapter;

    public CinemaFregrament(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        view = View.inflate(context, R.layout.cinema_fregrament,null);
        findView();
        return view;
    }

    private void findView() {
        rl_cinema = (RecyclerView) view.findViewById(R.id.rl_cinema);
    }

    @Override
    public void initData() {
        cinemaurl = URL.cinemaurl;

        getFromNetData();
    }

    /**
     * 联网请求
     */
    private void getFromNetData() {
        OkHttpUtils.get().url(cinemaurl).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Log.e("TAG", "影院数据请求失败");
            }

            @Override
            public void onResponse(String response) {
                Log.e("TAG", "影院数据请求成功");
                pressData(response);
            }
        });
    }

    /**
     * 解析并显示数据
     * @param response
     */
    private void pressData(String response) {
        response.replace("朝阳区", "chaoyang");
        response.replace("海淀区", "haidian");
        response.replace("东城区", "dongcheng");
        response.replace("丰台区", "fengtai");
        response.replace("大兴区", "daxing");
        response.replace("新城区", "xicheng");
        response.replace("通州区", "tongzhou");
        response.replace("昌平区", "changping");
        response.replace("房山区", "fangshan");
        response.replace("顺义区", "shunyi");
        response.replace("门头沟区", "mentougou");
        response.replace("石景山区", "shijingshan");
        response.replace("怀柔区", "huairou");
        response.replace("平谷区", "pinggu");
        response.replace("密云县", "miyun");
        response.replace("延庆县", "yanqing");
        Citybean citybean = new Gson().fromJson(response, Citybean.class);
        Citybean.DataBean data = citybean.getData();
        rl_cinema.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        adapter = new CinemaAdapter(context,data);
        rl_cinema.setAdapter(adapter);
    }
}
