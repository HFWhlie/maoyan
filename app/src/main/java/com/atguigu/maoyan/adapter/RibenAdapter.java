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
import com.atguigu.maoyan.bean.Ribean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/**
 * Created by tao on 2016/6/28.
 */
public class RibenAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<Ribean.DataBean.HotBean> hotlist;
    private View view;

    public RibenAdapter(Context context, List<Ribean.DataBean.HotBean> hotlist) {
        this.context = context;
        this.hotlist = hotlist;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = View.inflate(context, R.layout.ri_item, null);
        return new RiHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Ribean.DataBean.HotBean hotBean = hotlist.get(position);
        ((RiHolder) holder).tv_name.setText(hotBean.getNm());
        ((RiHolder) holder).tv_gread.setText(hotBean.getSc() + "");
        ((RiHolder) holder).tv_introduce.setText(hotBean.getCat());
        ((RiHolder) holder).tv_people.setText(hotBean.getDesc());
        ((RiHolder) holder).ll_zhuan.setVisibility(View.GONE);

        if (hotBean.getShowst() == 2) {
            ((RiHolder) holder).bt_mai.setVisibility(View.GONE);
            ((RiHolder) holder).ll_want.setVisibility(View.VISIBLE);
        }
        if (hotBean.getShowst() == 1) {
            ((RiHolder) holder).bt_mai.setVisibility(View.VISIBLE);
            ((RiHolder) holder).ll_want.setVisibility(View.GONE);
        }
        Glide.with(context).load(hotBean.getImg())
                .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                .placeholder(R.drawable.background_icon01)//加载过程中的图片
                .error(R.drawable.background_icon01)//加载失败的时候显示的图片
                .into(((RiHolder) holder).iv_icon);//请求成功后把图片设置到的控件
    }

    @Override
    public int getItemCount() {
        return hotlist.size();
    }

    private class RiHolder extends RecyclerView.ViewHolder {
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

        public RiHolder(View view) {
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
                    if(onClickriitemlistener != null){
                        onClickriitemlistener.onClickriitemlistener(v,getLayoutPosition());
                    }
                }
            });
        }
    }

    public interface OnClickriitemlistener{
        void onClickriitemlistener(View v, int layoutPosition);
    }

    public OnClickriitemlistener onClickriitemlistener;

    public void setOnClickriitemlistener(OnClickriitemlistener onClickriitemlistener) {
        this.onClickriitemlistener = onClickriitemlistener;
    }
}
