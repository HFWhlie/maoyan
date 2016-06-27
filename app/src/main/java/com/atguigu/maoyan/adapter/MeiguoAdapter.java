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
import com.atguigu.maoyan.bean.Meibean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/**
 * Created by tao on 2016/6/27.
 */
public class MeiguoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Meibean.DataBean.ComingBean> cominglist;
    private View view;

    public MeiguoAdapter(Context context, List<Meibean.DataBean.ComingBean> coming) {
        this.context = context;
        this.cominglist = coming;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = View.inflate(context, R.layout.mei_item, null);
        return new MeiHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Meibean.DataBean.ComingBean comingBean = cominglist.get(position);

        ((MeiHolder)holder).tv_name.setText(comingBean.getNm());
        ((MeiHolder)holder).tv_gread.setText(comingBean.getWish()+"");
        ((MeiHolder)holder).tv_introduce.setText(comingBean.getOverseaTime()+"美国上映");
        ((MeiHolder)holder).tv_people.setText(comingBean.getDesc());
//        if(comingBean.getShowst() == 1) {
//            ((MeiHolder)holder).bt_mai.setVisibility(View.GONE);
//            ((MeiHolder)holder).bt_yu.setVisibility(View.GONE);
//            ((MeiHolder)holder).ll_want.setVisibility(View.VISIBLE);
//        }
//        if(comingBean.getShowst() == 4){
//            ((MeiHolder)holder).bt_mai.setVisibility(View.GONE);
//            ((MeiHolder)holder).bt_yu.setVisibility(View.VISIBLE);
//            ((MeiHolder)holder).ll_want.setVisibility(View.GONE);
//        }
        ((MeiHolder)holder).ll_want.setVisibility(View.VISIBLE);

        Glide.with(context).load(comingBean.getImg())
                .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                .placeholder(R.drawable.background_icon01)//加载过程中的图片
                .error(R.drawable.background_icon01)//加载失败的时候显示的图片
                .into(((MeiHolder) holder).iv_icon);//请求成功后把图片设置到的控件
    }

    @Override
    public int getItemCount() {
        return cominglist.size();
    }

    private class MeiHolder extends RecyclerView.ViewHolder {
        private ImageView iv_icon;
        private ImageView iv_mode;
        private ImageView iv_max;
        private ImageView iv_stdy;

        private TextView tv_name;
        private TextView tv_gread;
        private TextView tv_introduce;
        private TextView tv_people;

        private Button bt_mai;
        private Button bt_yu;
        private LinearLayout ll_want;

        public MeiHolder(View view) {
            super(view);
            iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
            iv_mode = (ImageView) view.findViewById(R.id.iv_mode);
            iv_max = (ImageView) view.findViewById(R.id.iv_max);
            iv_stdy = (ImageView) view.findViewById(R.id.iv_stdy);

            tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_gread = (TextView) view.findViewById(R.id.tv_gread);
            tv_introduce = (TextView) view.findViewById(R.id.tv_introduce);
            tv_people = (TextView) view.findViewById(R.id.tv_people);

            bt_mai = (Button) view.findViewById(R.id.bt_mai);
            bt_yu = (Button) view.findViewById(R.id.bt_yu);
            ll_want = (LinearLayout) view.findViewById(R.id.ll_want);


        }
    }
}
