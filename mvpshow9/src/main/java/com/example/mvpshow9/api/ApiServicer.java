package com.example.mvpshow9.api;

import com.example.mvpshow9.bean.JiangShiBean;
import com.example.mvpshow9.bean.beanLisr;

import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @date：2020/7/14
 * @describe：
 * @author：FanYaJun
 */
public interface ApiServicer {

    String jiangshi_uri="https://api.yunxuekeji.cn/";
    String jianjie_uri="https://api.yunxuekeji.cn/";


    @GET("yunxue_app_api/content/getData/30/66597/1/10")
    Observable<JiangShiBean> getData();

    @GET("yunxue_app_api/teacher/getTeacherPower/")
    Observable<beanLisr> getDatass(@Query("ID") String id);
}
