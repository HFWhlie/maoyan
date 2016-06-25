package com.atguigu.maoyan.fregrament;

import android.content.Context;
import android.view.View;

import com.atguigu.maoyan.R;

/**
 * Created by tao on 2016/6/24.
 * 影院
 */
public class CinemaFregrament extends BaseFregrament {

    private View view;

    public CinemaFregrament(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        view = View.inflate(context, R.layout.cinema_fregrament,null);
        return view;
    }

    @Override
    public void initData() {
    }
}
