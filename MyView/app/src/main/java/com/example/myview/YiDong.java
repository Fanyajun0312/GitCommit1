package com.example.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @date：2020/7/15
 * @describe：
 * @author：FanYaJun
 */
public class YiDong extends View {

    private final Paint paint;
    public float MevmX=50;
    public float MevmY=50;
    public boolean isUp=false;
    public YiDong(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(isUp!=true){
            canvas.drawCircle(MevmX,MevmY,60,paint);
        }
        super.onDraw(canvas);
    }

    /**
     * flase不作出触摸
     * true 作出触摸动作
     * @param event
     * @return
     */

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()!=MotionEvent.ACTION_MOVE){
            paint.setColor(Color.RED);
            isUp=false;
            MevmX = event.getX();
            MevmY = event.getY();
        }else if(event.getAction()==MotionEvent.ACTION_UP){
            isUp=true;
        }
            invalidate();
        return true;//默认flase
    }
}
