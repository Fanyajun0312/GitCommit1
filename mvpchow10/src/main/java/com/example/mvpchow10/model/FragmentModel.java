package com.example.mvpchow10.model;

import com.example.mvpchow10.api.ApiServicer;
import com.example.mvpchow10.base.BaseModel;
import com.example.mvpchow10.bean.PojectList;
import com.example.mvpchow10.coll.CollBack;
import com.example.mvpchow10.presenter.FragmentPresenter;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @date：2020/7/16
 * @describe：
 * @author：FanYaJun
 */
public class FragmentModel extends BaseModel {

    public void getDatas(CollBack collBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiServicer.POJET_URI)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiServicer apiServicer = retrofit.create(ApiServicer.class);
        apiServicer.getData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PojectList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PojectList pojectList) {
                        collBack.pojectonfcc(pojectList);
                    }

                    @Override
                    public void onError(Throwable e) {
                    collBack.showErr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
