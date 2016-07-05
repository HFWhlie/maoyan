package com.atguigu.maoyan.bean;

/**
 * Created by tao on 2016/7/5.
 */
public class ShoppingCart extends Shumabean.DataBean.ListBean {
    private int count = 1;
    private boolean isCheck = true;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setIsCheck(boolean isCheck) {
        this.isCheck = isCheck;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "count=" + count +
                ", isCheck=" + isCheck +
                '}';
    }

}
