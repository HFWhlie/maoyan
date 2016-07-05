package com.atguigu.maoyan.fregrament;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.URL;
import com.atguigu.maoyan.activity.HotHfive;
import com.atguigu.maoyan.activity.MainActivity;
import com.atguigu.maoyan.adapter.CinemaAdapter;
import com.atguigu.maoyan.bean.Citybean;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import droid.Activity01;
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
    private TextView tv_adress;
    private Citybean.DataBean data;
    private TextView tv_city;
    private RelativeLayout rl_radiogroup;

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
        tv_adress = (TextView) view.findViewById(R.id.tv_adress);
        tv_city = (TextView) view.findViewById(R.id.tv_city);

        rl_radiogroup = (RelativeLayout) view.findViewById(R.id.rl_radiogroup);

        rl_radiogroup.setVisibility(View.GONE);

    }

    private void setlistener() {
        ll_show.setOnClickListener(this);
        iv_cityseach.setOnClickListener(this);
        iv_seach.setOnClickListener(this);
        ll_city.setOnClickListener(this);
        ((MainActivity) context).setOnlistener(new MainActivity.Onlistener() {

            @Override
            public void onclicklistener(final String key) {
                String text = (String) tv_city.getText();
                if (text.equals(key)) {
                    tv_city.setText(key);
                } else {
                    new AlertDialog.Builder(context)
                            .setTitle("定位到你当前的城市是北京，是否切换")
                            .setNegativeButton("取消", null)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    tv_city.setText(key);
                                }
                            })
                            .show();
                }
            }
        });
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
        data = citybean.getData();
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
            public void onCinemaitemListener(View v, int layoutPosition) {
                Intent intent = new Intent(context, HotHfive.class);
                String cinemaname = data.getchangpingqu().get(layoutPosition - 1).getNm();
                intent.putExtra("cinema", cinemaname);
                intent.setFlags(3);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_show://当联网失败，再次请求
                getFromNetData();
                break;

            case R.id.ll_city://城市选择
                Intent intent = new Intent(context, Activity01.class);
                ((MainActivity) context).startActivityForResult(intent, 1);
                break;
            case R.id.iv_cityseach://城市搜索
                showpopupWindow();
                break;
            case R.id.iv_seach://搜索
                Toast.makeText(context, "搜索", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * 显示popupWindow
     */
    private void showpopupWindow() {

        final List list = new ArrayList();
        list.add("行政区");
        list.add("地铁");
        list.add("特殊厅");
        list.add("品牌");
        list.add("服务");
        View menuView = LayoutInflater.from(context).inflate(
                R.layout.popup, null, true);
        final ListView lv1 = (ListView) menuView.findViewById(R.id.lv1);
        final ListView lv2 = (ListView) menuView.findViewById(R.id.lv2);
        final ListView lv3 = (ListView) menuView.findViewById(R.id.lv3);
        lv1.setAdapter(new BaseAdapter() {

            TextView tv;

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
                tv = new TextView(context);
                tv.setText(list.get(position) + "");
                tv.setHeight(ll_city.getHeight());
                tv.setWidth(lv1.getWidth());
                tv.setGravity(Gravity.CENTER);
                tv.setTextSize(18);
                tv.setBackgroundColor(Color.WHITE);
                return tv;
            }
        });
        final PopupWindow mPop = new PopupWindow(menuView, LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, true);


        // 需要设置一下此参数，点击外边可消失
        mPop.setBackgroundDrawable(new BitmapDrawable());
        //设置点击窗口外边窗口消失
        mPop.setOutsideTouchable(true);
        // 设置此参数获得焦点，否则无法点击
        mPop.setFocusable(true);

        mPop.setWidth(rl_cinema.getWidth());
        mPop.setHeight(800);
        mPop.showAsDropDown(ll_city, 0, 0);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:

                        final String[] arr0 = {"朝阳", "海淀", "大兴", "东城", "丰台", "西城", "通州", "昌平", "房山", "顺义", "怀柔", "门头沟", "石景", "平谷", "密云", "延庆"};
                        lv2.setAdapter(new BaseAdapter() {
                            @Override
                            public int getCount() {
                                return arr0.length;
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
                                TextView tv0 = new TextView(context);
                                tv0.setText(arr0[position]);
                                tv0.setHeight(ll_city.getHeight());
                                tv0.setWidth(lv2.getWidth());
                                tv0.setGravity(Gravity.CENTER);
                                tv0.setTextSize(18);
                                tv0.setBackgroundColor(Color.WHITE);
                                return tv0;
                            }
                        });
                        lv3.setAdapter(null);
                        break;
                    case 1:
                        final String[] arr1 = {"1号线", "2号线", "3号线", "4号线", "5号线", "6号线", "7号线", "8号线", "9号线", "10号线", "11号线", "12号线", "13号线", "14号线", "15号线", "八通线"};
                        lv2.setAdapter(new BaseAdapter() {
                            @Override
                            public int getCount() {
                                return arr1.length;
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
                                TextView tv1 = new TextView(context);
                                tv1.setText(arr1[position]);
                                tv1.setHeight(ll_city.getHeight());
                                tv1.setWidth(lv2.getWidth());
                                tv1.setGravity(Gravity.CENTER);
                                tv1.setTextSize(18);
                                tv1.setBackgroundColor(Color.WHITE);
                                return tv1;
                            }
                        });

                        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                switch (position) {
                                    case 0:
                                        final String[] arr5 = {"1号线", "2号线", "3号线", "4号线", "5号线", "6号线", "7号线", "8号线", "9号线", "10号线", "11号线", "12号线", "13号线", "14号线", "15号线", "八通线"};
                                        lv3.setAdapter(new BaseAdapter() {
                                            @Override
                                            public int getCount() {
                                                return arr5.length;
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
                                                TextView tv1 = new TextView(context);
                                                tv1.setText(arr5[position]);
                                                tv1.setHeight(ll_city.getHeight());
                                                tv1.setWidth(lv3.getWidth());
                                                tv1.setGravity(Gravity.CENTER);
                                                tv1.setTextSize(18);
                                                tv1.setBackgroundColor(Color.WHITE);
                                                return tv1;
                                            }
                                        });

                                        break;
                                }
                            }
                        });

                        break;
                    case 2:
                        final String[] arr2 = {"杜比全景声厅", "IMAX厅", "4K厅", "中国巨幕厅", "4DX厅", "4D厅", "双机3D厅", "巨幕厅"};
                        lv2.setAdapter(new BaseAdapter() {
                            @Override
                            public int getCount() {
                                return arr2.length;
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
                                TextView tv2 = new TextView(context);
                                tv2.setText(arr2[position]);
                                tv2.setHeight(ll_city.getHeight());
                                tv2.setWidth(lv2.getWidth());
                                tv2.setGravity(Gravity.CENTER);
                                tv2.setTextSize(18);
                                tv2.setBackgroundColor(Color.WHITE);
                                return tv2;
                            }
                        });
                        lv3.setAdapter(null);
                        break;
                    case 3:
                        final String[] arr3 = {"大地影院", "百汇老影院", "17.5影院", "保利国际影院"};
                        lv2.setAdapter(new BaseAdapter() {
                            @Override
                            public int getCount() {
                                return arr3.length;
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
                                TextView tv3 = new TextView(context);
                                tv3.setText(arr3[position]);
                                tv3.setHeight(ll_city.getHeight());
                                tv3.setWidth(lv2.getWidth());
                                tv3.setGravity(Gravity.CENTER);
                                tv3.setTextSize(18);
                                tv3.setBackgroundColor(Color.WHITE);
                                return tv3;
                            }
                        });
                        lv3.setAdapter(null);
                        break;
                    case 4:
                        final String[] arr4 = {"小吃", "可退票", "可改签", "会员卡"};
                        lv2.setAdapter(new BaseAdapter() {
                            @Override
                            public int getCount() {
                                return arr4.length;
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
                                TextView tv4 = new TextView(context);
                                tv4.setText(arr4[position]);
                                tv4.setHeight(ll_city.getHeight());
                                tv4.setWidth(lv2.getWidth());
                                tv4.setGravity(Gravity.CENTER);
                                tv4.setTextSize(18);
                                tv4.setBackgroundColor(Color.WHITE);
                                return tv4;
                            }
                        });
                        lv3.setAdapter(null);
                        break;
                }
            }
        });

    }
}
