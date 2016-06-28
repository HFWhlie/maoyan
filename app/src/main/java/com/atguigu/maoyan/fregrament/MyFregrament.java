package com.atguigu.maoyan.fregrament;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.atguigu.maoyan.R;

/**
 * Created by tao on 2016/6/24.
 * 我的
 */
public class MyFregrament extends BaseFregrament {
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

    private LinearLayout ll_all;
    public MyFregrament(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        view = View.inflate(context, R.layout.my_fregrament,null);
        findView();
        return view;
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

        ll_all = (LinearLayout) view.findViewById(R.id.ll_all);

    }

    @Override
    public void initData() {
        super.initData();
    }
}
