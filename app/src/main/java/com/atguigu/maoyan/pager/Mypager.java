package com.atguigu.maoyan.pager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by tao on 2016/6/25.
 *
 *使Viewpager不可以滑动
 */
public class Mypager extends ViewPager {
    public Mypager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 使Viewpager不可以滑动  返回false
     * @param ev
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }
}
