package com.example.shixunce.api;

import com.example.shixunce.bean.ListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @date：2020/7/17
 * @describe：
 * @author：FanYaJun
 */
public interface ApiServicer {
    String uri="https://www.wanandroid.com/";

    @GET("project/list/1/json?cid=294")
    Observable<ListBean> getData();
}
