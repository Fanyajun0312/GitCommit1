package com.example.shixunce.base;

import java.util.ArrayList;

/**
 * @date：2020/7/17
 * @describe：
 * @author：FanYaJun
 */
public abstract class BasePresenter<V extends BaseView> {
    public V mview;
    public ArrayList<BaseModel> models=new ArrayList<>();

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();
    public void addModel(BaseModel baseModel){
        models.add(baseModel);
    }
    public void bindView(V view){
        this.mview=view;
    }
    public void destroy(){
        mview=null;
        for(int i=0;i<models.size()  ;i++){
            models.get(i).disposable();

        }
    }
}
