package com.example.mvpchow2.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mvpchow2.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @date：2020/7/11
 * @describe：fragment基类
 * @author：FanYaJun
 */
public abstract class BaseFragment<P extends BasePersenter> extends Fragment implements BaseView{
    public P mFragmentPersenter;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), null);
        bind = ButterKnife.bind(this, view);
        initPersenter();
        if(mFragmentPersenter!=null){
            mFragmentPersenter.bindVIew(this);
        }
        initViewFragemnt();
        initDataFragment();
        initListenerFragment();
        return view;
    }

    protected abstract void initListenerFragment();

    protected abstract void initDataFragment();

    protected abstract void initViewFragemnt();

    protected abstract void initPersenter();

    protected abstract int getLayout();//protected 公开意思一样

    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
        mFragmentPersenter.destroy();
        mFragmentPersenter=null;
    }
}
