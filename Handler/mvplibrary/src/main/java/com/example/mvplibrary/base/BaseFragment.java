package com.example.mvplibrary.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.trello.rxlifecycle2.components.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @date：2020/8/9
 * @describe：
 * @author：FanYaJun
 */
public abstract class BaseFragment extends RxFragment {
    private Activity mActivity;
    private Context context;
    private View rootview;
    private Unbinder bind;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity= (Activity) context;
        this.context=context;
    }


    /**
     * 先找到布局 再聚获取数据
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if(rootview==null){
            rootview=inflater.inflate(initLayouId(),null);
            
        }
        bind = ButterKnife.bind(this, rootview);
        return rootview;
    }

    protected abstract int initLayouId();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    protected abstract void initData();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (rootview != null) {
            ((ViewGroup) rootview.getParent()).removeView(rootview);
        }

        if(bind!=null){
            bind.unbind();
        }
    }
}
