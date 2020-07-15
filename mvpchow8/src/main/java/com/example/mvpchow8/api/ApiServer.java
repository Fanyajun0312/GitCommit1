package com.example.mvpchow8.api;

import com.example.mvpchow8.bean.ListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @date：2020/7/13
 * @describe：
 * @author：FanYaJun
 */
public interface ApiServer {
    String suri_list="http://gank.io/";

    @GET("api/data/%E7%A6%8F%E5%88%A9/20/3")
    Observable<ListBean> getData();
}
