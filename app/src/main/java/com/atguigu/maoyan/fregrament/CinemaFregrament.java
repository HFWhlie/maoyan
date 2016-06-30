package com.atguigu.maoyan.fregrament;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.URL;
import com.atguigu.maoyan.activity.HotHfive;
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
public class CinemaFregrament extends BaseFregrament implements View.OnClickListener {

    private View view;
    private RecyclerView rl_cinema;
    private ProgressBar pb;
    private ImageView iv_pb;
    private LinearLayout ll_show;
    //影院接口
    private String cinemaurl;
    private CinemaAdapter adapter;

    private RelativeLayout rl_showadress;
    private LinearLayout ll_city;
    private ImageView iv_cityseach;
    private ImageView iv_seach;

    public CinemaFregrament(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        view = View.inflate(context, R.layout.cinema_fregrament, null);
        findView();
        setlistener();
        return view;
    }

    private void findView() {
        rl_cinema = (RecyclerView) view.findViewById(R.id.rl_cinema);
        rl_showadress = (RelativeLayout) view.findViewById(R.id.rl_showadress);
        pb = (ProgressBar) view.findViewById(R.id.pb);
        iv_pb = (ImageView) view.findViewById(R.id.iv_pb);
        iv_cityseach = (ImageView) view.findViewById(R.id.iv_cityseach);
        iv_seach = (ImageView) view.findViewById(R.id.iv_seach);

        ll_show = (LinearLayout) view.findViewById(R.id.ll_show);
        ll_city = (LinearLayout) view.findViewById(R.id.ll_city);
    }

    private void setlistener() {
        ll_show.setOnClickListener(this);
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
        pb.setVisibility(View.VISIBLE);
        iv_pb.setVisibility(View.VISIBLE);
        ll_show.setVisibility(View.GONE);
        OkHttpUtils.get().url(cinemaurl).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Log.e("TAG", "影院数据请求失败");
                pb.setVisibility(View.GONE);
                iv_pb.setVisibility(View.GONE);
                ll_show.setVisibility(View.VISIBLE);
            }

            @Override
            public void onResponse(String response) {
                Log.e("TAG", "影院数据请求成功");
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
                switch (event.getAction()) {
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

        adapter.setOnCinemaitemListener(new CinemaAdapter.OnCinemaitemListener() {
            @Override
            public void onCinemaitemListener(Citybean.DataBean.changpingquBean changpingquBean) {
                Intent intent = new Intent(context, HotHfive.class);
                String cinemaname = changpingquBean.getNm();
                intent.putExtra("cinema",cinemaname);
                intent.setFlags(3);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_show://当联网失败，再次请求
                getFromNetData();
                break;

            case R.id.ll_city://城市选择
                Toast.makeText(context,"城市选择",Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_cityseach://城市搜索
                Toast.makeText(context,"城市搜索",Toast.LENGTH_SHORT).show();
                break;

            case R.id.iv_seach://搜索
                Toast.makeText(context,"搜索",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
