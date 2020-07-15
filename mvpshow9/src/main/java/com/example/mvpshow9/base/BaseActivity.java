package com.example.mvpshow9.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * @date：2020/7/14
 * @describe：
 * @author：FanYaJun
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {
    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getKayout());
        ButterKnife.bind(this);
        initPresenter();
        if(mPresenter!=null){
            mPresenter.bindView(this);

        }
        initView();
        initData();
        initListener();
    }

    protected abstract int getKayout();
    protected abstract void initPresenter();
    protected abstract void initView();
    protected abstract void initData();
    protected abstract void initListener();
}
