package com.atguigu.maoyan.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.bean.FindPagerbean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/**
 * Created by tao on 2016/6/28.
 */
public class FindpagerAdapter extends PagerAdapter {
    private List<FindPagerbean.DataBean> data;
    private Context context;

    public FindpagerAdapter(Context context, List<FindPagerbean.DataBean> data) {
        this.context =context;
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
        FindPagerbean.DataBean dataBean = data.get(i);
        ImageView iv = new ImageView(context);
        Glide.with(context).load(dataBean.getImgUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                .placeholder(R.drawable.background_icon01)//加载过程中的图片
                .error(R.drawable.background_icon01)//加载失败的时候显示的图片
                .into(iv);//请求成功后把图片设置到的控件
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
