package com.atguigu.maoyan.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.URL;
import com.atguigu.maoyan.bean.AllmovPicturebean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import okhttp3.Request;

public class AllmovActivity extends Activity {
    private ImageView iv_back;
    private ImageView iv_top;
    private TextView tvDescribe1;
    private ImageView iv1;
    private TextView tvDescribe2;
    private ImageView iv2;
    private TextView describe3;
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
    //影库最上面图片的地址
    private String movurl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allmov);

        findView();
        setData();
    }

    //设置数据
    private void setData() {
        //影库最上面的图片接口
        movurl = URL.movurl;
        //联网请求图片
        getFromNetData();
    }

    private void getFromNetData() {
        OkHttpUtils.get().url(movurl).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Log.e("TAG", "影库最上面的图片请求失败");
            }

            @Override
            public void onResponse(String response) {
                Log.e("TAG", "影库最上面的图片请求成功");
                pressData(response);
            }
        });
    }

    /**
     * 最上面的图片
     * 解析并显示数据
     * @param response
     */
    private void pressData(String response) {
        AllmovPicturebean allmovPicturebean = new Gson().fromJson(response, AllmovPicturebean.class);
        List<AllmovPicturebean.DataBean> data = allmovPicturebean.getData();
        tv_content.setText(data.get(0).getContent());
        tv_objname.setText(data.get(0).getObjectName() + data.get(0).getPubDate());
        long date = data.get(0).getDate();
        Date dat=new Date(date);
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dat);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM");
        String sb=format.format(gc.getTime());
        tv_data.setText(sb);
        //显示数据
        Glide.with(this).load(data.get(0).getHorImg())
                .placeholder(R.drawable.background_icon01)
                .error(R.drawable.background_icon01)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(iv_top);
    }

    //初始化
    private void findView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_top = (ImageView) findViewById(R.id.iv_top);
        tvDescribe1 = (TextView) findViewById(R.id.tv_describe1);
        iv1 = (ImageView) findViewById(R.id.iv1);
        tvDescribe2 = (TextView) findViewById(R.id.tv_describe2);
        iv2 = (ImageView) findViewById(R.id.iv2);
        describe3 = (TextView) findViewById(R.id.describe3);
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
