package com.example.gitcommit.perenster;

import com.example.gitcommit.base.BasePersenter;
import com.example.gitcommit.bean.FuliBean;
import com.example.gitcommit.call.callBack;
import com.example.gitcommit.model.MainModel;
import com.example.gitcommit.view.MainView;

import javax.security.auth.callback.Callback;

/**
 * @date：2020/7/10
 * @describe：p m
 * @author：FanYaJun
 */
public class MianPerenter extends BasePersenter<MainView> implements Callback, callBack {

    private MainModel mainModel;

    @Override
    protected void initModel() {
        mainModel = new MainModel();
        addModel(mainModel);
    }

    public void getfuli() {
        mainModel.getfuliben(this);
    }

    @Override
    public void onFonil(FuliBean fuliBean) {
        mView.setData(fuliBean);
    }
}
