package com.atguigu.maoyan.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tao on 2016/6/30.
 * 全部分类
 */
public class Classify implements Serializable{

    /**
     * festivals : [{"festivalId":34,"festivalName":"奥斯卡金像奖 "},{"festivalId":33,"festivalName":"戛纳电影节 "},{"festivalId":37,"festivalName":"威尼斯电影节 "},{"festivalId":31,"festivalName":"柏林电影节 "},{"festivalId":29,"festivalName":"金球奖"},{"festivalId":28,"festivalName":"香港金像奖 "},{"festivalId":27,"festivalName":"台湾金马奖 "},{"festivalId":13,"festivalName":"东京电影节 "},{"festivalId":11,"festivalName":"上海电影节 "},{"festivalId":12,"festivalName":"釜山电影节 "}]
     * region : 热门
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String region;
        /**
         * festivalId : 34
         * festivalName : 奥斯卡金像奖
         */

        private List<FestivalsBean> festivals;

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public List<FestivalsBean> getFestivals() {
            return festivals;
        }

        public void setFestivals(List<FestivalsBean> festivals) {
            this.festivals = festivals;
        }

        public static class FestivalsBean {
            private int festivalId;
            private String festivalName;

            public int getFestivalId() {
                return festivalId;
            }

            public void setFestivalId(int festivalId) {
                this.festivalId = festivalId;
            }

            public String getFestivalName() {
                return festivalName;
            }

            public void setFestivalName(String festivalName) {
                this.festivalName = festivalName;
            }
        }
    }
}
