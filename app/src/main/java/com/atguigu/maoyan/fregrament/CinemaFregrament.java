package com.atguigu.maoyan.fregrament;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by tao on 2016/6/24.
 */
public class CinemaFregrament extends BaseFregrament {

    private TextView textView;
    public CinemaFregrament(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        textView=new TextView(context);
        textView.setTextSize(30);
        textView.setTextColor(Color.RED);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        textView.setText("CinemaFregrament");
    }
}
