package com.atguigu.maoyan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.atguigu.maoyan.R;
import com.atguigu.maoyan.fregrament.BaseFregrament;
import com.atguigu.maoyan.fregrament.CinemaFregrament;
import com.atguigu.maoyan.fregrament.FindFregrament;
import com.atguigu.maoyan.fregrament.MovieFregrament;
import com.atguigu.maoyan.fregrament.MyFregrament;
import com.igexin.sdk.PushManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private MainActivity context;
    private RadioGroup rg_bottom;
    private List<BaseFregrament> list;
    private MovieFregrament movieFregrament;
    private CinemaFregrament cinemaFregrament;
    private FindFregrament findFregrament;
    private MyFregrament myFregrament;
    private int curFregrament = 0;
    private boolean flag = false;
    private Handler handler = new Handler();
    private String hot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PushManager.getInstance().initialize(this.getApplicationContext());

        String clientid = PushManager.getInstance().getClientid(this);
        Log.e("TAG444",clientid);

        context = this;
        findView();
        initData();
        setListener();
    }

    /**
     * 初始化数据
     */
    private void findView() {
        rg_bottom = (RadioGroup) findViewById(R.id.rg_bottom);
    }

    private void initData() {
        //页面集合
        list = new ArrayList<>();

        list.add(new MovieFregrament(context));
        list.add(new CinemaFregrament(context));
        list.add(new FindFregrament(context));
        list.add(new MyFregrament(context));
    }

    private void setListener() {
        //radiobutton的监听
        rg_bottom.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        //默认选中第一个
        rg_bottom.check(R.id.rb_movie);
        curFregrament = 0;
        switchFregrament();
    }

    private class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_movie:
                    curFregrament = 0;

                    break;
                case R.id.rb_cinema:
                    curFregrament = 1;

                    break;
                case R.id.rb_find:
                    curFregrament = 2;

                    break;
                case R.id.rb_myself:
                    curFregrament = 3;
                    break;
            }
            switchFregrament();
        }
    }

    //选择某个fragment
    private void switchFregrament() {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fl_mian, new Fragment() {
            @Nullable
            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                BaseFregrament fragment = getFragment();
                if (fragment != null) {
                    return fragment.rootView;
                }
                return null;
            }
        });
        ft.commit();
    }

    private BaseFregrament getFragment() {
        BaseFregrament frament = list.get(curFregrament);
        if (frament != null) {
            if (!frament.isFragment) {
                frament.isFragment = true;
                frament.initData();
            }
            return frament;
        }
        return null;
    }

    //连续点击才退出
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (!flag && keyCode == KeyEvent.KEYCODE_BACK) {
            flag = true;
            Toast toast = Toast.makeText(context, "真的要离我而去吗?", Toast.LENGTH_SHORT);
            //使toast居中
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    flag = false;
                }
            }, 2000);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 0 && requestCode == 1) {
            String hot = data.getStringExtra("hot");

            if (onlistener != null) {
                onlistener.onclicklistener(hot);
            }
        }

        if (resultCode == 2 && requestCode == 2) {
            String key = data.getStringExtra("key");
            Log.e("namekay",key);
            if (onlistener2 != null) {
                onlistener2.onclicklistener2(key);
            }
        }

    }

    //接口1
    public interface Onlistener {
        public void onclicklistener(String key);
    }

    public Onlistener onlistener;

    public void setOnlistener(Onlistener onlistener) {
        this.onlistener = onlistener;
    }

    //接口2
    public interface Onlistener2 {
        public void onclicklistener2(String key);
    }

    public Onlistener2 onlistener2;

    public void setOnlistener2(Onlistener2 onlistener2) {
        this.onlistener2 = onlistener2;
    }
}
