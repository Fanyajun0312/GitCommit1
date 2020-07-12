package com.example.mvpchow;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpchow.base.BaseActivity;
import com.example.mvpchow.persener.MainPersenter;
import com.example.mvpchow.view.MainView;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPersenter> implements MainView {

    @BindView(R.id.rlv)
    RecyclerView rlv;
    private ArrayList<FuliBean.ResultsBean> list;
    private RlvAdapter adapter;


    @Override
    protected void initListener() {


    }

    @Override
    protected void initData() {
        mPersenter.getfu();
    }

    @Override
    protected void initView() {
        rlv.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new RlvAdapter(this, list);
        rlv.setAdapter(adapter);
    }

    @Override
    protected void initPenserter() {
    mPersenter=new MainPersenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showToast(String str) {

    }


    @Override
    public void getData(FuliBean fuliBean) {
        list.addAll(fuliBean.getResults());
        adapter.notifyDataSetChanged();
    }
}
