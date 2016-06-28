package com.atguigu.maoyan.Utils;

/**
 * Created by tao on 2016/6/28.
 */
public class DistanceUtil {
    private static double EARTH_RADIUS = 6378.137;// 单位千米

    /**
     * 角度弧度计算公式 rad:(). <br/>
     * <p/>
     * 360度=2π π=Math.PI
     * <p/>
     * x度 = x*π/360 弧度
     *
     * @param degree
     * @return
     * @author chiwei
     * @since JDK 1.6
     */
    private static double getRadian(double degree) {
        return degree * Math.PI / 180.0;
    }
    public static double getDistance(double v, double v1, double lat, double lng) {
        double radLat1 = getRadian(v);
        double radLat2 = getRadian(lat);
        double a = radLat1 - radLat2;// 两点纬度差
        double b = getRadian(v1) - getRadian(lng);// 两点的经度差
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1)
                * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
//        return s * 1000;
        return s;

    }
}
