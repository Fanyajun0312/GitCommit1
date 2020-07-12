package com.example.mvpchow3.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * @date：2020/7/11
 * @describe：Activity
 * @author：FanYaJun
 */
public abstract class BaseActvity<P extends BasePersenter> extends AppCompatActivity implements BaseView {
    public P mPersenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        initPersenter();
        if (mPersenter != null) {

            mPersenter.bindView(this);
        }
        initView();
        initData();
        initListener();
    }

    protected abstract int getLayout();

    protected abstract void initPersenter();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();
}
