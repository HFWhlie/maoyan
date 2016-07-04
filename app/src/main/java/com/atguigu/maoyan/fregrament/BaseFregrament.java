package com.atguigu.maoyan.fregrament;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by tao on 2016/6/24.
 */
public abstract class BaseFregrament extends Fragment {

    public Context context;

    public View rootView;
    public boolean isFragment;

    public BaseFregrament(Context context) {
        this.context = context;
        rootView = initView();
        isFragment = false;
    }

    public abstract View initView();

    public void initData() {

    }

    public void setButton(String key) {

    }
}
