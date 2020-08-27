package com.example.shixunexam.mvp;

import com.example.shixunexam.bean.GlicdeBesn;

/**
 * @date：2020/8/26
 * @describe：
 * @author：FanYaJun
 */
public interface CallBack {
    void onError(String msg,int code);
    void onCancle();
    void showOK(GlicdeBesn glicdeBesn);
}
