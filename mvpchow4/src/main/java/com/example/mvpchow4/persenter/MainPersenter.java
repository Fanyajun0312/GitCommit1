package com.example.mvpchow4.persenter;

import com.example.mvpchow4.base.BasePersenter;
import com.example.mvpchow4.bean.FuliBean;
import com.example.mvpchow4.coll.CollBack;
import com.example.mvpchow4.model.MainModel;
import com.example.mvpchow4.view.MainView;

/**
 * @date：2020/7/12
 * @describe：pp
 * @author：FanYaJun
 */
public class MainPersenter extends BasePersenter<MainView> implements CollBack {

    private MainModel mainModel;

    @Override
    protected void initModel() {
        mainModel = new MainModel();
        addmodel(mainModel);
    }

    public void getData() {
        mainModel.getDatas(this);
    }

    @Override
    public void cheng(FuliBean fuliBean) {
        mview.cheng(fuliBean);
    }

    @Override
    public void shi(String str) {
        mview.showToast(str);
    }
}
