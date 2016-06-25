package com.atguigu.maoyan.pager;

import android.content.Context;
import android.view.View;

/**
 * Created by tao on 2016/6/24.
 */
public abstract class Basepager {

    public View rootview;
    public Context context;

    public Basepager(Context context) {
        this.context = context;
        rootview = initview();
    }
    //判断是否加载过数据
    public boolean isInitData = false;
    public abstract View initview();

    public void initData() {

    }
}
