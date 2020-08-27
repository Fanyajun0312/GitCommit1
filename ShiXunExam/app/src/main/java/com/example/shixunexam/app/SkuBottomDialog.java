package com.example.shixunexam.app;

import android.content.Context;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

import com.example.shixunexam.R;
import com.example.shixunexam.adapter.SkuChangedEvent;
import com.example.shixunexam.bean.GlicdeBesn;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import org.greenrobot.eventbus.EventBus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ren.qinc.numberbutton.NumberButton;


/**
 * 项目名：Shopping
 * 包名：  com.example.liangxq.shopping.view
 * 文件名：SkuBottomDialog
 * 创建者：liangxq
 * 创建时间：2020/8/21  0:30
 * 描述：TODO
 *
 * 顶部弹出SkuDialog,动态添加控件到ViewGroup
 */

public class SkuBottomDialog extends BottomSheetDialog implements View.OnClickListener {
    //存储所有的Sku的集合
    public List<Map<TagFlowLayout,List<String>>>skuChangedEvents=new ArrayList<>();
    public NumberButton numberButton;
    private GlicdeBesn goodsDetail;
    private List<GlicdeBesn.GoodsSkuBean> goodsSkuBeans;
    public SkuBottomDialog(@NonNull final Context context, GlicdeBesn goodsDetail) {
        super(context);
        this.goodsDetail=goodsDetail;
        this.goodsSkuBeans=goodsDetail.getGoodsSku();
        setContentView(R.layout.layout_sku_pop);
        findViewById(R.id.mAddCartBtn).setOnClickListener(this);
        findViewById(R.id.mCloseIv).setOnClickListener(this);
        numberButton = findViewById(R.id.mSkuCountBtn);
        //初始化默认的值
        numberButton.setCurrentNumber(1);
        //只需要监听editText的变化即可
        EditText editText = numberButton.findViewById(R.id.text_count);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                EventBus.getDefault().postSticky(new SkuChangedEvent());
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        Glide.with(context).load(goodsDetail.getGoodsDefaultIcon()).into((ImageView) findViewById(R.id.mGoodsIconIv));
        //父控件
        ViewGroup viewGroup = findViewById(R.id.mSkuView);
        View inflate = null;
        for (GlicdeBesn.GoodsSkuBean goodsSkuBean : goodsSkuBeans) {
            Map<TagFlowLayout,List<String>>tagFlowLayoutListMap=new HashMap<>();
            //初始化一组数据
            inflate =  LayoutInflater.from(context)
                    .inflate(R.layout.layout_sku_view, null, false);
            final TagFlowLayout tagFlowLayout = inflate.findViewById(R.id.mSkuContentView);
            TextView textView = inflate.findViewById(R.id.mSkuTitleTv);
            textView.setText(goodsSkuBean.getGoodsSkuTitle());
            final List<String> skuContent = goodsSkuBean.getSkuContent();
            tagFlowLayout.setAdapter(new TagAdapter<String>(skuContent) {
                @Override
                public View getView(FlowLayout parent, int position, String s) {
                    TextView textView1 = (TextView) LayoutInflater.from(context)
                            .inflate(R.layout.layout_sku_item, parent, false);
                    textView1.setText(s);
                    return textView1;
                }
            });
            //初始化默认的选中的位置
            tagFlowLayout.getAdapter().setSelectedList(0);
            tagFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
                @Override
                public boolean onTagClick(View view, int position, FlowLayout parent) {
                    EventBus.getDefault().postSticky(new SkuChangedEvent());
                    return true;
                }
            });
            tagFlowLayoutListMap.put(tagFlowLayout,skuContent);
            skuChangedEvents.add(tagFlowLayoutListMap);
            //将一组数据添加到父控件当中
            viewGroup.addView(inflate);
        }
    }

    //获取全部选中的sku
    public List<String> getSkuChangedEvents() {
        List<String> checkSku=new ArrayList<>();
        for (Map<TagFlowLayout, List<String>> skuChangedEvent : skuChangedEvents) {
            //遍历集合Map
            Set<Map.Entry<TagFlowLayout, List<String>>> entries = skuChangedEvent.entrySet();
            for (Map.Entry<TagFlowLayout, List<String>> entry : entries) {
                TagFlowLayout tagFlowLayout = entry.getKey();
                List<String> value = entry.getValue();
                checkSku.add(value.get(tagFlowLayout.getSelectedList().iterator().next()));
            }
        }
        return checkSku;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mCloseIv:
                 dismiss();
                //防止事件重复在dismiss完取消订阅
                if(!EventBus.getDefault().isRegistered(this)){
                    EventBus.getDefault().unregister(this);
                }
                break;
            case R.id.mAddCartBtn:
                dismiss();
                break;
        }
    }
}