package com.example.gitcommit;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gitcommit.adapter.RlvAdapter;
import com.example.gitcommit.base.BasrActivity;
import com.example.gitcommit.bean.FuliBean;
import com.example.gitcommit.perenster.MianPerenter;
import com.example.gitcommit.view.MainView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BasrActivity<MianPerenter> implements MainView {

    @BindView(R.id.rlv)
    RecyclerView rlv;
    private ArrayList<FuliBean.ResultsBean> list;
    private RlvAdapter adapter;

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        mPersenter.getfuli();
    }

    @Override
    protected void initView() {
        rlv.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));
        rlv.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new RlvAdapter(this, list);
        rlv.setAdapter(adapter);
    }

    @Override
    protected void initPerenster() {
       mPersenter= new MianPerenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setData(FuliBean fuliBean) {
        list.addAll(fuliBean.getResults());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
