package com.example.mvpshow6.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * @date：2020/7/12
 * @describe：aaa
 * @author：FanYaJun
 */
public abstract class BaseActivity<P extends BasePersenter> extends AppCompatActivity implements BaseView {
    public P mPersenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        initPersenter();
        if(mPersenter!=null){
         mPersenter.bindView(this);

        }
        initVIew();
        initData();
        initListener();
    }

    protected abstract int getLayout();
    protected abstract void initPersenter();
    protected abstract void initVIew();
    protected abstract void initData();
    protected abstract void initListener();
}
