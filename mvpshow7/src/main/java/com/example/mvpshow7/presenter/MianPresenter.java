package com.example.mvpshow7.presenter;

import com.example.mvpshow7.base.BasePresenter;
import com.example.mvpshow7.bean.ListBean;
import com.example.mvpshow7.coll.CollBack;
import com.example.mvpshow7.model.MainModel;
import com.example.mvpshow7.view.MainView;

/**
 * @date：2020/7/13
 * @describe：
 * @author：FanYaJun
 */
public class MianPresenter extends BasePresenter<MainView> implements CollBack {

    private MainModel mainModel;

    @Override
    protected void initModel() {
        mainModel = new MainModel();
        addModel(mainModel);
    }

    public void getData() {
        mainModel.getDatas(this);
    }

    @Override
    public void onListss(ListBean listBean) {
        mview.onListss(listBean);
    }

    @Override
    public void onsuerr(String err) {
        mview.showToast(err);
    }
}
