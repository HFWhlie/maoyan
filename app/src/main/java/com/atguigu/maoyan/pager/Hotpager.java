package com.atguigu.maoyan.pager;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.adapter.HotAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tao on 2016/6/24.
 */
public class Hotpager extends Basepager {
    private View view;
    private SwipeRefreshLayout sf_refresh;
    private RecyclerView rl_refresh;
    private HotAdapter adapter;

    public Hotpager(Context context) {
        super(context);
    }


    @Override
    public View initview() {
        view = View.inflate(context, R.layout.hot_pager, null);
        findView();
        return view;
    }

    private void findView() {
        sf_refresh = (SwipeRefreshLayout) view.findViewById(R.id.sf_refresh);
        rl_refresh = (RecyclerView) view.findViewById(R.id.rl_refresh);
    }

    @Override
    public void initData() {
        List<String> list = new ArrayList();
        for (int i = 0; i < 20; i++) {
            list.add("猫眼电影"+i);
        }
        //设置布局管理器
        LinearLayoutManager manager = new LinearLayoutManager(context);
        rl_refresh.setLayoutManager(manager);
        //设置适配器
        adapter = new HotAdapter(context,list);
        rl_refresh.setAdapter(adapter);


    }
}
