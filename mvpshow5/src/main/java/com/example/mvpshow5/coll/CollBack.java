package com.example.mvpshow5.coll;

import com.example.mvpshow5.bean.ListBean;

/**
 * @date：2020/7/12
 * @describe：
 * @author：FanYaJun
 */
public interface CollBack {
    void onFeil(ListBean listBean);
    void onSunner(String str);
}
