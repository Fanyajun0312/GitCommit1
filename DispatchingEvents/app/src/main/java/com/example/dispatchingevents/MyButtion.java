package com.example.dispatchingevents;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * @date：2020/7/14
 * @describe：//没有截断
 * @author：FanYaJun
 */
@SuppressLint("AppCompatCustomView")
public class MyButtion extends Button {
    public MyButtion(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
