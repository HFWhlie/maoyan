package com.atguigu.maoyan.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.atguigu.maoyan.fregrament.BaseFregrament;

import java.util.List;

/**
 * Created by tao on 2016/6/25.
 */
public class OverseasAdapter extends PagerAdapter {
    private final List<BaseFregrament> list;
    private String[] arr;

    public OverseasAdapter(List<BaseFregrament> list, String[] arr) {
        this.list = list;
        this.arr = arr;
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
        BaseFregrament fregrament = list.get(position);
        View view = fregrament.initView();
        container.addView(view);
        //先不在这个显示数据，为了不消耗用户过多的资源  在页面改变时加载数据
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View) object);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return arr[position] ;
    }
}
