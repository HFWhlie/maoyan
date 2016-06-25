package com.atguigu.maoyan.pager;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.adapter.OverseasAdapter;
import com.atguigu.maoyan.fregrament.BaseFregrament;
import com.atguigu.maoyan.pager.OverseasFregrament.HanFregrament;
import com.atguigu.maoyan.pager.OverseasFregrament.MeiFregrament;
import com.atguigu.maoyan.pager.OverseasFregrament.RiFregrament;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tao on 2016/6/24.
 */
public class Overseaspager extends Basepager {
    private TabLayout tb;
    private ViewPager vp;


    private View view;
    //页面集合
    private List<BaseFregrament> list;
    //标题
    private String[] arr = {"美国", "韩国", "日本"};
    private OverseasAdapter adapter;

    public Overseaspager(Context context) {
        super(context);
    }

    @Override
    public View initview() {
        view = View.inflate(context, R.layout.overseas_pager, null);
        findview();
        return view;
    }

    private void findview() {
        tb = (TabLayout) view.findViewById(R.id.tb);
        vp = (ViewPager) view.findViewById(R.id.vp);

    }

    @Override
    public void initData() {
        //准备数据Ri
        list = new ArrayList();
        list.add(new MeiFregrament(context));
        list.add(new HanFregrament(context));
        list.add(new RiFregrament(context));
        //设置titl
        tb.addTab(tb.newTab().setText(arr[0]));
        tb.addTab(tb.newTab().setText(arr[1]));
        tb.addTab(tb.newTab().setText(arr[2]));
        tb.setTabTextColors(Color.GRAY, Color.RED);
//        tb.setTabMode(TabLayout.MODE_FIXED);

        adapter = new OverseasAdapter(list, arr);
        //设置适配器
        vp.setAdapter(adapter);
        //TabLayout与ViewPager关联
        tb.setupWithViewPager(vp);
        //设置页面改变的监听
        vp.addOnPageChangeListener(new OnPageChangeListener());
        //默认选中第一项
        list.get(0).initData();
    }

    private class OnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            //当选中这个页面时，加载数据
            list.get(position).initData();
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
