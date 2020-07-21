package com.example.shixunce;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import com.example.shixunce.fragment.GuangFragment;
import com.example.shixunce.fragment.HemoFragment;
import com.example.shixunce.fragment.VdeioFragment;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_toolbar_title)
    TextView tvToolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.fl)
    FrameLayout fl;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initToolbar();
        initVIew();

    }

    private void initVIew() {

        fragmentManager = getSupportFragmentManager();
        HemoFragment hemoFragment = new HemoFragment();
        VdeioFragment vdeioFragment = new VdeioFragment();
        GuangFragment guangFragment = new GuangFragment();
        fragmentManager.beginTransaction().add(R.id.fl,hemoFragment)
                .add(R.id.fl,vdeioFragment)
                .add(R.id.fl,guangFragment)
                .commit();

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==0){
                    fragmentManager.beginTransaction().show(hemoFragment)
                            .hide(vdeioFragment)
                            .hide(guangFragment)
                            .commit();

                }else if(tab.getPosition()==1){

                    fragmentManager.beginTransaction().show(guangFragment)
                            .hide(vdeioFragment)
                            .hide(hemoFragment)
                            .commit();
                }else if(tab.getPosition()==2){
                    fragmentManager.beginTransaction().show(vdeioFragment)
                            .hide(guangFragment)
                            .hide(hemoFragment)
                            .commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        tab.addTab(tab.newTab().setText("首页").setIcon(R.drawable.tab));
        tab.addTab(tab.newTab().setText("广场").setIcon(R.drawable.tab));
        tab.addTab(tab.newTab().setText("公众号").setIcon(R.drawable.tab));
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tvToolbarTitle.setText(tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,0,0,"22").setShowAsAction(0);
        return super.onCreateOptionsMenu(menu);
    }
}
