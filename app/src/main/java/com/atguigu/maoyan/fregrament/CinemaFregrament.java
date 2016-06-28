package com.atguigu.maoyan.fregrament;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

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

    private RelativeLayout rl_showadress;

    public CinemaFregrament(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        view = View.inflate(context, R.layout.cinema_fregrament, null);
        findView();
        return view;
    }

    private void findView() {
        rl_cinema = (RecyclerView) view.findViewById(R.id.rl_cinema);
        rl_showadress = (RelativeLayout) view.findViewById(R.id.rl_showadress);
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
     *
     * @param response
     */
    private void pressData(String response) {
        response = response.replace("朝阳区", "chaoyangqu");
        response = response.replace("海淀区", "haidianqu");
        response = response.replace("东城区", "dongchengqu");
        response = response.replace("丰台区", "fengtaiqu");
        response = response.replace("大兴区", "daxingqu");
        response = response.replace("西城区", "xichengqu");
        response = response.replace("通州区", "tongzhouqu");
        response = response.replace("昌平区", "changpingqu");
        response = response.replace("房山区", "fangshanqu");
        response = response.replace("顺义区", "shunyiqu");
        response = response.replace("门头沟区", "mentougouqu");
        response = response.replace("石景山区", "shijingshanqu");
        response = response.replace("怀柔区", "huairouqu");
        response = response.replace("平谷区", "pingguqu");
        response = response.replace("密云县", "miyunxian");
        response = response.replace("延庆县", "yanqingxian");
        Citybean citybean = new Gson().fromJson(response, Citybean.class);
        Citybean.DataBean data = citybean.getData();
        rl_cinema.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        adapter = new CinemaAdapter(context, data);
        rl_cinema.setAdapter(adapter);
        //使下面隐藏
        rl_cinema.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        case MotionEvent.ACTION_MOVE:
                            rl_showadress.setVisibility(View.GONE);
                            break;
                        case MotionEvent.ACTION_UP:
                            rl_showadress.setVisibility(View.VISIBLE);
                            break;
                }
                return false;
            }
        });
    }


}
