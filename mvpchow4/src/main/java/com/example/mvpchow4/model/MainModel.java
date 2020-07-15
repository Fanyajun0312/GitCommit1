package com.example.mvpchow4.model;

import com.example.mvpchow4.api.ApiServcer;
import com.example.mvpchow4.base.BaseModel;
import com.example.mvpchow4.bean.FuliBean;
import com.example.mvpchow4.coll.CollBack;
import com.example.mvpchow4.persenter.MainPersenter;
import com.example.mvpchow4.utils.BaseObserver;
import com.example.mvpchow4.utils.HttpUtils;
import com.example.mvpchow4.utils.RxUtils;

import javax.security.auth.callback.Callback;

/**
 * @date：2020/7/12
 * @describe：mm
 * @author：FanYaJun
 */
public class MainModel extends BaseModel {
    public void getDatas(CollBack callback) {
        HttpUtils.getInstance().getApiserver(ApiServcer.uri,ApiServcer.class)
                .getData()
                .compose(RxUtils.rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<FuliBean>(this) {
                    @Override
                    protected void onSuccess(FuliBean fuliBean) {
                        callback.cheng(fuliBean);
                    }

                    @Override
                    protected void error(String err) {
                        callback.shi(err);
                    }
                });
    }
}
