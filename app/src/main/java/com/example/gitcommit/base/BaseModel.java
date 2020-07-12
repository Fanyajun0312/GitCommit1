package com.example.gitcommit.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @date：2020/7/10
 * @describe：基类model
 * @author：FanYaJun  简单理解就是 model层可以自己接触网络连接 取消东西
 */
public abstract class BaseModel {  //modle抽象类
    // rxjava 用来判断的p和m
    public CompositeDisposable compositeDisposable = null;

    /**
     * @param disposable
     */
    public void addModelDisposable(Disposable disposable) {
        if (compositeDisposable == null) {
            synchronized (BaseModel.class) {
                if (compositeDisposable == null) {

                    compositeDisposable = new CompositeDisposable();

                }
            }
        }
        compositeDisposable.add(disposable);
    }
    ////由M层自己把网络和订阅关系取消
    public void disposable() {
        compositeDisposable.dispose();
    }
    /**
     * 用于移除关联
     * @param disposable
     */
    public void removeDisposeble(Disposable disposable) {
        if (compositeDisposable != null) {
            compositeDisposable.remove(disposable);
        }
    }
}
