package com.example.gitcommit.model;

import com.example.gitcommit.api.ApiServcer;
import com.example.gitcommit.base.BaseModel;
import com.example.gitcommit.bean.FuliBean;
import com.example.gitcommit.call.callBack;
import com.example.gitcommit.perenster.MianPerenter;



import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @date：2020/7/10
 * @describe：m m
 * @author：FanYaJun
 */
public class MainModel extends BaseModel {

    public void getfuliben(callBack callback) {
        Retrofit retrfit = new Retrofit.Builder().baseUrl(ApiServcer.uri)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiServcer apiServcer = retrfit.create(ApiServcer.class);
        Observable<FuliBean> ob = apiServcer.getData();
        ob.subscribeOn(Schedulers.io());
        ob.observeOn(AndroidSchedulers.mainThread());
        ob.subscribe(new Observer<FuliBean>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable();
            }

            @Override
            public void onNext(FuliBean fuliBean) {
                callback.onFonil(fuliBean);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
