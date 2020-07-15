package com.example.myview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @date：2020/7/15
 * @describe：
 * @author：FanYaJun
 */

/**
 * 准备画笔 通常在构造方法中使用
 */
public class MyXian extends View {

    private final Paint paint;

    @SuppressLint("ResourceAsColor")
    public MyXian(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();//paint  画笔的意思
        paint.setColor(R.color.colorPrimary);
        paint.setAntiAlias(true);//锯齿
        paint.setStrokeWidth(15);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int startY =100;
        int startX =200;
        int flasX=500;
        int flasY=150;
        canvas.drawLine(startX,startY,flasX,flasY,paint);
        super.onDraw(canvas);
    }
}
