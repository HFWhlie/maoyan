package com.atguigu.maoyan.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.bean.Welpictuer;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by tao on 2016/6/23.
 */
public class MyAdapter extends PagerAdapter {

    private Welpictuer.PostersBean bean;
    private Context context;


    public MyAdapter(Context context, Welpictuer.PostersBean postersBean) {
        this.context = context;
        this.bean = postersBean;
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView iv = new ImageView(context);
        //请求图片
        Glide.with(context).load(bean.getPic())
                .placeholder(R.drawable.background_icon01)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.background_icon01).into(iv);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(iv);
        return iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View) object);
    }
}
