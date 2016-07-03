package com.atguigu.maoyan.activity;

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
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;

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


    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLocationClient = new LocationClient(getApplicationContext());     //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);    //注册监听函数

        context = this;
        findView();
        initData();
        setListener();

        initLocation();
        mLocationClient.start();

    }

    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy
        );//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span = 1000;
        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要
        mLocationClient.setLocOption(option);
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

    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            //Receive Location
            StringBuffer sb = new StringBuffer(256);

            sb.append("\nLocType() : ");
            sb.append(location.getLocType());

            sb.append("time : ");
            sb.append(location.getTime());
            sb.append("\nerror code : ");
            sb.append(location.getLocType());
            sb.append("\nlatitude : ");
            sb.append(location.getLatitude());
            sb.append("\nlontitude : ");
            sb.append(location.getLongitude());
            sb.append("\nradius : ");
            sb.append(location.getRadius());
            if (location.getLocType() == BDLocation.TypeGpsLocation) {// GPS定位结果
                sb.append("\nspeed : ");
                sb.append(location.getSpeed());// 单位：公里每小时
                sb.append("\nsatellite : ");
                sb.append(location.getSatelliteNumber());
                sb.append("\nheight : ");
                sb.append(location.getAltitude());// 单位：米
                sb.append("\ndirection : ");
                sb.append(location.getDirection());// 单位度
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());
                sb.append("\ndescribe : ");
                sb.append("gps定位成功");

            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {// 网络定位结果
                sb.append("\naddr : ");
                sb.append(location.getAddrStr());
                //运营商信息
                sb.append("\noperationers : ");
                sb.append(location.getOperators());
                sb.append("\ndescribe : ");
                sb.append("网络定位成功");
            } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {// 离线定位结果
                sb.append("\ndescribe : ");
                sb.append("离线定位成功，离线定位结果也是有效的");
            } else if (location.getLocType() == BDLocation.TypeServerError) {
                sb.append("\ndescribe : ");
                sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");
            } else if (location.getLocType() == BDLocation.TypeNetWorkException) {
                sb.append("\ndescribe : ");
                sb.append("网络不同导致定位失败，请检查网络是否通畅");
            } else if (location.getLocType() == BDLocation.TypeCriteriaException) {
                sb.append("\ndescribe : ");
                sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");
            }
            sb.append("\nlocationdescribe : ");
            sb.append(location.getLocationDescribe());// 位置语义化信息
            List<Poi> list = location.getPoiList();// POI数据
            if (list != null) {
                sb.append("\npoilist size = : ");
                sb.append(list.size());
                for (Poi p : list) {
                    sb.append("\npoi= : ");
                    sb.append(p.getId() + " " + p.getName() + " " + p.getRank());
                }
            }
            Log.i("BaiduLocationApiDem", sb.toString());

            Toast.makeText(context,sb.toString(),Toast.LENGTH_SHORT).show();
        }
    }

}
