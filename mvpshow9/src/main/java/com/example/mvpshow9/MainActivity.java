package com.example.mvpshow9;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpshow9.adapter.RlvAdapter;
import com.example.mvpshow9.base.BaseActivity;
import com.example.mvpshow9.base.BasePresenter;
import com.example.mvpshow9.bean.JiangShiBean;
import com.example.mvpshow9.presenter.MainPresenter;
import com.example.mvpshow9.view.MainView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @BindView(R.id.tv_toolbar_title)
    TextView tvToolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rlv)
    RecyclerView rlv;
    private ArrayList<JiangShiBean.BodyBean.ResultBean> list;
    private RlvAdapter adapter;
    private JiangShiBean.BodyBean.ResultBean resultBean;
    public boolean ddddd;


    @Override
    protected int getKayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initPresenter() {
        mPresenter = new MainPresenter();
    }
    private void initToolbar() {
        //设置支持toolbar


        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        // 设置主标题或者子标题是否应该被显示，隐藏掉toolbar自带的主标题和子标题
        actionBar.setDisplayShowTitleEnabled(false);
        //返回按钮点击事件
        tvToolbarTitle.setText("名师推荐");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    protected void initView() {
        initToolbar();
        rlv.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        rlv.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new RlvAdapter(this, list);
        rlv.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        mPresenter.getDatas();
    }

    @Override
    protected void initListener() {
        adapter.setOnclicitemListener(new RlvAdapter.onclicitemListener() {
            @Override
            public void oncilck(int position) {
                if(ddddd=true){
                    resultBean = list.get(position);
                    Intent intent = new Intent(MainActivity.this, DescActivity.class);
                    intent.putExtra("bean",resultBean);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void showToast(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            switch(item.getItemId()) {
                    case R.id.item1:

                        break;
                }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onshibai(JiangShiBean jiangShiBean) {
            list.addAll(jiangShiBean.getBody().getResult());
            adapter.notifyDataSetChanged();
    }
}
