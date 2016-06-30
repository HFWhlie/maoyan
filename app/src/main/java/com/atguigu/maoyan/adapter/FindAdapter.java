package com.atguigu.maoyan.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.URL;
import com.atguigu.maoyan.activity.AllmovActivity;
import com.atguigu.maoyan.activity.HotHfive;
import com.atguigu.maoyan.bean.FindPagerbean;
import com.atguigu.maoyan.bean.Findbean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Request;

/**
 * Created by tao on 2016/6/28.
 */
public class FindAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THR = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int SEV = 7;
    private static final int EIG = 8;
    private Context context;
    private List<Findbean.DataBean.FeedsBean> feedslist;

    public FindAdapter(Context context, List<Findbean.DataBean.FeedsBean> feeds) {
        this.context = context;
        this.feedslist = feeds;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == ZERO) {
            View view = View.inflate(context, R.layout.find_pager, null);
            return new FindPagerHolder(view);
        }
        if (viewType == ONE) {
            return null;
        }
        if (viewType == TWO) {
            View view = View.inflate(context, R.layout.find_two, null);
            return new TwoHolder(view);
        }
        if (viewType == THR) {
            return null;
        }
        if (viewType == FOUR) {
            View view = View.inflate(context, R.layout.find_four, null);
            return new FourHolder(view);
        }
        if (viewType == FIVE) {
            return null;
        }
        if (viewType == SIX) {
            return null;
        }
        if (viewType == SEV) {
            View view = View.inflate(context, R.layout.find_seven, null);
            return new SevenHolder(view);
        }
        if (viewType == EIG) {
            View view = View.inflate(context, R.layout.find_eight, null);
            return new EightHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FindPagerHolder) {
            if (position == 0) {
                ((FindPagerHolder) holder).setData();
            }
        }

        if (getItemViewType(position) == TWO) {

            ((TwoHolder) holder).tv_name.setText(feedslist.get(position).getTitle());
            ((TwoHolder) holder).tv_writer.setText(feedslist.get(position).getUser().getNickName());
            ((TwoHolder) holder).tv_zuan.setText(feedslist.get(position).getViewCount() + "");
            ((TwoHolder) holder).tv_match.setText(feedslist.get(position).getCommentCount() + "");

            Glide.with(context).load(feedslist.get(position).getImages().get(0).getUrl())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.background_icon01)
                    .error(R.drawable.background_icon01)
                    .into(((TwoHolder) holder).iv1);
            Glide.with(context).load(feedslist.get(position).getImages().get(1).getUrl())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.background_icon01)
                    .error(R.drawable.background_icon01)
                    .into(((TwoHolder) holder).iv2);
            Glide.with(context).load(feedslist.get(position).getImages().get(2).getUrl())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                    .placeholder(R.drawable.background_icon01)//加载过程中的图片
                    .error(R.drawable.background_icon01)//加载失败的时候显示的图片
                    .into(((TwoHolder) holder).iv3);//请求成功后把图片设置到的控件
        }

        if (getItemViewType(position) == FOUR) {
            ((FourHolder) holder).tv_name.setText(feedslist.get(position).getTitle());
            ((FourHolder) holder).tv_writer.setText(feedslist.get(position).getUser().getNickName());
            ((FourHolder) holder).tv_zuan.setText(feedslist.get(position).getViewCount() + "");
            ((FourHolder) holder).tv_match.setText(feedslist.get(position).getCommentCount() + "");

            Glide.with(context).load(feedslist.get(position).getImages().get(0).getUrl())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                    .placeholder(R.drawable.background_icon01)//加载过程中的图片
                    .error(R.drawable.background_icon01)//加载失败的时候显示的图片
                    .into(((FourHolder) holder).iv_icon);//请求成功后把图片设置到的控件
        }

        if (getItemViewType(position) == SEV) {
            ((SevenHolder) holder).tv_name.setText(feedslist.get(position).getTitle());
            ((SevenHolder) holder).tv_writer.setText(feedslist.get(position).getUser().getNickName());
            ((SevenHolder) holder).tv_zuan.setText(feedslist.get(position).getViewCount() + "");
            ((SevenHolder) holder).tv_match.setText(feedslist.get(position).getCommentCount() + "");

            Glide.with(context).load(feedslist.get(position).getImages().get(0).getUrl())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                    .placeholder(R.drawable.background_icon01)//加载过程中的图片
                    .error(R.drawable.background_icon01)//加载失败的时候显示的图片
                    .into(((SevenHolder) holder).iv_icon);//请求成功后把图片设置到的控件
        }

        if (getItemViewType(position) == EIG) {
            ((EightHolder) holder).tv_name.setText(feedslist.get(position).getTitle());
            ((EightHolder) holder).tv_writer.setText(feedslist.get(position).getUser().getNickName());
            ((EightHolder) holder).tv_zuan.setText(feedslist.get(position).getViewCount() + "");
            ((EightHolder) holder).tv_match.setText(feedslist.get(position).getCommentCount() + "");
            ((EightHolder) holder).tv_count.setText(feedslist.get(position).getImageCount() + "张");

            Glide.with(context).load(feedslist.get(position).getImages().get(0).getUrl())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                    .placeholder(R.drawable.background_icon01)//加载过程中的图片
                    .error(R.drawable.background_icon01)//加载失败的时候显示的图片
                    .into(((EightHolder) holder).iv1);//请求成功后把图片设置到的控件
            Glide.with(context).load(feedslist.get(position).getImages().get(1).getUrl())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                    .placeholder(R.drawable.background_icon01)//加载过程中的图片
                    .error(R.drawable.background_icon01)//加载失败的时候显示的图片
                    .into(((EightHolder) holder).iv2);//请求成功后把图片设置到的控件
            Glide.with(context).load(feedslist.get(position).getImages().get(2).getUrl())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                    .placeholder(R.drawable.background_icon01)//加载过程中的图片
                    .error(R.drawable.background_icon01)//加载失败的时候显示的图片
                    .into(((EightHolder) holder).iv3);//请求成功后把图片设置到的控件
        }
    }

    @Override
    public int getItemCount() {
        return feedslist.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ZERO;
        }

        Findbean.DataBean.FeedsBean feedsBean = feedslist.get(position);
        int feedType = feedsBean.getFeedType();
        if (feedType == 1) {
            return ONE;

        } else if (feedType == 2) {
            return TWO;

        } else if (feedType == 3) {
            return THR;

        } else if (feedType == 4) {
            return FOUR;

        } else if (feedType == 5) {
            return FIVE;

        } else if (feedType == 6) {
            return SIX;

        } else if (feedType == 7) {
            return SEV;

        } else if (feedType == 8) {
            return EIG;

        }
        return -1;
    }

    /**
     * 头部的holder
     */
    private class FindPagerHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private RelativeLayout rl_pf;
        private RelativeLayout rl_yk;
        private RelativeLayout rl_zx;
        private LinearLayout ll_point;
        private ViewPager vp_find;
        private String findPagerurl;
        private FindpagerAdapter adapter;
        private RelativeLayout rl_ht;

        //上次高亮的位置
        private int prepoint = 0;
        private List<FindPagerbean.DataBean> data;

        public FindPagerHolder(View view) {
            super(view);
            vp_find = (ViewPager) view.findViewById(R.id.vp_find);
            ll_point = (LinearLayout) view.findViewById(R.id.ll_point);
            rl_ht = (RelativeLayout) view.findViewById(R.id.rl_ht);
            rl_zx = (RelativeLayout) view.findViewById(R.id.rl_zx);
            rl_yk = (RelativeLayout) view.findViewById(R.id.rl_yk);
            rl_pf = (RelativeLayout) view.findViewById(R.id.rl_pf);

            setListener();
        }

        //点击事件
        private void setListener() {
            rl_ht.setOnClickListener(this);
            rl_zx.setOnClickListener(this);
            rl_yk.setOnClickListener(this);
            rl_pf.setOnClickListener(this);
        }

        public void setData() {
            findPagerurl = URL.findPagerurl;
            getFromNetData();
        }

        private void getFromNetData() {
            OkHttpUtils.get().url(findPagerurl).build().execute(new StringCallback() {
                @Override
                public void onError(Request request, Exception e) {
                    Log.e("TAG", "发现Viewpager数据请求失败");
                }

                @Override
                public void onResponse(String response) {
                    Log.e("TAG", "发现Viewpager数据请求成功");
                    pressData(response);
                }
            });
        }

        private void pressData(String response) {
            FindPagerbean findPagerbean = new Gson().fromJson(response, FindPagerbean.class);
            data = findPagerbean.getData();
            //添加点
            for (int i = 0; i < data.size(); i++) {
                ImageView point = new ImageView(context);
                point.setBackgroundResource(R.drawable.point_selector);
                LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(8, 8);

                if (i == 0) {
                    point.setEnabled(true);
                } else {
                    point.setEnabled(false);
                    param.leftMargin = 8;
                }
                point.setLayoutParams(param);
                ll_point.addView(point);
            }
            adapter = new FindpagerAdapter(context, data);
            vp_find.setAdapter(adapter);
            //页面改变的监听
            vp_find.addOnPageChangeListener(new MyOnPageChangeListener());
            //轮播图

            vp_find.setCurrentItem(50);

            if (initHandler == null) {
                initHandler = new InitHandler();
            }
            initHandler.removeCallbacksAndMessages(null);
            initHandler.postDelayed(new Myrunnable(), 2000);


        }


        private InitHandler initHandler;

        /**
         * 点击事件
         *
         * @param v
         */
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.rl_ht://话题
                    Intent intent = new Intent(context, HotHfive.class);
                    intent.putExtra("find", "话题");
                    intent.setFlags(4);
                    context.startActivity(intent);
                    break;
                case R.id.rl_zx://资讯
                    Intent intent2 = new Intent(context, HotHfive.class);
                    intent2.putExtra("find2", "资讯");
                    intent2.setFlags(5);
                    context.startActivity(intent2);
                    break;
                case R.id.rl_yk://影库
                    context.startActivity(new Intent(context, AllmovActivity.class));
                    break;
                case R.id.rl_pf://票房
                    Intent intent4 = new Intent(context, HotHfive.class);
                    intent4.putExtra("find3", "猫眼专业版");
                    intent4.setFlags(6);
                    context.startActivity(intent4);
                    break;

            }

        }

        private class InitHandler extends Handler {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                vp_find.setCurrentItem((vp_find.getCurrentItem() + 1));
                initHandler.postDelayed(new Myrunnable(), 2000);
            }
        }

        private class Myrunnable implements Runnable {
            @Override
            public void run() {
                initHandler.sendEmptyMessage(0);
            }
        }

        /**
         * 页面改变的监听
         */
        private class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int i = position % (data.size());

                ll_point.getChildAt(prepoint).setEnabled(false);

                ll_point.getChildAt(i).setEnabled(true);

                prepoint = i;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        }

    }

    /**
     * 类型2的holder
     */
    private class TwoHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private TextView tv_writer;
        private TextView tv_zuan;
        private TextView tv_match;
        private ImageView iv1;
        private ImageView iv2;
        private ImageView iv3;

        public TwoHolder(View view) {
            super(view);
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_writer = (TextView) view.findViewById(R.id.tv_writer);
            tv_zuan = (TextView) view.findViewById(R.id.tv_zuan);
            tv_match = (TextView) view.findViewById(R.id.tv_match);

            iv1 = (ImageView) view.findViewById(R.id.iv1);
            iv2 = (ImageView) view.findViewById(R.id.iv2);
            iv3 = (ImageView) view.findViewById(R.id.iv3);
        }
    }

    /**
     * 类型4的holder
     */
    private class FourHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private TextView tv_writer;
        private TextView tv_zuan;
        private TextView tv_match;
        private ImageView iv_icon;

        public FourHolder(View view) {
            super(view);
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_writer = (TextView) view.findViewById(R.id.tv_writer);
            tv_zuan = (TextView) view.findViewById(R.id.tv_zuan);
            tv_match = (TextView) view.findViewById(R.id.tv_match);
            iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
        }
    }

    /**
     * 类型7的holder
     */
    private class SevenHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private TextView tv_writer;
        private TextView tv_zuan;
        private TextView tv_match;
        private ImageView iv_icon;

        public SevenHolder(View view) {
            super(view);
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_writer = (TextView) view.findViewById(R.id.tv_writer);
            tv_zuan = (TextView) view.findViewById(R.id.tv_zuan);
            tv_match = (TextView) view.findViewById(R.id.tv_match);
            iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
        }
    }

    /**
     * 类型8的holder
     */
    private class EightHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private TextView tv_writer;
        private TextView tv_zuan;
        private TextView tv_match;
        private TextView tv_count;
        private ImageView iv1;
        private ImageView iv2;
        private ImageView iv3;

        public EightHolder(View view) {
            super(view);
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_writer = (TextView) view.findViewById(R.id.tv_writer);
            tv_zuan = (TextView) view.findViewById(R.id.tv_zuan);
            tv_match = (TextView) view.findViewById(R.id.tv_match);
            tv_count = (TextView) view.findViewById(R.id.tv_count);

            iv1 = (ImageView) view.findViewById(R.id.iv1);
            iv2 = (ImageView) view.findViewById(R.id.iv2);
            iv3 = (ImageView) view.findViewById(R.id.iv3);
        }
    }
}
