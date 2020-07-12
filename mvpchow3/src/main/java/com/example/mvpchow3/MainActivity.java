package com.example.mvpchow3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mvpchow3.base.BaseActvity;
import com.example.mvpchow3.persenter.MainPersenter;
import com.example.mvpchow3.view.MianView;

public class MainActivity extends BaseActvity<MainPersenter> implements MianView {


    @Override
    protected int getLayout() {
        return 0;
    }

    @Override
    protected void initPersenter() {
        mPersenter=new MainPersenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        mPersenter.getData();
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void suresen(String fuliBean) {

    }

    @Override
    public void showToast(String str) {

    }
}
