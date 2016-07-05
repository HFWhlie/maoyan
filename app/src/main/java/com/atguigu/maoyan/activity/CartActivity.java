package com.atguigu.maoyan.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.atguigu.maoyan.R;
import com.atguigu.maoyan.Utils.CartProvider;
import com.atguigu.maoyan.Utils.PayResult;
import com.atguigu.maoyan.Utils.SignUtils;
import com.atguigu.maoyan.adapter.Busadapter;
import com.atguigu.maoyan.bean.ShoppingCart;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class CartActivity extends Activity {


    // 商户PID
    public static final String PARTNER = "2088911876712776";
    // 商户收款账号
    public static final String SELLER = "chenlei@atguigu.com";
    // 商户私钥，pkcs8格式
    public static final String RSA_PRIVATE = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALy57boTMdRkZhsN\n" +
            "uNuLgDZ2+peHj9phXw27iemxTbdYuh/oeepAnrkHQ7usUQGLQIICeaU7UWEaQpzf\n" +
            "HdK5iJDW5Zv19VMQxl6gsq4VPx2ziGWZZ6TvlIfGhjjrpSvLsCRpwmmBoQpaPemw\n" +
            "kbe6Pj7SzWGjrB7LdJNzxLrPsT+nAgMBAAECgYAxBKHIWL/yiHk0waWn8F3Gx7Ri\n" +
            "syUb9Xp42KMDfbfPzU3ah8lSnKIdMNPY5PLNUdvZaMcrsXJ7pBR1JkZauzHK6iOM\n" +
            "iimXCOMBX+TXhOnYF21bZRSUUVJ96KoylsjWlQpu71+j4w6oWPzI5iv8ps0h/+AX\n" +
            "A8GpoVuzYZZB4myEoQJBAPMPrBdQb54KNLob7UPkZa4K9K37HQo6PD0lX41D0yti\n" +
            "EQUWlDO3tp5g7REeAu79M1dD1JM2KIqXi7ZgUX7CRGkCQQDGxc35rtOW60sIseSd\n" +
            "emgc/WI0XYAjF5eO6URvJIlbBLbQWCpTjtv3OLqGiJGHo+6AaKGrqCR4EWLb5cIC\n" +
            "D6GPAkEA15clG6DbACEpV5KBx2CE1/Ubxl4gCfxRhiLqOBDa83YOhqbaWW0wbBao\n" +
            "8C/ghj7MFTEzEkhNeXCmGeQhJQAHUQJAMddNg4r70T7kjKSWj4ou6v36DulXBPWY\n" +
            "ciQ5najKrEDtWiaRTmxm6YGW+77oxtsrJZWW3EUIB/dME5lz4TJsLwJBALx8okTA\n" +
            "/MlNVb5BXFzTvyzdIyhvEuDVsxaPcKdjKrhPNrsou6pe6nUWouAEMb3hC4Rf1Qtq\n" +
            "eQkNzYSKnbbSKEM=";
    // 支付宝公钥
    public static final String RSA_PUBLIC = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC8ue26EzHUZGYbDbjbi4A2dvqX\n" +
            "h4/aYV8Nu4npsU23WLof6HnqQJ65B0O7rFEBi0CCAnmlO1FhGkKc3x3SuYiQ1uWb\n" +
            "9fVTEMZeoLKuFT8ds4hlmWek75SHxoY466Ury7AkacJpgaEKWj3psJG3uj4+0s1h\n" +
            "o6wey3STc8S6z7E/pwIDAQAB";
    private static final int SDK_PAY_FLAG = 1;


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


    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    PayResult payResult = new PayResult((String) msg.obj);
                    /**
                     * 同步返回的结果必须放置到服务端进行验证（验证的规则请看https://doc.open.alipay.com/doc2/
                     * detail.htm?spm=0.0.0.0.xdvAU6&treeId=59&articleId=103665&
                     * docType=1) 建议商户依赖异步通知
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息

                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                    if (TextUtils.equals(resultStatus, "9000")) {
                        Toast.makeText(CartActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
                    } else {
                        // 判断resultStatus 为非"9000"则代表可能支付失败
                        // "8000"代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            Toast.makeText(CartActivity.this, "支付结果确认中", Toast.LENGTH_SHORT).show();

                        } else {
                            // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                            Toast.makeText(CartActivity.this, "支付失败", Toast.LENGTH_SHORT).show();

                        }
                    }
                    break;
                }
                default:
                    break;
            }
        }

        ;
    };


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
        //结算按钮的点击事件
        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pay(v);
            }
        });
    }

    private void pay(View v) {
        if (TextUtils.isEmpty(PARTNER) || TextUtils.isEmpty(RSA_PRIVATE) || TextUtils.isEmpty(SELLER)) {
            new AlertDialog.Builder(this).setTitle("警告").setMessage("需要配置PARTNER | RSA_PRIVATE| SELLER")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialoginterface, int i) {
                            //
                            finish();
                        }
                    }).show();
            return;
        }
        String orderInfo = getOrderInfo("测试的商品", "该测试商品的详细描述", "0.01");

        /**
         * 特别注意，这里的签名逻辑需要放在服务端，切勿将私钥泄露在代码中！
         */
        String sign = sign(orderInfo);
        try {
            /**
             * 仅需对sign 做URL编码
             */
            sign = URLEncoder.encode(sign, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        /**
         * 完整的符合支付宝参数规范的订单信息
         */
        final String payInfo = orderInfo + "&sign=\"" + sign + "\"&" + getSignType();

        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                // 构造PayTask 对象
                PayTask alipay = new PayTask(CartActivity.this);
                // 调用支付接口，获取支付结果
                String result = alipay.pay(payInfo, true);

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();

    }


    /**
     * create the order info. 创建订单信息
     */
    private String getOrderInfo(String subject, String body, String price) {

        // 签约合作者身份ID
        String orderInfo = "partner=" + "\"" + PARTNER + "\"";

        // 签约卖家支付宝账号
        orderInfo += "&seller_id=" + "\"" + SELLER + "\"";

        // 商户网站唯一订单号
        orderInfo += "&out_trade_no=" + "\"" + getOutTradeNo() + "\"";

        // 商品名称
        orderInfo += "&subject=" + "\"" + subject + "\"";

        // 商品详情
        orderInfo += "&body=" + "\"" + body + "\"";

        // 商品金额
        orderInfo += "&total_fee=" + "\"" + price + "\"";

        // 服务器异步通知页面路径
        orderInfo += "&notify_url=" + "\"" + "http://notify.msp.hk/notify.htm" + "\"";

        // 服务接口名称， 固定值
        orderInfo += "&service=\"mobile.securitypay.pay\"";

        // 支付类型， 固定值
        orderInfo += "&payment_type=\"1\"";

        // 参数编码， 固定值
        orderInfo += "&_input_charset=\"utf-8\"";

        // 设置未付款交易的超时时间
        // 默认30分钟，一旦超时，该笔交易就会自动被关闭。
        // 取值范围：1m～15d。
        // m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。
        // 该参数数值不接受小数点，如1.5h，可转换为90m。
        orderInfo += "&it_b_pay=\"30m\"";

        // extern_token为经过快登授权获取到的alipay_open_id,带上此参数用户将使用授权的账户进行支付
        // orderInfo += "&extern_token=" + "\"" + extern_token + "\"";

        // 支付宝处理完请求后，当前页面跳转到商户指定页面的路径，可空
        orderInfo += "&return_url=\"m.alipay.com\"";

        // 调用银行卡支付，需配置此参数，参与签名， 固定值 （需要签约《无线银行卡快捷支付》才能使用）
        // orderInfo += "&paymethod=\"expressGateway\"";

        return orderInfo;
    }
    /**
     * get the out_trade_no for an order. 生成商户订单号，该值在商户端应保持唯一（可自定义格式规范）
     */
    private String getOutTradeNo() {
        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss", Locale.getDefault());
        Date date = new Date();
        String key = format.format(date);

        Random r = new Random();
        key = key + r.nextInt();
        key = key.substring(0, 15);
        return key;
    }

    /**
     * sign the order info. 对订单信息进行签名
     *
     * @param content 待签名订单信息
     */
    private String sign(String content) {
        return SignUtils.sign(content, RSA_PRIVATE);
    }

    /**
     * get the sign type we use. 获取签名方式
     */
    private String getSignType() {
        return "sign_type=\"RSA\"";
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
