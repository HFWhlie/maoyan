package com.atguigu.maoyan.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.atguigu.maoyan.Holder.BaseHolder;
import com.atguigu.maoyan.R;
import com.atguigu.maoyan.activity.HotHfive;
import com.atguigu.maoyan.activity.ShopPagerActivity;
import com.atguigu.maoyan.bean.Gridbean;
import com.atguigu.maoyan.bean.Shoppagerbean;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by tao on 2016/7/2.
 */
public class ShopAdapter extends RecyclerView.Adapter<BaseHolder> {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private Context context;
    private List<Shoppagerbean.DataBean> data;
    private List<Gridbean.DataBean.ListBean> list;

    public static String ecshop_gride = "{\"data\":{\"list\":[{\"dealid\":38292972,\"pic\":\"http://p0.meituan.net/348.348/movie/36aba8e808faa11da5e015add2d0c1b2139888.jpg@60q\",\"price\":35,\"title\":\"GetD魔兽电影主题3D眼镜（预售）\",\"value\":99},{\"dealid\":38330793,\"pic\":\"http://p0.meituan.net/348.348/movie/b2d68f14b9ff41b75211af78cb767a5a273569.jpg@60q\",\"price\":89,\"title\":\"愤怒的小鸟毛绒玩具 大电影儿童公仔玩具\",\"value\":119},{\"dealid\":38319221,\"pic\":\"http://p0.meituan.net/348.348/movie/e09ae917fa6e238237cab5e7570c933f410487.jpg@60q\",\"price\":68,\"title\":\"愤怒的小鸟经典常规款公仔 30cm\",\"value\":78},{\"dealid\":38319215,\"pic\":\"http://p0.meituan.net/348.348/movie/b2d68f14b9ff41b75211af78cb767a5a273569.jpg@60q\",\"price\":88,\"title\":\"愤怒的小鸟经典款大号公仔 37CM\",\"value\":98},{\"dealid\":38319224,\"pic\":\"http://p1.meituan.net/348.348/movie/2fea2c8ac8b3c090c699c4421cdd8f32355332.jpg@60q\",\"price\":48,\"title\":\"愤怒的小鸟经典款小公仔 22cm\",\"value\":60},{\"dealid\":38319228,\"pic\":\"http://p0.meituan.net/348.348/movie/dfa76dd2a59ca7fdb3738b726bfd439d366839.jpg@60q\",\"price\":28,\"title\":\"愤怒的小鸟系列经典款迷你公仔3件包邮！\",\"value\":38},{\"dealid\":38330823,\"pic\":\"http://p1.meituan.net/348.348/movie/55ea6ecf7d045450c80dedbe0da85d4f44402.jpg@60q\",\"price\":199,\"title\":\"《魔兽世界》正版模型 洛萨之剑\",\"value\":209},{\"dealid\":38330820,\"pic\":\"http://p0.meituan.net/348.348/movie/1b5b9c6814b1268c047f2da9073eef5050289.jpg@60q\",\"price\":199,\"title\":\"《魔兽世界》 杜隆坦之斧升级版\",\"value\":209},{\"dealid\":38330819,\"pic\":\"http://p0.meituan.net/348.348/movie/a174a9391c38afd0320c8c6164706e3130991.jpg@60q\",\"price\":39,\"title\":\"《魔兽世界》正版3D眼镜联盟款\",\"value\":69},{\"dealid\":38330818,\"pic\":\"http://p0.meituan.net/348.348/movie/ec71dc9533a98f9a1045eeb252f517af23998.jpg@60q\",\"price\":39,\"title\":\"《魔兽世界》正版3D眼镜部落款\",\"value\":69}],\"total\":823}}";


    public ShopAdapter(Context context, List<Shoppagerbean.DataBean> data) {
        this.context = context;
        this.data = data;

    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == ZERO) {
            View view = LayoutInflater.from(context).inflate(R.layout.viewpager, null);
            return new HeadHolder(view);
        }
        if (viewType == ONE) {
            View view = LayoutInflater.from(context).inflate(R.layout.price, null);
            return new ContentHolder(view);
        }
        if (viewType == TWO) {
            View view = LayoutInflater.from(context).inflate(R.layout.glird, null);
            return new FootHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        if (getItemViewType(position) == ZERO) {
            if (position == 0) {
                holder.setData();
            }
        }

        if (getItemViewType(position) == ONE) {
            if (position > 0 && position < 4) {
                holder.setData();
            }
        }
        if (getItemViewType(position) == TWO) {
            Gridbean gridbean = new Gson().fromJson(ecshop_gride, Gridbean.class);
            List<Gridbean.DataBean.ListBean> list = gridbean.getData().getList();

            GridLayoutManager manager = new GridLayoutManager(context, 2);
            ((FootHolder) holder).recyclerView.setLayoutManager(manager);
            FootAdapter adapter = new FootAdapter(context, list);
            ((FootHolder) holder).recyclerView.setAdapter(adapter);
        }
    }


    @Override
    public int getItemCount() {
        return 5;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ZERO;
        }
        if (position == 1) {
            return ONE;
        }
        if (position == 2) {
            return ONE;
        }
        if (position == 3) {
            return ONE;
        }
        return TWO;
    }

    /**
     * viewpager 的holder
     */
    private class HeadHolder extends BaseHolder implements View.OnClickListener {
        private ViewPager vp_shop;
        private LinearLayout ll_0;
        private LinearLayout ll_1;
        private LinearLayout ll_2;
        private LinearLayout ll_3;
        private LinearLayout ll_4;
        private LinearLayout ll_5;
        private LinearLayout ll_6;
        private LinearLayout ll_7;
        private LinearLayout ll_8;
        private LinearLayout ll_9;
        private Intent intent;

        public HeadHolder(View view) {
            super(view);
            vp_shop = (ViewPager) view.findViewById(R.id.vp_shop);
            ll_0 = (LinearLayout) view.findViewById(R.id.ll_0);
            ll_1 = (LinearLayout) view.findViewById(R.id.ll_1);
            ll_2 = (LinearLayout) view.findViewById(R.id.ll_2);
            ll_3 = (LinearLayout) view.findViewById(R.id.ll_3);
            ll_4 = (LinearLayout) view.findViewById(R.id.ll_4);
            ll_5 = (LinearLayout) view.findViewById(R.id.ll_5);
            ll_6 = (LinearLayout) view.findViewById(R.id.ll_6);
            ll_7 = (LinearLayout) view.findViewById(R.id.ll_7);
            ll_8 = (LinearLayout) view.findViewById(R.id.ll_8);
            ll_9 = (LinearLayout) view.findViewById(R.id.ll_9);

            setListener();
        }

        private void setListener() {
            ll_0.setOnClickListener(this);
            ll_1.setOnClickListener(this);
            ll_2.setOnClickListener(this);
            ll_3.setOnClickListener(this);
            ll_4.setOnClickListener(this);
            ll_5.setOnClickListener(this);
            ll_6.setOnClickListener(this);
            ll_7.setOnClickListener(this);
            ll_8.setOnClickListener(this);
            ll_9.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            intent = new Intent(context, ShopPagerActivity.class);
            switch (v.getId()) {
                case R.id.ll_1:
                    intent.setFlags(1);
                    break;
                case R.id.ll_2:
                    intent.setFlags(2);
                    break;
                case R.id.ll_3:
                    intent.setFlags(3);
                    break;
                case R.id.ll_4:
                    intent.setFlags(4);
                    break;
                case R.id.ll_5:
                    intent.setFlags(5);
                    break;
                case R.id.ll_6:
                    intent.setFlags(6);
                    break;
                case R.id.ll_7:
                    intent.setFlags(7);
                    break;
                case R.id.ll_8:
                    intent.setFlags(8);
                    break;
                case R.id.ll_9:
                    intent.setFlags(9);
                    break;
                case R.id.ll_0:
                    intent.setFlags(0);
                    break;
            }
            context.startActivity(intent);
        }

        @Override
        public void setData() {
            ShowPagerAdapter adapter = new ShowPagerAdapter(context, data);
            vp_shop.setAdapter(adapter);

            //轮播图
            vp_shop.setCurrentItem(50);
            if (initHandler == null) {
                initHandler = new InitHandler();
            }
            initHandler.removeCallbacksAndMessages(null);

            initHandler.postDelayed(new Myrunnable(), 2000);
        }

        public InitHandler initHandler;

        private class InitHandler extends Handler {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                int i = vp_shop.getCurrentItem() + 1;
                vp_shop.setCurrentItem(i);

                initHandler.postDelayed(new Myrunnable(), 2000);
            }
        }

        private class Myrunnable implements Runnable {
            @Override
            public void run() {
                initHandler.sendEmptyMessage(0);
            }
        }
    }

    /**
     * 每月特价 的holder
     */
    private class ContentHolder extends BaseHolder implements View.OnClickListener {
        private ImageView iv_one;
        private ImageView iv_two;
        private ImageView iv_three;

        public ContentHolder(View view) {
            super(view);
            iv_one = (ImageView) view.findViewById(R.id.iv_one);
            iv_two = (ImageView) view.findViewById(R.id.iv_two);
            iv_three = (ImageView) view.findViewById(R.id.iv_three);
            setListener();
        }

        private void setListener() {
            iv_one.setOnClickListener(this);
            iv_two.setOnClickListener(this);
            iv_three.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, HotHfive.class);
            switch (v.getId()) {
                case R.id.iv_one:
                    intent.setFlags(7);
                    break;
                case R.id.iv_two:
                    intent.setFlags(8);
                    break;
                case R.id.iv_three:
                    intent.setFlags(9);
                    break;
            }
            context.startActivity(intent);
        }
    }

    /**
     * Foot 的holder
     */
    private class FootHolder extends BaseHolder {
        private RecyclerView recyclerView;

        public FootHolder(View view) {
            super(view);
            recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        }
    }
}

