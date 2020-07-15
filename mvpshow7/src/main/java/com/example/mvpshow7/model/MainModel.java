package com.example.mvpshow7.model;

import com.example.mvpshow7.api.ApiServer;
import com.example.mvpshow7.base.BaseModel;
import com.example.mvpshow7.bean.ListBean;
import com.example.mvpshow7.coll.CollBack;
import com.example.mvpshow7.presenter.MianPresenter;
import com.example.mvpshow7.utils.BaseObserver;
import com.example.mvpshow7.utils.HttpUtils;
import com.example.mvpshow7.utils.RxUtils;

/**
 * @date：2020/7/13
 * @describe：
 * @author：FanYaJun
 */
public class MainModel extends BaseModel {

    public void getDatas(CollBack back) {
        HttpUtils.getInstance()
                .getApiserver(ApiServer.LIST_URI,ApiServer.class)
                .getData()
                .compose(RxUtils.rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<ListBean>(this) {
                    @Override
                    protected void onSuccess(ListBean listBean) {
                            back.onListss(listBean);
                    }

                    @Override
                    protected void error(String err) {
                            back.onsuerr(err);
                    }
                });
    }
}
