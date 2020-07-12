package com.example.mvpchow3.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mvpchow3.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @date：2020/7/11
 * @describe：fragment基类
 * @author：FanYaJun
 */
public abstract class BaseFragment<P extends BasePersenter> extends Fragment implements BaseView {
    public P mFragmentPersenter;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayout(), null);
        bind = ButterKnife.bind(this, inflate);
        initPersenter();
        if(mFragmentPersenter!=null){
            mFragmentPersenter.bindView(this);
        }
        initView();
        initData();
        initListener();
        return inflate;
    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayout();

    protected abstract void initPersenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
        mFragmentPersenter.destroy();
        mFragmentPersenter=null;
    }
}
