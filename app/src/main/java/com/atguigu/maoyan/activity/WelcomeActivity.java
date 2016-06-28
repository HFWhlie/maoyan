package com.atguigu.maoyan.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;

import com.atguigu.maoyan.R;

public class WelcomeActivity extends Activity {
    private static final int TWO = 1;
    public Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case TWO:
                    startActivity(new Intent(WelcomeActivity.this,WelcomeActivity2.class));
                    finish();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);

        new Thread(new Runnable() {
            @Override
            public void run() {
                //启动到欢迎页面2
                handler.sendEmptyMessageDelayed(TWO,1000);
            }
        }).start();
    }
}
