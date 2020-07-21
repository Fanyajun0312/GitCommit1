package com.example.shixunce.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @date：2020/7/17
 * @describe：
 * @author：FanYaJun
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {
    public P mPresenter;
    private View view;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayout(), container, false);
        bind = ButterKnife.bind(this, view);
        initPresenter();
        if(mPresenter!=null){
         mPresenter.bindView(this);

        }
        initView();
        initData();
        initListener();
        return view;
    }
    protected abstract int getLayout();
    protected abstract void initPresenter();
    protected abstract void initView();
    protected abstract void initData();
    protected abstract void initListener();
}
