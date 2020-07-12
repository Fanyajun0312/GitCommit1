package com.example.mvpchow2.model;

import com.example.mvpchow2.Utils.BaseObserver;
import com.example.mvpchow2.Utils.Constants;
import com.example.mvpchow2.Utils.HttpUtils;
import com.example.mvpchow2.Utils.Logger;
import com.example.mvpchow2.Utils.RxUtils;
import com.example.mvpchow2.api.ApiServcer;
import com.example.mvpchow2.base.BaseModel;
import com.example.mvpchow2.bean.FuliBean;
import com.example.mvpchow2.coll.MianCallBack;
import com.example.mvpchow2.persenter.MainPersenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.HTTP;

/**
 * @date：2020/7/11
 * @describe：mModel
 * @author：FanYaJun
 */
public class MianModel extends BaseModel {
    public void getDatas(MianCallBack mianCallBack) {

        HttpUtils.getInstance()
                .getApiserver(ApiServcer.uri, ApiServcer.class)
                .getData()
                .compose(RxUtils.rxObserableSchedulerHelper())//rx
                .subscribe(new BaseObserver<FuliBean>(this) {//baseob
                    @Override
                    protected void onSuccess(FuliBean fuliBean) {
                        mianCallBack.suresen(fuliBean);
                    }
                    @Override
                    protected void error(String err) {
                        mianCallBack.Fulide(err);
                    }
                });
    }
}
