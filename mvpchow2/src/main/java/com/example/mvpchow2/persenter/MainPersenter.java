package com.example.mvpchow2.persenter;

import com.example.mvpchow2.base.BasePersenter;
import com.example.mvpchow2.bean.FuliBean;
import com.example.mvpchow2.coll.MianCallBack;
import com.example.mvpchow2.model.MianModel;
import com.example.mvpchow2.view.MianView;

/**
 * @date：2020/7/11
 * @describe：mp
 * @author：FanYaJun
 */
public class MainPersenter extends BasePersenter<MianView> implements MianCallBack {

    private MianModel mianModel;

    @Override
    protected void initModel() {
        mianModel = new MianModel();
        addModel(mianModel);
    }

    public void getData(){
            mianModel.getDatas(this);
    }
    @Override
    public void suresen(FuliBean fuliBean) {
        mview.suresen(fuliBean);
    }

    @Override
    public void Fulide(String str) {
        mview.showToast(str);
    }
}
