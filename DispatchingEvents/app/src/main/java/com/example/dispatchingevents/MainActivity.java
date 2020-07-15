package com.example.dispatchingevents;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_touchme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        btn_touchme = (Button) findViewById(R.id.btn_one1);
        btn_touchme.setOnClickListener(this);
/**
 * 事件触发的管理
 */
        btn_touchme.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override//触摸时
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();//获得触摸的动作  
                if(action==MotionEvent.ACTION_DOWN){//按下了按钮
                    Log.i("TAG", "onTouch: "+"按下了按钮");
                    
                }else if(action==MotionEvent.ACTION_MOVE){//按下后滑动了按钮
                    Log.i("TAG", "onTouch: "+"滑动按钮");
                    
                }else if(action==MotionEvent.ACTION_UP){//按下后向上滑动
                    Log.i("TAG", "onTouch: "+"向上移动");

                }
                return false;//必须为flase 如果是true 真的那么就把所有的触摸事件取消 点击无效
                                    //flase 那么没有任何动作 事件不会取消 点击有小
            }
        });
    }

    /**
     * Activity 没有阶段方法
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(ev);
        Log.i("TAG", "dispatchTouchEvent: "+dispatchTouchEvent);
        return dispatchTouchEvent;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean TouchEvent = super.onTouchEvent(event);
        Log.i("TAG", "onTouchEvent: "+TouchEvent);
        return TouchEvent;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_one1:
                /**
                 * 正常的点击事件  touchEvent 的点击事件的话必须为flase 否则点击事件没有效果
                 */
                break;
        }
    }
}
