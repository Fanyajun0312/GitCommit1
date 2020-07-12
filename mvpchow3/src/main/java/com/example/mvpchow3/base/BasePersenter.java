package com.example.mvpchow3.base;

import java.util.ArrayList;

/**
 * @date：2020/7/11
 * @describe：p基类
 * @author：FanYaJun
 */
public abstract class BasePersenter<V extends BaseView> {
    public V mView;
    public ArrayList<BaseModel> models=new ArrayList<>();//接受所有的model

    public BasePersenter() {//通过无参构造 抽象类 能够实现方法
        initModel();
    }

    protected abstract void initModel();//实现initmodel方法
    public void addModel(BaseModel baseModel){
        models.add(baseModel);
    }
    public void bindView(V view){
        this.mView=view;
    }
    public void destroy(){//解除
        mView=null;
        for(int i=0;i<models.size()  ;i++){
            BaseModel baseModel = models.get(i);
            baseModel.disposa();

        }
    }

}
