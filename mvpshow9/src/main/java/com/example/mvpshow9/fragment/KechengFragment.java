package com.example.mvpshow9.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpshow9.R;
import com.example.mvpshow9.adapter.RlvAdapter;
import com.example.mvpshow9.api.ApiServicer;
import com.example.mvpshow9.bean.JiangShiBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class KechengFragment extends Fragment {


    @BindView(R.id.rlv_one)
    RecyclerView rlvOne;
    private View inflate;
    private Unbinder bind;
    private ArrayList<JiangShiBean.BodyBean.ResultBean> list;
    private RlvAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflate = inflater.inflate(R.layout.fragment_kecheng, container, false);
        bind = ButterKnife.bind(this, inflate);
        initView();
        initData();
        initListener();
        return inflate;
    }

    private void initListener() {
        adapter.setOnclicitemListener(new RlvAdapter.onclicitemListener() {
            @Override
            public void oncilck(int position) {
                Toast.makeText(getActivity(), list.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ApiServicer.jiangshi_uri)
                .build();

        Observable<JiangShiBean> observable = retrofit.create(ApiServicer.class).getData();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JiangShiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JiangShiBean jiangShiBean) {
                        list.addAll(jiangShiBean.getBody().getResult());
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView() {
        rlvOne.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        rlvOne.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new RlvAdapter(getActivity(), list);
        rlvOne.setAdapter(adapter);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
