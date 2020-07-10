package com.example.gitcommit.api;

import com.example.gitcommit.bean.FuliBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @date：2020/7/10
 * @describe：api
 * @author：FanYaJun
 */
public interface ApiServcer {

    String uri = "http://gank.io/api/";

    @GET("data/%E7%A6%8F%E5%88%A9/20/3")
    Observable<FuliBean> getData();

}