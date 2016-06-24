package com.atguigu.maoyan.pager;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by tao on 2016/6/24.
 */
public class Overseaspager extends Basepager {

    private TextView textView;

    public Overseaspager(Context context) {
        super(context);
    }

    @Override
    public View initview() {
        textView = new TextView(context);
        textView.setTextSize(18);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    public void initData() {
        textView.setText("海外");
    }
}
