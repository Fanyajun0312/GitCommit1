package com.example.pojecttwo.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvplibary.base.BaseMvpFragment;
import com.example.pojecttwo.R;
import com.example.pojecttwo.adapter.RlvSpAdapter;
import com.example.pojecttwo.callback.FrspCallBack;
import com.example.pojecttwo.presenter.FraSpPresenter;
import com.example.pojecttwo.shipinbean.DataBean;
import com.example.pojecttwo.shipinbean.ShiPinDemo;
import com.example.pojecttwo.view.FraSpView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HemoFragment extends BaseMvpFragment<FraSpView, FraSpPresenter> implements FraSpView, OnRefreshLoadmoreListener {


    @BindView(R.id.rlv)
    RecyclerView rlv;
    @BindView(R.id.sm)
    SmartRefreshLayout sm;
    private RlvSpAdapter adapter;
    private ArrayList<DataBean> list;
    private List<DataBean> data;
    private long page;

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_hemo;
    }

    @Override
    protected void initView() {
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new RlvSpAdapter(getActivity(), list);
        rlv.setAdapter(adapter);
        sm.setOnRefreshLoadmoreListener(this);
    }


    @Override
    protected void initEventAndData() {
        mPresenter.getData();

    }

    @Override
    protected FraSpPresenter initPresenter() {
        return new FraSpPresenter();
    }

    @Override
    public void onSossess(ShiPinDemo dataBean) {
        data = dataBean.getData();
        list.addAll(data);
        adapter.notifyDataSetChanged();
        sm.finishLoadmore();
        sm.finishRefresh();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void cancle() {

    }

    @Override
    public void onError(String msg, int code) {
        Log.i("TAG", "onErrorr: "+msg+code);
    }

    @Override
    public void onCancle() {

    }


    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {

        page++;
        //重新加载数据
        initEventAndData();
        //.finishLoadmore(3000);


    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        page = 1;
        //重新加载数据
        initEventAndData();
        //3秒以后关闭刷新的视图
        refreshlayout.finishRefresh(4000);
    }
}
