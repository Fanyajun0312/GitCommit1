package com.example.mvpshow7.api;

import com.example.mvpshow7.bean.ListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @date：2020/7/13
 * @describe：
 * @author：FanYaJun
 */
public interface ApiServer {
    String LIST_URI="http://www.wanandroid.com/";

    @GET("project/list/1/json?cid=294")
    Observable<ListBean> getData();
}
