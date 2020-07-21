package com.example.shixunce.presenter;

import androidx.appcompat.view.menu.MenuView;

import com.example.shixunce.FragmentModel;
import com.example.shixunce.base.BasePresenter;
import com.example.shixunce.bean.ListBean;
import com.example.shixunce.coll.CollBack;
import com.example.shixunce.view.FragmentView;

/**
 * @date：2020/7/17
 * @describe：
 * @author：FanYaJun
 */
public class FragmentPresenter extends BasePresenter<FragmentView> implements CollBack {

    private FragmentModel fragmentModel;

    @Override
    protected void initModel() {
        fragmentModel = new FragmentModel();
        addModel(fragmentModel);
    }

    public void getData() {
        fragmentModel.getdatas(this);
    }

    @Override
    public void showerr(String err) {
        mview.showToast(err);
    }

    @Override
    public void listok(ListBean listBean) {
        mview.beanok(listBean);
    }
}
