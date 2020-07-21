package com.example.mvpchow10.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;

/**
 * @date：2020/7/16
 * @describe：
 * @author：FanYaJun
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {
    public P mPresenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayout(), container,false);
        ButterKnife.bind(this,inflate);
        initPresenter();
        if(mPresenter!=null){
            mPresenter.bindView(this);

        }

        initView();
        initData();
        initListener();
        return inflate;

    }

    protected abstract int getLayout();
    protected abstract void initPresenter();
    protected abstract void initView();
    protected abstract void initData();
    protected abstract void initListener();

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.Destroy();
        mPresenter=null;
    }
}
