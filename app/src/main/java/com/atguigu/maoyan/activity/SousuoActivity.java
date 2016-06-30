package com.atguigu.maoyan.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.atguigu.maoyan.R;

/**
 * Created by tao on 2016/6/29.
 */
public class SousuoActivity extends Activity implements View.OnClickListener {
    private TextView tv_cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sousuo);


        findView();
        setListener();



    }

    private void setListener() {
        tv_cancel.setOnClickListener(this);
    }

    private void findView() {
        tv_cancel = (TextView) findViewById(R.id.tv_cancel);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.tv_cancel:
                finish();
                break;
        }
    }
}
