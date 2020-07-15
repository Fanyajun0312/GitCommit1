package com.example.mvpshow9;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.mvpshow9.adapter.VpAdapter;
import com.example.mvpshow9.bean.JiangShiBean;
import com.example.mvpshow9.fragment.KechengFragment;
import com.example.mvpshow9.fragment.ZhunFragment;
import com.example.mvpshow9.fragment.desFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DescActivity extends AppCompatActivity {

    @BindView(R.id.tv_toolbar_title)
    TextView tvToolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.iv_jiaoshi)
    ImageView ivJiaoshi;
    @BindView(R.id.tv_name1)
    TextView tvName1;
    @BindView(R.id.tv_nn)
    TextView tvNn;
    @BindView(R.id.btn_guan1)
    Button btnGuan1;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc);
        ButterKnife.bind(this);
        initToolbar();
        initView();

        initData();


    }

    private void initView() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new desFragment());
        fragments.add(new KechengFragment());
        fragments.add(new ZhunFragment());
        VpAdapter adapter = new VpAdapter(getSupportFragmentManager(), fragments);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("介绍");
        tab.getTabAt(1).setText("课程");
        tab.getTabAt(2).setText("专题");

    }

    private void initToolbar() {
            //设置支持toolbar
            setSupportActionBar(toolbar);
            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
            // 设置主标题或者子标题是否应该被显示，隐藏掉toolbar自带的主标题和子标题
            actionBar.setDisplayShowTitleEnabled(false);
            //返回按钮点击事件
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    private void initData() {
        JiangShiBean.BodyBean.ResultBean bean = (JiangShiBean.BodyBean.ResultBean) getIntent().getSerializableExtra("bean");
        Glide.with(this).load(bean.getTeacherPic()).into(ivJiaoshi);
        tvName1.setText(bean.getTeacherName());
        tvNn.setText(bean.getTitle());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
