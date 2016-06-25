package com.atguigu.maoyan.adapter;

import android.content.Context;
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
import com.atguigu.maoyan.bean.HotPagerbean;
import com.atguigu.maoyan.bean.Hotbean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/**
 * Created by tao on 2016/6/25.
 */
public class HotAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //viewpager的数据集合
    private List<HotPagerbean.DataBean> data;
    //list的集合
    private List<Hotbean.DataBean.MoviesBean> list;
    private Context context;


    public HotAdapter(Context context) {
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = View.inflate(context, R.layout.head_view, null);
            return new HeadHolder(view);
        }
        View view = View.inflate(context, R.layout.my_view, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            ((HeadHolder) holder).vp_reying_title.setAdapter(new HeadAdapter(context,data));
        }
        if (position == 1) {
            //得到位置
            Hotbean.DataBean.MoviesBean moviesBean = list.get(position);
            ((MyHolder) holder).tv_name.setText(moviesBean.getNm());
            ((MyHolder) holder).tv_gread.setText(moviesBean.getSc() + "");
            ((MyHolder) holder).tv_introduce.setText(moviesBean.getScm());
            ((MyHolder) holder).tv_people.setText(moviesBean.getShowInfo());
            if (moviesBean.getPreSale() == 0) {
                ((MyHolder) holder).bt_mai.setVisibility(View.VISIBLE);
                ((MyHolder) holder).bt_yu.setVisibility(View.GONE);
            } else if (moviesBean.getPreSale() == 1) {
                ((MyHolder) holder).bt_mai.setVisibility(View.GONE);
                ((MyHolder) holder).bt_yu.setVisibility(View.VISIBLE);
            }

            //请求图片
            Glide.with(context).load(moviesBean.getImg())
                    .placeholder(R.drawable.background_icon01)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .error(R.drawable.background_icon01).into(((MyHolder) holder).iv_icon);

        }

    }

    @Override
    public int getItemCount() {
        if(list != null && list.size()>0){
            list.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        }
        return 1;
    }
    //获取传过来的list
    public void setviewlist(List<Hotbean.DataBean.MoviesBean> movielist) {
        this.list = movielist;
        Log.e("TAG", "movielist = " + list);
    }

    public void setviewData(List<HotPagerbean.DataBean> data) {
        this.data = data;
        Log.e("TAG","data = "+data);
    }
}

class MyHolder extends RecyclerView.ViewHolder {
    public ImageView iv_icon;
    public TextView tv_name;
    public ImageView iv_mode;
    public TextView tv_gread;
    public TextView tv_introduce;
    public TextView tv_people;
    public Button bt_mai;
    public Button bt_yu;

    public MyHolder(View itemView) {
        super(itemView);
        iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
        iv_mode = (ImageView) itemView.findViewById(R.id.iv_mode);
        tv_name = (TextView) itemView.findViewById(R.id.tv_name);
        tv_gread = (TextView) itemView.findViewById(R.id.tv_gread);
        tv_introduce = (TextView) itemView.findViewById(R.id.tv_introduce);
        tv_people = (TextView) itemView.findViewById(R.id.tv_people);
        bt_mai = (Button) itemView.findViewById(R.id.bt_mai);
        bt_yu = (Button) itemView.findViewById(R.id.bt_yu);
    }
}

/**
 * 头部holder
 */
class HeadHolder extends RecyclerView.ViewHolder {
    public ViewPager vp_reying_title;
    private LinearLayout ll_sousou;
    public HeadHolder(View itemView) {
        super(itemView);
        vp_reying_title = (ViewPager) itemView.findViewById(R.id.vp_reying_title);
        ll_sousou = (LinearLayout) itemView.findViewById(R.id.ll_sousou);
    }
}



