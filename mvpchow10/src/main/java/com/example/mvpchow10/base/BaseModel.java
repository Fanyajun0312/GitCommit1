package com.example.mvpchow10.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @date：2020/7/16
 * @describe：
 * @author：FanYaJun
 */
public abstract class BaseModel {
    public CompositeDisposable compositeDisposable;
    public void addDisposable(Disposable disposable){
        if(compositeDisposable==null){
            synchronized (BaseModel.class){
                if(compositeDisposable==null){
                    compositeDisposable=new CompositeDisposable();

                }
            }
        }
        compositeDisposable.add(disposable);
    }
    public void disposable(){
        compositeDisposable.dispose();
    }
    public void revmenDisp(Disposable disposable){
        compositeDisposable.remove(disposable);
    }
}
