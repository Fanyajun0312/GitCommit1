package com.example.shixunexam.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.mvplibary.base.BaseMvpFragment;
import com.example.shixunexam.R;
import com.example.shixunexam.adapter.SkuChangedEvent;
import com.example.shixunexam.app.SkuBottomDialog;
import com.example.shixunexam.bean.GlicdeBesn;
import com.example.shixunexam.mvp.GView;
import com.example.shixunexam.mvp.Gpresenter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import javax.security.auth.callback.Callback;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends BaseMvpFragment<GView, Gpresenter> implements GView {

    @BindView(R.id.goodBan)
    Banner goodBan;//轮播图
    @BindView(R.id.mGoodsDescTv)
    TextView mGoodsDescTv;//标题
    @BindView(R.id.mGoodsPriceTv)
    TextView mGoodsPriceTv;//价格
    @BindView(R.id.mSkuLabelTv)
    TextView mSkuLabelTv;//
    @BindView(R.id.mSkuSelectedTv)
    TextView mSkuSelectedTv;
    @BindView(R.id.mMoreIv)
    ImageView mMoreIv;
    @BindView(R.id.mSkuView)
    RelativeLayout mSkuView;
    private SkuBottomDialog bottomDialog;
    @Override
    protected int initLayoutId() {
        return R.layout.fragment_one;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEventAndData() {
        mPresenter.getData();
    }

    @Override
    protected Gpresenter initPresenter() {
        return new Gpresenter();
    }

    @Override
    public void showOK(GlicdeBesn glicdeBesn) {
        String goodsBanner = glicdeBesn.getGoodsBanner();
        String[] split = goodsBanner.split(",");
        ArrayList<String> img = new ArrayList<>();
        for (String s : split) {
            img.add(s);
        }
        goodBan.setImages(img).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        }).start();
        String goodsDesc = glicdeBesn.getGoodsDesc();
        String goodsDefaultPrice = glicdeBesn.getGoodsDefaultPrice();
        mGoodsDescTv.setText(goodsDesc);
        mGoodsPriceTv.setText(goodsDefaultPrice);

        bottomDialog = new SkuBottomDialog(mActivity,glicdeBesn);
        mSkuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog.show();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void changeSku(SkuChangedEvent skuChangedEvent){
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < bottomDialog.getSkuChangedEvents().size(); i++) {
            stringBuilder.append(bottomDialog.getSkuChangedEvents().get(i));
            if(i!= bottomDialog.getSkuChangedEvents().size()-1){
                stringBuilder.append(",");
            }
        }
        mSkuSelectedTv.setText(stringBuilder.toString()+ bottomDialog.numberButton.getNumber()+"件");
    }

    @Override
    public void onError(String msg, int code) {
        Log.i("TAG", "onError: "+msg+code);
    }

    @Override
    public void onCancle() {
    }

}
