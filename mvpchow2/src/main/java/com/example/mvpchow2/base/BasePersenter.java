package com.example.mvpchow2.base;

import java.util.ArrayList;

/**
 * @date：2020/7/11
 * @describe：basep基类
 * @author：FanYaJun
 */
public abstract class BasePersenter<V extends BaseView> {

    public V mview;
    public ArrayList<BaseModel> models = new ArrayList<>();

    public BasePersenter() {
        initModel();
    }

    protected abstract void initModel();

    public void addModel(BaseModel baseModel) {
        models.add(baseModel);
    }

    public void bindVIew(V view) {
        this.mview = view;
    }

    public void destroy() {
        mview = null;
        for (int i = 0; i < models.size(); i++) {
            BaseModel baseModel = models.get(i);
            baseModel.disposa();
        }
    }
}
