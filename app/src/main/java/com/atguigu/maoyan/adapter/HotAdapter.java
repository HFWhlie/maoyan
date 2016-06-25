package com.atguigu.maoyan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.atguigu.maoyan.R;

import java.util.List;

/**
 * Created by tao on 2016/6/25.
 */
public class HotAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<String> list;

    public HotAdapter(Context context, List list) {
        this.context = context;
        this.list = list;
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
            return;
        }
        if (position == 1) {
            return;
        }
        String s = list.get(position);
        ((MyHolder) holder).tv.setText(s);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        }
        return 1;
    }
}

class MyHolder extends RecyclerView.ViewHolder {

    public TextView tv;

    public MyHolder(View itemView) {
        super(itemView);
        tv = (TextView) itemView.findViewById(R.id.tv_te);
    }
}

class HeadHolder extends RecyclerView.ViewHolder {

    public HeadHolder(View itemView) {
        super(itemView);
    }
}

