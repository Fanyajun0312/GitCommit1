package com.example.mvplibrary.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.lang.reflect.InvocationHandler;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @date：2020/8/9
 * @describe：
 * @author：FanYaJun
 */

/**
 * InvocationHandler动态代理
 */
public abstract class BaseActivity extends RxAppCompatActivity implements InvocationHandler {

    private Unbinder bind;

    //buttonk的返回值
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        bind = ButterKnife.bind(this);
        initView();
        initData();
    }

    protected abstract int getLayout();
    protected abstract void initView();
    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
