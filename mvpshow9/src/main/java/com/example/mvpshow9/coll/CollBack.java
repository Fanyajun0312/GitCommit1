package com.example.mvpshow9.coll;

import com.example.mvpshow9.bean.JiangShiBean;

/**
 * @date：2020/7/14
 * @describe：
 * @author：FanYaJun
 */
public interface CollBack {
    void onjiaoshiBe(JiangShiBean jiangShiBean);
    void shibai(String err);
}
