package com.example.mvpchow4;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivty<MainPersenter> implements MainView {

    @BindView(R.id.rcy)
    RecyclerView rcy;
    private ArrayList<FuliBean.ResultsBean> list;
    private RlvAdapter adapter;
    public Handler handler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            msg(msg);
            return false;
        }
    });

    private void msg(@NonNull Message msg) {
        if(msg.what==1){
            String s = (String) msg.obj;

        }else if(msg.what==2){
            int a= (int) msg.obj;

        }
    }

    @Override
    protected void initView() {
        rcy.addItemDecoration(new DividerItemDecoration(BaseApp.sBaseApp,RecyclerView.VERTICAL));
        rcy.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new RlvAdapter(this, list);
        rcy.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        mPersenter.getData();


    }

    @Override
    protected void initListener() {
        handler.sendMessage(handler.obtainMessage(1,"Hallod word"));
    }

    @Override
    protected void initPersenter() {
        mPersenter=new MainPersenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void cheng(FuliBean fuliBean) {
            list.addAll(fuliBean.getResults());
            adapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
