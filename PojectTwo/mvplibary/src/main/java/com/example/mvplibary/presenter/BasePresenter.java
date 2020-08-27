package com.example.mvplibary.presenter;

import com.example.mvplibary.view.BaseView;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.lang.ref.WeakReference;

/**
 * @date：2020/8/11
 * @describe：
 * @author：FanYaJun
 */
public class BasePresenter<V extends BaseView> {
    public V mView;
    private WeakReference<V>weakReference;
    //绑定
    public void attacthView(V v){
        weakReference =new WeakReference<V>(v);
        mView=weakReference.get();
    }
    //返回视图层对象
    public LifecycleProvider getLifeCycle(){
        return (LifecycleProvider) mView;
    }
    //解绑
    public void destoryView(){
        if(weakReference!=null){
            weakReference.clear();
        }
    }
}
