package com.example.mvpchow4.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * @date：2020/7/12
 * @describe：aaa
 * @author：FanYaJun
 */
public abstract class BaseActivty<P extends BasePersenter> extends AppCompatActivity implements BaseView {
    public P mPersenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        initPersenter();
        if(mPersenter!=null){
         mPersenter.bindview(this);
        }
        initView();
        initData();
        initListener();
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();

    protected abstract void initPersenter();

    protected abstract int getLayout();
}
