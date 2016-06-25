package com.atguigu.maoyan.pager;

import android.content.Context;
import android.view.View;

import com.atguigu.maoyan.R;

/**
 * Created by tao on 2016/6/24.
 */
public class Hotpager extends Basepager {

    private View view;

    public Hotpager(Context context) {
        super(context);
    }


    @Override
    public View initview() {
        view = View.inflate(context, R.layout.hot_pager, null);
        return view;
    }

    @Override
    public void initData() {
    }
}
