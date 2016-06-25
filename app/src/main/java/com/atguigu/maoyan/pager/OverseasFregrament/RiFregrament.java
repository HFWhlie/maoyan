package com.atguigu.maoyan.pager.OverseasFregrament;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.atguigu.maoyan.fregrament.BaseFregrament;

/**
 * Created by tao on 2016/6/25.
 */
public class RiFregrament extends BaseFregrament {

    private TextView textView;

    public RiFregrament(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        textView = new TextView(context);
        textView.setTextSize(18);
        textView.setTextColor(Color.RED);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    public void initData() {
        textView.setText("RiFregrament");
    }
}
