package com.atguigu.maoyan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.atguigu.maoyan.R;

import java.util.List;

/**
 * Created by tao on 2016/6/27.
 */
public class Refresh1Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List list;

    public Refresh1Adapter(Context context, List list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item1, null);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ItemHolder)holder).tv1.setText(list.get(position)+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class ItemHolder extends RecyclerView.ViewHolder {
        private TextView tv1;
        public ItemHolder(View view) {
            super(view);
            tv1 = (TextView) view.findViewById(R.id.tv1);
        }
    }
}
