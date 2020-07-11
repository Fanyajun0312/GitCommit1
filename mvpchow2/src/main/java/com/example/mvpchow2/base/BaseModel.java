package com.example.mvpchow2.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @date：2020/7/11
 * @describe：model基类
 * @author：FanYaJun
 */
public abstract class BaseModel {
    public volatile CompositeDisposable cdisposable;//rxjava的销毁
    //添加
    public void addModel(Disposable disposable) {//添加销毁双检索
        if (cdisposable == null) {
            synchronized (BaseModel.class) {
                if (cdisposable == null) {
                    cdisposable = new CompositeDisposable();
                }
            }
        }
        cdisposable.add(disposable);//添加
    }

    public void disposa() {//销毁
        cdisposable.dispose();
    }

    public void remvectDisposable(Disposable disposable) {//移除
        if (cdisposable != null) {
            cdisposable.remove(disposable);
        }
    }

}
