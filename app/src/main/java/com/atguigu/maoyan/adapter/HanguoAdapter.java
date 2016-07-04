package com.atguigu.maoyan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.bean.Hanbean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/**
 * Created by tao on 2016/6/27.
 */
public class HanguoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Hanbean.DataBean.HotBean> hot;
    private Context context;
    private View view;

    public HanguoAdapter(Context context, List<Hanbean.DataBean.HotBean> hot) {
        this.context = context;
        this.hot = hot;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = View.inflate(context, R.layout.han_item, null);
        return new HanHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Hanbean.DataBean.HotBean hotBean = hot.get(position);
        ((HanHolder) holder).tv_name.setText(hotBean.getNm());
        ((HanHolder) holder).tv_gread.setText(hotBean.getSc() + "");
        ((HanHolder) holder).tv_introduce.setText(hotBean.getCat());
        ((HanHolder) holder).tv_people.setText(hotBean.getDesc());
        if (hotBean.getHeadLinesVO() != null && hotBean.getHeadLinesVO().size() > 0) {
            ((HanHolder) holder).ll_zhuan.setVisibility(View.VISIBLE);
            ((HanHolder) holder).tv_zhuti.setText(hotBean.getHeadLinesVO().get(0).getType());
            ((HanHolder) holder).tv1.setText(hotBean.getHeadLinesVO().get(0).getTitle());
            ((HanHolder) holder).tv_zhuangfang.setText(hotBean.getHeadLinesVO().get(1).getType());
            ((HanHolder) holder).tv2.setText(hotBean.getHeadLinesVO().get(1).getTitle());
        } else {
            ((HanHolder) holder).ll_zhuan.setVisibility(View.GONE);
        }
        if (hotBean.getShowst() == 2) {
            ((HanHolder) holder).bt_mai.setVisibility(View.GONE);
            ((HanHolder) holder).ll_want.setVisibility(View.VISIBLE);
        }
        if (hotBean.getShowst() == 3) {
            ((HanHolder) holder).bt_mai.setVisibility(View.VISIBLE);
            ((HanHolder) holder).ll_want.setVisibility(View.GONE);
        }
        Glide.with(context).load(hotBean.getImg())
                .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                .placeholder(R.drawable.background_icon01)//加载过程中的图片
                .error(R.drawable.background_icon01)//加载失败的时候显示的图片
                .into(((HanHolder) holder).iv_icon);//请求成功后把图片设置到的控件
    }

    @Override
    public int getItemCount() {
        return hot.size();
    }

    private class HanHolder extends RecyclerView.ViewHolder {

        private ImageView iv_icon;

        private TextView tv_name;
        private TextView tv_gread;
        private TextView tv_introduce;
        private TextView tv_people;
        private TextView tv_zhuti;
        private TextView tv1;
        private TextView tv_zhuangfang;
        private TextView tv2;

        private Button bt_mai;

        private LinearLayout ll_want;
        private LinearLayout ll_zhuan;

        public HanHolder(View view) {
            super(view);
            iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
            bt_mai = (Button) view.findViewById(R.id.bt_mai);
            ll_want = (LinearLayout) view.findViewById(R.id.ll_want);
            ll_zhuan = (LinearLayout) view.findViewById(R.id.ll_zhuan);
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_gread = (TextView) view.findViewById(R.id.tv_gread);
            tv_introduce = (TextView) view.findViewById(R.id.tv_introduce);
            tv_people = (TextView) view.findViewById(R.id.tv_people);
            tv_zhuti = (TextView) view.findViewById(R.id.tv_zhuti);
            tv1 = (TextView) view.findViewById(R.id.tv1);
            tv2 = (TextView) view.findViewById(R.id.tv2);
            tv_zhuangfang = (TextView) view.findViewById(R.id.tv_zhuangfang);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onClickHanitemlistener != null){
                        onClickHanitemlistener.onClickHanitemlistener(v,getLayoutPosition());
                    }
                }
            });
        }
    }

    public interface OnClickHanitemlistener {
        void onClickHanitemlistener(View v, int layoutPosition);
    }

    public OnClickHanitemlistener onClickHanitemlistener;

    public void setOnClickHanitemlistener(OnClickHanitemlistener onClickHanitemlistener) {
        this.onClickHanitemlistener = onClickHanitemlistener;
    }
}
