package com.example.pojecttwo.presenter;

import com.example.mvplibary.model.ModelFractory;
import com.example.mvplibary.presenter.BasePresenter;
import com.example.pojecttwo.callback.FrspCallBack;
import com.example.pojecttwo.model.FraSpModel;
import com.example.pojecttwo.shipinbean.DataBean;
import com.example.pojecttwo.shipinbean.ShiPinDemo;
import com.example.pojecttwo.view.FraSpView;

import java.util.List;

/**
 * @date：2020/8/11
 * @describe：
 * @author：FanYaJun
 */
public class FraSpPresenter extends BasePresenter<FraSpView> implements FrspCallBack {

    public void getData(){
        FraSpModel fraSpModel = ModelFractory.creatModle(FraSpModel.class);
        fraSpModel.getdata(this,getLifeCycle());
    }
    @Override
    public void onErrorr(String msg, int code) {
        mView.onError(msg, code);
    }

    @Override
    public void onSerssrss(ShiPinDemo dataBean) {
        mView.onSossess(dataBean);
    }

    @Override
    public void cancle() {
        mView.cancle();
    }
}
