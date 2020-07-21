package com.example.mvpshow9;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import com.bumptech.glide.Glide;
import com.example.mvpshow9.api.ApiServicer;
import com.example.mvpshow9.bean.JiangShiBean;
import com.example.mvpshow9.bean.beanLisr;
import com.example.mvpshow9.fragment.KechengFragment;
import com.example.mvpshow9.fragment.ZhunFragment;
import com.example.mvpshow9.fragment.desFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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
    @BindView(R.id.fl)
    FrameLayout fl;


    private JiangShiBean.BodyBean.ResultBean bean;
    private List<beanLisr.BodyBean.ResultBean> result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc);
        ButterKnife.bind(this);
        initToolbar();
        initData();
        initDAta2();


    }

    private void initDAta2() {

        desFragment fragment = new desFragment();
        KechengFragment fragment1 = new KechengFragment();
        ZhunFragment fragment2 = new ZhunFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fl,fragment).add(R.id.fl,fragment1).add(R.id.fl,fragment2)
                .commit();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiServicer.jianjie_uri)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        retrofit.create(ApiServicer.class).getDatass(bean.get_ID())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<beanLisr>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(beanLisr beanLisr) {
                        result = beanLisr.getBody().getResult();
                        for (int i = 0; i < result.size(); i++) {
                            tab.addTab(tab.newTab().setText(result.get(i).getDescription()));
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("999", "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


        /**
         * tab
         */
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==0){
                    fragmentManager.beginTransaction().show(fragment).hide(fragment2).hide(fragment1)
                            .commit();
                }else if(tab.getPosition()==1){
                    fragmentManager.beginTransaction().show(fragment1).hide(fragment).hide(fragment2)
                    .commit();

                }else if(tab.getPosition()==2){
                    fragmentManager.beginTransaction().show(fragment2).hide(fragment).hide(fragment1)
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
        bean = (JiangShiBean.BodyBean.ResultBean) getIntent().getSerializableExtra("bean");
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
