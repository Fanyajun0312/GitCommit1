package com.example.mvpshow6.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @date：2020/7/12
 * @describe：bm
 * @author：FanYaJun
 */
public abstract class BaseModel {
    public CompositeDisposable cdosposable;
    public void addModel(Disposable disposable){
        if(cdosposable==null){
            synchronized (BaseModel.class){
                if(cdosposable==null){
                    cdosposable=new CompositeDisposable();

                }
            }

        }
        cdosposable.add(disposable);
    }
    public void detroy(){
        cdosposable.dispose();
    }
    public void revemDisposable(Disposable disposable){
        if(cdosposable!=null){
                cdosposable.remove(disposable);

        }
    }
}
