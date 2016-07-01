package com.atguigu.maoyan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.atguigu.maoyan.bean.Classify;

import java.util.List;

/**
 * Created by tao on 2016/7/1.
 * 全球电影奖项
 */
public class KnobAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Classify.DataBean> data;
    private Classify list;
    private Context context;

    public KnobAdapter(Context context, Classify list) {
        this.context = context;
        this.list = list;
        data = list.getData();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
