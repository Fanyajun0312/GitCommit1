package com.example.shixunexam.mvp;

import com.example.mvplibary.model.ModelFractory;
import com.example.mvplibary.presenter.BasePresenter;
import com.example.shixunexam.bean.GlicdeBesn;

import javax.security.auth.callback.Callback;

/**
 * @date：2020/8/26
 * @describe：
 * @author：FanYaJun
 */
public class Gpresenter extends BasePresenter<GView> implements CallBack {
    public void getData() {
        GModel gModel = ModelFractory.creatModle(GModel.class);
        gModel.getData(this);
    }


    @Override
    public void onError(String msg, int code) {
        mView.onError(msg, code);
    }

    @Override
    public void onCancle() {
        mView.onCancle();
    }

    @Override
    public void showOK(GlicdeBesn glicdeBesn) {
        mView.showOK(glicdeBesn);
    }
}
