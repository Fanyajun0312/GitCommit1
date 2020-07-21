package com.example.shixunce.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shixunce.R;
import com.example.shixunce.adapter.RlvAdapter;
import com.example.shixunce.base.BaseApp;
import com.example.shixunce.base.BaseFragment;
import com.example.shixunce.bean.ListBean;
import com.example.shixunce.bean.SqlBean;
import com.example.shixunce.presenter.FragmentPresenter;
import com.example.shixunce.view.FragmentView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.example.shixunce.R.drawable.ic_cloud;
import static com.example.shixunce.R.drawable.ic_cloud_queue_black_24dp;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuangFragment extends BaseFragment<FragmentPresenter> implements FragmentView {


    @BindView(R.id.rlv)
    RecyclerView rlv;
    private View inflate;
    private Unbinder bind;
    private ArrayList<ListBean.DataBean.DatasBean> list;
    private RlvAdapter rlvAdapter;


    @Override
    protected int getLayout() {
        return R.layout.fragment_guang;
    }

    @Override
    protected void initPresenter() {
        mPresenter=new FragmentPresenter();
    }

    @Override
    protected void initView() {
        rlv.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        rlvAdapter = new RlvAdapter(getActivity(), list);
        rlv.setAdapter(rlvAdapter);
    }

    @Override
    protected void initData() {
        mPresenter.getData();
        rlvAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initListener() {
        rlvAdapter.setOnClickItemListener(new RlvAdapter.onClickItemListener() {
            @Override
            public void onClickItemListener(int position) {
                ListBean.DataBean.DatasBean datasBean = list.get(position);
                SqlBean sqlBean = new SqlBean();
                sqlBean.setId((long)position);
                sqlBean.setTit(datasBean.getTitle());
                    long insert = BaseApp.getInstance().getDaoSession().insertOrReplace(sqlBean);
                    if(insert>=0 ){
                        Toast.makeText(getActivity(), "插入成功", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getActivity(), "插入失败", Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(getActivity(), "222", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void beanok(ListBean listBean) {
        list.addAll(listBean.getData().getDatas());
        rlvAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String err) {

    }
}
