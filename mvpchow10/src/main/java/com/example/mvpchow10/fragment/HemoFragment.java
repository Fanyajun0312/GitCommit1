package com.example.mvpchow10.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpchow10.DowLoadActivity;
import com.example.mvpchow10.R;
import com.example.mvpchow10.adapter.RlvAdapter;
import com.example.mvpchow10.base.BaseFragment;
import com.example.mvpchow10.bean.PojectList;
import com.example.mvpchow10.presenter.FragmentPresenter;
import com.example.mvpchow10.view.FragmentVIew;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HemoFragment extends BaseFragment<FragmentPresenter> implements FragmentVIew {


    @BindView(R.id.rlv)
    RecyclerView rlv;
    private View inflate;
    private Unbinder bind;
    private ArrayList<PojectList.DataBean.DatasBean> list;
    private RlvAdapter rlvAdapter;


    @Override
    protected int getLayout() {
        return R.layout.fragment_hemo;
    }

    @Override
    protected void initPresenter() {
        mPresenter=new FragmentPresenter();
    }

    @Override
    protected void initView() {
        rlv.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        rlvAdapter = new RlvAdapter(getActivity(), list);
        rlv.setAdapter(rlvAdapter);
    }

    @Override
    protected void initData() {
        mPresenter.getData();
    }

    @Override
    protected void initListener() {
        rlvAdapter.setOnClickitemListener(new RlvAdapter.onClickitemListener() {
            @Override
            public void onClickItem(int position) {
                startActivity(new Intent(getActivity(), DowLoadActivity.class));
            }
        });
    }

    @Override
    public void pojectonff(PojectList pojectList) {
        list.addAll(pojectList.getData().getDatas());
        rlvAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String err) {
        Toast.makeText(getActivity(), err, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
