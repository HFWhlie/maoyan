package com.atguigu.maoyan.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.URL;
import com.atguigu.maoyan.adapter.ShoptextAdapter;
import com.atguigu.maoyan.bean.Shumabean;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Request;

/**
 * Created by tao on 2016/7/2.
 * 高玩专区等
 */
public class ShopPagerActivity extends Activity {
    private Context context;
    private ImageView iv_back;
    private TextView tv_select;
    private RecyclerView rv;
    private ShoptextAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoppager_activity);
        context = this;
        findView();
        initData();
    }

    private void initData() {
        int flags = getIntent().getFlags();
        switch (flags) {
            case 0://星球大战
                tv_select.setText("星球大战");
                String xqdzurl = URL.xqdzurl;
                getFromNetData(xqdzurl, flags);
                break;
            case 1://数码
                tv_select.setText("数码");
                String smurl = URL.smurl;
                getFromNetData(smurl, flags);
                break;
            case 2://高玩
                tv_select.setText("高玩");
                String gwurl = URL.gwurl;
                getFromNetData(gwurl, flags);
                break;
            case 3://玩具
                tv_select.setText("玩具");
                String wjurl = URL.wjurl;
                getFromNetData(wjurl, flags);
                break;
            case 4://生活
                tv_select.setText("生活");
                String shurl = URL.shurl;
                getFromNetData(shurl, flags);
                break;
            case 5://服饰
                tv_select.setText("服饰");
                String fsurl = URL.fsurl;
                getFromNetData(fsurl, flags);
                break;
            case 6://超蝙
                tv_select.setText("超蝙");
                String cburl = URL.cburl;
                getFromNetData(cburl, flags);
                break;
            case 7://机器猫
                tv_select.setText("机器猫");
                String jqmurl = URL.jqmurl;
                getFromNetData(jqmurl, flags);
                break;
            case 8://魔兽
                tv_select.setText("魔兽");
                String msurl = URL.msurl;
                getFromNetData(msurl, flags);
                break;
            case 9://美队
                tv_select.setText("美队");
                String mdurl = URL.mdurl;
                getFromNetData(mdurl, flags);
                break;
        }
    }

    private void getFromNetData(String url, final int flags) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Request request, Exception e) {
                Log.e("TAG", "商城数据请求失败");
            }

            @Override
            public void onResponse(String response) {
                Log.e("TAG", "商城数据请求成功");
                pressData(response, flags);
            }
        });

    }

    private void pressData(String response, int flags) {
        if (flags == 1) {
            Shumabean shumabean = new Gson().fromJson(response, Shumabean.class);
            List<Shumabean.DataBean.ListBean> data = shumabean.getData().getList();
            adapter = new ShoptextAdapter(context, data);
        }

        if (flags == 2) {
            Shumabean shumabean = new Gson().fromJson(response, Shumabean.class);
            List<Shumabean.DataBean.ListBean> data = shumabean.getData().getList();
            adapter = new ShoptextAdapter(context, data);
        }
        if (flags == 2) {
            Shumabean shumabean = new Gson().fromJson(response, Shumabean.class);
            List<Shumabean.DataBean.ListBean> data = shumabean.getData().getList();
            adapter = new ShoptextAdapter(context, data);
        }
        if (flags == 3) {
            Shumabean shumabean = new Gson().fromJson(response, Shumabean.class);
            List<Shumabean.DataBean.ListBean> data = shumabean.getData().getList();
            adapter = new ShoptextAdapter(context, data);
        }
        if (flags == 4) {
            Shumabean shumabean = new Gson().fromJson(response, Shumabean.class);
            List<Shumabean.DataBean.ListBean> data = shumabean.getData().getList();
            adapter = new ShoptextAdapter(context, data);
        }
        if (flags == 5) {
            Shumabean shumabean = new Gson().fromJson(response, Shumabean.class);
            List<Shumabean.DataBean.ListBean> data = shumabean.getData().getList();
            adapter = new ShoptextAdapter(context, data);
        }
        if (flags == 6) {
            Shumabean shumabean = new Gson().fromJson(response, Shumabean.class);
            List<Shumabean.DataBean.ListBean> data = shumabean.getData().getList();
            adapter = new ShoptextAdapter(context, data);
        }
        if (flags == 7) {
            Shumabean shumabean = new Gson().fromJson(response, Shumabean.class);
            List<Shumabean.DataBean.ListBean> data = shumabean.getData().getList();
            adapter = new ShoptextAdapter(context, data);
        }
        if (flags == 8) {
            Shumabean shumabean = new Gson().fromJson(response, Shumabean.class);
            List<Shumabean.DataBean.ListBean> data = shumabean.getData().getList();
            adapter = new ShoptextAdapter(context, data);
        }
        if (flags == 9) {
            Shumabean shumabean = new Gson().fromJson(response, Shumabean.class);
            List<Shumabean.DataBean.ListBean> data = shumabean.getData().getList();
            adapter = new ShoptextAdapter(context, data);
        }
        if (flags == 0) {
            Shumabean shumabean = new Gson().fromJson(response, Shumabean.class);
            List<Shumabean.DataBean.ListBean> data = shumabean.getData().getList();
            adapter = new ShoptextAdapter(context, data);
        }
        GridLayoutManager manager = new GridLayoutManager(context, 2);
        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);
    }

    private void findView() {
        rv = (RecyclerView) findViewById(R.id.rv);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        tv_select = (TextView)findViewById(R.id.tv_select);
    }
}
