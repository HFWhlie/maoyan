package com.atguigu.maoyan.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.atguigu.maoyan.pager.Basepager;

import java.util.List;

/**
 * Created by tao on 2016/6/24.
 */
public class Movieadapter extends PagerAdapter {
    private List<Basepager> list;

    public Movieadapter(List<Basepager> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Basepager basepager = list.get(position);
        View viewroot = basepager.rootview;
        //为了节约用户的资源，当点击某项时才加载数据,   监听页面改变时，设置数据
        basepager.initData();
        container.addView(viewroot);
        return viewroot;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View) object);
    }
}
