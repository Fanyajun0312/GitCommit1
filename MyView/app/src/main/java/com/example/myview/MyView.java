package com.example.myview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @date：2020/7/15
 * @describe：
 * @author：FanYaJun
 */
public class MyView extends View {

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        //创建一支画笔
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);
        //设置画笔粗细
        paint.setStrokeWidth(2);
        //设置是否为空心
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        //绘制头部
        RectF mRectF_head = new RectF(110,110,canvas.getHeight()/2,canvas.getHeight()/2);
        mRectF_head.offset(100,10);
        canvas.drawArc(mRectF_head,-10,-160,false,paint);
        //天线
        paint.setColor(Color.GREEN);//划线
        paint.setStrokeWidth(10);
        canvas.drawLine(220,115,435,300,paint);
        canvas.drawLine(900,115,685,300,paint);
        //眼睛
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(20);
        canvas.drawCircle(700,300,4,paint);
        canvas.drawCircle(400,300,4,paint);

        paint.setStrokeWidth(2);
        paint.setColor(Color.GREEN);

        //身体
        canvas.drawRect(220,450,885,900,paint);//圆角
        RectF rextf_body = new RectF(220,800,885,1200);
        canvas.drawRoundRect(rextf_body,50,50,paint);
        //胳膊
        RectF rectF_arm = new RectF(100,430,200,1000);
        canvas.drawRoundRect(rectF_arm,180,180,paint);
        rectF_arm.offset(805,0);
        canvas.drawRoundRect(rectF_arm,180,180,paint);



        //dialog  绘制文字
        paint.setColor(Color.BLACK);
        paint.setTextSize(30);
        paint.setTextAlign(Paint.Align.CENTER); //字体居中
        canvas.drawText("你是真牛逼",950,250,paint);

        //腿
        paint.setColor(Color.GREEN);
        RectF rectF_foot = new RectF(400,1100,500,1500);
        canvas.drawRoundRect(rectF_foot,180,180,paint);
        rectF_foot.offset(200,0);
        canvas.drawRoundRect(rectF_foot,180,180,paint);
        RectF rectF = new RectF(0, 0, 390, 390);
        canvas.drawArc(rectF,-90,-90,true,paint);
        super.onDraw(canvas);



    }
}
