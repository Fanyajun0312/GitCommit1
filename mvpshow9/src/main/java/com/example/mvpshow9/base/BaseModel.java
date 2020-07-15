package com.example.mvpshow9.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @date：2020/7/14
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

    public void distroy() {
        cdisposable.dispose();
    }

    public void revmeDisposable(Disposable disposable) {
        cdisposable.remove(disposable);
    }
}
