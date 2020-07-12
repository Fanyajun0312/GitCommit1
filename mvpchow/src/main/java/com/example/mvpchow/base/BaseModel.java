package com.example.mvpchow.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @date：2020/7/10
 * @describe：基类model
 * @author：FanYaJun
 */
public abstract class BaseModel {
    private CompositeDisposable cdisposable=null;
    public void addDispsable(Disposable disposable){
        if(cdisposable==null){
            synchronized (BaseModel.class){
                if(cdisposable==null){
                cdisposable=new CompositeDisposable();
                }
            }
        }
        cdisposable.add(disposable);
    }
    public void disposable(){
        cdisposable.dispose();
    }
    public void remvceDisposable(Disposable disposable){
        if(cdisposable!=null){
            cdisposable.remove(disposable);
        }
    }
}
