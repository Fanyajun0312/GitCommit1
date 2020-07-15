package com.example.mvpshow5.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * @date：2020/7/12
 * @describe：aa
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
        initView();
        initData();
        initListener();
    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initPersenter();

    protected abstract int getLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPersenter!=null){
            mPersenter.desteroy();
            mPersenter=null;

        }
    }
}
