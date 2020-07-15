package com.example.mvpshow9.base;

import java.util.ArrayList;

/**
 * @date：2020/7/14
 * @describe：
 * @author：FanYaJun
 */
public abstract class BasePresenter<V extends BaseView> {
    public V mview;
    public ArrayList<BaseModel> models = new ArrayList<>();

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    public void addModel(BaseModel baseModel) {
        models.add(baseModel);
    }

    public void bindView(V view) {
        this.mview = view;
    }

    public void destroy() {
        mview = null;
        for (int i = 0; i < models.size(); i++) {
            models.get(i).distroy();

        }
    }


}
