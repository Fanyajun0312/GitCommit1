package com.example.mvpshow7;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpshow7.adapter.RlvAdapter;
import com.example.mvpshow7.base.BaseActivity;
import com.example.mvpshow7.bean.ListBean;
import com.example.mvpshow7.presenter.MianPresenter;
import com.example.mvpshow7.view.MainView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MianPresenter> implements MainView {

    @BindView(R.id.rlv)
    RecyclerView rlv;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private ArrayList<ListBean.DataBean.DatasBean> list;
    private RlvAdapter adapter;

    @Override
    protected void initListener() {
        adapter.setOnClickitemListener(new RlvAdapter.onClickitemListener() {
            @Override
            public void onclickItemListener(int position) {
                String link = list.get(position).getLink();
                EventMsg eventMsg = new EventMsg();
                eventMsg.msg=link;
                EventBus.getDefault().postSticky(eventMsg);
                Intent intent = new Intent(MainActivity.this, WebActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        mPresenter.getData();
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
    protected void initPresenter() {
        mPresenter = new MianPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onListss(ListBean listBean) {
        list.addAll(listBean.getData().getDatas());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }
}
