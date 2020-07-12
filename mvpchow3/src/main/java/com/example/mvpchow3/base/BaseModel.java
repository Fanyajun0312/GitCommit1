package com.example.mvpchow3.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @date：2020/7/11
 * @describe：m基类
 * @author：FanYaJun
 */
public abstract class BaseModel {
    private CompositeDisposable cdisposable;//basemodel实现解除网络数据的解体 添加dis方法 实现dis方法 删除dis方法

    public void addDisposable(Disposable disposable){//添加解除的方法
        if(cdisposable==null){
            synchronized (BaseModel.class){
                if(cdisposable==null){
                    cdisposable=new CompositeDisposable();

                }
            }

        }
        cdisposable.add(disposable);
    }

    public void disposa(){//销毁方法
        cdisposable.dispose();
    }

    public void remvectDisposable(Disposable disposable){//移除解体方法
        if(cdisposable!=null){
            cdisposable.remove(disposable);
        }
    }
}
