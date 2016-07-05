package com.atguigu.maoyan.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.bean.Classify;

import java.util.List;

/**
 * Created by tao on 2016/7/1.
 * 全球电影奖项
 */
public class KnobAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int FIVE = 5;
    private int FOUR = 4;
    private int THREE = 3;
    private int TWO = 2;
    private int ZERO = 0;
    private int ONE = 1;
    private final List<Classify.DataBean> list;
    private Context context;

    public KnobAdapter(Context context, List<Classify.DataBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ZERO) {
            View view = LayoutInflater.from(context).inflate(R.layout.knob_item, null);
            return new Holder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == ZERO) {
            ((Holder) holder).setData();
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        String region = list.get(position).getRegion();
        if (region.equals("热门")) {
            return ZERO;
        }
//        if (region.equals("华语")) {
//            return ONE;
//        }
//        if (region.equals("北美")) {
//            return TWO;
//        }
//        if (region.equals("亚洲")) {
//            return THREE;
//        }
//        if (region.equals("欧洲")) {
//            return FOUR;
//        }
//        if (region.equals("其他")) {
//            return FIVE;
//        }
        return -1;
    }

    private class Holder extends RecyclerView.ViewHolder {
        private RecyclerView knob_view;
        private TextView tv_title;
//        private TextView tv_other;
//        private TextView tv_other1;

        public Holder(View view) {
            super(view);
//            tv_other = (TextView) view.findViewById(R.id.tv_other);
//            tv_other1 = (TextView) view.findViewById(R.id.tv_other1);
            tv_title = (TextView) view.findViewById(R.id.tv_title);
            knob_view = (RecyclerView) view.findViewById(R.id.knob_view);
        }

        public void setData() {
            Classify.DataBean dataBean = list.get(0);
            final List<Classify.DataBean.FestivalsBean> festivals = dataBean.getFestivals();
            tv_title.setText(dataBean.getRegion());
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
            knob_view.setLayoutManager(gridLayoutManager);
            knob_view.setAdapter(new RecyclerView.Adapter() {
                @Override
                public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                    View view = LayoutInflater.from(context).inflate(R.layout.item, null);
                    return new Itemholder(view);
                }

                @Override
                public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                    ((Itemholder) holder).tv_other.setText(festivals.get(position).getFestivalName());
                }

                @Override
                public int getItemCount() {
                    return festivals.size();
                }
            });

        }

        private class Itemholder extends RecyclerView.ViewHolder {
            private TextView tv_other;

            public Itemholder(View view) {
                super(view);
                tv_other = (TextView) view.findViewById(R.id.tv_other);

            }
        }
    }
}
