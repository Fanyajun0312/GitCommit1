package com.example.mvpshow7.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @date：2020/7/13
 * @describe：bm
 * @author：FanYaJun
 */
public abstract class BaseModel {
    public CompositeDisposable cdisposable;

    public void addDisposable(Disposable disposable) {
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
    public void revemeDisposable(Disposable disposable){
        cdisposable.remove(disposable);
    }

}
