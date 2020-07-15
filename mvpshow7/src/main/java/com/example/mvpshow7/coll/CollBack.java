package com.example.mvpshow7.coll;

import com.example.mvpshow7.bean.ListBean;

/**
 * @date：2020/7/13
 * @describe：
 * @author：FanYaJun
 */
public interface CollBack {
    void onListss(ListBean listBean);
    void onsuerr(String err);
}
