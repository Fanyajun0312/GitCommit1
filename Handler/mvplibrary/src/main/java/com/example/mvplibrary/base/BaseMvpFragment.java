package com.example.mvplibrary.base;

/**
 * @date：2020/8/9
 * @describe：
 * @author：FanYaJun
 */
public  abstract class BaseMvpFragment<V extends BaseView,P extends BasePresenter<V>>extends BaseFragment {
    public P Presnenter;

    protected abstract P initPresenter();

    @Override
    protected void initData() {
        Presnenter=initPresenter();
        if(Presnenter!=null){
            Presnenter.attachView((V) this);//不等于空就绑定布局

        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(Presnenter!=null){
            Presnenter.detachView();
            Presnenter=null;
        }
    }
}
