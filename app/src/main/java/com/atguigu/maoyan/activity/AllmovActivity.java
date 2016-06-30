package com.atguigu.maoyan.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.URL;
import com.atguigu.maoyan.adapter.GlobalAdapter;
import com.atguigu.maoyan.bean.AllmovPicturebean;
import com.atguigu.maoyan.bean.Americabean;
import com.atguigu.maoyan.bean.Classify;
import com.atguigu.maoyan.bean.Expectbean;
import com.atguigu.maoyan.bean.Globalbean;
import com.atguigu.maoyan.bean.Priesabean;
import com.atguigu.maoyan.bean.Toneheadbean;
import com.atguigu.maoyan.bean.Topbean;
import com.atguigu.maoyan.bean.Tthrheadbean;
import com.atguigu.maoyan.bean.Ttwoheadbean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import okhttp3.Request;

public class AllmovActivity extends Activity {

    private Context context;
    private ImageView iv_back;
    private ImageView iv_top;
    private TextView tvDescribe1;
    private ImageView iv1;
    private TextView tvDescribe2;
    private ImageView iv2;
    private TextView tvDescribe3;
    private ImageView iv3;
    private TextView tvDescribe4;
    private ImageView iv4;
    private ImageView ivT1;
    private TextView tvTname1;
    private TextView tvFen1;
    private ImageView ivT2;
    private TextView tvTname2;
    private TextView tvFen2;
    private ImageView ivT3;
    private TextView tvTname3;
    private TextView tvFen3;
    private RecyclerView recylerview;
    private LinearLayout ll_allmovie;
    private Button btnYingkuDonghua;
    private Button btnYingkuXiju;
    private Button btnYingkuKongbu;
    private Button btnYingkuAiqing;
    private Button btnYingkuKehuan;
    private Button btnYingkuDongzuo;
    private Button btnYingkuJuqing;
    private Button btnYingkuJingsong;
    private Button btnYingkuZhanzheng;
    private Button btnYingkuFanzui;
    private Button btnYingkuXuanyi;
    private Button btMei;
    private Button btChina;
    private Button btRi;
    private Button btHan;
    private Button btGt;
    private LinearLayout ll_allclassify;
    private TextView tv_data;
    private TextView tv_content;
    private TextView tv_objname;


    private String movurl;
    private String praiseurl;
    private String expecturl;
    private String americaurl;
    private String topurl;
    private ArrayList list;
    private String toneurl;
    private String toneheadurl;
    private String ttwourl;
    private String ttwoheadurl;
    private String tthrurl;
    private String tthrheadurl;
    private String globalurl;
    private GlobalAdapter adapter;
    private String classifyurl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allmov);
        context = this;

        findView();
        setData();
    }

    //设置数据
    private void setData() {
        //影库最上面的图片的地址
        movurl = URL.movurl;
        //热门口碑的地址
        praiseurl = URL.praiseurl;
        //最受期待的地址
        expecturl = URL.expecturl;
        //北美票房的地址
        americaurl = URL.americaurl;
        //TOP100的地址
        topurl = URL.topurl;
        //推荐1
        toneurl = URL.toneurl;
        toneheadurl = URL.toneheadurl;
        //推荐2
        ttwourl = URL.ttwourl;
        ttwoheadurl = URL.ttwoheadurl;
        //推荐3
        tthrurl = URL.tthrurl;
        tthrheadurl = URL.tthrheadurl;
        //全球电影奖项
        globalurl = URL.globalurl;
        //全部分类
        classifyurl = URL.classifyurl;
        list = new ArrayList();
        list.add(movurl);
        list.add(praiseurl);
        list.add(expecturl);
        list.add(americaurl);
        list.add(topurl);
        list.add(toneheadurl);
        list.add(ttwoheadurl);
        list.add(tthrheadurl);
        list.add(globalurl);
        list.add(classifyurl);


        //联网请求图片
        for (int i = 0; i < list.size(); i++) {
            getFromNetData((String) list.get(i), i);
        }

    }

    private void getFromNetData(String url, final int i) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Log.e("TAG", "影库最上面的图片请求失败");
            }

            @Override
            public void onResponse(String response) {
                Log.e("TAG", "影库最上面的图片请求成功");
                pressData(response, i);
            }
        });
    }

    /**
     * 解析并显示数据
     *
     * @param response
     * @param i
     */
    private void pressData(String response, final int i) {
        if (i == 0) {//最上面的图片
            AllmovPicturebean allmovPicturebean = new Gson().fromJson(response, AllmovPicturebean.class);
            List<AllmovPicturebean.DataBean> data = allmovPicturebean.getData();
            tv_content.setText(data.get(0).getContent());
            tv_objname.setText(data.get(0).getObjectName() + data.get(0).getPubDate());
            long date = data.get(0).getDate();
            Date dat = new Date(date);
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(dat);
            SimpleDateFormat format = new SimpleDateFormat("dd/MM");
            String sb = format.format(gc.getTime());
            tv_data.setText(sb);

            Glide.with(this).load(data.get(0).getHorImg())
                    .placeholder(R.drawable.background_icon01)
                    .error(R.drawable.background_icon01)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(iv_top);
        }

        if (i == 1) {//热映口碑
            Priesabean priesabean = new Gson().fromJson(response, Priesabean.class);
            Priesabean.DataBean data = priesabean.getData();
            tvDescribe1.setText(data.getMovies().get(0).getNm());
            Glide.with(this).load(data.getMovies().get(0).getImg())
                    .placeholder(R.drawable.background_icon01)
                    .error(R.drawable.background_icon01)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(iv1);
        }

        if (i == 2) {//最受期待
            Expectbean expectbean = new Gson().fromJson(response, Expectbean.class);
            Expectbean.DataBean data = expectbean.getData();
            tvDescribe2.setText(data.getMovies().get(0).getNm());
            Glide.with(this).load(data.getMovies().get(0).getImg())
                    .placeholder(R.drawable.background_icon01)
                    .error(R.drawable.background_icon01)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(iv2);
        }
        if (i == 3) {//北美票房
            Americabean americabean = new Gson().fromJson(response, Americabean.class);
            Americabean.DataBean data = americabean.getData();
            tvDescribe3.setText(data.getMovies().get(0).getNm());
            Glide.with(this).load(data.getMovies().get(0).getImg())
                    .placeholder(R.drawable.background_icon01)
                    .error(R.drawable.background_icon01)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(iv3);
        }
        if (i == 4) {//TOP100
            Topbean topbean = new Gson().fromJson(response, Topbean.class);
            Topbean.DataBean data = topbean.getData();
            tvDescribe4.setText(data.getMovies().get(0).getNm());
            Glide.with(this).load(data.getMovies().get(0).getImg())
                    .placeholder(R.drawable.background_icon01)
                    .error(R.drawable.background_icon01)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(iv4);
        }

        if (i == 5) {//推荐1
            Toneheadbean toneheadbean = new Gson().fromJson(response, Toneheadbean.class);
            Toneheadbean.DataBean data = toneheadbean.getData();
            tvTname1.setText(data.getMovie().getNm());
            tvFen1.setText(data.getMovie().getSc() + "");
            Glide.with(this).load(toneurl)
                    .placeholder(R.drawable.background_icon01)
                    .error(R.drawable.background_icon01)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(ivT1);
        }

        if (i == 6) {//推荐2
            Ttwoheadbean ttwoheadbean = new Gson().fromJson(response, Ttwoheadbean.class);
            Ttwoheadbean.DataBean data = ttwoheadbean.getData();
            tvTname2.setText(data.getMovie().getNm());
            tvFen2.setText(data.getMovie().getSc() + "");
            Glide.with(this).load(ttwourl)
                    .placeholder(R.drawable.background_icon01)
                    .error(R.drawable.background_icon01)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(ivT2);
        }
        if (i == 7) {//推荐3
            Tthrheadbean tthrheadbean = new Gson().fromJson(response, Tthrheadbean.class);
            Tthrheadbean.DataBean data = tthrheadbean.getData();
            tvTname3.setText(data.getMovie().getNm());
            tvFen3.setText(data.getMovie().getSc() + "");
            Glide.with(this).load(tthrurl)
                    .placeholder(R.drawable.background_icon01)
                    .error(R.drawable.background_icon01)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(ivT3);
        }
        if (i == 8) {
            Globalbean globalbean = new Gson().fromJson(response, Globalbean.class);
            List<Globalbean.ListBean> list = globalbean.getList();
            Log.e("TAG","list ===="+list);
            recylerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            adapter = new GlobalAdapter(context,list);
            recylerview.setAdapter(adapter);
        }

        if(i == 9) {
            Classify classify = new Gson().fromJson(response, Classify.class);
            final List<Classify.DataBean> data = classify.getData();
            ll_allmovie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, KnobActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("list", (Serializable) data);
                    intent.putExtras(bundle);
                    context.startActivity(intent);

                }
            });
        }

    }

    //初始化
    private void findView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_top = (ImageView) findViewById(R.id.iv_top);
        tvDescribe1 = (TextView) findViewById(R.id.tv_describe1);
        iv1 = (ImageView) findViewById(R.id.iv1);
        tvDescribe2 = (TextView) findViewById(R.id.tv_describe2);
        iv2 = (ImageView) findViewById(R.id.iv2);
        tvDescribe3 = (TextView) findViewById(R.id.describe3);
        iv3 = (ImageView) findViewById(R.id.iv3);
        tvDescribe4 = (TextView) findViewById(R.id.tv_describe4);
        iv4 = (ImageView) findViewById(R.id.iv4);
        ivT1 = (ImageView) findViewById(R.id.iv_t1);
        tvTname1 = (TextView) findViewById(R.id.tv_tname1);
        tvFen1 = (TextView) findViewById(R.id.tv_fen1);
        ivT2 = (ImageView) findViewById(R.id.iv_t2);
        tvTname2 = (TextView) findViewById(R.id.tv_tname2);
        tvFen2 = (TextView) findViewById(R.id.tv_fen2);
        ivT3 = (ImageView) findViewById(R.id.iv_t3);
        tvTname3 = (TextView) findViewById(R.id.tv_tname3);
        tvFen3 = (TextView) findViewById(R.id.tv_fen3);
        tv_data = (TextView) findViewById(R.id.tv_data);
        tv_content = (TextView) findViewById(R.id.tv_content);
        tv_objname = (TextView) findViewById(R.id.tv_objname);

        recylerview = (RecyclerView) findViewById(R.id.recylerview);
        ll_allmovie = (LinearLayout) findViewById(R.id.ll_allmovie);
        ll_allclassify = (LinearLayout) findViewById(R.id.ll_allclassify);

        btnYingkuDonghua = (Button) findViewById(R.id.btn_yingku_donghua);
        btnYingkuXiju = (Button) findViewById(R.id.btn_yingku_xiju);
        btnYingkuKongbu = (Button) findViewById(R.id.btn_yingku_kongbu);
        btnYingkuAiqing = (Button) findViewById(R.id.btn_yingku_aiqing);
        btnYingkuKehuan = (Button) findViewById(R.id.btn_yingku_kehuan);
        btnYingkuDongzuo = (Button) findViewById(R.id.btn_yingku_dongzuo);
        btnYingkuJuqing = (Button) findViewById(R.id.btn_yingku_juqing);
        btnYingkuJingsong = (Button) findViewById(R.id.btn_yingku_jingsong);
        btnYingkuZhanzheng = (Button) findViewById(R.id.btn_yingku_zhanzheng);
        btnYingkuFanzui = (Button) findViewById(R.id.btn_yingku_fanzui);
        btnYingkuXuanyi = (Button) findViewById(R.id.btn_yingku_xuanyi);
        btMei = (Button) findViewById(R.id.bt_mei);
        btChina = (Button) findViewById(R.id.bt_china);
        btRi = (Button) findViewById(R.id.bt_ri);
        btHan = (Button) findViewById(R.id.bt_han);
        btGt = (Button) findViewById(R.id.bt_gt);
    }

}
