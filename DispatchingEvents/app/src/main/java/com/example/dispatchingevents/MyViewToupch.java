package com.example.dispatchingevents;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * @date：2020/7/14
 * @describe：先分发 在截断 最后走到结束 tiuchevent  viewgroup有截断方法 上面是老大activity 下面是小弟 view控件
 * @author：FanYaJun
 */
public class MyViewToupch extends ScrollView {
    public MyViewToupch(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     *分发
     * @param ev
     * @return  先分发 在截断 最后走到结束 tiuchevent
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    /**
     * @param ev
     * @return true 表示为截断 flase 表示不截断 截断后子控件没有任何效果
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

    /**
     *触摸
     * @param ev
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }
}
