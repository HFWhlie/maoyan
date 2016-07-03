package com.atguigu.maoyan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.bean.Gridbean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/**
 * Created by tao on 2016/7/2.
 */
public class FootAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<Gridbean.DataBean.ListBean> list;

    public FootAdapter(Context context, List<Gridbean.DataBean.ListBean> list) {
        this.context =context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sm_item, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Gridbean.DataBean.ListBean listBean = list.get(position);
        ((Holder) holder).tv.setText(listBean.getTitle());
        ((Holder) holder).tv_price.setText(listBean.getPrice() + "元");
        ((Holder) holder).tv_preprice.setText(listBean.getValue() + "元");
        Glide.with(context).load(listBean.getPic())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.background_icon01)
                .error(R.drawable.background_icon01)
                .into(((Holder) holder).iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class Holder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv;
        private TextView tv_price;
        private TextView tv_preprice;
        public Holder(View view) {
            super(view);
            iv = (ImageView) view.findViewById(R.id.iv);
            tv = (TextView) view.findViewById(R.id.tv);
            tv_price = (TextView) view.findViewById(R.id.tv_price);
            tv_preprice = (TextView) view.findViewById(R.id.tv_preprice);
        }
    }
}
