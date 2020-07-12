package com.example.mvpchow.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * @date：2020/7/10
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
        initPenserter();
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

    protected abstract void initPenserter();

    protected abstract int getLayout();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPersenter!=null){//判断bp不等于空的话就销毁然后赋值为空
            mPersenter.destroy();
            mPersenter=null;
        }
    }
}
