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
 * 锟斤拷映H5
 */
public class HotHfive extends Activity implements View.OnClickListener {
    private WebView webview;
    private WebSettings settings;
    private ImageView iv_back;
    private ImageView iv_collect;
    private ProgressBar pb_loading;
    private TextView tv_name;
    private String hot;
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
        switch (flags) {
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
            case 4:
                String find = getIntent().getStringExtra("find");
                String htfive = URL.Htfive;
                webview.loadUrl(htfive);
                tv_name.setText(find);
                break;
            case 5:
                String find2 = getIntent().getStringExtra("find2");
                String zxfive = URL.zxfive;
                webview.loadUrl(zxfive);
                tv_name.setText(find2);
                break;
            case 6:
                String find3 = getIntent().getStringExtra("find3");
                String pffive = URL.pffive;
                webview.loadUrl(pffive);
                tv_name.setText(find3);
                break;
            case 7:
                String privce1url = URL.privce1url;
                webview.loadUrl(privce1url);
                break;
            case 8:
                String privce2url = URL.privce2url;
                webview.loadUrl(privce2url);
                break;
            case 9:
                String privce3url = URL.privce3url;
                webview.loadUrl(privce3url);
                break;
            case 10:
                String title = getIntent().getStringExtra("title");
                String findfive = URL.findfive;
                tv_name.setText(title);
                webview.loadUrl(findfive);
                break;
        }
        settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
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
            case R.id.iv_collect:
                showShare();
                break;
        }
    }

    private void showShare() {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        oks.disableSSOWhenAuthorize();
        oks.setTitle("猫锟桔碉拷影");
        oks.setTitleUrl("http://sharesdk.cn");
        oks.setUrl("http://sharesdk.cn");
        oks.setComment("锟斤拷锟角诧拷锟斤拷锟斤拷锟斤拷锟侥憋拷");
        oks.setSite(getString(R.string.app_name));
        oks.setSiteUrl("http://sharesdk.cn");
        oks.show(this);
    }
}
