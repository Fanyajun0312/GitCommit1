package com.example.mvpchow8.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @date：2020/7/13
 * @describe：
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
    public void revemDosposable(Disposable disposable){
        cdisposable.remove(disposable);
    }
}
