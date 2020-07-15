package com.example.mvpshow5.api;

import com.example.mvpshow5.bean.ListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @date：2020/7/12
 * @describe：api
 * @author：FanYaJun
 */
public interface ApiServer {

    String URI_LIST="http://c.m.163.com/";
    @GET("nc/article/headline/T1348647909107/0-20.html")
    Observable<ListBean> getData();
}
