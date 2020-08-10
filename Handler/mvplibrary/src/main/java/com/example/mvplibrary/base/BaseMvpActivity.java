package com.example.mvplibrary.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

import java.lang.reflect.InvocationHandler;

/**
 * @date：2020/8/9
 * @describe：
 * @author：FanYaJun
 */
public abstract class BaseMvpActivity<V extends BaseView,P extends BasePresenter<V>> extends BaseActivity implements InvocationHandler {
    public P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(mPresenter==null){
              mPresenter=initPresenter();
        }
        if(mPresenter!=null){
            mPresenter.attachView((V) this);
        }
    }

    protected abstract P initPresenter();

    @Override
    protected void initData() {
        if(mPresenter==null){
            mPresenter=initPresenter();
        }
        initDataMvp();
    }

    protected abstract void initDataMvp();

    //销毁view的方法

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
                mPresenter.detachView();
        }
    }
}
