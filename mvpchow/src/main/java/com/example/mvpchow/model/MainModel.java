package com.example.mvpchow.model;

import com.example.mvpchow.ApiServcer;
import com.example.mvpchow.FuliBean;
import com.example.mvpchow.base.BaseModel;
import com.example.mvpchow.callBack;

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
 * @describe：model
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
