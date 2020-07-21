package com.example.mvpchow10.presenter;

import androidx.appcompat.view.menu.MenuView;

import com.example.mvpchow10.base.BasePresenter;
import com.example.mvpchow10.bean.PojectList;
import com.example.mvpchow10.coll.CollBack;
import com.example.mvpchow10.model.FragmentModel;
import com.example.mvpchow10.view.FragmentVIew;

/**
 * @date：2020/7/16
 * @describe：
 * @author：FanYaJun
 */
public class FragmentPresenter extends BasePresenter<FragmentVIew> implements CollBack {

    private FragmentModel fragmentModel;

    @Override
    protected void initModel() {
        fragmentModel = new FragmentModel();
        addModel(fragmentModel);
    }

    public void getData() {
        fragmentModel.getDatas(this);
    }

    @Override
    public void pojectonfcc(PojectList pojectList) {
        mview.pojectonff(pojectList);
    }

    @Override
    public void showErr(String err) {
        mview.showToast(err);
    }
}
