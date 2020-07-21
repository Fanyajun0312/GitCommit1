package com.example.shixunce.base;

import android.widget.BaseAdapter;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**c
 * @date：2020/7/17
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
    public void  disposable(){
        compositeDisposable.dispose();
    }
    public void revemDisposable(Disposable disposable){
        compositeDisposable.remove(disposable);
    }
}
