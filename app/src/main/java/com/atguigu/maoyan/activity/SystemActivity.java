package com.atguigu.maoyan.activity;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.atguigu.maoyan.R;

public class SystemActivity extends Activity {
    private Context context;
    private VideoView vv;
    private Uri data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_system);
        context = this;
        findView();

        initData();
    }

    private void initData() {
        data = getIntent().getData();
        vv.setVideoURI(data);

        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            /**
             * 启动播放
             * @param mp
             */
            @Override
            public void onPrepared(MediaPlayer mp) {
                //设置循环播放
//                mp.setLooping(true);
                //开始播放
                vv.start();
            }
        });
        vv.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            /**
             * 播放出错
             * @param mp
             * @param what
             * @param extra
             * @return
             */
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(context, "播放出错了", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(context, "播放完成", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        //设置控制面板
        vv.setMediaController(new MediaController(context));
    }

    private void findView() {
        vv = (VideoView) findViewById(R.id.vv);
    }
}
