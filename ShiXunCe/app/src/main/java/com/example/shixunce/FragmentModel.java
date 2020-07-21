package com.example.shixunce;

import com.example.shixunce.api.ApiServicer;
import com.example.shixunce.base.BaseModel;
import com.example.shixunce.bean.ListBean;
import com.example.shixunce.coll.CollBack;
import com.example.shixunce.presenter.FragmentPresenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @date：2020/7/17
 * @describe：
 * @author：FanYaJun
 */
public class FragmentModel extends BaseModel {
    public void getdatas(CollBack collBack) {
        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl(ApiServicer.uri)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Observable<ListBean> observable = retrofit.create(ApiServicer.class).getData();

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ListBean listBean) {
                    collBack.listok(listBean);
                    }

                    @Override
                    public void onError(Throwable e) {collBack.showerr(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
