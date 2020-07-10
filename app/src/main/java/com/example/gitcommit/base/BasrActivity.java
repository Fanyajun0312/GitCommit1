package com.example.gitcommit.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * @date：2020/7/10
 * @describe：虚拟activity
 * @author：FanYaJun
 */
public abstract class BasrActivity<P extends BasePersenter> extends AppCompatActivity implements BaseView {
    public P mPersenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        initPerenster();
        if(mPersenter!=null){
            mPersenter.bindView(this);
        }
        initView();
        initData();
        initListener();
    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initPerenster();

    protected abstract int getLayout();
}
