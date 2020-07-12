package com.example.mvpchow.base;

import java.util.ArrayList;

/**
 * @date：2020/7/10
 * @describe：基类p
 * @author：FanYaJun
 */
public abstract class BasePersenter<V extends BaseView>  {
    public V mView;
    public ArrayList<BaseModel> models=new ArrayList<>();
    public BasePersenter() {
      initModel();
    }
    protected abstract void initModel();
    public void addModel(BaseModel baseModel){
        models.add(baseModel);
    }
    public void bindView(V view){
        mView=view;
    }
    public void destroy(){
        mView=null;
        for(int i=0;i<models.size()  ;i++){
            BaseModel baseModel = models.get(i);
            baseModel.disposable();
        }
    }
}
