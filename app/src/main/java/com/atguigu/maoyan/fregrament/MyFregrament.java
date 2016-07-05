package com.atguigu.maoyan.fregrament;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.activity.CartActivity;
import com.atguigu.maoyan.activity.LoginActivity;
import com.atguigu.maoyan.activity.ShopActivity;

/**
 * Created by tao on 2016/6/24.
 * 我的
 */
public class MyFregrament extends BaseFregrament implements View.OnClickListener {
    private View view;

    private RelativeLayout rl_login;
    private RelativeLayout rl_want;
    private RelativeLayout rl_watch;
    private RelativeLayout rl_yingping;
    private RelativeLayout rl_huati;
    private RelativeLayout rl_wxf;
    private RelativeLayout rl_dfk;
    private RelativeLayout rl_dpj;
    private RelativeLayout rl_fk;
    private RelativeLayout rl_handler;
    private RelativeLayout rl_centert;
    private RelativeLayout rl_cj;
    private RelativeLayout rl_yhj;
    private RelativeLayout rl_money;
    private RelativeLayout rl_shop;
    private RelativeLayout rl_set;

    private RelativeLayout rl_all;
    public MyFregrament(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        view = View.inflate(context, R.layout.my_fregrament,null);
        findView();
        setlistener();
        return view;
    }

    /**
     * 点击事件的监听
     */
    private void setlistener() {
        rl_login.setOnClickListener(this);
        rl_want.setOnClickListener(this);
        rl_watch.setOnClickListener(this);
        rl_yingping.setOnClickListener(this);
        rl_huati.setOnClickListener(this);
        rl_wxf.setOnClickListener(this);
        rl_dfk.setOnClickListener(this);
        rl_dpj.setOnClickListener(this);
        rl_fk.setOnClickListener(this);
        rl_handler.setOnClickListener(this);
        rl_centert.setOnClickListener(this);
        rl_login.setOnClickListener(this);
        rl_yhj.setOnClickListener(this);
        rl_money.setOnClickListener(this);
        rl_cj.setOnClickListener(this);
        rl_set.setOnClickListener(this);
        rl_shop.setOnClickListener(this);
        rl_cj.setOnClickListener(this);
        rl_all.setOnClickListener(this);
    }


    private void findView() {
        rl_login = (RelativeLayout) view.findViewById(R.id.rl_login);
        rl_want = (RelativeLayout) view.findViewById(R.id.rl_want);
        rl_watch = (RelativeLayout) view.findViewById(R.id.rl_watch);
        rl_yingping = (RelativeLayout) view.findViewById(R.id.rl_yingping);
        rl_huati = (RelativeLayout) view.findViewById(R.id.rl_huati);
        rl_wxf = (RelativeLayout) view.findViewById(R.id.rl_wxf);
        rl_dfk = (RelativeLayout) view.findViewById(R.id.rl_dfk);
        rl_dpj = (RelativeLayout) view.findViewById(R.id.rl_dpj);
        rl_fk = (RelativeLayout) view.findViewById(R.id.rl_fk);
        rl_handler = (RelativeLayout) view.findViewById(R.id.rl_handler);
        rl_centert = (RelativeLayout) view.findViewById(R.id.rl_centert);
        rl_cj = (RelativeLayout) view.findViewById(R.id.rl_cj);
        rl_yhj = (RelativeLayout) view.findViewById(R.id.rl_yhj);
        rl_money = (RelativeLayout) view.findViewById(R.id.rl_money);
        rl_shop = (RelativeLayout) view.findViewById(R.id.rl_shop);
        rl_set = (RelativeLayout) view.findViewById(R.id.rl_set);
        rl_all = (RelativeLayout) view.findViewById(R.id.rl_all);

    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_shop:
                context.startActivity(new Intent(context,ShopActivity.class));
                break;
            case R.id.rl_login:
                context.startActivity(new Intent(context, LoginActivity.class));
                break;
            case R.id.rl_all:
                context.startActivity(new Intent(context, CartActivity.class));
        }
    }
}
