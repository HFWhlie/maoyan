package com.atguigu.maoyan.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.URL;
import com.atguigu.maoyan.adapter.ShoptextAdapter;
import com.atguigu.maoyan.bean.Shumabean;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

/**
 * Created by tao on 2016/7/2.
 * 高玩专区等
 */
public class ShopPagerActivity extends Activity implements View.OnClickListener {
    private Context context;
    private ImageView iv_back;
    private TextView tv_select;
    private RecyclerView rv;
    private ShoptextAdapter adapter;
    private LinearLayout ll_isenable1;
    private LinearLayout ll_isenable2;
    private LinearLayout ll_isenable3;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoppager_activity);
        context = this;
        findView();
        initData();
        setlistener();
    }

    private void setlistener() {
        ll_isenable1.setOnClickListener(this);
        ll_isenable2.setOnClickListener(this);
        ll_isenable3.setOnClickListener(this);
        iv_back.setOnClickListener(this);
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
        ll_isenable1 = (LinearLayout) findViewById(R.id.ll_isenable1);
        ll_isenable2 = (LinearLayout) findViewById(R.id.ll_isenable2);
        ll_isenable3 = (LinearLayout) findViewById(R.id.ll_isenable3);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_isenable1:
                showPopupWindow1();
                break;
            case R.id.ll_isenable2:
                showPopupWindow2();
                break;
            case R.id.ll_isenable3:
                showPopupWindow3();
                break;

        }
    }

    private void showPopupWindow3() {
        PopupWindow popupWindow = new PopupWindow();
        popupWindow.setWidth(rv.getWidth());
        popupWindow.setHeight(500);
        popupWindow.setContentView(listView);
        // 需要设置一下此参数，点击外边可消失
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //设置点击窗口外边窗口消失
        popupWindow.setOutsideTouchable(true);
        // 设置此参数获得焦点，否则无法点击
        popupWindow.setFocusable(true);

        popupWindow.showAsDropDown(ll_isenable1, 0, 0);

        final List list = new ArrayList();
        list.add("默认排序");
        list.add("价格从低到高");
        list.add("价格从高到低");
        list.add("销量最多");
        list.add("销量最小");
        list.add("最近更新");
        list.add("最远更新");
        listView = new ListView(context);
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView tv = new TextView(context);
                tv.setText(list.get(position) + "");
                tv.setHeight(iv_back.getHeight());
                tv.setWidth(rv.getWidth());
                tv.setGravity(Gravity.VERTICAL_GRAVITY_MASK);
                tv.setTextSize(18);
                tv.setBackgroundColor(Color.WHITE);
                return tv;
            }
        });
    }

    private void showPopupWindow2() {
        PopupWindow popupWindow = new PopupWindow();
        popupWindow.setWidth(rv.getWidth());
        popupWindow.setHeight(500);
        popupWindow.setContentView(listView);
        // 需要设置一下此参数，点击外边可消失
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //设置点击窗口外边窗口消失
        popupWindow.setOutsideTouchable(true);
        // 设置此参数获得焦点，否则无法点击
        popupWindow.setFocusable(true);

        popupWindow.showAsDropDown(ll_isenable1, 0, 0);

        final List list = new ArrayList();
        list.add("全部/未分类的");
        list.add("数码");
        list.add("高玩");
        list.add("玩具");
        list.add("生活");
        list.add("服饰");
        list.add("3C配件");
        list.add("箱包");
        list.add("手办公仔");
        list.add("电影原著");
        list.add("配饰");
        list.add("家纺");
        list.add("文具");
        list.add("毛绒公仔");
        listView = new ListView(context);
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView tv = new TextView(context);
                tv.setText(list.get(position) + "");
                tv.setHeight(iv_back.getHeight());
                tv.setWidth(rv.getWidth());
                tv.setGravity(Gravity.VERTICAL_GRAVITY_MASK);
                tv.setTextSize(18);
                tv.setBackgroundColor(Color.WHITE);
                return tv;
            }
        });
    }

    private void showPopupWindow1() {

        PopupWindow popupWindow = new PopupWindow();
        popupWindow.setWidth(rv.getWidth());
        popupWindow.setHeight(500);
        popupWindow.setContentView(listView);
        // 需要设置一下此参数，点击外边可消失
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //设置点击窗口外边窗口消失
        popupWindow.setOutsideTouchable(true);
        // 设置此参数获得焦点，否则无法点击
        popupWindow.setFocusable(true);

        popupWindow.showAsDropDown(ll_isenable1, 0, 0);

        final List list = new ArrayList();
        list.add("全部/未分类的");
        list.add("超蝙");
        list.add("机器猫");
        list.add("魔兽");
        list.add("美队");
        list.add("星球大战");
        list.add("功夫熊猫");
        list.add("变形金刚");
        list.add("其他主题");
        list.add("超人");
        list.add("迪士尼");
        list.add("钢铁侠");
        list.add("史努比");
        list.add("大圣");
        list.add("日漫");
        list.add("大白");
        listView = new ListView(context);
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView tv = new TextView(context);
                tv.setText(list.get(position) + "");
                tv.setHeight(iv_back.getHeight());
                tv.setWidth(rv.getWidth());
                tv.setGravity(Gravity.VERTICAL_GRAVITY_MASK);
                tv.setTextSize(18);
                tv.setBackgroundColor(Color.WHITE);
                return tv;
            }
        });
    }
}
