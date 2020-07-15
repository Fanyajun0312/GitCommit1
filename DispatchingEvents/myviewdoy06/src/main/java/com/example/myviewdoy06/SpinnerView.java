package com.example.myviewdoy06;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
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
import android.widget.Toast;

import java.util.ArrayList;

/**
 * @date：2020/7/14
 * @describe：
 * @author：FanYaJun
 */


public class SpinnerView extends RelativeLayout {


    private EditText ed_key;
    private ImageView iv_img;
    private ArrayList<String> mData;
    private PopupWindow popupWindow;
    private View inflate;
    private PopupWindow window;

    public SpinnerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initSpinnerview();
    }

    private void initSpinnerview() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_spinner, this);
        initView();
        initData();
    }

    private void initData() {
        mData = new ArrayList<>();
        for(int i=0;i<10  ;i++){
            mData.add("今天范亚军被夸奖了第"+i+"次");
        }
    }

    private void initView() {
        ed_key=findViewById(R.id.ed_key);
        iv_img=findViewById(R.id.iv_img);

        iv_img.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dealPopup();

            }
        });
    }
    private void dealPopup() {
        //创建popipwindow
        ListView listView = new ListView(getContext());
        //给listview设置数据      android.R.layout.simple_expandable_list_item_1  系统自带的布局 只有一个textview
        listView.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_expandable_list_item_1, mData));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //得到点击条目的数据
                String s = mData.get(position);
                //把数据设置到输入框
                ed_key.setText(s);
                //设置光标在最后
                ed_key.setSelection(s.length());
                //关闭
                window.dismiss();
            }
        });
        //设置界面宽 ,高
        window = new PopupWindow(listView, ed_key.getWidth(), 600);
        window.setBackgroundDrawable(new ColorDrawable());
        window.setOutsideTouchable(true);
        window.showAsDropDown(ed_key);
    }
}
