package com.atguigu.maoyan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.CartProvider;
import com.atguigu.maoyan.bean.ShoppingCart;
import com.atguigu.maoyan.bean.Shumabean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/**
 * Created by tao on 2016/7/2.
 */
public class ShoptextAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Shumabean.DataBean.ListBean> list;

    private CartProvider cartProvider;

    public ShoptextAdapter(Context context, List<Shumabean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
        cartProvider = new CartProvider(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sm_item, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Shumabean.DataBean.ListBean listBean = list.get(position);
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

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Shumabean.DataBean.ListBean listBean = list.get(getLayoutPosition());
                    ShoppingCart shopCar = cartProvider.conversion(listBean);
                    cartProvider.addData(shopCar);
                }
            });
        }
    }
}
