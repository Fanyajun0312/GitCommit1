package com.example.myviewdemo2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * @date：2020/7/14
 * @describe：
 * @author：FanYaJun
 */
public class Sinnper extends RelativeLayout {

    private ArrayList<String> mData;
    private EditText ed_key_one;
    private ImageView iv_img;
    private PopupWindow popupWindow;

    public Sinnper(Context context, AttributeSet attrs) {
        super(context, attrs);
        initspinner();
    }

    private void initspinner() {
        LayoutInflater.from(getContext()).inflate(R.layout.spinnerview, this);
        initView();
        initData();
    }

    private void initData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mData.add("今天范亚军又帅第" + i + "");
        }
    }

    private void initView() {
        ed_key_one=findViewById(R.id.ed_key_one);
        iv_img=findViewById(R.id.iv_img);
        iv_img.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                pop();
            }
        });


    }

    private void pop() {
        ListView listView = new ListView(getContext());
        listView.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_expandable_list_item_1,mData));
        popupWindow = new PopupWindow(listView, ed_key_one.getWidth(), 500);
        popupWindow.setBackgroundDrawable(null);
        popupWindow.setOutsideTouchable(true);
        if(popupWindow!=null){
            popupWindow.setFocusable(true);

        }


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = mData.get(position);
                ed_key_one.setText(s);
                ed_key_one.setSelection(s.length());
                popupWindow.dismiss();
            }
        });

        if(!popupWindow.isShowing()){
            popupWindow.showAsDropDown(ed_key_one);
        }else {
            popupWindow.dismiss();

        }

    }
}
