package com.atguigu.maoyan.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by tao on 2016/6/23.
 * 缓存工具类
 */
public class CashUtils {

    //保存
    public static void putString(Context context, String key, String value) {
        SharedPreferences sp = context.getSharedPreferences("maoyan",Context.MODE_PRIVATE);
        sp.edit().putString(key,value).commit();
    }

    public static String getString(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences("maoyan",Context.MODE_PRIVATE);
        return sp.getString(key,"");
    }
}
