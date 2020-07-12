package com.example.mvpchow3.persenter;

import com.example.mvpchow3.base.BasePersenter;
import com.example.mvpchow3.coll.CollBack;
import com.example.mvpchow3.model.MainModel;
import com.example.mvpchow3.view.MianView;

/**
 * @date：2020/7/11
 * @describe：mianp
 * @author：FanYaJun
 */
public class MainPersenter extends BasePersenter<MianView> implements CollBack {

    public MainModel mainModel;

    @Override
    protected void initModel() {
        mainModel = new MainModel();
        addModel(mainModel);
    }

    public void getData() {
        mainModel.getDatas(this);
    }

    @Override
    public void osuee(String str) {
            mView.suresen(str);
    }

}
