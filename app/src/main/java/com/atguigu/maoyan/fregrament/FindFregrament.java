package com.atguigu.maoyan.fregrament;

import android.content.Context;
import android.view.View;

import com.atguigu.maoyan.R;

/**
 * Created by tao on 2016/6/24.
 * 发现
 */
public class FindFregrament extends BaseFregrament {
    private View view;

    public FindFregrament(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        view = View.inflate(context, R.layout.find_fregrament,null);
        return view;
    }

    @Override
    public void initData() {

    }
}
