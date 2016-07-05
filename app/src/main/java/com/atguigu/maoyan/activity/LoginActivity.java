package com.atguigu.maoyan.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atguigu.maoyan.R;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.wechat.friends.Wechat;

public class LoginActivity extends Activity implements View.OnClickListener {
    private Context context;
    private TextView tv_mt;
    private LinearLayout ll_phone;
    private ImageView iv_weixin;
    private ImageView iv_qq;
    private ImageView iv_xinlang;
    private ImageView iv_kongjian;
    private EditText et_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = this;
        findView();
        setlistener();
    }

    private void setlistener() {
        iv_weixin.setOnClickListener(this);
        iv_qq.setOnClickListener(this);
        iv_xinlang.setOnClickListener(this);
        iv_kongjian.setOnClickListener(this);
    }

    private void findView() {
        tv_mt = (TextView) findViewById(R.id.tv_mt);
        ll_phone = (LinearLayout) findViewById(R.id.ll_phone);
        iv_weixin = (ImageView) findViewById(R.id.iv_weixin);
        iv_qq = (ImageView) findViewById(R.id.iv_qq);
        iv_xinlang = (ImageView) findViewById(R.id.iv_xinlang);
        iv_kongjian = (ImageView) findViewById(R.id.iv_kongjian);
        et_name = (EditText) findViewById(R.id.et_name);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_weixin:
                ShareSDK.initSDK(this);
                Platform wechat = ShareSDK.getPlatform(Wechat.NAME);
                wechat.setPlatformActionListener(new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                        Platform wechat = ShareSDK.getPlatform(context, Wechat.NAME);
                        String accessToken = wechat.getDb().getToken(); // 获取授权token
                        String openId = wechat.getDb().getUserId(); // 获取用户在此平台的ID
                        String nickname = wechat.getDb().get("nickname"); // 获取用户昵称
                        Log.e("WEIXINTAG", accessToken + "=====" + openId + "-----" + nickname);
                        Intent intent = new Intent(context, MainActivity.class);
                        intent.putExtra("key", nickname);
                        setResult(2, intent);
                        finish();
                    }

                    @Override
                    public void onError(Platform platform, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(Platform platform, int i) {

                    }
                });

                break;


            case R.id.iv_qq:
                ShareSDK.initSDK(this);
                Platform qq = ShareSDK.getPlatform(QQ.NAME);
                qq.setPlatformActionListener(new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                        Platform qq = ShareSDK.getPlatform(context, QQ.NAME);
                        String accessToken = qq.getDb().getToken(); // 获取授权token
                        String openId = qq.getDb().getUserId(); // 获取用户在此平台的ID
                        String nickname = qq.getDb().get("nickname"); // 获取用户昵称
                        Log.e("QQTAG", accessToken + "=====" + openId + "-----" + nickname);
                        Intent intent = new Intent(context, MainActivity.class);
                        intent.putExtra("key", nickname);
                        setResult(1, intent);
                        finish();
                    }

                    @Override
                    public void onError(Platform platform, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(Platform platform, int i) {

                    }
                });
                break;


            case R.id.iv_xinlang:
                ShareSDK.initSDK(this);
                Platform sinaweibo = ShareSDK.getPlatform(SinaWeibo.NAME);
                sinaweibo.setPlatformActionListener(new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                        Platform sinaweibo = ShareSDK.getPlatform(context, SinaWeibo.NAME);
                        String accessToken = sinaweibo.getDb().getToken(); // 获取授权token
                        String openId = sinaweibo.getDb().getUserId(); // 获取用户在此平台的ID
                        String nickname = sinaweibo.getDb().get("nickname"); // 获取用户昵称
                        Log.e("XINLANGTAG", accessToken + "=====" + openId + "-----" + nickname);

                        Intent intent = new Intent(context, MainActivity.class);
                        intent.putExtra("hot", nickname);
                        setResult(RESULT_OK, intent);
                        finish();
                    }

                    @Override
                    public void onError(Platform platform, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(Platform platform, int i) {

                    }
                });
                sinaweibo.authorize();
                //移除授权
                //weibo.removeAccount(true);
                break;


            case R.id.iv_kongjian:
                ShareSDK.initSDK(this);
                Platform qzone = ShareSDK.getPlatform(QZone.NAME);
                qzone.setPlatformActionListener(new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                        Platform qzone = ShareSDK.getPlatform(context, QZone.NAME);
                        String accessToken = qzone.getDb().getToken(); // 获取授权token
                        String openId = qzone.getDb().getUserId(); // 获取用户在此平台的ID
                        String nickname = qzone.getDb().get("nickname"); // 获取用户昵称
                        Log.e("KONGJIANTAG", accessToken + "=====" + openId + "-----" + nickname);
                        Intent intent = new Intent(context, MainActivity.class);
                        intent.putExtra("key", nickname);
                        setResult(2, intent);
                        finish();
                    }

                    @Override
                    public void onError(Platform platform, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(Platform platform, int i) {

                    }
                });
                qzone.authorize();
                break;


            case R.id.iv_back:
                finish();
                break;
        }
    }
}
