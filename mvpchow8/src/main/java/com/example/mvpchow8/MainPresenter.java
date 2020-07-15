package com.example.mvpchow8;

import com.example.mvpchow8.base.BasePresenter;
import com.example.mvpchow8.bean.ListBean;
import com.example.mvpchow8.coll.CollBack;
import com.example.mvpchow8.model.MainModel;
import com.example.mvpchow8.view.MainView;

/**
 * @date：2020/7/13
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
    public void getData() {
            mainModel.getDatas(this);
    }
    @Override
    public void fuliss(ListBean listBean) {
        mview.fuliben(listBean);
    }

    @Override
    public void shibai(String err) {
        mview.showToast(err);
    }


}
