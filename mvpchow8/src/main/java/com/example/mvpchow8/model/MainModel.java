package com.example.mvpchow8.model;

import com.example.mvpchow8.MainPresenter;
import com.example.mvpchow8.api.ApiServer;
import com.example.mvpchow8.base.BaseModel;
import com.example.mvpchow8.bean.ListBean;
import com.example.mvpchow8.coll.CollBack;

import org.reactivestreams.Subscription;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @date：2020/7/13
 * @describe：
 * @author：FanYaJun
 */
public class MainModel extends BaseModel {
    public void getDatas(CollBack collBack) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiServer.suri_list)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        apiServer.getData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ListBean listBean) {
                        collBack.fuliss(listBean);
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
