package com.atguigu.maoyan.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.activity.SousuoActivity;
import com.atguigu.maoyan.bean.Stdybean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tao on 2016/6/27.
 */
public class StdyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int ONE = 0;
    private static final int TWO = 1;
    //listview集合
    private List<Stdybean.DataBean.ComingBean> list;
    private Context context;

    public StdyAdapter(Context context, List<Stdybean.DataBean.ComingBean> cominglist) {
        this.context = context;
        this.list = cominglist;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == ONE) {
            View view = View.inflate(context, R.layout.refresh1_item, null);
            return new RefreshHolder(view);
        }
        if (viewType == TWO) {
            View view = View.inflate(context, R.layout.content_item, null);
            return new ContentHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RefreshHolder) {
            if (position == 0) {
                List list1 = new ArrayList();
                for (int i = 1; i < 20; i++) {
                    list1.add("大家好帅" + i);
                }
                ((RefreshHolder) holder).rl1.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                ((RefreshHolder) holder).rl1.setAdapter(new Refresh1Adapter(context, list1));
                List list2 = new ArrayList();
                for (int i = 1; i < 20; i++) {
                    list2.add("老师好帅" + i);
                }
                ((RefreshHolder) holder).rl2.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                ((RefreshHolder) holder).rl2.setAdapter(new Refresh2Adapter(context, list2));
            }
        }

        if (holder instanceof ContentHolder) {
            Stdybean.DataBean.ComingBean comingBean = list.get(position - 1);

            //是否显示标题
            String rt = comingBean.getRt();
            for(int i = 0;i<list.indexOf(comingBean);i++){
                if(rt.equals(list.get(i).getRt())){
                    ((ContentHolder) holder).ll_date.setVisibility(View.GONE);
                    break;
                }
                ((ContentHolder) holder).ll_date.setVisibility(View.VISIBLE);
            }
            
            if(list.indexOf(comingBean) == 0) {
                ((ContentHolder) holder).ll_date.setVisibility(View.VISIBLE);
            }
            //显示日期
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf2 = new SimpleDateFormat("MM月dd日 E");
            Date date = null;//提取格式中的日期
            try {
                date = sdf1.parse(rt);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            rt = sdf2.format(date);
            ((ContentHolder) holder).tv_month.setText(rt);

            ((ContentHolder) holder).tv_name.setText(comingBean.getNm());
            ((ContentHolder) holder).tv_gread.setText(comingBean.getWish() + "人想看");
            ((ContentHolder) holder).tv_introduce.setText(comingBean.getScm());
            ((ContentHolder) holder).tv_people.setText(comingBean.getDesc());

            if (comingBean.getHeadLinesVO() != null&&comingBean.getHeadLinesVO().size()>0) {
                ((ContentHolder) holder).ll_zhuan.setVisibility(View.VISIBLE);
                ((ContentHolder) holder).tv_zhuti.setText(comingBean.getHeadLinesVO().get(0).getType());
                ((ContentHolder) holder).tv1.setText(comingBean.getHeadLinesVO().get(0).getTitle());
            } else {
                ((ContentHolder) holder).ll_zhuan.setVisibility(View.GONE);
            }
            if (comingBean.getShowst() == 1) {
                ((ContentHolder) holder).ll_want.setVisibility(View.VISIBLE);
                ((ContentHolder) holder).bt_yu.setVisibility(View.GONE);
            }
            if (comingBean.getShowst() == 4) {
                ((ContentHolder) holder).ll_want.setVisibility(View.GONE);
                ((ContentHolder) holder).bt_yu.setVisibility(View.VISIBLE);
            }

            Glide.with(context).load(comingBean.getImg())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                    .placeholder(R.drawable.background_icon01)//加载过程中的图片
                    .error(R.drawable.background_icon01)//加载失败的时候显示的图片
                    .into(((ContentHolder) holder).iv_icon);//请求成功后把图片设置到的控件
        }
    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ONE;
        }
        return TWO;
    }

    class ContentHolder extends RecyclerView.ViewHolder {
        public ImageView iv_icon;
        public ImageView iv_mode;
        public ImageView iv_max;

        public TextView tv_name;
        public TextView tv_gread;
        public TextView tv_introduce;
        public TextView tv_people;
        public TextView tv_month;
        public TextView tv1;
        public TextView tv_zhuti;

        public LinearLayout ll_want;
        public LinearLayout ll_date;
        public LinearLayout ll_zhuan;

        public Button bt_yu;

        public ContentHolder(View itemView) {
            super(itemView);
            iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
            iv_mode = (ImageView) itemView.findViewById(R.id.iv_mode);
            iv_max = (ImageView) itemView.findViewById(R.id.iv_max);

            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_gread = (TextView) itemView.findViewById(R.id.tv_gread);
            tv_introduce = (TextView) itemView.findViewById(R.id.tv_introduce);
            tv_people = (TextView) itemView.findViewById(R.id.tv_people);
            tv_month = (TextView) itemView.findViewById(R.id.tv_month);

            bt_yu = (Button) itemView.findViewById(R.id.bt_yu);

            ll_want = (LinearLayout) itemView.findViewById(R.id.ll_want);
            ll_zhuan = (LinearLayout) itemView.findViewById(R.id.ll_zhuan);
            tv1 = (TextView) itemView.findViewById(R.id.tv1);
            tv_zhuti = (TextView) itemView.findViewById(R.id.tv_zhuti);
            ll_date = (LinearLayout) itemView.findViewById(R.id.ll_date);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onStdylistener != null){
                        onStdylistener.onstdyonclicklistener(v,getLayoutPosition());
                    }
                }
            });
        }
    }

    class RefreshHolder extends RecyclerView.ViewHolder {
        private LinearLayout ll_sousou;
        private RecyclerView rl1;
        private RecyclerView rl2;

        public RefreshHolder(View view) {
            super(view);
            rl1 = (RecyclerView) view.findViewById(R.id.rl1);
            rl2 = (RecyclerView) view.findViewById(R.id.rl2);
            ll_sousou = (LinearLayout)view.findViewById(R.id.ll_sousou);

            ll_sousou.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, SousuoActivity.class));
                }
            });
        }
    }


    public interface OnStdylistener{
        void onstdyonclicklistener(View v, int layoutPosition);
    }

    public OnStdylistener onStdylistener;

    public void setOnStdylistener(OnStdylistener onStdylistener) {
        this.onStdylistener = onStdylistener;
    }
}


