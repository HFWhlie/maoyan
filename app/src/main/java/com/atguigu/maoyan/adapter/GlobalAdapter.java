package com.atguigu.maoyan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.bean.Globalbean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/**
 * Created by tao on 2016/6/30.
 */
public class GlobalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Globalbean.ListBean> list;

    public GlobalAdapter(Context context, List<Globalbean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.global_item, null);
        return new GlobalHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Globalbean.ListBean listBean = list.get(position);
        ((GlobalHolder)holder).tv_name.setText(listBean.getNm());
        ((GlobalHolder)holder).tv_konb.setText(listBean.getFra());
        Glide.with(context).load(listBean.getImg())
                .placeholder(R.drawable.background_icon01)
                .error(R.drawable.background_icon01)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(((GlobalHolder)holder).iv_icon);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class GlobalHolder extends RecyclerView.ViewHolder {
        private TextView tv_konb;
        private TextView tv_name;
        private ImageView iv_icon;
        public GlobalHolder(View view) {
            super(view);
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_konb = (TextView) view.findViewById(R.id.tv_konb);
            iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
        }
    }
}
