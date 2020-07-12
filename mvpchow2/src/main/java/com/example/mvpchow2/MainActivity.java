package com.example.mvpchow2;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.example.mvpchow2.adapter.ViewPaAdapter;
import com.example.mvpchow2.base.BaseActivity;
import com.example.mvpchow2.bean.FuliBean;
import com.example.mvpchow2.fragment.CollFragment;
import com.example.mvpchow2.fragment.HemoFragment;
import com.example.mvpchow2.persenter.MainPersenter;
import com.example.mvpchow2.view.MianView;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import butterknife.BindView;


public class MainActivity extends BaseActivity<MainPersenter> implements MianView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tab)
    TabLayout tab;


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initPersenter() {
       mPensenter= new MainPersenter();
    }

    @Override
    protected void initView() {
        setSupportActionBar(toolbar);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HemoFragment());
        fragments.add(new CollFragment());
        ArrayList<String> titles = new ArrayList<>();
        titles.add("首页");
        titles.add("收藏");
        ViewPaAdapter adapter = new ViewPaAdapter(getSupportFragmentManager(), fragments, titles);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
    }

    @Override
    protected void initData() {



    }
    @Override
    protected void initListener() {
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                toolbar.setTitle(tab.getText());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void suresen(FuliBean fuliBean) {

    }

    @Override
    public void showToast(String str) {

    }
}
