package com.example.mvpshow5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpshow5.adapter.RlvAdapter;
import com.example.mvpshow5.base.BaseActivity;
import com.example.mvpshow5.bean.ListBean;
import com.example.mvpshow5.model.MainModel;
import com.example.mvpshow5.persenter.MainPersenter;
import com.example.mvpshow5.utils.ToastUtil;
import com.example.mvpshow5.view.MainView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPersenter> implements MainView {

    @BindView(R.id.rlv)
    RecyclerView rlv;
    @BindView(R.id.btn_caozuo)
    Button btnCaozuo;
    @BindView(R.id.btn_delete)
    Button btnDelete;
    @BindView(R.id.btn_ok)
    Button btnOk;
    private ArrayList<ListBean.T1348647909107Bean> list;
    private RlvAdapter adapter;


    @OnClick({R.id.btn_caozuo, R.id.btn_delete, R.id.btn_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_caozuo:
                adapter.isShow = true;
                adapter.notifyDataSetChanged();
                break;
            case R.id.btn_delete:
                isDelete();
                break;
            case R.id.btn_ok:
                adapter.isShow = false;
                adapter.notifyDataSetChanged();
                break;
        }
    }


    private void isDelete() {
        ArrayList<ListBean.T1348647909107Bean> arrayList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ListBean.T1348647909107Bean bean = list.get(i);
            if (!bean.isIscilck()) {
                arrayList.add(bean);
            }
        }
        list.clear();
        list.addAll(arrayList);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        mPersenter.getData();
    }

    @Override
    protected void initView() {
        rlv.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        rlv.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new RlvAdapter(this, list);
        rlv.setAdapter(adapter);
    }

    @Override
    protected void initPersenter() {
        mPersenter = new MainPersenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onFuile(ListBean listBean) {
        list.addAll(listBean.getT1348647909107());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String str) {
        ToastUtil.showLong(str);
    }
}
