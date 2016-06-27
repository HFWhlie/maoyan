package com.atguigu.maoyan.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.bean.HotPagerbean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/**
 * Created by tao on 2016/6/25.
 */
public class HeadAdapter extends PagerAdapter {
    private Context context;
    private List<HotPagerbean.DataBean> data;

    public HeadAdapter(Context context, List<HotPagerbean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        int i = position % data.size();
        HotPagerbean.DataBean dataBean = data.get(i);
        ImageView iv = new ImageView(context);
        Glide.with(context).load(dataBean.getImgUrl())
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
