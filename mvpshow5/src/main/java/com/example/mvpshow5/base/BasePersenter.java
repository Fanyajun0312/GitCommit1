package com.example.mvpshow5.base;

import java.util.ArrayList;

/**
 * @date：2020/7/12
 * @describe：pp
 * @author：FanYaJun
 */
public abstract class BasePersenter<V extends BaseView> {
    public V mview;
    public ArrayList<BaseModel> models = new ArrayList<>();

    public BasePersenter() {
        initModel();
    }

    protected abstract void initModel();

    public void addMdel(BaseModel baseModel) {
        models.add(baseModel);
    }

    public void bindView(V view) {
        this.mview = view;
    }

    public void desteroy() {
        mview = null;
        for (int i = 0; i < models.size(); i++) {
            BaseModel baseModel = models.get(i);
            baseModel.disposable();

        }
    }
}
