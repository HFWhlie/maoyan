package com.atguigu.maoyan.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Toast;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.URL;
import com.atguigu.maoyan.adapter.MyAdapter;
import com.atguigu.maoyan.bean.Welpictuer;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Request;

public class WelcomeActivity2 extends Activity {
    private ViewPager viewpager;
    private String welUrl;
    private Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome2);

        findView();
        initData();
    }

    //初始化数据
    private void findView() {
        context = this;
        viewpager = (ViewPager) findViewById(R.id.viewpager);
    }

    private void initData() {
        welUrl = URL.welUrl;
//        Log.e("TAG", "welUrl = " + welUrl);
//        String json = CashUtils.getString(context, welUrl);
//        if (!TextUtils.isEmpty(json)) {
//            processeData(json);
//        }
        getFromNetData();
    }

    //请求网络
    private void getFromNetData() {
        OkHttpUtils
                .get()
                .url(welUrl)
                .build()
                .execute(new StringCallback() {
                    /**
                     * 请求失败
                     * @param request
                     * @param e
                     */
                    @Override
                    public void onError(Request request, Exception e) {
                        Log.e("TAG", "onError");
                        Toast.makeText(context,"联网失败",Toast.LENGTH_SHORT).show();
                    }

                    /**
                     * 请求成功
                     * @param response
                     */
                    @Override
                    public void onResponse(final String response) {
                        Log.e("TAG", "onResponse");
                        //缓存
//                        CashUtils.putString(context, welUrl, response);
                        processeData(response);
                    }
                });

    }

    //解析并显示数据
    private void processeData(String json) {
        //得到对象
        Welpictuer welpictuer = new Gson().fromJson(json, Welpictuer.class);
        Welpictuer.PostersBean postersBean = welpictuer.getPosters().get(0);
        //设置适配器
        viewpager.setAdapter(new MyAdapter(context, postersBean));
        statAnimation();
    }

    private void statAnimation() {
        //透明动画
        AlphaAnimation aa = new AlphaAnimation(1,0);
        aa.setDuration(2000);
        aa.setFillAfter(true);
        //渐变动画
        ScaleAnimation sa = new ScaleAnimation(1,1.1f,1,1.1f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        sa.setDuration(2000);
        aa.setFillAfter(true);
        AnimationSet as = new AnimationSet(true);
        as.addAnimation(aa);
        as.addAnimation(sa);
        as.setDuration(2000);
        as.setFillAfter(true);
        viewpager.startAnimation(as);
        //动画的监听
        as.setAnimationListener(new MyAnimationListener());

    }

    private class MyAnimationListener implements Animation.AnimationListener {
        //动画开始回调的方法
        @Override
        public void onAnimationStart(Animation animation) {

        }

        /**
         * 动画结束回调的方法
         * @param animation
         */
        @Override
        public void onAnimationEnd(Animation animation) {
            startActivity(new Intent(context,MainActivity.class));
            finish();
        }

        /**
         * 当动画重复时调用的方法
         * @param animation
         */
        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
