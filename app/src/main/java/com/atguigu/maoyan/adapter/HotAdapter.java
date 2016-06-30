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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.URL;
import com.atguigu.maoyan.activity.SousuoActivity;
import com.atguigu.maoyan.bean.HotPagerbean;
import com.atguigu.maoyan.bean.Hotbean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Request;

/**
 * Created by tao on 2016/6/25.
 */
public class HotAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int ONE = 0;
    private static final int TWO = 1;

    private Context context;

    //listview集合
    private List<Hotbean.DataBean.MoviesBean> list;

    //viewPager集合
    private List<HotPagerbean.DataBean> data;
    private Hotbean.DataBean.MoviesBean moviesBean;

    public HotAdapter(Context context, List<Hotbean.DataBean.MoviesBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ONE) {
            View view = View.inflate(context, R.layout.head_view, null);
            return new HeadHolder(view);
        }
        if (viewType == TWO) {
            View view = View.inflate(context, R.layout.my_view, null);
            return new MyHolder(view);
        }
        return null;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position) == ONE) {
            ((HeadHolder) holder).setData();
        }
        if (getItemViewType(position) == TWO) {

            moviesBean = list.get(position-1);
            //片名
            ((MyHolder) holder).tv_name.setText(moviesBean.getNm());
            Log.e("TAG", "moviesBean.getNm() = " + moviesBean.getNm());
            //描述
            ((MyHolder) holder).tv_introduce.setText(moviesBean.getScm());
            //多少人
            ((MyHolder) holder).tv_people.setText(moviesBean.getShowInfo());

            if (moviesBean.getPreSale() == 0) {
                ((MyHolder) holder).bt_mai.setVisibility(View.VISIBLE);
                ((MyHolder) holder).bt_yu.setVisibility(View.GONE);
                ((MyHolder) holder).tv_gread.setText(moviesBean.getSc() + "分");
            } else if (moviesBean.getPreSale() == 1) {
                ((MyHolder) holder).bt_mai.setVisibility(View.GONE);
                ((MyHolder) holder).bt_yu.setVisibility(View.VISIBLE);
                ((MyHolder) holder).tv_gread.setText(moviesBean.getWish() + "人想看");
            }
            if (!moviesBean.isValue3d()) {
                ((MyHolder) holder).iv_mode.setVisibility(View.GONE);
            } else {
                ((MyHolder) holder).iv_mode.setVisibility(View.VISIBLE);
            }
            if (!moviesBean.isImax()) {
                ((MyHolder) holder).iv_max.setVisibility(View.GONE);
            } else {
                ((MyHolder) holder).iv_max.setVisibility(View.VISIBLE);
            }
            //请求图片
            Glide.with(context).load(moviesBean.getImg())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                    .placeholder(R.drawable.background_icon01)//加载过程中的图片
                    .error(R.drawable.background_icon01)//加载失败的时候显示的图片
                    .into(((MyHolder) holder).iv_icon);//请求成功后把图片设置到的控件

            ((MyHolder) holder).ll_zhuan.setVisibility(View.GONE);
            if (position == 1) {
                ((MyHolder) holder).ll_zhuan.setVisibility(View.VISIBLE);
                ((MyHolder) holder).tv1.setText("绿巨人：周杰伦真的很酷！");
                ((MyHolder) holder).tv1.setText("如果出第三部你会看吗？");
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ONE;
        }
        return TWO;
    }

    /**
     * listview holder
     */
    class MyHolder extends RecyclerView.ViewHolder {
        public ImageView iv_icon;
        public ImageView iv_mode;
        public ImageView iv_max;

        public TextView tv_name;
        public TextView tv_gread;
        public TextView tv_introduce;
        public TextView tv_people;

        public Button bt_mai;
        public Button bt_yu;

        public LinearLayout ll_zhuan;
        public TextView tv1;
        public TextView tv2;

        public MyHolder(final View itemView) {
            super(itemView);
            iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
            iv_mode = (ImageView) itemView.findViewById(R.id.iv_mode);
            iv_max = (ImageView) itemView.findViewById(R.id.iv_max);

            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_gread = (TextView) itemView.findViewById(R.id.tv_gread);
            tv_introduce = (TextView) itemView.findViewById(R.id.tv_introduce);
            tv_people = (TextView) itemView.findViewById(R.id.tv_people);
            tv1 = (TextView) itemView.findViewById(R.id.tv1);
            tv2 = (TextView) itemView.findViewById(R.id.tv2);

            bt_mai = (Button) itemView.findViewById(R.id.bt_mai);
            bt_yu = (Button) itemView.findViewById(R.id.bt_yu);

            ll_zhuan = (LinearLayout) itemView.findViewById(R.id.ll_zhuan);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onClickitemListeren != null) {
                        onClickitemListeren.onclickListener(moviesBean);
                    }
                }
            });
        }
    }

    /**
     * head holder
     */
    private class HeadHolder extends RecyclerView.ViewHolder {
        public ViewPager vp_head;
        private String hotPagerurl;
        private LinearLayout ll_sousou;

        public HeadHolder(View view) {
            super(view);
            vp_head = (ViewPager) view.findViewById(R.id.vp_head);
            ll_sousou = (LinearLayout) view.findViewById(R.id.ll_sousou);

            setListener();
        }

        private void setListener() {
            //搜索框的监听
            ll_sousou.setOnClickListener(new MyonClickListener());

        }

        public void setData() {
            hotPagerurl = URL.hotPagerurl;
            getFromPagerNetData();
        }

        private void getFromPagerNetData() {
            OkHttpUtils.get().url(hotPagerurl).build().execute(new StringCallback() {
                @Override
                public void onError(Request request, Exception e) {
                    Log.e("TAG", "联网失败");
                }

                @Override
                public void onResponse(final String response) {
                    Log.e("TAG", "联网成功viewpager");
                    //解析并显示数据
                    processPagerData(response);
                }
            });
        }

        private void processPagerData(String response) {
            HotPagerbean hotPagerbean = new Gson().fromJson(response, HotPagerbean.class);
            data = hotPagerbean.getData();
            vp_head.setAdapter(new HeadAdapter(context, data));

            vp_head.setCurrentItem(50);
            //轮播图
            //开始循环切换ViewPager
            if (internalHandler == null) {
                internalHandler = new InternalHandler();
            }
            //把所有的消息和任务移除
            internalHandler.removeCallbacksAndMessages(null);
            //发消息
            internalHandler.postDelayed(new MyRunable(), 2000);
        }

        private InternalHandler internalHandler;

        class InternalHandler extends Handler {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                //切换到下一个页面
                int item = (vp_head.getCurrentItem() + 1);
                vp_head.setCurrentItem(item);

                //重新发消息
                internalHandler.postDelayed(new MyRunable(), 2000);
            }
        }

        class MyRunable implements Runnable {
            @Override
            public void run() {
                internalHandler.sendEmptyMessage(0);
            }
        }

        /**
         * 搜索框的点击事件
         */
        private class MyonClickListener implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, SousuoActivity.class));
            }
        }
    }


    /**
     * 自定义接口
     */
    public interface OnClickitemListeren {
        public void onclickListener(Hotbean.DataBean.MoviesBean bean);
    }

    public OnClickitemListeren onClickitemListeren;

    public void setOnClickitemListeren(OnClickitemListeren onClickitemListeren) {
        this.onClickitemListeren = onClickitemListeren;
    }
}







