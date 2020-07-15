package com.example.mvpshow5.persenter;

import com.example.mvpshow5.base.BasePersenter;
import com.example.mvpshow5.bean.ListBean;
import com.example.mvpshow5.coll.CollBack;
import com.example.mvpshow5.model.MainModel;
import com.example.mvpshow5.view.MainView;

/**
 * @date：2020/7/12
 * @describe：
 * @author：FanYaJun
 */
public class MainPersenter extends BasePersenter<MainView> implements CollBack {
    private MainModel mainModel;
    @Override
    protected void initModel() {
        mainModel = new MainModel();
        addMdel(mainModel);
    }

    public void getData() {
        mainModel.getDatas(this);
    }

    @Override
    public void onFeil(ListBean listBean) {
        mview.onFuile(listBean);
    }

    @Override
    public void onSunner(String str) {
        mview.showToast(str);
    }
}
