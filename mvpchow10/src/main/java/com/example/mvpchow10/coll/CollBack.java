package com.example.mvpchow10.coll;

import com.example.mvpchow10.bean.PojectList;

/**
 * @date：2020/7/16
 * @describe：
 * @author：FanYaJun
 */
public interface CollBack {
    void pojectonfcc(PojectList pojectList);
    void showErr(String err);
}
