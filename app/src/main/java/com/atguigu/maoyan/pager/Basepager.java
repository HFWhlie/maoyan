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


    public abstract View initview();

    public void initData() {

    }
}
