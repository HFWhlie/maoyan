package com.atguigu.maoyan.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.URL;
import com.atguigu.maoyan.bean.Welpictuer;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Request;

public class WelcomeActivity2 extends Activity {
    private String welUrl;
    private Activity context;
    private ImageView iv_wel;

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
        iv_wel = (ImageView) findViewById(R.id.iv_wel);
    }

    private void initData() {
        welUrl = URL.welUrl;
        Log.e("TAG", "welUrl = " + welUrl);
//        String json = CashUtils.getString(context, welUrl);
//        //先从缓存中查找，看是否存在
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
                        Toast.makeText(context, "联网失败", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(context, MainActivity.class));
                        finish();
                    }

                    /**
                     * 请求成功
                     * @param response
                     */
                    @Override
                    public void onResponse(String response) {
                        Log.e("TAG", "onResponse");
                        //缓存
//                        CashUtils.putString(context, welUrl, response);
                        //解析并显示数据
                        processeData(response);
                    }
                });

    }

    //解析并显示数据
    private void processeData(String json) {
        //得到对象
        Welpictuer welpictuer = new Gson().fromJson(json, Welpictuer.class);
        if(welpictuer.getPosters()!= null&&welpictuer.getPosters().size()>0){
            Welpictuer.PostersBean postersBean = welpictuer.getPosters().get(0);
            Glide.with(context).load(postersBean.getPic())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//图片的缓存
                    .placeholder(R.drawable.background_icon01)//加载过程中的图片
                    .error(R.drawable.background_icon01)//加载失败的时候显示的图片
                    .into(iv_wel);//请求成功后把图片设置到的控件
            //设置动画
            statAnimation();
        }
        startActivity(new Intent(context, MainActivity.class));
        finish();
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
        iv_wel.startAnimation(as);
        //动画的监听
        as.setAnimationListener(new MyAnimationListener());

    }

    private class MyAnimationListener implements Animation.AnimationListener {
        /**
         * 动画开始回调的方法
         * @param animation
         */
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
