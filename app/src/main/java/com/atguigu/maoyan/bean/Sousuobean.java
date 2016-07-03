package com.atguigu.maoyan.bean;

import java.util.List;

/**
 * Created by tao on 2016/7/2.
 */
public class Sousuobean {

    /**
     * url :
     * value : 魔兽
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String url;
        private String value;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
