package com.example.shixunexam.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mvplibary.base.BaseActivity;
import com.example.shixunexam.R;
import com.example.shixunexam.adapter.VpAdapter;
import com.example.shixunexam.fragment.OneFragment;
import com.example.shixunexam.fragment.TwoFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GrlidsActivity extends BaseActivity {

    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.mShareTv)
    TextView mShareTv;
    @BindView(R.id.mEnterCartTv)
    TextView mEnterCartTv;
    @BindView(R.id.mAddCartBtn)
    Button mAddCartBtn;
    @BindView(R.id.ll_bottom)
    LinearLayout llBottom;


    @Override
    protected void initEvent() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());
        ArrayList<String> titles = new ArrayList<>();
        titles.add("商品");
        titles.add("详情");
        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), titles, fragments);
        vp.setAdapter(vpAdapter);
        tab.setupWithViewPager(vp);
    }

    @Override
    protected void initData() {

        mShareTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GrlidsActivity.this, "分享", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected int initLayoutId() {
        return R.layout.activity_grlids;
    }


}
