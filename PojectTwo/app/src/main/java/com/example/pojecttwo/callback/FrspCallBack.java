package com.example.pojecttwo.callback;

import com.example.pojecttwo.shipinbean.ShiPinDemo;

import java.util.List;

/**
 * @date：2020/8/11
 * @describe：
 * @author：FanYaJun
 */
public interface FrspCallBack {
    void onErrorr(String msg,int code);
    void onSerssrss(ShiPinDemo shiPinDemo);
    void cancle();
}
