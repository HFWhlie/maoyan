package com.atguigu.maoyan.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.URL;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * 热映H5
 */
public class HotHfive extends Activity implements View.OnClickListener {
    private WebView webview;
    private WebSettings settings;
    private ImageView iv_back;
    private ImageView iv_collect;
    private ProgressBar pb_loading;
    private TextView tv_name;
    //热映H5地址
    private String hot;
    //待映和影院的H5地址
    private String stdyfive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_hot_hfive);

        webview = (WebView) findViewById(R.id.webview);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_collect = (ImageView) findViewById(R.id.iv_collect);
        pb_loading = (ProgressBar) findViewById(R.id.pb_loading);
        tv_name = (TextView) findViewById(R.id.tv_name);

        int flags = getIntent().getFlags();
        switch (flags){
            case 1:
                String value = getIntent().getStringExtra("key");
                hot = URL.Hotfive;
                webview.loadUrl(hot);
                tv_name.setText(value);
                break;
            case 2:
                String stdy = getIntent().getStringExtra("stdy");
                stdyfive = URL.Stdyfive;
                webview.loadUrl(stdyfive);
                tv_name.setText(stdy);
                break;
            case 3:
                String cinemaname = getIntent().getStringExtra("cinema");
                webview.loadUrl(stdyfive);
                tv_name.setText(cinemaname);
                break;

        }
        settings = webview.getSettings();
        //支持Java
        settings.setJavaScriptEnabled(true);
        //支持双击变大变小  页面支持才可以
        settings.setUseWideViewPort(true);
        //添加缩放按钮
        settings.setBuiltInZoomControls(true);

        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                pb_loading.setVisibility(View.GONE);
            }
        });

        iv_back.setOnClickListener(this);
        iv_collect.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_collect://分享
                showShare();
            break;
        }
    }

    private void showShare () {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle("猫眼电影");
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");
        // 启动分享GUI
        oks.show(this);
    }
}
