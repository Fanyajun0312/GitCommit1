package com.example.mvpshow9.presenter;

import com.example.mvpshow9.base.BasePresenter;
import com.example.mvpshow9.bean.JiangShiBean;
import com.example.mvpshow9.coll.CollBack;
import com.example.mvpshow9.model.MainModel;
import com.example.mvpshow9.view.MainView;

/**
 * @date：2020/7/14
 * @describe：
 * @author：FanYaJun
 */
public class MainPresenter extends BasePresenter<MainView> implements CollBack {

    private MainModel mainModel;

    @Override
    protected void initModel() {
        mainModel = new MainModel();
        addModel(mainModel);
    }

    public void getDatas() {
        mainModel.getData(this);
    }

    @Override
    public void onjiaoshiBe(JiangShiBean jiangShiBean) {
        mview.onshibai(jiangShiBean);
    }

    @Override
    public void shibai(String err) {
        mview.showToast(err);
    }
}
