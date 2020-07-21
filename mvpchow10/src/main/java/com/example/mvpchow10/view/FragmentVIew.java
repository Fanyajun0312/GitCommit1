package com.example.mvpchow10.view;

import com.example.mvpchow10.base.BaseView;
import com.example.mvpchow10.bean.PojectList;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @date：2020/7/16
 * @describe：
 * @author：FanYaJun
 */
public interface FragmentVIew extends BaseView {
    void pojectonff(PojectList pojectList);
}
