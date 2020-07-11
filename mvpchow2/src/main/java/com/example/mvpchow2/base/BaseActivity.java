package com.example.mvpchow2.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * @date：2020/7/11
 * @describe：activity基类
 * @author：FanYaJun
 */
public abstract class BaseActivity<P extends BasePersenter> extends AppCompatActivity implements  BaseView{
    public P mPensenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);//控件
        initPersenter();
        if(mPensenter!=null){
            mPensenter.bindVIew(this);
        }
        initView();//布局
        initData();//数据
        initListener();//点击事件
    }

    protected abstract int getLayout();
    protected abstract void initPersenter();
    protected abstract void initView();
    protected abstract void initData();
    protected abstract void initListener();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPensenter!=null){
            mPensenter.destroy();//界面销毁p也会销毁
            mPensenter=null;

        }
    }
}
