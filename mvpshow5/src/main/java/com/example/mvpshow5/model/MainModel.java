package com.example.mvpshow5.model;

import com.example.mvpshow5.api.ApiServer;
import com.example.mvpshow5.base.BaseModel;
import com.example.mvpshow5.bean.ListBean;
import com.example.mvpshow5.coll.CollBack;
import com.example.mvpshow5.persenter.MainPersenter;
import com.example.mvpshow5.utils.BaseObserver;
import com.example.mvpshow5.utils.HttpUtils;
import com.example.mvpshow5.utils.RxUtils;

/**
 * @date：2020/7/12
 * @describe：
 * @author：FanYaJun
 */
public class MainModel extends BaseModel {
    public void getDatas(CollBack collBack) {
        HttpUtils
                .getInstance()
                .getApiserver(ApiServer.URI_LIST, ApiServer.class)
                .getData()
                .compose(RxUtils.rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<ListBean>(this) {
                    @Override
                    protected void onSuccess(ListBean listBean) {
                        collBack.onFeil(listBean);
                    }
                    @Override
                    protected void error(String err) {
                        collBack.onSunner(err);

                    }
                });

    }

}
