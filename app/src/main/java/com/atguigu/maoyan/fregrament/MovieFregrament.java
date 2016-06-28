package com.atguigu.maoyan.fregrament;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.adapter.Movieadapter;
import com.atguigu.maoyan.pager.Basepager;
import com.atguigu.maoyan.pager.Hotpager;
import com.atguigu.maoyan.pager.Overseaspager;
import com.atguigu.maoyan.pager.Stdypager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tao on 2016/6/24.
 * 电影
 */
public class MovieFregrament extends BaseFregrament {
    private ViewPager movie_viewpager;
    private LinearLayout ll_city;
    private TextView tv_city;
    private View view;
    private ImageView iv_whilt;
    private RadioGroup rg_title;
    private RadioButton rb_hot_show;
    private RadioButton rb_stdy_show;
    private RadioButton rb_overseas;
    //viewpager页面的集合
    private List<Basepager> list;
    //两点之间的距离
    private int left;
    private Movieadapter adapter;
    //当前页面的viewpager

    public MovieFregrament(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        view = View.inflate(context, R.layout.movie_fregrament, null);
        findView();
        return view;
    }

    private void findView() {
        rg_title = (RadioGroup) view.findViewById(R.id.rg_title);
        movie_viewpager = (ViewPager) view.findViewById(R.id.movie_viewpager);
        iv_whilt = (ImageView) view.findViewById(R.id.iv_whilt);
        ll_city = (LinearLayout) view.findViewById(R.id.ll_city);
        rb_hot_show = (RadioButton) view.findViewById(R.id.rb_hot_show);
        rb_stdy_show = (RadioButton) view.findViewById(R.id.rb_stdy_show);
        rb_overseas = (RadioButton) view.findViewById(R.id.rb_overseas);
        tv_city = (TextView) view.findViewById(R.id.tv_city);
    }

    @Override
    public void initData() {

        rg_title.check(R.id.rb_hot_show);
        //准备数据
        list = new ArrayList<>();
        list.add(new Hotpager(context));
        list.add(new Stdypager(context));
        list.add(new Overseaspager(context));
        //设置适配器
        adapter = new Movieadapter(list);
        movie_viewpager.setAdapter(adapter);
        //设置RadioGroup的点击事件
        rg_title.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        //得到两点之间的间距
        iv_whilt.getViewTreeObserver().addOnGlobalLayoutListener(new MyOnGlobalLayoutListener());
        //监听页面改变
        movie_viewpager.addOnPageChangeListener(new MyOnPageChangeListener());
        //默认选中第一项的数据
        movie_viewpager.setCurrentItem(0);
        list.get(0).initData();
    }

    /**
     * 得到两点之间的距离
     */
    private class MyOnGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void onGlobalLayout() {
            //防止运行两次
            iv_whilt.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            //得到两点之间的距离
            left = rg_title.getChildAt(1).getLeft() - rg_title.getChildAt(0).getLeft();
        }
    }

    /**
     * 监听页面的改变
     */
    private class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            int instance = (int) ((positionOffset + position) * left);
            if (instance < left) {
                rb_hot_show.setAlpha(positionOffset);
                rb_stdy_show.setAlpha(positionOffset);
            }
            if (left < instance && instance < left * 2) {
                rb_overseas.setAlpha(positionOffset);
                rb_stdy_show.setAlpha(positionOffset);
            }
            if (instance == left || instance == 0 || instance == left * 2) {
                rb_hot_show.setAlpha(1);
                rb_stdy_show.setAlpha(1);
                rb_overseas.setAlpha(1);
            }

            //得到红点的属性
            RelativeLayout.LayoutParams redParams = (RelativeLayout.LayoutParams) iv_whilt.getLayoutParams();
            redParams.leftMargin = instance;
            iv_whilt.setLayoutParams(redParams);//不加会出现直接跳过去的效果
        }

        @Override
        public void onPageSelected(int position) {
            if (!list.get(position).isInitData) {
                list.get(position).initData();
            }

            int id = rg_title.getChildAt(position).getId();
            rg_title.check(id);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    //RadioGroup的点击事件
    private class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                //热映
                case R.id.rb_hot_show:
                    movie_viewpager.setCurrentItem(0, false);
                    break;
                //待映
                case R.id.rb_stdy_show:
                    movie_viewpager.setCurrentItem(1, false);
                    break;
                //海外
                case R.id.rb_overseas:
                    movie_viewpager.setCurrentItem(2, false);
                    break;
            }

        }
    }
}

