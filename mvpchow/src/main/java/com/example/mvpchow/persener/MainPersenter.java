package com.example.mvpchow.persener;

import com.example.mvpchow.FuliBean;
import com.example.mvpchow.view.MainView;
import com.example.mvpchow.base.BasePersenter;
import com.example.mvpchow.callBack;
import com.example.mvpchow.model.MainModel;

/**
 * @date：2020/7/10
 * @describe：
 * @author：FanYaJun
 */
public class MainPersenter extends BasePersenter<MainView> implements callBack {
    private MainModel mainModel;
    @Override
    protected void initModel() {
        mainModel=new MainModel();
        addModel(mainModel);
    }
    public void getfu(){
        mainModel.getfuliben(this);
    }

    @Override
    public void onFonil(FuliBean fuliBean) {
        mView.getData(fuliBean);
    }
}
