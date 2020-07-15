package com.example.mvpchow4.base;

import java.util.ArrayList;

/**
 * @date：2020/7/12
 * @describe：per
 * @author：FanYaJun
 */
public abstract class BasePersenter<V extends BaseView> {
    public V mview;
    public ArrayList<BaseModel> models=new ArrayList<>();
    public BasePersenter() {
        initModel();
    }

    protected abstract void initModel();
    public void addmodel(BaseModel baseModel){
        models.add(baseModel);
    }
    public void bindview(V view){
        this.mview=view;
    }
    public void destroy(){
        mview=null;
        for(int i=0;i<models.size()  ;i++){
            BaseModel baseModel = models.get(i);
            baseModel.disposable();
        }
    }
}
