package com.example.mvpchow2.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpchow2.R;
import com.example.mvpchow2.Utils.ToastUtil;
import com.example.mvpchow2.adapter.RlvAdapter;
import com.example.mvpchow2.base.BaseFragment;
import com.example.mvpchow2.base.BasePersenter;
import com.example.mvpchow2.base.BaseView;
import com.example.mvpchow2.bean.FuliBean;
import com.example.mvpchow2.persenter.MainPersenter;
import com.example.mvpchow2.view.MianView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HemoFragment extends BaseFragment<MainPersenter> implements MianView {
    @BindView(R.id.rlv)
    RecyclerView rlv;
    private ArrayList<FuliBean.ResultsBean> list;
    private RlvAdapter adapter;

    @Override
    protected void initListenerFragment() {

    }

    @Override
    protected void initDataFragment() {
       mFragmentPersenter.getData();
    }

    @Override
    protected void initViewFragemnt() {
        rlv.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new RlvAdapter(getActivity(), list);
        rlv.setAdapter(adapter);
    }

    @Override
    protected void initPersenter() {
        mFragmentPersenter=new MainPersenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_hemo;
    }

    @Override
    public void showToast(String str) {
        ToastUtil.showLong(str);
    }

    @Override
    public void suresen(FuliBean fuliBean) {
        list.addAll(fuliBean.getResults());
        adapter.notifyDataSetChanged();
    }

}
