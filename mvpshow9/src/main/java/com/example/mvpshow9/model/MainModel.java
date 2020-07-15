package com.example.mvpshow9.model;

import com.example.mvpshow9.api.ApiServicer;
import com.example.mvpshow9.base.BaseModel;
import com.example.mvpshow9.bean.JiangShiBean;
import com.example.mvpshow9.coll.CollBack;
import com.example.mvpshow9.presenter.MainPresenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @date：2020/7/14
 * @describe：
 * @author：FanYaJun
 */
public class MainModel extends BaseModel {
    public void getData(CollBack collBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiServicer.jiangshi_uri)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        Observable<JiangShiBean> observable = retrofit.create(ApiServicer.class).getData();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JiangShiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JiangShiBean jiangShiBean) {
                        collBack.onjiaoshiBe(jiangShiBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        collBack.shibai(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
