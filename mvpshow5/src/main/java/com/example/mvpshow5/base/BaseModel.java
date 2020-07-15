package com.example.mvpshow5.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @date：2020/7/12
 * @describe：model
 * @author：FanYaJun
 */
public abstract class BaseModel {
    public CompositeDisposable cdisposable;

    public void addModel(Disposable disposable) {
        if (cdisposable == null) {
            synchronized (BaseModel.class) {
                if (cdisposable == null) {
                    cdisposable = new CompositeDisposable();

                }
            }
        }
        cdisposable.add(disposable);
    }

    public void disposable(){
        cdisposable.dispose();
    }
    public void recvmeDisposable(Disposable disposable){
        if(cdisposable!=null){
         cdisposable.remove(disposable);

        }
    }
}
