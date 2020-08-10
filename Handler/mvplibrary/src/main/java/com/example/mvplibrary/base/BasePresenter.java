package com.example.mvplibrary.base;

import androidx.annotation.UiThread;

import com.trello.rxlifecycle2.LifecycleProvider;

/**
 * @date：2020/8/9
 * @describe：抽象类作为底层实现presenter的方法
 * @author：FanYaJun
 */
public abstract class BasePresenter<V extends BaseView> {
    private V mView;
    private MvpViewProxy<V> mvpViewProxy;

    @UiThread
    public V getView(){
        return mView;
    }
    //绑定生命周期获取view
    protected final LifecycleProvider getLifecyleProvider(){
        return (LifecycleProvider) getView();
    }
    //bangdingview
    public void attachView(V view)
    {
        MvpViewProxy<V> vMvpViewProxy = new MvpViewProxy<>();
        mView = (V) vMvpViewProxy.newinvocationHandler(view);
    }

    /**
     * 移除view
     */
    public void detachView(){
        if(mvpViewProxy!=null){
            mvpViewProxy.detachView();
            
        }
    }
}
