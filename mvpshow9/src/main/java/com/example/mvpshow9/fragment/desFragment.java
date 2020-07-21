package com.example.mvpshow9.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.mvpshow9.R;
import com.example.mvpshow9.api.ApiServicer;
import com.example.mvpshow9.bean.JiangShiBean;
import com.example.mvpshow9.bean.beanLisr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
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
public class desFragment extends Fragment {


    @BindView(R.id.rv_tit)
    TextView rvTit;
    private View inflate;
    private Unbinder bind;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_des, container, false);
        bind = ButterKnife.bind(this, inflate);
       rvTit.setText("老师今天真可爱");
        return inflate;
    }

}
