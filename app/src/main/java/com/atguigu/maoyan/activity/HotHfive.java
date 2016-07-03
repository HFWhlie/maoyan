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
    //锟斤拷映H5锟斤拷址
    private String hot;
    //锟斤拷映锟斤拷影院锟斤拷H5锟斤拷址
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


        }
        settings = webview.getSettings();
        //支锟斤拷Java
        settings.setJavaScriptEnabled(true);
        //支锟斤拷双锟斤拷锟斤拷锟斤拷小  页锟斤拷支锟街才匡拷锟斤拷
        settings.setUseWideViewPort(true);
        //锟斤拷锟斤拷锟斤拷虐锟脚�        settings.setBuiltInZoomControls(true);

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
            case R.id.iv_collect://锟斤拷锟斤拷
                showShare();
                break;
        }
    }

    private void showShare () {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        //锟截憋拷sso锟斤拷权
        oks.disableSSOWhenAuthorize();

        // 锟斤拷锟斤拷时Notification锟斤拷图锟斤拷锟斤拷锟斤拷锟� 2.5.9锟皆猴拷陌姹撅拷锟斤拷锟斤拷么朔锟斤拷锟�        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title锟斤拷锟解，印锟斤拷始恰锟斤拷锟斤拷洹拷锟较拷锟轿拷拧锟斤拷锟斤拷锟斤拷锟斤拷QQ锟秸硷拷使锟斤拷
        oks.setTitle("猫锟桔碉拷影");
        // titleUrl锟角憋拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷樱锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷QQ锟秸硷拷使锟斤拷
        oks.setTitleUrl("http://sharesdk.cn");
        // text锟角凤拷锟斤拷锟侥憋拷锟斤拷锟斤拷锟斤拷平台锟斤拷锟斤拷要锟斤拷锟斤拷侄锟�        oks.setText("锟斤拷锟角凤拷锟斤拷锟侥憋拷");
        // imagePath锟斤拷图片锟侥憋拷锟斤拷路锟斤拷锟斤拷Linked-In锟斤拷锟斤拷锟狡教拷锟街э拷执瞬锟斤拷锟�        //oks.setImagePath("/sdcard/test.jpg");//确锟斤拷SDcard锟斤拷锟斤拷锟斤拷诖锟斤拷锟酵计�        // url锟斤拷锟斤拷微锟脚ｏ拷锟斤拷锟斤拷锟斤拷锟窖猴拷锟斤拷锟斤拷圈锟斤拷锟斤拷使锟斤拷
        oks.setUrl("http://sharesdk.cn");
        // comment锟斤拷锟揭讹拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷郏锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷QQ锟秸硷拷使锟斤拷
        oks.setComment("锟斤拷锟角诧拷锟斤拷锟斤拷锟斤拷锟侥憋拷");
        // site锟角凤拷锟斤拷锟斤拷锟斤拷莸锟斤拷锟秸撅拷锟狡ｏ拷锟斤拷锟斤拷QQ锟秸硷拷使锟斤拷
        oks.setSite(getString(R.string.app_name));
        // siteUrl锟角凤拷锟斤拷锟斤拷锟斤拷莸锟斤拷锟秸撅拷锟街凤拷锟斤拷锟斤拷锟絈Q锟秸硷拷使锟斤拷
        oks.setSiteUrl("http://sharesdk.cn");
        // 锟斤拷锟斤拷锟斤拷锟斤拷GUI
        oks.show(this);
    }
}
