package com.atguigu.maoyan.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.CartProvider;
import com.atguigu.maoyan.adapter.Busadapter;
import com.atguigu.maoyan.bean.ShoppingCart;

import java.util.List;

public class CartActivity extends Activity {
    private Context context;
    /**
     * 购物车的数据
     */
    private List<ShoppingCart> datas;

    /**
     * 编辑状态
     */
    private static final int ACTION_EDIT = 1;
    /**
     * 完成状态
     */
    private static final int ACITON_COMPLETE = 2;

    private ImageView iv_back;
    private Button btn_cart;
    private RecyclerView recyclerview;
    private CheckBox checkbox_all;
    private TextView tv_total_price;
    private Button btn_order;
    private Button btn_delete;
    private Busadapter adapter;
    private CartProvider cartProvider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        context = this;
        cartProvider = new CartProvider(context);
        findView();
        initData();
        setlistener();

    }

    private void setlistener() {
        btn_cart.setTag(ACTION_EDIT);
        //设置点击事件
        btn_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //得到状态
                int action = (int) btn_cart.getTag();

                if (action == ACTION_EDIT) {
                    //显示删除按钮
                    showDeleteButton();
                } else if (action == ACITON_COMPLETE) {
                    //隐藏删除按钮
                    hideDeleteButton();
                }

            }
        });

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //设置删除按钮的点击事件
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.deleteData();
            }
        });
    }

    private void hideDeleteButton() {
        //1.设置文本为编辑
        btn_cart.setText("编辑");
        //2.设置全部为 勾选和全选按钮为 勾选
        adapter.all_none(true);
        checkbox_all.setChecked(true);
        //3.显示价格
        tv_total_price.setVisibility(View.VISIBLE);
        //4.隐藏删除按钮
        btn_delete.setVisibility(View.GONE);
        //5.显示结算按钮
        btn_order.setVisibility(View.VISIBLE);
        //6.设置状态 ACTION_EDIT
        btn_cart.setTag(ACTION_EDIT);
    }

    private void showDeleteButton() {
        //1.设置文本为完成
        btn_cart.setText("完成");
        //2.设置全部为非勾选和全选按钮为非勾选
        adapter.all_none(false);
        checkbox_all.setChecked(false);
        //3.隐藏价格
        tv_total_price.setVisibility(View.GONE);
        //4.显示删除按钮
        btn_delete.setVisibility(View.VISIBLE);
        //5.隐藏结算按钮
        btn_order.setVisibility(View.GONE);
        //6.设置状态 ACTION_COMPLETE
        btn_cart.setTag(ACITON_COMPLETE);
    }

    private void initData() {
        datas = cartProvider.getAllData();
        adapter = new Busadapter(context, datas, tv_total_price, checkbox_all);
        recyclerview.setAdapter(adapter);

        //设置布局管理器
        recyclerview.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
    }

    private void findView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        btn_cart = (Button) findViewById(R.id.btn_cart);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        tv_total_price = (TextView) findViewById(R.id.tv_total_price);
        checkbox_all = (CheckBox) findViewById(R.id.checkbox_all);
        btn_order = (Button) findViewById(R.id.btn_order);
        btn_delete = (Button) findViewById(R.id.btn_delete);
    }
}
